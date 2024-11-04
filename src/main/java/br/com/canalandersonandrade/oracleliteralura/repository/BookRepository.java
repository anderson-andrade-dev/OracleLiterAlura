package br.com.canalandersonandrade.oracleliteralura.repository;

import br.com.canalandersonandrade.oracleliteralura.client.LivroApiClient;
import br.com.canalandersonandrade.oracleliteralura.records.BooksRecord;
import br.com.canalandersonandrade.oracleliteralura.repository.interfaces.BookRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 04/11/2024
 */

@Repository
public class BookRepository implements BookRepositoryInterface {
    private final LivroApiClient livroApiClient;

    public BookRepository(LivroApiClient livroApiClient) {
        this.livroApiClient = livroApiClient;
    }

    @Override
    public Optional<BooksRecord> buscaPorAutor(String nomeAutor) {
        String nomeDoAutorFormatado = String.format("search=%s",nomeAutor.replace(" ","%20"));
        return livroApiClient.requisitarBook(nomeDoAutorFormatado);
    }
}
