package com.seuprojeto.marketplace.configuration;

import com.seuprojeto.marketplace.application.usecase.CalcularCarrinhoUseCase;
import com.seuprojeto.marketplace.domain.repository.ProdutoRepositorio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoUseCase {

    @Bean
    public CalcularCarrinhoUseCase calcularCarrinhoUseCase(ProdutoRepositorio repository) {
        return new CalcularCarrinhoUseCase(repository);
    }
}