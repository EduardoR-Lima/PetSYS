CREATE TABLE CLIENTES (
	ID SERIAL PRIMARY KEY NOT NULL,
	CPF VARCHAR(11) NOT NULL,
	NOME VARCHAR(100) NOT NULL,
	ENDERECO VARCHAR(100) NOT NULL,
	TEL_CEL VARCHAR(12) NOT NULL,
	EMAIL VARCHAR(256) NOT NULL,
	DATA_ADICAO VARCHAR(8) NOT NULL
);

CREATE TABLE VETERINARIOS (
	ID SERIAL PRIMARY KEY NOT NULL,
	CRMV VARCHAR(7) NOT NULL,
	NOME VARCHAR(100) NOT NULL,
	ENDERECO VARCHAR(100) NOT NULL,
	TEL_CEL VARCHAR(12) NOT NULL,
	EMAIL VARCHAR(256) NOT NULL,
	DATA_ADICAO VARCHAR(8) NOT NULL
);

CREATE TABLE PRODUTOS (
	ID SERIAL PRIMARY KEY NOT NULL,
	NOME VARCHAR(100) NOT NULL,
	CATEGORIA VARCHAR(50) NOT NULL,
	ESPECIFICACOES TEXT NOT NULL,
	PRECO DECIMAL(6, 2) NOT NULL,
	DATA_ADICAO VARCHAR(8) NOT NULL,
	ESTOQUE INT NOT NULL
);

CREATE TABLE SERVICOS (
	ID SERIAL PRIMARY KEY NOT NULL,
	NOME VARCHAR(100) NOT NULL,
	CATEGORIA VARCHAR(50) NOT NULL,
	ESPECIFICACOES TEXT NOT NULL,
	VALOR DECIMAL(6, 2) NOT NULL,
	DATA_ADICAO VARCHAR(8) NOT NULL
);

CREATE TABLE PETS (
	ID SERIAL PRIMARY KEY NOT NULL,
	NOME VARCHAR(100) NOT NULL,
	DATA_NASCIMENTO VARCHAR(8) NOT NULL,
	ESPECIE VARCHAR(20) NOT NULL,
	RACA VARCHAR(10) NOT NULL,
	SEXO VARCHAR(2) NOT NULL,
	ID_CLIENTE INT NOT NULL,
	DATA_ADICAO VARCHAR(8) NOT NULL,
	FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTES (ID)
);

CREATE TABLE NOTAS_FISCAIS (
	ID SERIAL PRIMARY KEY NOT NULL,
	TIPO VARCHAR(10) NOT NULL,
	DATA_EMISSAO VARCHAR(8) NOT NULL,
	CPF_CLIENTE VARCHAR(11),
	VALOR_NOTA DECIMAL(8, 2) NOT NULL
);

CREATE TABLE HIST_VENDAS (
	ID SERIAL PRIMARY KEY NOT NULL,
	DATA_VENDA VARCHAR(8) NOT NULL,
	FORMA_PAG VARCHAR(20) NOT NULL,
	ID_CLIENTE int,
	ID_NF INT NOT NULL,
	FOREIGN KEY (ID_NF) REFERENCES NOTAS_FISCAIS (ID),
	FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTES (ID)
);

CREATE TABLE HIST_ATENDIMENTOS (
	ID SERIAL PRIMARY KEY NOT NULL,
	DATA_ATENDIMENTO VARCHAR(8) NOT NULL,
	MOTIVO_ATEND TEXT NOT NULL,
	ID_SERVICO INT NOT NULL,
	ID_VETERINARIO INT,
	ID_PET INT NOT NULL,
	ID_VENDA INT NOT NULL,
	FOREIGN KEY (ID_SERVICO) REFERENCES SERVICOS (ID),
	FOREIGN KEY (ID_VETERINARIO) REFERENCES VETERINARIOS (ID),
	FOREIGN KEY (ID_PET) REFERENCES PETS (ID),
	FOREIGN KEY (ID_VENDA) REFERENCES HIST_VENDAS (ID)
);

CREATE TABLE HIST_PRODUTOS_VENDIDOS (
	ID SERIAL PRIMARY KEY NOT NULL,
	ID_NF INT NOT NULL,
	ID_PRODUTO INT NOT NULL,
	QUANT INT NOT NULL,
	VALOR_TOTAL DECIMAL(8, 2) NOT NULL,
	FOREIGN KEY (ID_PRODUTO) REFERENCES PRODUTOS (ID),
	FOREIGN KEY (ID_NF) REFERENCES NOTAS_FISCAIS (ID)
);

SELECT c.cpf as cp_nf, * FROM clientes c;