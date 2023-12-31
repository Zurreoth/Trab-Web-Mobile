package br.upf.sistemaleitura.dtos

import br.upf.sistemaleitura.model.Livro
import br.upf.sistemaleitura.model.StatusLeitura
import br.upf.sistemaleitura.model.Usuario
import jakarta.persistence.*

data class StatusResponseDTO(
    val id: Long? = null,
    val usuario: Long?,
    val livro: Long?,
    val nota: Int,
    val status: String,
)
