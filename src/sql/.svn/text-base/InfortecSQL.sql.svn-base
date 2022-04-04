SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `Infortec` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `Infortec` ;

-- -----------------------------------------------------
-- Table `Infortec`.`cliente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`cliente` (
  `cod_cliente` INT NOT NULL AUTO_INCREMENT ,
  `nome_cliente` VARCHAR(50) NOT NULL ,
  `cpf_cliente` VARCHAR(11) NOT NULL ,
  `rg_cliente` VARCHAR(25) NOT NULL ,
  `orgao_rg_cliente` VARCHAR(5) NULL ,
  `nascimento_cliente` DATE NOT NULL ,
  `profissao_cliente` VARCHAR(40) NULL ,
  `empresa_cliente` VARCHAR(50) NULL ,
  `fone_empresa` VARCHAR(10) NULL ,
  `tipo_cliente` CHAR(1) NOT NULL ,
  `cnpj_cliente` VARCHAR(14) NULL ,
  `referencia_cliente` VARCHAR(50) NULL ,
  `fone_referencia_cliente` VARCHAR(10) NULL ,
  `email` VARCHAR(45) NULL ,
  PRIMARY KEY (`cod_cliente`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`cliente_endereco`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`cliente_endereco` (
  `cod_endereco` INT NOT NULL AUTO_INCREMENT ,
  `logradouro_endereco` VARCHAR(50) NOT NULL ,
  `complemento_endereco` VARCHAR(50) NULL ,
  `cep_endereco` VARCHAR(8) NOT NULL ,
  `bairro_endereco` VARCHAR(50) NOT NULL ,
  `cidade_endereco` VARCHAR(50) NOT NULL ,
  `uf_endereco` CHAR(2) NOT NULL ,
  `rua_endereco` VARCHAR(30) NOT NULL ,
  `numero_endereco` INT NULL ,
  `pais_endereco` VARCHAR(30) NOT NULL ,
  `cliente_cod_cliente` INT NOT NULL ,
  PRIMARY KEY (`cod_endereco`, `cliente_cod_cliente`) ,
  INDEX `fk_cliente_endereco_cliente` (`cliente_cod_cliente` ASC) ,
  CONSTRAINT `fk_cliente_endereco_cliente`
    FOREIGN KEY (`cliente_cod_cliente` )
    REFERENCES `Infortec`.`cliente` (`cod_cliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`cliente_telefone`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`cliente_telefone` (
  `cod_telefone` INT NOT NULL AUTO_INCREMENT ,
  `numero_telefone` VARCHAR(10) NULL ,
  `tipo_telefone` VARCHAR(10) NULL ,
  `cliente_cod_cliente` INT NOT NULL ,
  PRIMARY KEY (`cod_telefone`, `cliente_cod_cliente`) ,
  INDEX `fk_cliente_telefone_cliente1` (`cliente_cod_cliente` ASC) ,
  CONSTRAINT `fk_cliente_telefone_cliente1`
    FOREIGN KEY (`cliente_cod_cliente` )
    REFERENCES `Infortec`.`cliente` (`cod_cliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`banco`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`banco` (
  `cod_banco` INT NOT NULL AUTO_INCREMENT ,
  `nome_banco` VARCHAR(50) NOT NULL ,
  `agencia_banco` INT NOT NULL ,
  `conta_banco` INT NOT NULL ,
  `gerente_banco` VARCHAR(50) NULL ,
  `fone_banco` VARCHAR(10) NOT NULL ,
  `observacoes_banco` TEXT NULL ,
  PRIMARY KEY (`cod_banco`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`fornecedor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`fornecedor` (
  `cod_fornecedor` INT NOT NULL AUTO_INCREMENT ,
  `nome_fornecedor` VARCHAR(50) NOT NULL ,
  `cnpj_fornecedor` VARCHAR(15) NOT NULL ,
  `fone_comercial_fornecedor` VARCHAR(15) NULL ,
  `email_fornecedor` VARCHAR(100) NULL ,
  `fax_fornecedor` VARCHAR(10) NULL ,
  `fone_fornecedor` VARCHAR(10) NULL ,
  `logradouro_fornecedor` VARCHAR(50) NOT NULL ,
  `bairro_fornecedor` VARCHAR(50) NOT NULL ,
  `cidade_fornecedor` VARCHAR(50) NOT NULL ,
  `uf_fornecedor` CHAR(2) NOT NULL ,
  `cep_fornecedor` VARCHAR(8) NULL ,
  `numero_fornecedor` INT NULL ,
  `rua_fornecedor` VARCHAR(30) NOT NULL ,
  `pais_fornecedor` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`cod_fornecedor`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`departamento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`departamento` (
  `cod_departamento` INT NOT NULL AUTO_INCREMENT ,
  `nome_departamento` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`cod_departamento`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`Servico`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`Servico` (
  `idServico` INT NOT NULL ,
  `Descricao_servico` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`idServico`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`Ordem_servico`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`Ordem_servico` (
  `cod_servico` INT NOT NULL AUTO_INCREMENT ,
  `cliente_servico` VARCHAR(45) NOT NULL ,
  `dados_aparelh_servico` VARCHAR(50) NULL ,
  `data_entrada` DATE NOT NULL ,
  `previsao_saida_servico` DATE NULL ,
  `data_entrega_servico` DATE NULL ,
  `defeito_servico` TEXT NOT NULL ,
  `preco_servico` DOUBLE NULL ,
  `forma_pagamento_servico` VARCHAR(45) NULL ,
  `cliente_cod_cliente` INT NOT NULL ,
  `Servico_idServico` INT NOT NULL ,
  PRIMARY KEY (`cod_servico`, `cliente_cod_cliente`, `Servico_idServico`) ,
  INDEX `fk_servico_cliente1` (`cliente_cod_cliente` ASC) ,
  INDEX `fk_Ordem_servico_Servico1` (`Servico_idServico` ASC) ,
  CONSTRAINT `fk_servico_cliente1`
    FOREIGN KEY (`cliente_cod_cliente` )
    REFERENCES `Infortec`.`cliente` (`cod_cliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ordem_servico_Servico1`
    FOREIGN KEY (`Servico_idServico` )
    REFERENCES `Infortec`.`Servico` (`idServico` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`funcionarios`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`funcionarios` (
  `cod_funcionarios` INT NOT NULL AUTO_INCREMENT ,
  `nome_funcionarios` VARCHAR(50) NULL ,
  `cpf_funcionarios` VARCHAR(15) NOT NULL ,
  `rg_funcionarios` INT NOT NULL ,
  `salario_funcionarios` DOUBLE NULL ,
  `comissao_funcionarios` DOUBLE NULL ,
  `meta_funcionarios` DOUBLE NULL ,
  `admissao_funcionarios` DATE NOT NULL ,
  `demissao_funcionarios` DATE NULL ,
  `login_funcionarios` VARCHAR(15) NOT NULL ,
  `senha_funcionarios` VARCHAR(10) NOT NULL ,
  `logradouro_funcionario` VARCHAR(50) NOT NULL ,
  `bairro_funcionario` VARCHAR(50) NOT NULL ,
  `cidade_funcionario` VARCHAR(50) NOT NULL ,
  `uf_funcionario` CHAR(2) NOT NULL ,
  `cep_funcionario` VARCHAR(8) NULL ,
  `rua_funcionario` VARCHAR(30) NOT NULL ,
  `pais_funcionario` VARCHAR(30) NOT NULL ,
  `nascimento_funcionario` DATE NULL ,
  `email_funcionario` VARCHAR(45) NULL ,
  `departamento_cod_departamento` INT NOT NULL ,
  `servico_cod_servico` INT NOT NULL ,
  PRIMARY KEY (`cod_funcionarios`, `departamento_cod_departamento`, `servico_cod_servico`) ,
  INDEX `fk_funcionarios_departamento1` (`departamento_cod_departamento` ASC) ,
  INDEX `fk_funcionarios_servico1` (`servico_cod_servico` ASC) ,
  CONSTRAINT `fk_funcionarios_departamento1`
    FOREIGN KEY (`departamento_cod_departamento` )
    REFERENCES `Infortec`.`departamento` (`cod_departamento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionarios_servico1`
    FOREIGN KEY (`servico_cod_servico` )
    REFERENCES `Infortec`.`Ordem_servico` (`cod_servico` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`categoria_produto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`categoria_produto` (
  `cod_categoria_produto` INT NOT NULL AUTO_INCREMENT ,
  `nome_categoria_produto` VARCHAR(50) NOT NULL ,
  `descricao_categoria` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`cod_categoria_produto`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`produto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`produto` (
  `cod_produto` INT NOT NULL AUTO_INCREMENT ,
  `nome_produto` VARCHAR(40) NOT NULL ,
  `descricao_produto` VARCHAR(50) NOT NULL ,
  `valor_compra_produto` DOUBLE NULL ,
  `valor_venda_produto` DOUBLE NULL ,
  `estoque` DOUBLE NULL ,
  `localizacao_produto` VARCHAR(45) NOT NULL ,
  `fornecedor_cod_fornecedor` INT NOT NULL ,
  `categoria_produto_cod_categoria_produto` INT NOT NULL ,
  PRIMARY KEY (`cod_produto`, `fornecedor_cod_fornecedor`, `categoria_produto_cod_categoria_produto`) ,
  INDEX `fk_produto_fornecedor1` (`fornecedor_cod_fornecedor` ASC) ,
  INDEX `fk_produto_categoria_produto1` (`categoria_produto_cod_categoria_produto` ASC) ,
  CONSTRAINT `fk_produto_fornecedor1`
    FOREIGN KEY (`fornecedor_cod_fornecedor` )
    REFERENCES `Infortec`.`fornecedor` (`cod_fornecedor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_categoria_produto1`
    FOREIGN KEY (`categoria_produto_cod_categoria_produto` )
    REFERENCES `Infortec`.`categoria_produto` (`cod_categoria_produto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`condicao_pgto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`condicao_pgto` (
  `cod_condicao_pgto` INT NOT NULL AUTO_INCREMENT ,
  `descricao_condicao_pgto` CHAR(20) NOT NULL ,
  PRIMARY KEY (`cod_condicao_pgto`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`parcelas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`parcelas` (
  `cod_parcelas` INT NOT NULL AUTO_INCREMENT ,
  `numero_parcelas` INT NULL ,
  `valorMinimo_parcelas` DOUBLE NULL ,
  `data_vencimento_parcelas` DATE NULL ,
  PRIMARY KEY (`cod_parcelas`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`forma_pagto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`forma_pagto` (
  `cod_forma_pagto` INT NOT NULL AUTO_INCREMENT ,
  `descricao_forma_pagto` CHAR(20) NOT NULL ,
  `num_de_prestacoes_forma_pagto` VARCHAR(45) NULL ,
  `nome_forma_pagto` INT NOT NULL ,
  `vendas_itens_vendas_cod_itens_vendas` INT NOT NULL ,
  `condicao_pgto_cod_condicao_pgto` INT NOT NULL ,
  `parcelas_cod_parcelas` INT NOT NULL ,
  PRIMARY KEY (`cod_forma_pagto`, `vendas_itens_vendas_cod_itens_vendas`, `condicao_pgto_cod_condicao_pgto`, `parcelas_cod_parcelas`) ,
  INDEX `fk_forma_pagto_condicao_pgto1` (`condicao_pgto_cod_condicao_pgto` ASC) ,
  INDEX `fk_forma_pagto_parcelas1` (`parcelas_cod_parcelas` ASC) ,
  CONSTRAINT `fk_forma_pagto_condicao_pgto1`
    FOREIGN KEY (`condicao_pgto_cod_condicao_pgto` )
    REFERENCES `Infortec`.`condicao_pgto` (`cod_condicao_pgto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_forma_pagto_parcelas1`
    FOREIGN KEY (`parcelas_cod_parcelas` )
    REFERENCES `Infortec`.`parcelas` (`cod_parcelas` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`cartao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`cartao` (
  `cod_cartao` INT NOT NULL AUTO_INCREMENT ,
  `nome_cartao` VARCHAR(20) NOT NULL ,
  `taxa_cartao` DOUBLE NULL ,
  PRIMARY KEY (`cod_cartao`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`cheque`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`cheque` (
  `cod_cheque` INT NOT NULL AUTO_INCREMENT ,
  `num_cheque` INT NOT NULL ,
  `data_cheque` DATE NOT NULL ,
  `valor_cheque` DOUBLE NOT NULL ,
  `situacao_cheque` VARCHAR(10) NOT NULL ,
  `historico_cheque` TEXT NOT NULL ,
  `cliente_cod_cliente` INT NOT NULL ,
  PRIMARY KEY (`cod_cheque`, `cliente_cod_cliente`) ,
  INDEX `fk_cheque_cliente1` (`cliente_cod_cliente` ASC) ,
  CONSTRAINT `fk_cheque_cliente1`
    FOREIGN KEY (`cliente_cod_cliente` )
    REFERENCES `Infortec`.`cliente` (`cod_cliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`pagamento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`pagamento` (
  `cod_pagamento` INT NOT NULL AUTO_INCREMENT ,
  `numero_doc_pagamento` VARCHAR(20) NULL ,
  `vlr_total_pagamento` DOUBLE NULL ,
  `vlr_juro_pagamento` DOUBLE NULL ,
  `vlr_multa_pagamento` DOUBLE NULL ,
  `vlr_desconto_pagamento` DOUBLE NULL ,
  `vlr_pago__pagamento` DOUBLE NULL ,
  `numero_cheque_pagamento` INT NULL ,
  `nominal_pagamento` VARCHAR(50) NOT NULL ,
  `emissao_pagamento` DATE NULL ,
  `lancamento_pagamento` DATE NULL ,
  `vencimento_pagamento` DATE NULL ,
  `data_pagamento` DATE NULL ,
  `data_cheque_pagamento` DATE NULL ,
  `banco_cod_banco` INT NOT NULL ,
  `forma_pagto_cod_forma_pagto` INT NOT NULL ,
  `cliente_cod_cliente` INT NOT NULL ,
  `cartao_cod_cartao` INT NOT NULL ,
  `cheque_cod_cheque` INT NOT NULL ,
  PRIMARY KEY (`cod_pagamento`, `banco_cod_banco`, `forma_pagto_cod_forma_pagto`, `cliente_cod_cliente`, `cartao_cod_cartao`, `cheque_cod_cheque`) ,
  INDEX `fk_pagamento_banco1` (`banco_cod_banco` ASC) ,
  INDEX `fk_pagamento_forma_pagto1` (`forma_pagto_cod_forma_pagto` ASC) ,
  INDEX `fk_pagamento_cliente1` (`cliente_cod_cliente` ASC) ,
  INDEX `fk_pagamento_cartao1` (`cartao_cod_cartao` ASC) ,
  INDEX `fk_pagamento_cheque1` (`cheque_cod_cheque` ASC) ,
  CONSTRAINT `fk_pagamento_banco1`
    FOREIGN KEY (`banco_cod_banco` )
    REFERENCES `Infortec`.`banco` (`cod_banco` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pagamento_forma_pagto1`
    FOREIGN KEY (`forma_pagto_cod_forma_pagto` )
    REFERENCES `Infortec`.`forma_pagto` (`cod_forma_pagto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pagamento_cliente1`
    FOREIGN KEY (`cliente_cod_cliente` )
    REFERENCES `Infortec`.`cliente` (`cod_cliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pagamento_cartao1`
    FOREIGN KEY (`cartao_cod_cartao` )
    REFERENCES `Infortec`.`cartao` (`cod_cartao` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pagamento_cheque1`
    FOREIGN KEY (`cheque_cod_cheque` )
    REFERENCES `Infortec`.`cheque` (`cod_cheque` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`vendas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`vendas` (
  `cod_vendas` INT NOT NULL AUTO_INCREMENT ,
  `cliente_vendas` INT(11)  NULL ,
  `vendedor_vendas` INT(11)  NULL ,
  `condicao_pgto_vendas` VARCHAR(10) NULL ,
  `valor_total_vendas` DOUBLE NULL ,
  `valor_desconto_vendas` DOUBLE NULL ,
  `valor_a_pagar_vendas` DOUBLE NULL ,
  `cliente_cod_cliente` INT NOT NULL ,
  `forma_pagto_cod_forma_pagto` INT NOT NULL ,
  `pagamento_cod_pagamento` INT NOT NULL ,
  `funcionarios_cod_funcionarios` INT NOT NULL ,
  PRIMARY KEY (`cod_vendas`, `cliente_cod_cliente`, `forma_pagto_cod_forma_pagto`, `pagamento_cod_pagamento`, `funcionarios_cod_funcionarios`) ,
  INDEX `fk_vendas_cliente1` (`cliente_cod_cliente` ASC) ,
  INDEX `fk_vendas_forma_pagto1` (`forma_pagto_cod_forma_pagto` ASC) ,
  INDEX `fk_vendas_pagamento1` (`pagamento_cod_pagamento` ASC) ,
  INDEX `fk_vendas_funcionarios1` (`funcionarios_cod_funcionarios` ASC) ,
  CONSTRAINT `fk_vendas_cliente1`
    FOREIGN KEY (`cliente_cod_cliente` )
    REFERENCES `Infortec`.`cliente` (`cod_cliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vendas_forma_pagto1`
    FOREIGN KEY (`forma_pagto_cod_forma_pagto` )
    REFERENCES `Infortec`.`forma_pagto` (`cod_forma_pagto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vendas_pagamento1`
    FOREIGN KEY (`pagamento_cod_pagamento` )
    REFERENCES `Infortec`.`pagamento` (`cod_pagamento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vendas_funcionarios1`
    FOREIGN KEY (`funcionarios_cod_funcionarios` )
    REFERENCES `Infortec`.`funcionarios` (`cod_funcionarios` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`itens_vendas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`itens_vendas` (
  `cod_itens_vendas` INT NOT NULL AUTO_INCREMENT ,
  `qtde_itens_vendas` DOUBLE NOT NULL ,
  `preco_itens_vendas` DOUBLE NULL ,
  `valor_uni_itens_vendas` DOUBLE NULL ,
  `vendas_cod_vendas` INT NOT NULL ,
  `produto_cod_produto` INT NOT NULL ,
  `produto_fornecedor_cod_fornecedor` INT NOT NULL ,
  `produto_categoria_produto_cod_categoria_produto` INT NOT NULL ,
  PRIMARY KEY (`cod_itens_vendas`, `vendas_cod_vendas`, `produto_cod_produto`, `produto_fornecedor_cod_fornecedor`, `produto_categoria_produto_cod_categoria_produto`) ,
  INDEX `fk_itens_vendas_vendas1` (`vendas_cod_vendas` ASC) ,
  INDEX `fk_itens_vendas_produto1` (`produto_cod_produto` ASC, `produto_fornecedor_cod_fornecedor` ASC, `produto_categoria_produto_cod_categoria_produto` ASC) ,
  CONSTRAINT `fk_itens_vendas_vendas1`
    FOREIGN KEY (`vendas_cod_vendas` )
    REFERENCES `Infortec`.`vendas` (`cod_vendas` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itens_vendas_produto1`
    FOREIGN KEY (`produto_cod_produto` , `produto_fornecedor_cod_fornecedor` , `produto_categoria_produto_cod_categoria_produto` )
    REFERENCES `Infortec`.`produto` (`cod_produto` , `fornecedor_cod_fornecedor` , `categoria_produto_cod_categoria_produto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`itens_compras`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`itens_compras` (
  `cod_itens_compras` INT NOT NULL AUTO_INCREMENT ,
  `produto_itens_compras` INT(11)  NOT NULL ,
  `qtde_itens_compras` DECIMAL(10,2)  NOT NULL ,
  `valor_uni_itens_compras` VARCHAR(45) NULL ,
  `produto_cod_produto` INT NOT NULL ,
  `produto_fornecedor_cod_fornecedor` INT NOT NULL ,
  `produto_categoria_produto_cod_categoria_produto` INT NOT NULL ,
  PRIMARY KEY (`cod_itens_compras`, `produto_cod_produto`, `produto_fornecedor_cod_fornecedor`, `produto_categoria_produto_cod_categoria_produto`) ,
  INDEX `fk_itens_compras_produto1` (`produto_cod_produto` ASC, `produto_fornecedor_cod_fornecedor` ASC, `produto_categoria_produto_cod_categoria_produto` ASC) ,
  CONSTRAINT `fk_itens_compras_produto1`
    FOREIGN KEY (`produto_cod_produto` , `produto_fornecedor_cod_fornecedor` , `produto_categoria_produto_cod_categoria_produto` )
    REFERENCES `Infortec`.`produto` (`cod_produto` , `fornecedor_cod_fornecedor` , `categoria_produto_cod_categoria_produto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	' ;


-- -----------------------------------------------------
-- Table `Infortec`.`compras`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`compras` (
  `cod_compras` INT NOT NULL AUTO_INCREMENT ,
  `fornecedor_compras` INT(11)  NULL ,
  `custo_total_vendas` DOUBLE NULL ,
  `valor_desconto_compras` DOUBLE NULL ,
  `custo_pagar_compras` DOUBLE NULL ,
  `itens_compras_cod_itens_compras` INT NOT NULL ,
  `forma_pagto_cod_forma_pagto` INT NOT NULL ,
  PRIMARY KEY (`cod_compras`, `itens_compras_cod_itens_compras`, `forma_pagto_cod_forma_pagto`) ,
  INDEX `fk_compras_itens_compras1` (`itens_compras_cod_itens_compras` ASC) ,
  INDEX `fk_compras_forma_pagto1` (`forma_pagto_cod_forma_pagto` ASC) ,
  CONSTRAINT `fk_compras_itens_compras1`
    FOREIGN KEY (`itens_compras_cod_itens_compras` )
    REFERENCES `Infortec`.`itens_compras` (`cod_itens_compras` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compras_forma_pagto1`
    FOREIGN KEY (`forma_pagto_cod_forma_pagto` )
    REFERENCES `Infortec`.`forma_pagto` (`cod_forma_pagto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`estoque`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`estoque` (
  `cod_estoque` INT NOT NULL AUTO_INCREMENT ,
  `produto_estoque` INT NOT NULL ,
  `tipo_estoque` CHAR(1) NOT NULL ,
  `data_estoque` DATE NOT NULL ,
  `qtde_estoque` DOUBLE NOT NULL ,
  `produto_cod_produto` INT NOT NULL ,
  PRIMARY KEY (`cod_estoque`, `produto_cod_produto`) ,
  INDEX `fk_estoque_produto1` (`produto_cod_produto` ASC) ,
  CONSTRAINT `fk_estoque_produto1`
    FOREIGN KEY (`produto_cod_produto` )
    REFERENCES `Infortec`.`produto` (`cod_produto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`movimento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`movimento` (
  `cod_movimento` INT NOT NULL AUTO_INCREMENT ,
  `mes_ano_movimento` VARCHAR(7) NULL ,
  `num_cheque_movimento` INT NULL ,
  `num_documento_movimento` VARCHAR(20) NULL ,
  `data_cheque_movimento` DATE NULL ,
  `data_lancamento_movimento` DATE NULL ,
  `historico_movimento` VARCHAR(50) NULL ,
  `valor_documento_movimento` DOUBLE NULL ,
  PRIMARY KEY (`cod_movimento`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Infortec`.`conta_fornecedor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Infortec`.`conta_fornecedor` (
  `cod_conta_fornecedor` INT NOT NULL AUTO_INCREMENT ,
  `banco_conta_fornecedor` VARCHAR(45) NOT NULL ,
  `agencia_conta_fornecedor` INT NOT NULL ,
  `numero_conta_fornecedor` INT NOT NULL ,
  `fornecedor_cod_fornecedor` INT NOT NULL ,
  PRIMARY KEY (`cod_conta_fornecedor`, `fornecedor_cod_fornecedor`) ,
  INDEX `fk_conta_fornecedor_fornecedor1` (`fornecedor_cod_fornecedor` ASC) ,
  CONSTRAINT `fk_conta_fornecedor_fornecedor1`
    FOREIGN KEY (`fornecedor_cod_fornecedor` )
    REFERENCES `Infortec`.`fornecedor` (`cod_fornecedor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
