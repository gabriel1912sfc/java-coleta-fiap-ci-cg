-- V2__alter_tb_coleta_and_tb_users.sql

-- Renomeia a coluna ADRESS para ADDRESS na tabela TB_COLETA
ALTER TABLE TB_COLETA RENAME COLUMN ADRESS TO ADDRESS;

-- Adiciona a coluna NAME na tabela TB_USERS
ALTER TABLE TB_USERS ADD NAME VARCHAR2(200) NOT NULL;
