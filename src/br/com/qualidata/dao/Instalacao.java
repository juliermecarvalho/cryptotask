package br.com.qualidata.dao;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public class Instalacao extends Dao {

	@DatabaseField
	private Date imei;
	@DatabaseField
	private String nomeDispositivo;
	@DatabaseField(foreign = true)
	private Pessoa pessoa;

	public Date getImei() {
		return imei;
	}

	public void setImei(Date imei) {
		this.imei = imei;
	}

	public String getNomeDispositivo() {
		return nomeDispositivo;
	}

	public void setNomeDispositivo(String nomeDispositivo) {
		this.nomeDispositivo = nomeDispositivo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
