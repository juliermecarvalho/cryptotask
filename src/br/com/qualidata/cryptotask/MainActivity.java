package br.com.qualidata.cryptotask;





import java.sql.SQLException;

import br.com.qualidata.dao.Instalacao;
import br.com.qualidata.dao.Mensagem;
import br.com.qualidata.dao.Pessoa;
import br.com.qualidata.dao.Tarefa;
import br.com.qualidata.repositorio.RepositorioInstalacao;
import br.com.qualidata.repositorio.RepositorioMensagem;
import br.com.qualidata.repositorio.RepositorioPessoa;
import br.com.qualidata.repositorio.RepositorioTarefa;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;


import android.app.Activity;
import android.content.Intent;
import android.util.Log;


@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

	@Click(R.id.btnProsseguir)
	void irParaSenha(){		
		try {
			RepositorioPessoa helpe = new RepositorioPessoa(
					getApplicationContext());
			Pessoa pessoa = new Pessoa();
			pessoa.setNome("nome novo");
			helpe.createOrUpdate(pessoa);

			RepositorioInstalacao repositorioInstalacao = new RepositorioInstalacao(
					getApplicationContext());
			Instalacao instalacao = new Instalacao();
			instalacao.setNomeDispositivo("nomeDispositivo");
			instalacao.setPessoa(pessoa);
			repositorioInstalacao.createOrUpdate(instalacao);

			RepositorioTarefa repositorioTarefa = new RepositorioTarefa(
					getApplicationContext());
			Tarefa tarefa = new Tarefa();
			tarefa.setDescricao("descricao");
			tarefa.setDono(pessoa);
			tarefa.setExecutor(pessoa);
			tarefa.setTitulo("titulo");
			repositorioTarefa.createOrUpdate(tarefa);

			RepositorioMensagem repositorioMensagem = new RepositorioMensagem(
					getApplicationContext());
			Mensagem mensagem = new Mensagem();
			mensagem.setRemetente(pessoa);
			mensagem.setTarefa(tarefa);
			mensagem.setConteudo("conteudo");
			repositorioMensagem.createOrUpdate(mensagem);

			/*
			 * List<Pessoa> list = helpe.getAll(); String i = ""; for (Pessoa p
			 * : list) { i = i + " - " + String.valueOf(p.getId()); }
			 */
			//TextView txt = (TextView) findViewById(R.id.txt);
			//txt.setText(String.valueOf(instalacao.getId()));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Log.e("Julierme", "Database exception", e);
			e.printStackTrace();
		}
		Intent intent = new Intent(getBaseContext(), PasswordActivity_.class);
		startActivity(intent);
		
	}

}
