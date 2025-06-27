package com.lfrank.revendas.business;

import com.lfrank.revendas.infra.entitys.Product;
import com.lfrank.revendas.infra.repository.ProductRepository;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void saveProduct(Product product) {
        repository.saveAndFlush(product);
    }

    public Product searchProductByName(String name){
        return repository.findByName(name).orElseThrow(
                () -> new RuntimeException("Produto não encontrado")
        );
    }

    public void deleteProductByName(String name){
        repository.deleteByName(name);
    }


    public void updateProductById(Integer id, Product product){
        Product productEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Product productUpdated = Product.builder()
                .name(product.getName() != null ? product.getName() : productEntity.getName())
                .price(product.getPrice() != null ? product.getPrice() : productEntity.getPrice())
                .brand(product.getBrand() != null ? product.getBrand() : productEntity.getBrand())
                .quantity(product.getQuantity() != null ? product.getQuantity() : productEntity.getQuantity())
                .type(product.getType() != null ? product.getType() : productEntity.getType())
                .id(productEntity.getId())
                .build();

        repository.saveAndFlush(productUpdated);
    }

}
