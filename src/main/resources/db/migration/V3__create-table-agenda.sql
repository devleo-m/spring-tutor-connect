CREATE TABLE agenda(
    id_agenda BIGSERIAL PRIMARY KEY,
    id_aluno INT REFERENCES aluno(id_aluno),
    id_tutor INT REFERENCES tutor(id_tutor),
    data_agenda DATE NOT NULL,
    status_agenda VARCHAR(20),
    tema_agenda VARCHAR(100),
    descricao_breve TEXT
);
