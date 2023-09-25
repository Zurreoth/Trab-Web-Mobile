package br.upf.sistemaleitura.service

import br.upf.sistemaleitura.converters.StatusConverter
import br.upf.sistemaleitura.dtos.StatusDTO
import br.upf.sistemaleitura.dtos.StatusResponseDTO
import br.upf.sistemaleitura.exceptions.NotFoundException
import br.upf.sistemaleitura.repository.StatusRepository
import org.springframework.stereotype.Service

private const val STATUS_NOT_FOUND_MESSAGE = "Status não encontrado!"


@Service
class StatusService (
    var repository: StatusRepository,
    var converter: StatusConverter,
){
    fun listar(): List<StatusResponseDTO> {
        return repository.findAll()
            .map(converter::toStatusResponseDTO)
    }

    fun buscarPorId(id: Long): StatusResponseDTO {
        val status = repository.findById(id)
            .orElseThrow { NotFoundException(STATUS_NOT_FOUND_MESSAGE) }
        return converter.toStatusResponseDTO(status)
    }

    fun cadastrar(dto: StatusDTO): StatusResponseDTO {
        return converter.toStatusResponseDTO(
            repository.save(converter.toStatus(dto)))
    }

    fun atualizar(id: Long, dto: StatusDTO): StatusResponseDTO {
        val status = repository.findById(id)
            .orElseThrow { NotFoundException(STATUS_NOT_FOUND_MESSAGE) }
            .copy(
                usuario = dto.usuario,
                livro = dto.livro,
                nota = dto.nota,
                status = dto.status,
            )
        return converter.toStatusResponseDTO(repository.save(status))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }


}