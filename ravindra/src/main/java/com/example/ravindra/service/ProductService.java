package com.example.ravindra.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {
	private ProductRepository repository;

	public Product addproduct(Product product) {
		return repository.save(product);

}
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);

}
	public List<Product> getProducts() {
		return repository.findAll();

}
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);

}

	public Product getProductByName(String name) {
		return repository.findByName(name).orElse(null);

}
	public String deleteProductById(int id) {
		repository.deleteById(id);
		return "product delected"+id;

}
	public Product updateProductById(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);}}