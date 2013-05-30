package br.com.qualidata.cryptotask;

import br.com.qualidata.servico.ReadWeatherJSONFeedTask;
import br.com.qualidata.servico.WebService;

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

		WebService webService = new WebService();
		String json = webService
				.get("http://wsServidorCentralCryptoTask.CryptoTask.com/Assinante/ObterUrlDoServidorCliente?conta=PMV");

		textView.setText(json);
		new ReadWeatherJSONFeedTask()
				.execute("http://wsServidorCentralCryptoTask.CryptoTask.com/Assinante/ObterUrlDoServidorCliente?conta=PMV" );
	}

}
