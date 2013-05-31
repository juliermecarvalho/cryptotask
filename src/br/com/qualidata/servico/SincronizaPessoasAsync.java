package br.com.qualidata.servico;

import java.sql.SQLException;
import java.util.List;

import org.json.JSONException;

import br.com.qualidata.dao.Pessoa;
import br.com.qualidata.repositorio.RepositorioPessoa;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class SincronizaPessoasAsync extends
		AsyncTask<String, Void, List<Pessoa>> {
	private Context context;

	public SincronizaPessoasAsync(Context context) {
		this.context = context;
	}

	protected List<Pessoa> doInBackground(String... urls) {
		WebService webService = new WebService();
		String jsonRetorno = webService.post(urls[0]);

		try {
			List<Pessoa> pessoas = Serializer.DeserializePessoa(jsonRetorno);
			RepositorioPessoa repositorioPessoa = new RepositorioPessoa(
					this.context);

			for (Pessoa pessoa : pessoas) {
				repositorioPessoa.createOrUpdate(pessoa);
			}

			return repositorioPessoa.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		return null;

	}

	public void onPostExecute(List<Pessoa> pessoas) {
		try {
			
			Toast.makeText(this.context, String.valueOf(pessoas.size()),
					Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			Log.d("ReadWeatherJSONFeedTask", e.getLocalizedMessage());
		}
	}
}