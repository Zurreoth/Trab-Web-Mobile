package br.upf.sistemaleitura.dtos

import br.upf.sistemaleitura.model.StatusLeitura
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.time.LocalDateTime

data class LivroDTO(
    @field:NotBlank(message = "Livro sempre deve ter um nome")
    val nome: String,
    @field:NotNull(message = "Livro sempre deve ter um autor")
    val autor: String,
    val resenha: String,
)