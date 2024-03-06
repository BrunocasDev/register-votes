package com.bruno.registervotes.domain.repository;

import com.bruno.registervotes.domain.entity.MesaVoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaVotoRepository extends JpaRepository<MesaVoto, Long> {
}
