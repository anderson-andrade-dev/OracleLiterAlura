package br.com.canalandersonandrade.oracleliteralura.repository.interfaces;

import br.com.canalandersonandrade.oracleliteralura.records.BooksRecord;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 04/11/2024
 */
public interface BookRepositoryInterface {
    Optional<BooksRecord> buscaPorAutor(String nomeAutor);
}
