# API-de-Sistema-de-Biblioteca<br>


## DataBase
CREATE DATABASE biblioteca;<br>
USE biblioteca;


CREATE TABLE livro (<br>
id BIGINT AUTO_INCREMENT PRIMARY KEY,<br>
titulo VARCHAR(150) NOT NULL,<br>
autor VARCHAR(100) NOT NULL,<br>
ano_publicacao INT NOT NULL<br>
);<br>


CREATE TABLE usuario (<br>
id BIGINT AUTO_INCREMENT PRIMARY KEY,<br>
nome VARCHAR(100) NOT NULL,<br>
email VARCHAR(100) NOT NULL<br>
);<br>


CREATE TABLE emprestimo (<br>
id BIGINT AUTO_INCREMENT PRIMARY KEY,<br>
livro_id BIGINT NOT NULL,<br>
usuario_id BIGINT NOT NULL,<br>
data_emprestimo DATE NOT NULL,<br>
data_devolucao DATE,<br>
FOREIGN KEY (livro_id) REFERENCES livro(id),<br>
FOREIGN KEY (usuario_id) REFERENCES usuario(id)<br>
);<br>



## Tipo JSON para PostMan
/* TABELA livro<br><br>
{<br>
"titulo": "teste",<br>
"autor": "teste",<br>
"ano_publicacao" : 2026<br>
}<br>
*/

<br>/* TABELA usuario<br>
{<br>
"nome": "teste",<br>
"email": "teste"<br>
}<br>
*/

<br>/* TABELA emprestimo<br>
{<br>
"livro_id": 2,<br>
"usuario_id": 2,<br>
"data_emprestimo": "2021-02-19",<br>
"data_devolucao": "2022-03-01"<br>
}<br>
*/





