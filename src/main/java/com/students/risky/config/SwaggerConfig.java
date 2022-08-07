package com.students.risky.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.students.risky"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointsInfo());
    }
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Spring Boot Öğrenci-Ders-Sınıf-Öğretmen İlişkisi")
                .description("""
                         --API Açıklama testi--
                         **_OKUNMALI_**\s
                         Eğer herhangi bir nesneyi eklemek istemiyorsanız, `## Eklemek istemediğiniz nesneyi JSON'dan siliniz. Nesneye NULL ifadeside verebilirsiniz. `\s
                        - Örnek olarak:
                         **Öğretmen ekliyorsunuz ve sınıfının olmamasını istiyorsanız**, o halde JSON'dan **responsibleClass'ı silmek yeterli olacaktır.**\s
                         Bunu sınıf veya öğrenci kontrolleri üzerindende yapabilirsiniz.\s
                         \s
                         **_ÖNEMLİ_**\s
                         Herşey ID'ler üzerinden yönetiliyor. **Sildiğiniz bir nesne, diğer tablolara etki edecektir.**\s
                         \s
                         - Örnek olarak:
                         Bir öğretmenin sınıfını güncellemek istediğimizde, o sınıfın ID'sini Update Teacher kısmında JSON içindeki responsibleClass objesine yazmak yeterli olur. **`'responsibleClass': 1`**""")
                .contact(new Contact("Yunus Yıldız", "", ""))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }
}
