package br.com.qualidata.dao;

import java.util.Date;
import java.util.UUID;

public interface IDao {
	UUID getId();
	void setId(UUID Id);

	Date getDataDaUltimaAlteracao();

	void setDataDaUltimaAlteracao(Date DataDaUltimaAlteracao);

}
