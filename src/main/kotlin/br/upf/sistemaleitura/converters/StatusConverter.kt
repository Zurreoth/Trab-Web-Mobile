package br.upf.sistemaleitura.converters

import br.upf.sistemaleitura.dtos.StatusDTO
import br.upf.sistemaleitura.dtos.StatusResponseDTO
import br.upf.sistemaleitura.model.Status
import org.springframework.stereotype.Component

@Component
class StatusConverter {
    fun toStatusResponseDTO(status: Status): StatusResponseDTO {
        return StatusResponseDTO(
            id = status.id,
            usuario = status.usuario,
            livro = status.livro,
            nota = status.nota,
            status = status.status,
        )
    }

    fun toStatus(dto: StatusDTO): Status {
        return Status(
            usuario = dto.usuario,
            livro = dto.livro,
            nota = dto.nota,
            status = dto.status,
        )
    }
}
