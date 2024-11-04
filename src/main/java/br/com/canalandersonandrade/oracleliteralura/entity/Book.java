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
    private String mediaType;
    private Map<String,String> formats;
    private Double downloadCount;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", translators=" + translators +
                ", bookshelves=" + bookshelves +
                ", languages=" + languages +
                ", copyright=" + copyright +
                ", mediaType='" + mediaType + '\'' +
                ", formats=" + formats +
                ", downloadCount=" + downloadCount +
                '}';
    }
}




