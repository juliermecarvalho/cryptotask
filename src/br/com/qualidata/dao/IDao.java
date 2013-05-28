package br.com.qualidata.dao;

import java.util.Date;

public interface IDao {
	int getId();

	Date getDataDaUltimaAlteracao();

	void setDataDaUltimaAlteracao(Date DataDaUltimaAlteracao);

}
