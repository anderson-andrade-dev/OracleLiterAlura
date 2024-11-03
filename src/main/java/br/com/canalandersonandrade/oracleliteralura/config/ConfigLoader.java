package br.com.canalandersonandrade.oracleliteralura.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 02/11/2024
 */

@Component
public class ConfigLoader {
    private static final Properties prop = new Properties();

    public ConfigLoader() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if(input == null){
                throw new IllegalArgumentException("Arquivo de configuração não encontrado");
            }

            prop.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar configurações", e);
        }
    }

    public String getUrl(){
        return prop.getProperty("url");
    }
}
