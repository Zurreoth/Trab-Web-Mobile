package br.upf.sistemaleitura.converters

import br.upf.sistemaleitura.dtos.LivroDTO
import br.upf.sistemaleitura.dtos.LivroResponseDTO
import br.upf.sistemaleitura.model.Livro
import org.springframework.stereotype.Component

@Component
class LivroConverter {
    fun toLivro(dto: LivroDTO): Livro {
        return Livro(
            nome = dto.nome,
            autor = dto.autor,
            resenha = dto.resenha,
            leitores = listOf()
        )
    }

    fun toLivroResponseDTO(livro: Livro): LivroResponseDTO {
        return LivroResponseDTO(
            id = livro.id,
            nome = livro.nome,
            autor = livro.autor,
            resenha = livro.resenha
        )
    }
}