package com.trokr.repository;
 
import com.trokr.model.Avaliacao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
 
    List<Avaliacao> findByPropostaId(Long propostaId);
 
    List<Avaliacao> findByUsuarioAlvoId(Long usuarioId);
 
    List<Avaliacao> findByUsuarioAutorId(Long usuarioId);
 
    boolean existsByPropostaIdAndUsuarioAutorId(Long propostaId, Long usuarioAutorId);
 
    long countByUsuarioAlvoIdAndNotaIsNotNull(Long usuarioId);
 
    @Query("select avg(a.nota) from Avaliacao a where a.usuarioAlvo.id = :usuarioId")
    Double mediaDasNotasRecebidas(@Param("usuarioId") Long usuarioId);
}