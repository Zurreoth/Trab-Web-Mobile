package br.upf.sistemaleitura.dtos

import br.upf.sistemaleitura.model.Livro
import br.upf.sistemaleitura.model.StatusLeitura
import br.upf.sistemaleitura.model.Usuario
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class StatusDTO(
    @field:NotBlank(message = "Deve haver Status!")
    val status: StatusLeitura,
    @field:NotNull(message = "Status deve ter Usuário!")
    val usuario: Usuario,
    @field:NotNull(message = "Status deve ter Livro!")
    val livro: Livro,
    val nota: Int,
)
