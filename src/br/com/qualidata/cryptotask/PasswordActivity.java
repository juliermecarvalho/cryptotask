package br.com.qualidata.cryptotask;

import br.com.qualidata.servico.ReadWeatherJSONFeedTask;


import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.widget.TextView;


@EActivity(R.layout.activity_password)
public class PasswordActivity extends Activity {

	@ViewById
	public TextView textView;

	@Click(R.id.btnProsseguirSenha)
	void toJson() {

		//WebService webService = new WebService();
		//String json = webService.get("http://wsServidorCentralCryptoTask.CryptoTask.com/Assinante/ObterUrlDoServidorCliente?conta=PMV");
		//Toast.makeText(this, json,  Toast.LENGTH_SHORT).show();
		//textView.setText(json);
/*		new ReadWeatherJSONFeedTask(this)
				.execute("http://wsServidorCentralCryptoTask.CryptoTask.com/Assinante/ObterUrlDoServidorCliente?conta=PMV" );*/
		
		new ReadWeatherJSONFeedTask(this)
		.execute("http://wscryptotaskqualidata.cryptotask.com/Sincronizador/Pessoas?dataHoraDaUltimaSincronizacao=2000-01-01" );
	}

}
