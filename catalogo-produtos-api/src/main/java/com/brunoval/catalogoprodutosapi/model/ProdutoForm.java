package com.brunoval.catalogoprodutosapi.model;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

public class ProdutoForm {

    @NotNull @Length(min = 1, max = 100)
    @Value("Nome")
    private String nome;
    @NotNull
    @Value("Valor")
    private BigDecimal valor;
    @Length(min = 3, max = 255)
    @Value("Descricao")
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Produto toProdutoEntity() {
        return new Produto(null, this.nome, this.valor, this.descricao);
    }
}
