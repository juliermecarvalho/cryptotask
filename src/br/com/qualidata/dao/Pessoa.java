package br.com.qualidata.dao;

import com.j256.ormlite.field.DatabaseField;



public class Pessoa extends Dao {

	@DatabaseField
	private String Cpf;
	@DatabaseField
	private String Senha;
	@DatabaseField
	private String Nome;
	@DatabaseField
	private String Funcao;
	@DatabaseField
	private Boolean Ativo;
	@DatabaseField
	private Perfil Perfil;

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String Cpf) {
		this.Cpf = Cpf;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String Senha) {
		this.Senha = Senha;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public String getFuncao() {
		return Funcao;
	}

	public void setFuncao(String Funcao) {
		this.Funcao = Funcao;
	}

	public Boolean getAtivo() {
		return Ativo;
	}

	public void setAtivo(Boolean Ativo) {
		this.Ativo = Ativo;
	}

	public Perfil getPerfil() {
		return Perfil;
	}

	public void setPerfil(Perfil Perfil) {
		this.Perfil = Perfil;
	}

}
