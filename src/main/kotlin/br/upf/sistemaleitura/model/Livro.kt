package br.upf.sistemaleitura.model

import jakarta.persistence.*

@Entity
data class Livro(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val autor: String,
    val resenha: String,

    @OneToMany(mappedBy = "livro")
    val leitores: List<Status> = listOf()
)
