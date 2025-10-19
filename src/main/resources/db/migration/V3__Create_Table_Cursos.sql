CREATE TABLE Cursos(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(120) NOT NULL,
    descricao VARCHAR(150) NOT NULL,
    carga_horaria INT NOT NULL,
    professor_id BIGINT NOT NULL,
    FOREIGN KEY (professor_id) REFERENCES Professores(id)
);