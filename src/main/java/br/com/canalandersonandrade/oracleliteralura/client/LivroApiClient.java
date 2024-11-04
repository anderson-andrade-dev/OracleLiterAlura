package br.com.canalandersonandrade.oracleliteralura.client;

import br.com.canalandersonandrade.oracleliteralura.config.ConfigLoader;
import br.com.canalandersonandrade.oracleliteralura.records.BooksRecord;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;


/**
 * @author Anderson Andrade Dev
 * @Data de Criação 02/11/2024
 */
@Service
public class LivroApiClient {

    private static final Logger logger = LoggerFactory.getLogger(LivroApiClient.class);
    private final String url;
    private final Gson gson;
    private final HttpClient client = HttpClient.newHttpClient();

    public LivroApiClient(ConfigLoader config) {
        this.url = config.getUrl();
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    public Optional<BooksRecord> requisitarBook(String paramentro) {
        String urlApi = String.format("%s%s", url, paramentro);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlApi))
                .timeout(Duration.ofSeconds(60))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 301 || response.statusCode() == 302){
                String location = response.headers().firstValue("Location").orElse("Não foi encontrado o cabeçalho Location");
                logger.error(String.format("Verifique a URL ela esta sendo redirecionada: %s",location));
            }

            if (response.statusCode() == 200) {

                return Optional.of(gson.fromJson(response.body(), BooksRecord.class));

            } else {
                logger.error(String.format("Erro na Conexão %s", response.statusCode()));
            }

        } catch (IOException | InterruptedException e) {
            logger.error(String.format("Erro ao requisitar API: %s", e.getMessage()));
        }
        return Optional.empty();
    }
}
