package br.upf.sistemaleitura.repository

import br.upf.sistemaleitura.model.Livro
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LivroRepository: JpaRepository<Livro, Long> {

    fun findByNome(nomeLivro: String, paginacao: Pageable): Page<Livro>
}