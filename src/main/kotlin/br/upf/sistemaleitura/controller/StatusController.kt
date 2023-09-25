package br.upf.sistemaleitura.controller

import br.upf.sistemaleitura.dtos.StatusDTO
import br.upf.sistemaleitura.dtos.StatusResponseDTO
import br.upf.sistemaleitura.service.StatusService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/status")
class StatusController(val service: StatusService) {

    @GetMapping
    fun listar(): List<StatusResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): StatusResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: StatusDTO,
                 uriBuilder: UriComponentsBuilder
    ): ResponseEntity<StatusResponseDTO> {
        val statusResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/status/${statusResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(statusResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: StatusDTO
    ): StatusResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}