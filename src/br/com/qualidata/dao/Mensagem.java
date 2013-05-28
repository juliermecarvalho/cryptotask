package br.com.qualidata.dao;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public class Mensagem extends Dao {

	@DatabaseField
	private Date dataHoraDeEnvio;
	@DatabaseField
	private String conteudo;
	@DatabaseField
	private Boolean lida;
	@DatabaseField(foreign = true)
	private Pessoa remetente;
	@DatabaseField(foreign = true)
	private Tarefa tarefa;

	public Date getDataHoraDeEnvio() {
		return dataHoraDeEnvio;
	}

	public void setDataHoraDeEnvio(Date dataHoraDeEnvio) {
		this.dataHoraDeEnvio = dataHoraDeEnvio;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Boolean getLida() {
		return lida;
	}

	public void setLida(Boolean lida) {
		this.lida = lida;
	}

	public Pessoa getRemetente() {
		return remetente;
	}

	public void setRemetente(Pessoa remetente) {
		this.remetente = remetente;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

}
