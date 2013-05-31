package br.com.qualidata.cryptotask;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.qualidata.dao.Pessoa;

import br.com.qualidata.repositorio.RepositorioPessoa;
import br.com.qualidata.servico.Serializer;
import br.com.qualidata.servico.SincronizaPessoasAsync;
import br.com.qualidata.servico.WebService;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

	@ViewById
	public TextView edtConta;

	@Click(R.id.btnProsseguir)
	void irParaSenha() {
		try {
			/*
			 * RepositorioPessoa helpe = new RepositorioPessoa(
			 * getApplicationContext()); Pessoa pessoa = new Pessoa();
			 * pessoa.setNome("nome novo"); helpe.createOrUpdate(pessoa);
			 * 
			 * RepositorioInstalacao repositorioInstalacao = new
			 * RepositorioInstalacao( getApplicationContext()); Instalacao
			 * instalacao = new Instalacao();
			 * instalacao.setNomeDispositivo("nomeDispositivo");
			 * instalacao.setPessoa(pessoa);
			 * repositorioInstalacao.createOrUpdate(instalacao);
			 * 
			 * RepositorioTarefa repositorioTarefa = new RepositorioTarefa(
			 * getApplicationContext()); Tarefa tarefa = new Tarefa();
			 * tarefa.setDescricao("descricao"); tarefa.setDono(pessoa);
			 * tarefa.setExecutor(pessoa); tarefa.setTitulo("titulo");
			 * repositorioTarefa.createOrUpdate(tarefa);
			 * 
			 * RepositorioMensagem repositorioMensagem = new
			 * RepositorioMensagem( getApplicationContext()); Mensagem mensagem
			 * = new Mensagem(); mensagem.setRemetente(pessoa);
			 * mensagem.setTarefa(tarefa); mensagem.setConteudo("conteudo");
			 * repositorioMensagem.createOrUpdate(mensagem);
			 */

			//WebService w = new WebService();
			// JSONArray
			// JSONObject
			//String p = w.post("http://wscryptotaskqualidata.cryptotask.com/Sincronizador/Pessoas?dataHoraDaUltimaSincronizacao=2000-01-01");
			
			//List<Pessoa> pessoas = Serializer.DeserializePessoa(p);
		   
		
			//new SincronizaPessoasAsync(getApplicationContext()).			
			//execute("http://wscryptotaskqualidata.cryptotask.com/Sincronizador/Pessoas?dataHoraDaUltimaSincronizacao=2000-01-01");
			RepositorioPessoa repositorioPessoa = new RepositorioPessoa(getApplicationContext());
			List<Pessoa> pessoas = repositorioPessoa.getAll();
			String json = Serializer.SerializerPessoa(pessoas);
			Log.i("julierme", json);
	/*		RepositorioPessoa repositorioPessoa = new RepositorioPessoa(getApplicationContext());
			List<Pessoa> pessoas = repositorioPessoa.getAll();
			for (Pessoa pessoa : pessoas) {
				Log.i("julierme", String.valueOf( pessoa.getId()));
				//repositorioPessoa.createOrUpdate(pessoa);
			}*/
			
			// Log.println(TRIM_MEMORY_COMPLETE, "oi", p);
			// Log.println(TRIM_MEMORY_COMPLETE, "oi", p.split("}")[1]);
			/*
			 * String c =
			 * "[{\"id\":\"254ca1b7-4b06-4183-81fc-30a13e4774c9\",\"cpf\":\"03177731780\",\"senha\":\"123\",\"nome\":\"João Alves da Motta\",\"funcao\":\"Diretor Comercial\",\"ativo\":\"true\",\"perfil\":1},"
			 * +
			 * "{\"id\":\"254ca1b7-4b06-4183-81fc-30a13e4774c9\",\"cpf\":\"03177731780\",\"senha\":\"123\",\"nome\":\"João Alves da Motta\",\"funcao\":\"Diretor Comercial\",\"ativo\":\"true\",\"perfil\":1}]"
			 * ;
			 */

			/*JSONArray jsonArray = new JSONArray(p);
			Log.println(TRIM_MEMORY_COMPLETE, "oi", jsonArray.toString());
			JSONObject jsonObject;
			for (int i = 0; i < jsonArray.length(); i++) {
				jsonObject = jsonArray.getJSONObject(i);
				UUID id = UUID.fromString(jsonObject.getString("Id"));
				 Log.i(Pessoa.class.getName(), jsonObject.getString("Nome"));
			}*/

			//edtConta.setText(String.valueOf(jsonArray.length()));
			// int i = ps.size();
			// Log.e("Julierme", i, "");
			/*
			 * List<Pessoa> list = helpe.getAll(); String i = ""; for (Pessoa p
			 * : list) { i = i + " - " + String.valueOf(p.getId()); }
			 */
			// TextView txt = (TextView) findViewById(R.id.txt);
			// txt.setText(String.valueOf(instalacao.getId()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e("Julierme", "Database exception", e);
			e.printStackTrace();
		}
		// Intent intent = new Intent(getBaseContext(),
		// PasswordActivity_.class);
		// startActivity(intent);

	}

}
