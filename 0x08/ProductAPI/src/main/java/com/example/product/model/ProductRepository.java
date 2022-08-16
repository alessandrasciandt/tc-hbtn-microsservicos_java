package com.example.product.model;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> list = new ArrayList<Product>();

    @GetMapping
    public List<Product> getAllProducts() {
        return list;
    }

    public Product getProductById(Long id) {
        for(Product product : list){
            if (product.getId() == Long.valueOf(id.longValue())){
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product s) {
        boolean verificador = false;
        if(list.isEmpty()){
            list.add(s);
        }
        for(Product product : list){
            if(product.getId() == Long.valueOf(s.getId().longValue())){
                verificador = true;
            }
        }
        if(verificador == false){
            list.add(s);
        }
    }

    public void updateProduct(Product s) {
        Product produto = getProductById(s.getId());
        int aux = list.indexOf(produto);
        if(produto != null){
            produto.setCode(s.getCode());
            produto.setName(s.getName());
            produto.setDescription(s.getDescription());
            produto.setPrice(s.getPrice());
            produto.setStatus(s.getStatus());
            list.set(aux, produto);
        }
    }

    public void removeProduct(Product s) {
        Product produto = getProductById(s.getId());
        if(produto != null){
            list.remove(s);
        }
    }

    public void addList(List<Product> listOfProducts) {
       for(Product produto : list){
           list.add(produto);
       }
    }
}
