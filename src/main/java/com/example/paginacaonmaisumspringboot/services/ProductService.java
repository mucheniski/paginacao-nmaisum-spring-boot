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
    public Page<ProductDTO> find(PageRequest pageRequest) {
        Page<Product> pageProducts = repository.findAll(pageRequest);

        /**
         * Quando o ProductDTO for buscar as categorias, elas ja estaram em cache assim nao vao ser feitas novas consultas
         * isso e o padrao mapa de identidade nos padroes de arquitetura corporativa
         * mapa de identidade nao busca o mesmo objeto mais de uma vez no mesmo contexto em banco de dados
         * as ferramentas ORM usam isso
         * fazendo essa chamada do metodo abaixo findProcutsWithCategories, as categorias ja ficam em memoria, depois retornando o page normalmente
         * ja devem buscar do que esta em memoria na lista de pageProducts
         */
        repository.findProcutsWithCategories(pageProducts.stream().collect(Collectors.toList()));

        return pageProducts.map(product -> new ProductDTO(product));
    }
}
