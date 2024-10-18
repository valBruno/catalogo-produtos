package com.brunoval.catalogoprodutosapi.repository;

import com.brunoval.catalogoprodutosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Modifying
    @Query("UPDATE Produto p SET p.nome = ?1, p.valor = ?2, p.descricao = ?3 WHERE p.id = ?4")
    void updateProdutoById(String nome, BigDecimal valor, String descricao, Long id);
}
