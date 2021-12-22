package com.example.paginacaonmaisumspringboot.controllers;

import com.example.paginacaonmaisumspringboot.dto.ProductDTO;
import com.example.paginacaonmaisumspringboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<ProductDTO> productDTOS = service.find(pageRequest);
        return ResponseEntity.ok(productDTOS);
    }

}
