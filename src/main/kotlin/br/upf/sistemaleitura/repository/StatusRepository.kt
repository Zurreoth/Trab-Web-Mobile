package br.upf.sistemaleitura.repository

import br.upf.sistemaleitura.model.Status
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StatusRepository: JpaRepository<Status, Long> {
}