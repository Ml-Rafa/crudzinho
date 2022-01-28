package com.example.recapitulandospring.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;



// Entity indica conecsão com o banco de dados
// @Data substitui get and set
@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotBlank
    private String nome;
    private String categoria;
    private Double preco;
    private Double desconto = 0.0;

    public Produto(String nomeDoProduto, String categoriaDoProduto, double precoDoProduto, double descontoDoProduto) {

        this.nome = nomeDoProduto;
        this.categoria = categoriaDoProduto;
        this.preco = precoDoProduto;
        this.desconto = descontoDoProduto;
    }
    public Produto(){

    }

}
