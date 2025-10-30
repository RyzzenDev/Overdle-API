package com.overdaily.Overdaily.Config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Overwatch API")
                        .version("v1")
                        .description("Esta é a API que o nosso time criou para o Overdle. Para mais detalhes sobre o projeto, " +
                                "veja o **[repositório no GitHub](https://github.com/RyzzenDev/OverDaily)**. " +
                                "Sinta-se à vontade para abrir uma issue se encontrar algum problema."));

    }
}