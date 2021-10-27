--CNAE
CREATE TABLE IF NOT EXISTS cnae(
    cne_id BIGSERIAL NOT NULL PRIMARY KEY,
    cne_descricao VARCHAR(7)
);

--PRODUTOS
CREATE TABLE IF NOT EXISTS produto(
    pdt_id BIGSERIAL NOT NULL PRIMARY KEY,
    pdt_tipo VARCHAR(15)
);


--ENDERECO
CREATE TABLE IF NOT EXISTS endereco(
    edc_id BIGSERIAL NOT NULL PRIMARY KEY,
    edc_bairro VARCHAR(50),
    edc_numero VARCHAR(10),
    edc_cep VARCHAR(10),
    edc_descricao VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS cidade(
    cdd_id BIGSERIAL NOT NULL PRIMARY KEY,
    cdd_descricao VARCHAR(50),
    edc_id BIGINT,
    CONSTRAINT fk_cdd_edc FOREIGN KEY(edc_id) REFERENCES endereco(edc_id)
);

CREATE TABLE IF NOT EXISTS uf(
    uf_id BIGSERIAL NOT NULL PRIMARY KEY,
    uf_descricao VARCHAR(2),
    cdd_id BIGINT,
    CONSTRAINT fk_uf_cdd FOREIGN KEY(cdd_id) REFERENCES cidade(cdd_id)
);

CREATE TABLE IF NOT EXISTS pais(
    pas_id BIGSERIAL NOT NULL PRIMARY KEY,
    pas_descricao VARCHAR(50),
    uf_id BIGINT,
    CONSTRAINT fk_pas_uf FOREIGN KEY(uf_id) REFERENCES uf(uf_id)
);

--USUARIO
CREATE TABLE IF NOT EXISTS usuario(
    uso_id BIGSERIAL NOT NULL PRIMARY KEY,
    uso_login VARCHAR(100),
    uso_password VARCHAR(100),
    cdd_descricao VARCHAR(50)
);

--FORNECEDOR
CREATE TABLE IF NOT EXISTS fornecedor(
    fnc_id BIGSERIAL NOT NULL PRIMARY KEY,
    fnc_cnpj BIGINT,
    fnc_inscricao_estadual VARCHAR(255),
    fnc_inscricao_municipal VARCHAR(255),
    fnc_nome_fantasia VARCHAR(255),
    fnc_razao_social VARCHAR(255),    
    cne_id BIGINT,
    pdt_id BIGINT,
    edc_id BIGINT,    
    CONSTRAINT fk_fnc_cne FOREIGN KEY(cne_id) REFERENCES cnae(cne_id),
    CONSTRAINT fk_fnc_pdt FOREIGN KEY(pdt_id) REFERENCES produto(pdt_id),
    CONSTRAINT fk_fnc_edc FOREIGN KEY(edc_id) REFERENCES endereco(edc_id)    
);

--CONTATO
CREATE TABLE IF NOT EXISTS email(
    eml_id BIGSERIAL NOT NULL PRIMARY KEY,
    eml_email VARCHAR(255),
    fnc_id BIGINT,
    CONSTRAINT fk_eml_fnc FOREIGN KEY(fnc_id) REFERENCES fornecedor(fnc_id)
);

CREATE TABLE IF NOT EXISTS email_fornecedor(
    fnc_id BIGINT,
    eml_id BIGINT,
    PRIMARY KEY(fnc_id, eml_id),
    FOREIGN KEY (fnc_id) REFERENCES fornecedor(fnc_id),
    FOREIGN KEY (eml_id) REFERENCES email(eml_id)
);

CREATE TABLE IF NOT EXISTS telefone(
    tlf_id BIGSERIAL NOT NULL PRIMARY KEY,
    tlf_codigo INTEGER,
    tlf_ddd VARCHAR(2),
    tlf_numero VARCHAR(15),
    tlf_tipo VARCHAR(20),
    fnc_id BIGINT,
    CONSTRAINT fk_tlf_fnc FOREIGN KEY(fnc_id) REFERENCES fornecedor(fnc_id)
);

CREATE TABLE IF NOT EXISTS telefone_fornecedor(
    fnc_id BIGINT,
    tlf_id BIGINT,
    PRIMARY KEY (fnc_id, tlf_id),
    FOREIGN KEY (fnc_id) REFERENCES fornecedor(fnc_id),
    FOREIGN KEY (tlf_id) REFERENCES telefone(tlf_id)
);