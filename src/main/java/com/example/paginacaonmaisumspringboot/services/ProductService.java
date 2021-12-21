package com.example.paginacaonmaisumspringboot.services;

import com.example.paginacaonmaisumspringboot.dto.ProductDTO;
import com.example.paginacaonmaisumspringboot.entities.Product;
import com.example.paginacaonmaisumspringboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> find(PageRequest pageRequest) {
        Page<Product> list = repository.findAll(pageRequest);
        return list.map(x -> new ProductDTO(x));
    }
}
