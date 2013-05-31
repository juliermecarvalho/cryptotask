package br.com.qualidata.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.qualidata.dao.Perfil;
import br.com.qualidata.dao.Pessoa;

public class Serializer {

	public static List<Pessoa> DeserializePessoa(String jsonArray)
			throws JSONException {
		JSONArray array = new JSONArray(jsonArray);
		JSONObject jsonObject;
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (int i = 0; i < array.length(); i++) {
			jsonObject = array.getJSONObject(i);
			Pessoa pessoa = new Pessoa();
			UUID id = UUID.fromString(jsonObject.getString("Id"));
			pessoa.setId(id);
			pessoa.setCpf(jsonObject.getString("Cpf"));
			pessoa.setSenha(jsonObject.getString("Senha"));
			pessoa.setNome(jsonObject.getString("Nome"));
			pessoa.setFuncao(jsonObject.getString("Funcao"));
			pessoa.setAtivo(jsonObject.getBoolean("Ativo"));
			Perfil perfil = Perfil.fromValue(jsonObject.getInt("Perfil"));
			pessoa.setPerfil(perfil);
			pessoas.add(pessoa);
		}

		return pessoas;
	}

}
