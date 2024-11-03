package br.com.canalandersonandrade.oracleliteralura.entity;

import java.util.List;
import java.util.Map;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 02/11/2024
 */
public class Book {
    private Long id;
    private String title;
    private List<Author> authors;
    private List<Person> translators;
    private List<String>bookshelves;
    private List<String>languages;
    private boolean copyright;
    private String media_type;
    private Map<String,String> formats;
    private Double download_count;

}




