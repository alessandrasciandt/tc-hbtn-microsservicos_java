package com.example.jpah2demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private TelefoneRepository telefoneRepository;

    @PostMapping("/addClient")
    //aqui para adicionar o cliente eu preciso primeiro adicionar seu telefone e seu endereço para depois salvar um cliente na base de dados
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
        for (Endereco endereco : cliente.getEnderecos()){
            endereco.setCliente(cliente);
        }
        for(Telefone telefone : cliente.getTelefones()){
            telefone.setCliente(cliente);
        }
        Cliente salvarCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok().body(salvarCliente);
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
       List<Cliente> clientes = clienteRepository.findAll();
       return ResponseEntity.ok().body(clientes);
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        Optional<Cliente> cliente = clienteRepository.findById(idClient);
        Cliente clienteId = cliente.get();
        if (!cliente.isPresent()) {
            return ResponseEntity.ok().body(null);
        } else {
            return ResponseEntity.ok().body(clienteId);
        }
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
        clienteRepository.deleteById(idClient);
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        Optional<Cliente> encontrarCliente = clienteRepository.findById(id);
        Cliente salvarCliente = encontrarCliente.get();
        for(Endereco endereco : cliente.getEnderecos()){
            salvarCliente.getEnderecos().add(endereco);
            endereco.setCliente(salvarCliente);
        }
        for(Telefone telefone : cliente.getTelefones()){
            salvarCliente.getTelefones().add(telefone);
            telefone.setCliente(salvarCliente);
        }
        clienteRepository.save(salvarCliente);
    }
}