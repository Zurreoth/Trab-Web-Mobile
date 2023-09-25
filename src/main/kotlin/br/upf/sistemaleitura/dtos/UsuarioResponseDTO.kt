package br.upf.sistemaleitura.dtos

data class UsuarioResponseDTO(val id: Long? = null,
                              val nome: String,
                              val senha: String)
