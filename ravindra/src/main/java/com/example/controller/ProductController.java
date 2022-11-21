package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;

@RestController
//@RequestMapping(value = "/ravindra")
public class ProductController {
   @Autowired
   private ProductService productService;
   @Autowired
   private ProductRepository repository;

   @PostMapping("/addProduct")
   public Product addproduct(@RequestBody Product product) {
	   return productService.addproduct(product);
   }

   @PostMapping("/addProducts")
   public List<Product> addproducts(@RequestBody List<Product> products) {
	   return productService.saveProducts(products);
   }
   @GetMapping("/welocome")
   public String welcome(){
	   return "hi to everyone";
   }

   @GetMapping("/products")
   public List<Product> getproducts(){
	   return productService.getProducts();
   }

   @GetMapping("/product/{id}")
   public Product getproductbyid(@PathVariable int id){
	   return productService.getProductById(id);
   }

   @GetMapping("/productByName/{name}")
   public Product getproductbyname(@PathVariable String name){
	   return productService.getProductByName(name);
   }

   @DeleteMapping("/delete/{id}")
   public String deleteproduct(@PathVariable int id){
	   return productService.deleteProductById(id);
   }

   @PutMapping("/update")
   public Product updateproduct(@RequestBody Product product) {
	   return productService.updateProductById(product);
   }

}