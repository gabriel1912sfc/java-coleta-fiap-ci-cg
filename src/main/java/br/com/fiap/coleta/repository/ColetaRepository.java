package br.com.fiap.coleta.repository;

import br.com.fiap.coleta.model.Coleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColetaRepository extends JpaRepository<Coleta, Long> {

}
