package com.lista2.lista_spring.entity;

import java.math.BigDecimal;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "o nome nao pode ser nulo")
    @Size(min = 2, message = "o nome deve ter mais que dois caracteres")
    private String nome;

    @NotBlank(message = "o preco nao pode ser nulo")
    @Size(min = 2, message = "o nome deve ter mais que dois caracteres")
    @Min(value = 0, message = "o preço deve ser maior ou igual a 0")
    private BigDecimal preco;

    @NotBlank(message = "a quantidade nao pode ser nulo")
    @Size(min = 2, message = "o nome deve ter mais que dois caracteres")
    @Min(value = 0, message = "a quantidade deve ser maior ou igual a 0")

    private Integer quantidade;

}
