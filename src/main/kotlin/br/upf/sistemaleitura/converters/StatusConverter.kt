package br.upf.sistemaleitura.converters

import br.upf.sistemaleitura.dtos.StatusDTO
import br.upf.sistemaleitura.dtos.StatusResponseDTO
import br.upf.sistemaleitura.model.Status
import br.upf.sistemaleitura.model.StatusLeitura
import br.upf.sistemaleitura.service.LivroService
import br.upf.sistemaleitura.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class StatusConverter (
        var usuarioService: UsuarioService,
        var livroService: LivroService
) {
    fun toStatusResponseDTO(status: Status): StatusResponseDTO {
        return StatusResponseDTO(
            id = status.id,
            usuario = status.usuario.id,
            livro = status.livro.id,
            nota = status.nota,
            status = status.status.name,
        )
    }

    fun toStatus(dto: StatusDTO): Status {
        return Status(
            usuario = usuarioService.buscarUsuarioPorId(dto.usuario),
            livro = livroService.buscarLivroPorId(dto.livro),
            nota = dto.nota,
            status = StatusLeitura.valueOf(dto.status),
        )
    }
}
