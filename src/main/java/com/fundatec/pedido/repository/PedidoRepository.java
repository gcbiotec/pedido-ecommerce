package com.fundatec.pedido.repository;

import com.fundatec.pedido.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Classe responsável pela interface com o banco de dados
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
