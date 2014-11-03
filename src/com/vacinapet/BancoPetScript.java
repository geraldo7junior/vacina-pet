package com.vacinapet;

import android.content.Context;

public class BancoPetScript extends BancoPet {

	// Script para fazer drop na tabela
	private static final String SCRIPT_DATABASE_DELETE = "DROP TABLE IF EXISTS pet";

	// Cria a tabela com o "_id" sequencial
	// Cadastro default de "Luck" no Banco, pq Luck é 10
	private static final String[] SCRIPT_DATABASE_CREATE = new String[] {
			"create table pet ( _id integer primary key autoincrement, nome text not null, animal text not null, raca text not null, sexo text not null, nascimento text not null, peso text not null);",
			"insert into pet(nome,animal,raca,sexo,nascimento,peso) values('Luck','Cachorro','Viralata','macho','outubro', 'dois');" };

	// Nome do banco
	private static final String NOME_BANCO = "baco_dados";

	// Controle de versão
	private static final int VERSAO_BANCO = 1;

	// Nome da tabela
	public static final String TABELA_PET = "pet";

	// Classe utilitária para abrir, criar, e atualizar o banco de dados
	private SQLiteHelper dbHelper;

	// Cria o banco de dados com um script SQL
	public BancoPetScript(Context ctx) {
		// Criar utilizando um script SQL
		dbHelper = new SQLiteHelper(ctx, BancoPetScript.NOME_BANCO,
				BancoPetScript.VERSAO_BANCO,
				BancoPetScript.SCRIPT_DATABASE_CREATE,
				BancoPetScript.SCRIPT_DATABASE_DELETE);

		// abre o banco no modo escrita para poder alterar também
		db = dbHelper.getWritableDatabase();
	}

	// Fecha o banco
	@Override
	public void fechar() {
		super.fechar();
		if (dbHelper != null) {
			dbHelper.close();
		}
	}
}