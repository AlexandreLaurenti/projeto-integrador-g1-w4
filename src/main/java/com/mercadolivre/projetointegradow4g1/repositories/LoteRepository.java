package com.mercadolivre.projetointegradow4g1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadolivre.projetointegradow4g1.entities.Lote;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> {

}
