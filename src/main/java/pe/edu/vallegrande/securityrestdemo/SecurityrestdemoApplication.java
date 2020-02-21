package pe.edu.vallegrande.securityrestdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import pe.edu.vallegrande.securityrestdemo.entity.Product;
import pe.edu.vallegrande.securityrestdemo.repository.ProductRepository;

import java.math.BigDecimal;

@SpringBootApplication
public class SecurityrestdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityrestdemoApplication.class, args);
    }

    @Profile("securitydemo")
    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return args -> {
            productRepository.save(new Product("Tarro de leche 400ml", "GLORIA SAC", "4.80", "LACTEOS Y DERIVADOS", "A"));
            productRepository.save(new Product("Fideo spaguetti 250gr", "DON MAXIMO EIRL", "2.50", "SALSAS Y PASTAS", "A"));
            productRepository.save(new Product("Yogurt de vainilla 1lt", "GLORIA SAC", "5.20", "LACTEOS Y DERIVADOS", "A"));
            productRepository.save(new Product("Barra ded sublime 55gr", "M & M SAC", "2.70", "CHOCOLATES", "A"));
        };
    }
}
