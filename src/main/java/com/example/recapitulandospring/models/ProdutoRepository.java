package com.example.recapitulandospring.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto,Integer> {

    Iterable<Produto>findByNomeContainingIgnoreCase(String nomes);
}
