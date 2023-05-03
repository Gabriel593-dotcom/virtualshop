package com.virtualshop.msproduct.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualshop.msproduct.entities.Product;
import com.virtualshop.msproduct.entities.dtos.ProductInputDTO;
import com.virtualshop.msproduct.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> findAll() {
        return repo.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> product = repo.findById(id);
        return product.get();
    }

    @Transactional
    public void saveProduct(ProductInputDTO productInputDTO) {
        Product product = producInputDTOToProduct(productInputDTO);
        repo.save(product);
    }

    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }

    public void updateProduct(ProductInputDTO updatedProductInputDTO, Long id) {
        Product product = findById(id);
        Product updatedProduct = producInputDTOToProduct(updatedProductInputDTO);
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setQuantity(updatedProduct.getQuantity());

        repo.save(product);
    }

    private Product producInputDTOToProduct(ProductInputDTO productInputDTO) {
        return new Product(null, productInputDTO.getName(), productInputDTO.getPrice(), productInputDTO.getQuantity());
    }
}
