INSERT INTO alunos (nome) VALUES
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

INSERT INTO tutores (nome, especialidade) VALUES
    ('Ana Souza', 'Java'),
    ('Carlos Ferreira', 'Angular'),
    ('Juliana Lima', 'JavaScript');

INSERT INTO agendas (alunos, tutores, data, status, tema, descricao) VALUES
    (7, 1, '2024-03-28', 'Confirmado', 'Introdução ao Java', 'Revisão para prova'),
    (2, 2, '2024-04-02', 'Pendente', 'Desenvolvimento Web - Angular', 'Auxílio na criação de um projeto'),
    (3, 2, '2024-03-30', 'Confirmado', 'HTML Avançado', 'Resolução de dúvidas de CSS'),
    (4, 3, '2024-04-05', 'Pendente', 'Fundamentos de JavaScript', 'Atividade Pratica'),
    (5, 2, '2024-04-10', 'Confirmado', 'Java Avançado', 'Revisão para prova prática');

INSERT INTO materiais (agendas, descricao, caminhoArquivo) VALUES
    (1, 'Slides de Introdução ao Java', 'https://exemplo.com/slides_java.pdf'),
    (2, 'Tutorial de Angular', 'https://exemplo.com/tutorial_angular.docx'),
    (3, 'Exemplos de código de HTML/CSS', 'https://exemplo.com/exemplos_html_css.zip'),
    (4, 'Material de estudo de Javascript', 'https://exemplo.com/material_javascript.pdf'),
    (5, 'Projeto de exemplo de Java', 'https://exemplo.com/projeto_java.pdf');

