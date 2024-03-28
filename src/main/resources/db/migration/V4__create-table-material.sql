CREATE TABLE material(
    id_material SERIAL PRIMARY KEY,
    id_agenda INT REFERENCES Agenda(id_agenda),
    descricao_material TEXT,
    caminho_arquivo TEXT
);
