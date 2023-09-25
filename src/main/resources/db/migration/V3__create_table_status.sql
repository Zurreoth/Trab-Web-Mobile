CREATE TABLE `status` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `status` enum('LIDO', 'PLANEJO_LER', 'PAREI', 'LENDO') DEFAULT NULL,
 `nota` INT NOT NULL,
 `livro_id` bigint NOT NULL,
 `usuario_id` bigint NOT NULL,
 FOREIGN KEY (`livro_id`) REFERENCES `livro` (`id`),
 FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
);