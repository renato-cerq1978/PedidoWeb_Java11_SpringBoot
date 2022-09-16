package br.com.pedido.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class Fornecedor {
	 	
	 	@Id
	 	@Column(name = "cod_fornecedor")
	    private String codigo;
	 	@Column(name = "num_cgc_cpf")
	 	@NotBlank
	 	@CNPJ
	 	@Size(max = 19)
	 	private String cnpj;
	 	@Column(name = "raz_social")
	 	@NotBlank
	 	@Size(max = 50)
	    private String nome;
	 	@Column(name = "ies_fornec_ativo")
	 	@NotBlank
	 	@Size(max = 1)
	    private String ativo;
	    @Column(name = "num_telefone")
	    @NotBlank
	    @Size(max = 15)
	    private String telefone;
	    
	    
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		public String getCnpj() {
			return cnpj;
		}
		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getAtivo() {
			return ativo;
		}
		public void setAtivo(String ativo) {
			this.ativo = ativo;
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
}
