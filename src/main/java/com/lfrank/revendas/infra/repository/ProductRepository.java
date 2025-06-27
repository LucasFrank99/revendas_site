package com.lfrank.revendas.infra.repository;

import com.lfrank.revendas.infra.entitys.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByName(String name);

    @Transactional
    void deleteByName(String name);
}
