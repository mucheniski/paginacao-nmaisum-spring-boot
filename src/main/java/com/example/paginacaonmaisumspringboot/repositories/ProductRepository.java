package com.example.paginacaonmaisumspringboot.repositories;

import com.example.paginacaonmaisumspringboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     *
     * O JOIN FETCH evita que várias consultas sejam feitas para cada categoria de produto, e faz uma unica consulta retornado
     * todas as categorias de uma vez
     */
    @Query("SELECT product From Product product JOIN FETCH product.categories")
    List<Product> findProcutsWithCategories();

}