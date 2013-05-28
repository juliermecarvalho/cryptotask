package br.com.qualidata.repositorio;

import java.sql.SQLException;

import android.content.Context;
import br.com.qualidata.dao.Tarefa;

public class RepositorioTarefa extends Repositorio<Tarefa> {
	public RepositorioTarefa(Context context) throws SQLException {
		super(context, Tarefa.class);
	}

}
