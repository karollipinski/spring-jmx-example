package net.atos.springjmxexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;

@EnableMBeanExport
@SpringBootApplication
public class SpringJmxExampleApplication {

    @Bean
    public Resource jmxResource() {
        return new Resource();
    }

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringJmxExampleApplication.class, args);

        Resource resource = context.getBean(Resource.class);
        resource.addItem("Item");
        Thread.sleep(Long.MAX_VALUE);
    }

}
