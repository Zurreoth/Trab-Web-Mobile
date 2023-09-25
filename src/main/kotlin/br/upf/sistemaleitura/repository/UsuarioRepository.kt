package br.upf.sistemaleitura.repository

import br.upf.sistemaleitura.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long> {
}
