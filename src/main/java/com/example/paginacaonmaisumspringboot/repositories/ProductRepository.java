package com.example.paginacaonmaisumspringboot.repositories;

import com.example.paginacaonmaisumspringboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}