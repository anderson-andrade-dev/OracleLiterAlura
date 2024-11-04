package br.com.canalandersonandrade.oracleliteralura.records;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 04/11/2024
 */
public record AuthorRecord(
        long id,
        String name,
        int birthYear,
        int deathYear
) {
}
