package com.brunoval.catalogoprodutosapi.controller;

import com.brunoval.catalogoprodutosapi.model.Produto;
import com.brunoval.catalogoprodutosapi.model.ProdutoDTO;
import com.brunoval.catalogoprodutosapi.model.ProdutoForm;
import com.brunoval.catalogoprodutosapi.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Produto>> getProdutos() {
//        TODO paginacao
        return ResponseEntity.ok(produtoService.getListaProdutos());
    }

    @PostMapping("/")
    public ResponseEntity<ProdutoDTO> postProdutos(@Valid @RequestBody ProdutoForm form, UriComponentsBuilder uriBuilder) {

        ProdutoDTO created = produtoService.addProduto(form);
        return ResponseEntity.created(uriBuilder.path("/{idProduto}").buildAndExpand(created.getId()).toUri()).body(created);
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<ProdutoDTO> getProdutoByID(@PathVariable Long idProduto) {
        return ResponseEntity.ok(produtoService.getProdutoById(idProduto));
    }

    @PatchMapping("/{idProduto}")
    public ResponseEntity<ProdutoDTO> updateProduto(@PathVariable Long idProduto, @Valid @RequestBody ProdutoForm form) {
        //TODO quais campos podem ser alterados?
        ProdutoDTO updated = produtoService.updateProduto(idProduto, form);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<String> deleteProduto(@PathVariable Long idProduto) {
        produtoService.deleteProduto(idProduto);
        return ResponseEntity.noContent().build();
    }
}