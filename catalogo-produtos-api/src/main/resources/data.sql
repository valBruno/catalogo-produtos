INSERT INTO produtosdb.public.produtos (ID, NOME, VALOR, DESCRICAO)
VALUES
    ('1', 'Café Pelé', 19.99, 'Com sabor suave, equilibrado em corpo e acidez, é um café de aroma contagiante para todos os momentos do seu dia.' )
    ON CONFLICT DO NOTHING;