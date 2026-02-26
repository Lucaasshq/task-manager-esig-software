INSERT INTO responsavel (nome, data_nascimento, data_cadastro) VALUES ('Ricardo Oliveira', '1985-04-12', CURRENT_DATE);
INSERT INTO responsavel (nome, data_nascimento, data_cadastro) VALUES ('Beatriz Souza', '1995-08-25', CURRENT_DATE);
INSERT INTO responsavel (nome, data_nascimento, data_cadastro) VALUES ('Marcos Pereira', '1978-12-05', CURRENT_DATE);
INSERT INTO responsavel (nome, data_nascimento, data_cadastro) VALUES ('Juliana Costa', '2000-01-30', CURRENT_DATE);
INSERT INTO responsavel (nome, data_nascimento, data_cadastro) VALUES ('Fernando Silva', '1992-06-15', CURRENT_DATE);


INSERT INTO tarefa (titulo, descricao, responsavel_id, prioridade, deadLine, status) VALUES ('Configurar Banco de Dados', 'Configurar o PostgreSQL e o persistence.xml', 1, 'ALTA', '2026-03-01', 'ABERTA');
INSERT INTO tarefa (titulo, descricao, responsavel_id, prioridade, deadLine, status) VALUES ('Desenvolver Entidades', 'Criar as classes Java com anotações JPA', 2, 'MEDIA', '2026-03-05', 'ABERTA');
INSERT INTO tarefa (titulo, descricao, responsavel_id, prioridade, deadLine, status) VALUES ('Criar Managed Beans', 'Implementar a lógica de controlo com CDI', 3, 'MEDIA', '2026-03-10', 'EM_ANDAMENTO');
INSERT INTO tarefa (titulo, descricao, responsavel_id, prioridade, deadLine, status) VALUES ('Desenvolver Telas XHTML', 'Criar interfaces com PrimeFaces', 4, 'BAIXA', '2026-03-15', 'ABERTA');
INSERT INTO tarefa (titulo, descricao, responsavel_id, prioridade, deadLine, status) VALUES ('Testar Integração', 'Realizar testes de ponta a ponta no sistema', 5, 'ALTA', '2026-03-20', 'ABERTA');