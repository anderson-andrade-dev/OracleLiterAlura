package br.com.canalandersonandrade.oracleliteralura.records;

import br.com.canalandersonandrade.oracleliteralura.entity.Author;
import br.com.canalandersonandrade.oracleliteralura.entity.Person;

import java.util.List;
import java.util.Map;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 04/11/2024
 */
public record BookRecord(
        long id,
        String title,
        List<AuthorRecord> authors,
        List<PersonRecord> translators,
        List<String> bookshelves,
        List<String> languages,
        Map<String,String >formats,
        boolean copyright,
        String mediaType,
        double downloadCount
) {}
