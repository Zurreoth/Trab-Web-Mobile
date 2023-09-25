package br.upf.sistemaleitura.service

import br.upf.sistemaleitura.converters.LivroConverter
import br.upf.sistemaleitura.dtos.LivroDTO
import br.upf.sistemaleitura.dtos.LivroResponseDTO
import br.upf.sistemaleitura.exceptions.NotFoundException
import br.upf.sistemaleitura.repository.LivroRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val EVENTO_NOT_FOUND_MESSAGE = "Livro não encontrado!"

@Service
class LivroService(
    private val repository: LivroRepository,
    private val converter: LivroConverter
) {

    fun listar(
        nomeLivro: String?,
        paginacao: Pageable): Page<LivroResponseDTO> {
        val livros = if (nomeLivro == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeLivro, paginacao)
        }
        return livros
            .map(converter::toLivroResponseDTO)
    }

    fun buscarPorId(id: Long): LivroResponseDTO {
        val livro = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
        return converter.toLivroResponseDTO(livro)
    }

    fun cadastrar(dto: LivroDTO): LivroResponseDTO {
        return converter.toLivroResponseDTO(
            repository.save(converter.toLivro(dto))
        )
    }

    fun atualizar(id: Long, dto: LivroDTO): LivroResponseDTO {
        val livro = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                autor = dto.autor,
                resenha = dto.resenha
            )
        return converter.toLivroResponseDTO(repository.save(livro))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}