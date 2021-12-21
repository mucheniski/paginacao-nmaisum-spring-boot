package com.example.paginacaonmaisumspringboot.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    /*
        https://stackoverflow.com/questions/69804273/ignite-2-10-0-org-h2-jdbc-jdbcsqlexception-function-lock-mode-not-found
        @EqualsAndHashCode.Exclude precisa ser adicionado para evitar o erro de java.lang.StackOverflowError\r\n\tat org.h2.command.Parser.readIf
     */
    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    Set<Category> categories = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

}
