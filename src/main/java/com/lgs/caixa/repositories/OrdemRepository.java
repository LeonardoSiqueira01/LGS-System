package com.lgs.caixa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lgs.caixa.entities.Pedido;

@Repository
public interface OrdemRepository extends JpaRepository<Pedido, Long> {

}
