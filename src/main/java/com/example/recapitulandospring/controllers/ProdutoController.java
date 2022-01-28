package com.example.recapitulandospring.controllers;

import com.example.recapitulandospring.models.Produto;
import com.example.recapitulandospring.models.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController

// RequestMapping aponta a url que precisa ser chamada
@RequestMapping("/api/pedidos")

public class ProdutoController {

    // Autowired para instanciar um novo objeto;
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public Produto novoProduto(@Valid Produto produto) {
        //@valid para validar oque pediu na classe produto

        produtoRepository.save(produto);
        return produto;

    }

    // esse methodo vai retornar a lista completa
    @GetMapping
    public Iterable <Produto> obterProduto(){
        return produtoRepository.findAll();
    }

    // esse methodo faz pesquisa por string que contem na coluna nome
    @GetMapping(path = "/nome/{nomes}")
    public Iterable<Produto> consultarPorString(@PathVariable String nomes){

        return produtoRepository.findByNomeContainingIgnoreCase(nomes);
    }

    // esse methodo retorna uma consuta por pagina
    @GetMapping(path = "/pagina/{numeroDePagina}")
        public Iterable<Produto>produtoPorPagina(@PathVariable int numeroDePagina){

        Pageable pag = PageRequest.of(numeroDePagina, 3);
        return produtoRepository.findAll(pag);
    }

    //esse methodo vai retornar o produto por id
    @GetMapping(path ="/{id}")
    public Optional<Produto> obterPorId(@PathVariable int id){
        return produtoRepository.findById(id);
    }
    @PutMapping
    public Produto alterarProduto(Produto produto){
        produtoRepository.save(produto);
        return produto;
    }
    @DeleteMapping(path ="/{id}")
    public void deletarPorId(@PathVariable int id){
        produtoRepository.deleteById(id);
    }

}
