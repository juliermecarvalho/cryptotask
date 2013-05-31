package br.com.qualidata.dao;

import java.util.Date;
import java.util.UUID;

import com.j256.ormlite.field.DatabaseField;

public class Dao implements IDao {

	@DatabaseField(id = true)
	private UUID Id;
	@DatabaseField
	private Date DataDaUltimaAlteracao;

	@Override
	public UUID getId() {
		return Id;
	}
	
	@Override
	public void setId(UUID Id) {
		this.Id = Id;		
	}
	
	@Override
	public Date getDataDaUltimaAlteracao() {
		return DataDaUltimaAlteracao;
	}

	@Override
	public void setDataDaUltimaAlteracao(Date DataDaUltimaAlteracao) {
		this.DataDaUltimaAlteracao = DataDaUltimaAlteracao;
	}

	

}
