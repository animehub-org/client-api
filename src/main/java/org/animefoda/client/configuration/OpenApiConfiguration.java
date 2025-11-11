package org.animefoda.client.configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sua API de Módulos de Projeto")
                        .version("1.0")
                        .description("Documentação da API REST para Autenticação e Dados.")
                );
    }
}
