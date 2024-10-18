package com.brunoval.catalogoprodutosapi.service;

import com.brunoval.catalogoprodutosapi.model.Produto;
import com.brunoval.catalogoprodutosapi.model.ProdutoDTO;
import com.brunoval.catalogoprodutosapi.model.ProdutoForm;
import com.brunoval.catalogoprodutosapi.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getListaProdutos() {
        return produtoRepository.findAll();
    }

    @Transactional
    public ProdutoDTO addProduto(@Valid ProdutoForm form) {
        Produto save = produtoRepository.save(form.toProdutoEntity());
        return new ProdutoDTO(save);
    }

    public ProdutoDTO getProdutoById(Long idProduto) {
        return new ProdutoDTO(produtoRepository.findById(idProduto).orElseThrow());
    }

    @Transactional
    public ProdutoDTO updateProduto(Long idProduto, ProdutoForm form) {
        produtoRepository.updateProdutoById(form.getNome(), form.getValor(), form.getDescricao(), idProduto);
        return new ProdutoDTO(produtoRepository.findById(idProduto).orElseThrow());
    }

    @Transactional
    public void deleteProduto(Long idProduto) {
        produtoRepository.deleteById(idProduto);
    }
}