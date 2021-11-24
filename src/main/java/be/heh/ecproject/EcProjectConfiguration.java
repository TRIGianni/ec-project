package be.heh.ecproject;

import be.heh.ecproject.product.adapter.out.persistence.ProductPersistenceAdapter;
import be.heh.ecproject.product.adapter.out.persistence.ProductRepository;
import be.heh.ecproject.product.application.port.in.DisplayListProductsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@Profile("prod")
@Configuration
@EnableJpaRepositories
public class EcProjectConfiguration {

    @Autowired
    private ProductRepository productRepository;
    @Bean
    DisplayListProductsUseCase getDisplayListProductsUseCase() {

        return new ProductPersistenceAdapter(productRepository);
    }
}
