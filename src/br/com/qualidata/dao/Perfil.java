package br.com.qualidata.dao;

public enum Perfil {
	DelegarOuExecutarTarefas(0), SomenteExecutarTarefas(1);

	private int value;

	private Perfil(int value) {
		this.value = value;
	}

	public static Perfil fromValue(int value) {
		for (Perfil my : Perfil.values()) {
			if (my.value == value) {
				return my;
			}
		}

		return null;
	}

	int value() {
		return value;
	}

}
