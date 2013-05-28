package br.com.qualidata.dao;

import com.j256.ormlite.field.DatabaseField;

public class Pessoa extends Dao {

	@DatabaseField
	private String cpf;
	@DatabaseField
	private String senha;
	@DatabaseField
	private String Nome;
	@DatabaseField
	private String Funcao;
	@DatabaseField
	private Boolean Ativo;
	@DatabaseField
	private Perfil perfil;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getFuncao() {
		return Funcao;
	}

	public void setFuncao(String funcao) {
		Funcao = funcao;
	}

	public Boolean getAtivo() {
		return Ativo;
	}

	public void setAtivo(Boolean ativo) {
		Ativo = ativo;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
