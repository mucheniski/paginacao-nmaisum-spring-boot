package com.example.paginacaonmaisumspringboot.dto;

import com.example.paginacaonmaisumspringboot.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProductDTO {

    private Long id;
    private String name;

    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        categories = product.getCategories().stream().map(category -> new CategoryDTO(category)).collect(Collectors.toList());
    }

}
