package br.upf.sistemaleitura.model

import jakarta.persistence.*

@Entity
data class Status(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    val usuario: Usuario,
    @ManyToOne
    val livro: Livro,
    val nota: Int,
    @Enumerated(value = EnumType.STRING)
    val status: StatusLeitura,
)
