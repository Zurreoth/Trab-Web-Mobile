package br.upf.sistemaleitura.controller

import br.upf.sistemaleitura.dtos.LivroDTO
import br.upf.sistemaleitura.dtos.LivroResponseDTO
import br.upf.sistemaleitura.service.LivroService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/livros")
class LivroController(val service: LivroService) {

    @GetMapping
    fun listar(
        @RequestParam(required = false) nomeLivro: String?,
        @PageableDefault(size = 10, sort = ["nome"]) paginacao: Pageable)
    : Page<LivroResponseDTO> {
        return service.listar(nomeLivro, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): LivroResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastra(@RequestBody @Valid dto: LivroDTO,
                 uriBuilder: UriComponentsBuilder
    ): ResponseEntity<LivroResponseDTO> {
        val livroResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/livros/${livroResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(livroResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: LivroDTO
    ): LivroResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}