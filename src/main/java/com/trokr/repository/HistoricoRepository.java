package com.trokr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.trokr.model.Historico;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {
    
    List<Historico> findByPropostaIdOrderByDataAsc(Long propostaId);
}
