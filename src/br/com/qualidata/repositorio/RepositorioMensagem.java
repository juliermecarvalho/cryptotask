package br.com.qualidata.repositorio;

import java.sql.SQLException;

import android.content.Context;
import br.com.qualidata.dao.Mensagem;

public class RepositorioMensagem extends Repositorio<Mensagem> {

	public RepositorioMensagem(Context context) throws SQLException {
		super(context, Mensagem.class);
	}

}
