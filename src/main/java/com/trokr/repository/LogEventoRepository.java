package com.trokr.repository;

import com.trokr.model.LogEvento;
import com.trokr.model.NivelLog;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogEventoRepository extends MongoRepository<LogEvento, String> {

    List<LogEvento> findByTipoOrderByTimestampDesc(String tipo);
    List<LogEvento> findByNivelAndTimestampBetween(NivelLog nivel, LocalDateTime inicio, LocalDateTime fim);
    
}