package cargoes.web.configuration.mvc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Swagger2Configuration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("cargoes.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    //构建 api文档的详细信息函数
    private ApiInfo apiInfo() {
    	Contact con = new Contact();
    	con.setName("cargoes");
    	con.setUrl("/cargoes");
    	con.setEmail("1234567@cargoes.top");
        return new ApiInfoBuilder()
                //页面标题
                .title("cargoes系统接口文档")
                //版本号
                .version("1.X")
                //描述
                .description("API描述")
                .build();
    }
}