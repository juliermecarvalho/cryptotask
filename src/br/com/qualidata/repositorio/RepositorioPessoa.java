package br.com.qualidata.repositorio;

import java.sql.SQLException;

import android.content.Context;
import br.com.qualidata.dao.Pessoa;

public class RepositorioPessoa extends Repositorio<Pessoa> {

	public RepositorioPessoa(Context context) throws SQLException {
		super(context, Pessoa.class);
	}

}
