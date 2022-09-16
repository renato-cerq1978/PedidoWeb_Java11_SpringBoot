create table fornecedor (
  num_cgc_cpf char(19) DEFAULT NULL,
  cod_fornecedor char(15) NOT NULL,
  raz_social char(50) DEFAULT NULL,  
  ies_fornec_ativo char(1) DEFAULT NULL,
  num_telefone char(15) DEFAULT NULL,
primary key (cod_fornecedor));