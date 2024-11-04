package br.com.canalandersonandrade.oracleliteralura.services;

import br.com.canalandersonandrade.oracleliteralura.records.BooksRecord;
import br.com.canalandersonandrade.oracleliteralura.repository.interfaces.BookRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 04/11/2024
 */
@Service
public class BookService {

    private final BookRepositoryInterface bookRepository;

    public BookService(BookRepositoryInterface bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<BooksRecord> findBook(String nomeAutor) {
        return bookRepository.buscaPorAutor(nomeAutor);
    }
}
