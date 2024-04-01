CREATE TABLE alunos(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE tutores(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    especialidade VARCHAR(100) NOT NULL
);

CREATE TABLE agendas(
    id BIGSERIAL PRIMARY KEY,
    alunos INT REFERENCES alunos(id),
    tutores INT REFERENCES tutores(id),
    data DATE NOT NULL,
    status VARCHAR(20),
    tema VARCHAR(100),
    descricao TEXT
);

CREATE TABLE materiais(
    id SERIAL PRIMARY KEY,
    agendas INT REFERENCES Agendas(id),
    descricao TEXT,
    caminhoArquivo TEXT NOT NULL
);
