package br.com.canalandersonandrade.oracleliteralura.client;

import br.com.canalandersonandrade.oracleliteralura.config.ConfigLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 02/11/2024
 */
public class LivroApiClientTest {

    @Test
    public void testarConexaoComAPI(){
        LivroApiClient api = new LivroApiClient(new ConfigLoader());
        api.requisitarBook("search=Dom%20Casmurro");
        Assertions.assertTrue(true);
    }
}
