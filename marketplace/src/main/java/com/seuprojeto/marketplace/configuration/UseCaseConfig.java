package com.seuprojeto.marketplace.configuration;

import com.seuprojeto.marketplace.application.usecase.CalculateCartUseCase;
import com.seuprojeto.marketplace.domain.repository.ProductRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CalculateCartUseCase calculateCartUseCase(ProductRepository repository) {
        return new CalculateCartUseCase(repository);
    }
}