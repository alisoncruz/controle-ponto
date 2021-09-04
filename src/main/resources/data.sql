INSERT INTO NIVEL_ACESSO (descricao) VALUES ('usuario');
INSERT INTO NIVEL_ACESSO (descricao) VALUES ('administrador');

INSERT INTO LOCALIDADE (descricao, nivel_acesso_id) VALUES ('matriz',1);
INSERT INTO LOCALIDADE (descricao, nivel_acesso_id) VALUES ('filial_centro',1);
INSERT INTO LOCALIDADE (descricao, nivel_acesso_id) VALUES ('filial_barra',2);
INSERT INTO LOCALIDADE (descricao, nivel_acesso_id) VALUES ('filial_tijuca',2);
INSERT INTO LOCALIDADE (descricao, nivel_acesso_id) VALUES ('filial_nilopolis',1);
INSERT INTO LOCALIDADE (descricao, nivel_acesso_id) VALUES ('filial_nova_iguacu',2);

INSERT INTO OCORRENCIA (nome,descricao) VALUES ('ausencia_saude','Empregado deixou de comparecer para ir ao médico');
INSERT INTO OCORRENCIA (nome,descricao) VALUES ('saida_expediente','Empregado deixou o local de trabalho por motivos pessoais');
INSERT INTO OCORRENCIA (nome,descricao) VALUES ('saida_acidente','Empregado deixou o local de trabalho por ter sofrido acidente');
INSERT INTO OCORRENCIA (nome,descricao) VALUES ('ausencia_servico','Empregado deixou o local de trabalho para atender outra unidade');

INSERT INTO TIPO_DATA (descricao) VALUES ('dia_semana');
INSERT INTO TIPO_DATA (descricao) VALUES ('dia_fim_semana');
INSERT INTO TIPO_DATA (descricao) VALUES ('feriado');

INSERT INTO CALENDARIO(data_especial,descricao,tipo_data_id) VALUES('2021-09-07','Feriado Nacional',3);
INSERT INTO CALENDARIO(data_especial,descricao,tipo_data_id) VALUES('2021-09-08','dia_trabalho',1);
INSERT INTO CALENDARIO(data_especial,descricao,tipo_data_id) VALUES('2021-09-09','dia_trabalho',1);
INSERT INTO CALENDARIO(data_especial,descricao,tipo_data_id) VALUES('2021-09-10','dia_trabalho',1);

INSERT INTO JORNADA_TRABALHO (descricao) VALUES('CLT');
INSERT INTO JORNADA_TRABALHO (descricao) VALUES('PJ');

INSERT INTO CATEGORIA_USUARIO (descricao) VALUES ('manutenção');
INSERT INTO CATEGORIA_USUARIO (descricao) VALUES ('gerência');
INSERT INTO CATEGORIA_USUARIO (descricao) VALUES ('operacional');
INSERT INTO CATEGORIA_USUARIO (descricao) VALUES ('limpeza');
INSERT INTO CATEGORIA_USUARIO (descricao) VALUES ('RH');

INSERT INTO EMPRESA(cnpj,descricao,logradouro,numero,bairro,cidade,estado,cep,telefone)
VALUES ('40.308.104/0001-82','Serviços de Telecomunicação','Rua Professor Valter Frankel','324','Colégio','Rio de Janeiro','RJ','21832-106','(21)13588-0036');
INSERT INTO EMPRESA(cnpj,descricao,logradouro,numero,bairro,cidade,estado,cep,telefone)
VALUES ('02.422.216/0001-70','Serviços de Logística','Rua Assis Vasconcelos','542','Pilares','Rio de Janeiro','RJ','23085-330','(21)45516-6656');
INSERT INTO EMPRESA(cnpj,descricao,logradouro,numero,bairro,cidade,estado,cep,telefone)
VALUES ('97.795.866/0001-78','Serviços de Limpeza','Rua Sílvia Renata','668','Santa Cruz','Rio de Janeiro','RJ','22441-080','(21)71434-1405');

INSERT INTO USUARIO (final_jornada,inicio_jornada,nome,tolerancia,categoria_usuario_id,empresa_id,jornada_trabalho_id,nivel_acesso_id)
VALUES ('2021-09-03 08:00:00','2021-09-03 17:00:00','Martin Osvaldo Aragão',20,3,1,1,1);
INSERT INTO USUARIO (final_jornada,inicio_jornada,nome,tolerancia,categoria_usuario_id,empresa_id,jornada_trabalho_id,nivel_acesso_id)
VALUES ('2021-09-03 08:00:00','2021-09-03 17:00:00','Alana Rebeca Teresinha Nascimento',20,2,2,1,1);
INSERT INTO USUARIO (final_jornada,inicio_jornada,nome,tolerancia,categoria_usuario_id,empresa_id,jornada_trabalho_id,nivel_acesso_id)
VALUES ('2021-09-03 08:00:00','2021-09-03 17:00:00','Carla Helena Ramos',15,4,1,1,1);
INSERT INTO USUARIO (final_jornada,inicio_jornada,nome,tolerancia,categoria_usuario_id,empresa_id,jornada_trabalho_id,nivel_acesso_id)
VALUES ('2021-09-03 08:00:00','2021-09-03 17:00:00','Martin Guilherme Gabriel dos Santos',10,3,3,1,1);

INSERT INTO MOVIMENTACAO(id_movimento,id_usuario,data_entrada,data_saida,periodo,calendario_id,ocorrencia_id)
VALUES(1,1,'2021-09-08','2021-09-08',50,2,4);

INSERT INTO BANCO_HORAS(id_banco_horas,id_movimento,id_usuario,data_trabalhada,quantidade_horas,saldo_horas)
VALUES(1,1,1,'2021-09-08',8,0);

