package com.lgs.caixa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lgs.caixa.entities.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
