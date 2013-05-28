package br.com.qualidata.repositorio;

import java.sql.SQLException;

import android.content.Context;
import br.com.qualidata.dao.Instalacao;

public class RepositorioInstalacao extends Repositorio<Instalacao> {

	public RepositorioInstalacao(Context context) throws SQLException {
		super(context, Instalacao.class);
	}

}
