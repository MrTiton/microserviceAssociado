package com.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "associado")
public class Associado {
	
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Size(max = 150)
    @NotEmpty
    private String nome;
	
    @Size(max = 80)
    @NotEmpty
    private String email;
	
    @Size(max = 15)
    @NotEmpty
    private String senha;
	
    @Size(max = 255)//talvez deve-se mudar para uma lista de arrays
    private String competencias;
	
    //cargo na cooperativa
    @Size(max = 200)
    private String cargo;
	 
    @Size(max = 30)
    private String telefone;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
    private Date nascimento;
	
    @Size(max = 100)
    @Column(name = "endereco_rua")
    private String enderecoRua;
    
    @Size(max = 100)
    @Column(name = "endereco_bairro")
    private String enderecoBairro;

    @Size(max = 30)
    @Column(name = "endereco_numero")
    private String enderecoNumero;

    @Size(max = 100)
    @NotEmpty
    private String cidade;

    @Size(max = 2)
    private String estado;
    
    @Size(max = 10)
    private String cep;
    
    @Column(name = "tipo_cooperativa_id")
    private Long tipoCooperativaID;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCompetencias() {
		return competencias;
	}

	public void setCompetencias(String competencias) {
		this.competencias = competencias;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getEnderecoRua() {
		return enderecoRua;
	}

	public void setEnderecoRua(String enderecoRua) {
		this.enderecoRua = enderecoRua;
	}

	public String getEnderecoBairro() {
		return enderecoBairro;
	}

	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}

	public String getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getTipoCooperativaID() {
		return tipoCooperativaID;
	}

	public void setTipoCooperativaID(Long tipoCooperativaID) {
		this.tipoCooperativaID = tipoCooperativaID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Associado other = (Associado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}    
}
