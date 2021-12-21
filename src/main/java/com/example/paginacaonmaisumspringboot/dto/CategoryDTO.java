package com.example.paginacaonmaisumspringboot.dto;

import com.example.paginacaonmaisumspringboot.entities.Category;
import lombok.Data;

@Data
public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO(Category category) {
        id = category.getId();
        name = category.getName();
    }

}
