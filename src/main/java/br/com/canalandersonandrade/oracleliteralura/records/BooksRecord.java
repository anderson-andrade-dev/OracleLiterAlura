package br.com.canalandersonandrade.oracleliteralura.records;

import br.com.canalandersonandrade.oracleliteralura.entity.Book;

import java.util.List;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 02/11/2024
 */
public record BooksRecord(long count, String next, String previous, List<BookRecord> results){}