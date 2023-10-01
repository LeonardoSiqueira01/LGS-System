package com.lgs.caixa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lgs.caixa.entities.OrdemPedido;


@Repository
public interface OrdemPedidoRepository extends JpaRepository<OrdemPedido, Long> {

}
