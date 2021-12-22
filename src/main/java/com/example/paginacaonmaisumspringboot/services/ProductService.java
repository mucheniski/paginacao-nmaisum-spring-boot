package com.example.paginacaonmaisumspringboot.services;

import com.example.paginacaonmaisumspringboot.dto.ProductDTO;
import com.example.paginacaonmaisumspringboot.entities.Product;
import com.example.paginacaonmaisumspringboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductDTO> find(PageRequest pageRequest) {
        List<Product> products = repository.findProcutsWithCategories();
        return products.stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());
    }
}
