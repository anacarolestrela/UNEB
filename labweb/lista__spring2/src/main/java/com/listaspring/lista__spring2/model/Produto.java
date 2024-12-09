package com.listaspring.lista__spring2.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "valor nao pode ser nulo")
    @Size(min =3 , message = "nome deve ter mais que 3 caracteres")
    private String nome;
    @NotNull(message = "valor nao pode ser nulo")
    @Positive(message = "deve ser maior que 0")
    private BigDecimal preco;
    @Min(value = 0, message = "deve ser maior ou igual a 0")
    private Integer quantidade =0;

}
