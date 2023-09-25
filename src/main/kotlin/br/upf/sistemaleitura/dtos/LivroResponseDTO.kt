package br.upf.sistemaleitura.dtos

import br.upf.sistemaleitura.model.Status
import br.upf.sistemaleitura.model.StatusLeitura
import java.time.LocalDate
import java.time.LocalDateTime

data class LivroResponseDTO (
    val id: Long?,
    val nome: String,
    val autor: String,
    val resenha: String
)