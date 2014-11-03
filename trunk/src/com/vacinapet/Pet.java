package com.vacinapet;

import android.provider.BaseColumns;

public class Pet {

	public static String[] colunas = new String[] { Pets._ID, Pets.NOME,
			Pets.ANIMAL, Pets.RACA, Pets.SEXO, Pets.NASCIMENTO, Pets.PESO };
	// Isso aq é só frescura para copyright caso vire algo com conexão e pá
	public static final String AUTHORITY = "com.vacinapet.provider.pet";

	public long id;
	public String nome;
	public String animal;
	public String raca;
	public String sexo;
	public String nascimento;
	public String peso;

	public Pet() {

	}

	public Pet(String nome, String animal, String raca, String sexo,
			String nascimento, String peso) {
		super();
		this.nome = nome;
		this.animal = animal;
		this.raca = raca;
		this.sexo = sexo;
		this.nascimento = nascimento;
		this.peso = peso;
	}

	public Pet(long id, String nome, String animal, String raca, String sexo,
			String nascimento, String peso) {
		super();
		this.id = id;
		this.nome = nome;
		this.animal = animal;
		this.raca = raca;
		this.sexo = sexo;
		this.nascimento = nascimento;
		this.peso = peso;
	}

	public static final class Pets implements BaseColumns {

		// Não pode instanciar esta Classe
		private Pets() {
		}

		public static final String NOME = "nome";
		public static final String ANIMAL = "animal";
		public static final String RACA = "raca";
		public static final String SEXO = "sexo";
		public static final String NASCIMENTO = "nascimento";
		public static final String PESO = "peso";

	}

	@Override
	public String toString() {
		return "Nome: " + nome + ", animal: " + animal + ", Raça: " + raca
				+ ", sexo: " + sexo + ", data de nascimento: " + nascimento
				+ ", peso: " + peso;
	}

}