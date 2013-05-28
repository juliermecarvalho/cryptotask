package br.com.qualidata.dao;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public class Dao implements IDao {

	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField
	private Date dataDaUltimaAlteracao;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public Date getDataDaUltimaAlteracao() {
		return dataDaUltimaAlteracao;
	}

	@Override
	public void setDataDaUltimaAlteracao(Date dataDaUltimaAlteracao) {
		this.dataDaUltimaAlteracao = dataDaUltimaAlteracao;
	}

}
