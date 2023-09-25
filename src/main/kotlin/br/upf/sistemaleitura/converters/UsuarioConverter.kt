package br.upf.sistemaleitura.converters

import br.upf.sistemaleitura.dtos.UsuarioDTO
import br.upf.sistemaleitura.dtos.UsuarioResponseDTO
import br.upf.sistemaleitura.model.Usuario
import org.springframework.stereotype.Component

@Component
class UsuarioConverter {
    fun toUsuarioResponseDTO(usuario: Usuario): UsuarioResponseDTO {
        return UsuarioResponseDTO(
            id = usuario.id,
            nome = usuario.nome,
            senha = usuario.senha
        )
    }

    fun toUsuario(dto: UsuarioDTO): Usuario {
        return Usuario(
            nome = dto.nome,
            senha = dto.senha
        )
    }
}
