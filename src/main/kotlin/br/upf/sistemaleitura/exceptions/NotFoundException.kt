package br.upf.sistemaleitura.exceptions

import java.lang.RuntimeException

class NotFoundException(override val message: String)
    : RuntimeException()