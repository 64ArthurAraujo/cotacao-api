package cc.wordview.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "cc.wordview.api" })
public class Application {

        public static void main(String[] args) throws Exception {
                SpringApplication.run(Application.class, args);
        }
}
