CREATE TABLE aluno(
    id_aluno BIGSERIAL PRIMARY KEY,
    nome_aluno VARCHAR(255) NOT NULL
);

CREATE TABLE tutor(
    id_tutor BIGSERIAL PRIMARY KEY,
    nome_tutor VARCHAR(255) NOT NULL,
    especialidade_tutor VARCHAR(100) NOT NULL
);

CREATE TABLE agenda(
    id_agenda BIGSERIAL PRIMARY KEY,
    id_aluno INT REFERENCES aluno(id_aluno),
    id_tutor INT REFERENCES tutor(id_tutor),
    data_agenda DATE NOT NULL,
    status_agenda VARCHAR(20),
    tema_agenda VARCHAR(100),
    descricao_breve TEXT
);

CREATE TABLE material(
    id_material SERIAL PRIMARY KEY,
    id_agenda INT REFERENCES Agenda(id_agenda),
    descricao_material TEXT,
    caminho_arquivo TEXT
);

INSERT INTO aluno (nome_aluno) VALUES
    ('João Silva'),
    ('Maria Santos'),
    ('Pedro Oliveira'),
    ('Ana Paula'),
    ('Fernando Lima'),
    ('Carla Vieira'),
    ('Rafaela Martins'),
    ('Luiz Carlos'),
    ('Amanda Costa'),
    ('Diego Ferreira');

INSERT INTO tutor (nome_tutor, especialidade_tutor) VALUES
    ('Ana Souza', 'Java'),
    ('Carlos Ferreira', 'Angular'),
    ('Juliana Lima', 'JavaScript');

INSERT INTO agenda (id_aluno, id_tutor, data_agenda, status_agenda, tema_agenda, descricao_breve) VALUES
    (7, 1, '2024-03-28', 'Confirmado', 'Introdução ao Java', 'Revisão para prova'),
    (2, 2, '2024-04-02', 'Pendente', 'Desenvolvimento Web - Angular', 'Auxílio na criação de um projeto'),
    (3, 2, '2024-03-30', 'Confirmado', 'HTML Avançado', 'Resolução de dúvidas de CSS'),
    (4, 3, '2024-04-05', 'Pendente', 'Fundamentos de JavaScript', 'Atividade Pratica'),
    (5, 2, '2024-04-10', 'Confirmado', 'Java Avançado', 'Revisão para prova prática');

INSERT INTO material (id_agenda, descricao_material, caminho_arquivo) VALUES
    (1, 'Slides de Introdução ao Java', 'https://exemplo.com/slides_java.pdf'),
    (2, 'Tutorial de Angular', 'https://exemplo.com/tutorial_angular.docx'),
    (3, 'Exemplos de código de HTML/CSS', 'https://exemplo.com/exemplos_html_css.zip'),
    (4, 'Material de estudo de Javascript', 'https://exemplo.com/material_javascript.pdf'),
    (5, 'Projeto de exemplo de Java', 'https://exemplo.com/projeto_java.pdf');

