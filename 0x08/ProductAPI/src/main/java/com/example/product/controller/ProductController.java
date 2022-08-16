package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "API Rest Products")
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/welcome")
    @ApiOperation(value = "- Responsável por retornar uma mensagem de boas vindas")
    public ResponseEntity<String> welcome(){
        return ResponseEntity.ok().body("BEM VINDO À PRODUCT REST API.");
    }

    @GetMapping(value = "/allProducts")
    @ApiResponses(value = {
            @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    })
    @ApiOperation(value = "- Responsável por retornar uma lista de produtos")
    public ResponseEntity <List<Product>> allProducts(){
        List<Product> produto = productRepository.getAllProducts();
        return ResponseEntity.ok().body(produto);
    }


    @GetMapping(value = "/findProductById/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    })
    @ApiOperation(value = "- Responsável por retornar um produto pelo id")
    public ResponseEntity<Product> findProductById(@PathVariable Long id){
        Product product = productRepository.getProductById(id);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping(value = "/addProduct")
    @ApiResponses(value = {
            @ApiResponse(code = 10, message = "Required fields not informed.")
    })
    @ApiOperation(value = "- Responsável por adicionar um produto")
    public void addProduct(@RequestBody Product product){
        productRepository.addProduct(product);
    }


    @DeleteMapping(value = "/removeProduct")
    @ApiResponses(value = {
            @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    })
    @ApiOperation(value = "- Responsável por adicionar um produto")
    public void removeProduct(@RequestBody Product product){
        productRepository.removeProduct(product);
    }


    @PutMapping("/updateProduct")
    @ApiResponses(value = {
            @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    })
    @ApiOperation(value = "- Responsável por atualizar um produto")
    public void updateProduct(@RequestBody Product product){
        productRepository.updateProduct(product);
    }

}
