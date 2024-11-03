package br.com.canalandersonandrade.oracleliteralura.controller;

import br.com.canalandersonandrade.oracleliteralura.client.LivroApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 02/11/2024
 */
@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final LivroApiClient livroApiClient;

    public HomeController(LivroApiClient livroApiClient) {
        this.livroApiClient = livroApiClient;
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
}