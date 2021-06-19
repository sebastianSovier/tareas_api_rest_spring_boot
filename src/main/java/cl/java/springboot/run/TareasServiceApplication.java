package cl.java.springboot.run;

import cl.java.springboot.bo.TareasBo;
import cl.java.springboot.rest.TareasController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackageClasses = TareasController.class)
public class TareasServiceApplication {


    @Bean
    public RestTemplate getresttemplate() {
        return new RestTemplate();
    }
    @Bean
    public TareasBo getTareasBo() {
        return new TareasBo();
    }

    public static void main(String[] args) {
        SpringApplication.run(TareasServiceApplication.class, args);
    }

}
