package com.lista.listadef.model;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, message = "deve ser maior que 3")
    private String nome;

    @NotNull
    @Positive(message = "O preço deve ser maior que zero.")
    private BigDecimal preco;

    @PositiveOrZero(message = "A quantidade deve ser maior ou igual zero.")
    private Integer quantidade = 0;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

}
