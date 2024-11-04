package br.com.canalandersonandrade.oracleliteralura.controller;

import br.com.canalandersonandrade.oracleliteralura.client.LivroApiClient;
import br.com.canalandersonandrade.oracleliteralura.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 02/11/2024
 */
@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final LivroApiClient livroApiClient;
    private final BookService bookService;


    public HomeController(LivroApiClient livroApiClient, BookService bookService) {
        this.livroApiClient = livroApiClient;
        this.bookService = bookService;
    }

    @GetMapping
    public String index(Model model) {
        logger.info("Método teste() chamado."); // Log para depuração
        model.addAttribute("mensagem", "Olá, Mundo!");
        return "index";
    }

    @ResponseBody
    @GetMapping("teste")
    public String teste(){
         return livroApiClient.requisitarBook("search=Dom%20Casmurro").get().toString();
    }

    @ResponseBody
    @GetMapping("buscaPorNome")
    public String bascaNomeAutor(@RequestParam("nome") String nomeAutor){
        return bookService.findBook(nomeAutor).get().toString();
    }
}