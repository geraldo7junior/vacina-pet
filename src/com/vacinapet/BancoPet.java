package com.vacinapet;

import java.util.ArrayList;
import java.util.List;

import com.vacinapet.Pet.Pets;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

public class BancoPet {

	private static final String CATEGORIA = "dados";

	// Nome do banco
	private static final String NOME_BANCO = "dados_pets";
	// Nome da tabela
	public static final String NOME_TABELA = "pet";

	protected SQLiteDatabase db;

	public BancoPet(Context ctx) {
		// Abre o banco de dados já existente
		db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
	}

	protected BancoPet() {
		// Apenas para criar uma subclasse...
	}

	// Salva o pet, insere um novo ou atualiza
	public long salvar(Pet pet) {
		long id = pet.id;

		if (id != 0) {
			atualizar(pet);
		} else {
			// Insere novo
			id = inserir(pet);
		}

		return id;
	}

	// Insere um novo pet
	public long inserir(Pet pet) {
		ContentValues values = new ContentValues();
		values.put(Pets.NOME, pet.nome);
		values.put(Pets.ANIMAL, pet.animal);
		values.put(Pets.RACA, pet.raca);
		values.put(Pets.SEXO, pet.sexo);
		values.put(Pets.NASCIMENTO, pet.nascimento);
		values.put(Pets.PESO, pet.peso);

		long id = inserir(values);
		return id;
	}

	// Insere um novo pet
	public long inserir(ContentValues valores) {
		long id = db.insert(NOME_TABELA, "", valores);
		return id;
	}

	// Atualiza o pet no banco. O id do pet é utilizado.
	public int atualizar(Pet pet) {
		ContentValues values = new ContentValues();
		values.put(Pets.NOME, pet.nome);
		values.put(Pets.ANIMAL, pet.animal);
		values.put(Pets.RACA, pet.raca);
		values.put(Pets.SEXO, pet.sexo);
		values.put(Pets.NASCIMENTO, pet.nascimento);
		values.put(Pets.PESO, pet.peso);
		String _id = String.valueOf(pet.id);

		String where = Pets._ID + "=?";
		String[] whereArgs = new String[] { _id };

		int count = atualizar(values, where, whereArgs);

		return count;
	}

	// Atualiza o pet com os valores abaixo
	// A paradinha do where serve para identificar o pet a ser atualizado
	public int atualizar(ContentValues valores, String where, String[] whereArgs) {
		int count = db.update(NOME_TABELA, valores, where, whereArgs);
		Log.i(CATEGORIA, "Atualizou [" + count + "] registros");
		return count;
	}

	// Deleta o pet com o id fornecido
	public int deletar(long id) {
		String where = Pets._ID + "=?";

		String _id = String.valueOf(id);
		String[] whereArgs = new String[] { _id };

		int count = deletar(where, whereArgs);

		return count;
	}

	// Deleta o pet com os argumentos fornecidos
	public int deletar(String where, String[] whereArgs) {
		int count = db.delete(NOME_TABELA, where, whereArgs);
		Log.i(CATEGORIA, "Deletou [" + count + "] registros");
		return count;
	}

	// Busca o pet pelo id
	public Pet buscarPet(long id) {
		// select * from pet where _id=?
		Cursor c = db.query(true, NOME_TABELA, Pet.colunas,
				Pets._ID + "=" + id, null, null, null, null, null);

		if (c.getCount() > 0) {

			// Posicinoa no primeiro elemento do cursor
			c.moveToFirst();

			Pet pet = new Pet();

			// Lê os dados
			pet.id = c.getLong(0);
			pet.nome = c.getString(1);
			pet.animal = c.getString(2);
			pet.raca = c.getString(3);
			pet.sexo = c.getString(4);
			pet.nascimento = c.getString(5);
			pet.peso = c.getString(6);

			return pet;
		}

		return null;
	}

	// Retorna um cursor com todos os pets
	public Cursor getCursor() {
		try {
			// select * from pets
			return db.query(NOME_TABELA, Pet.colunas, null, null, null, null,
					null, null);
		} catch (SQLException e) {
			Log.e(CATEGORIA, "Erro ao buscar os pets: " + e.toString());
			return null;
		}
	}

	// Retorna uma lista com todas os pets
	public List<Pet> listarPets() {
		Cursor c = getCursor();

		List<Pet> pets = new ArrayList<Pet>();

		if (c.moveToFirst()) {

			// Recupera os índices das colunas
			int idxId = c.getColumnIndex(Pets._ID);
			int idxNome = c.getColumnIndex(Pets.NOME);
			int idxAnimal = c.getColumnIndex(Pets.ANIMAL);
			int idxRaca = c.getColumnIndex(Pets.RACA);
			int idxSexo = c.getColumnIndex(Pets.SEXO);
			int idxNascimento = c.getColumnIndex(Pets.NASCIMENTO);
			int idxPeso = c.getColumnIndex(Pets.PESO);

			// Loop até o final
			do {
				Pet pet = new Pet();
				pets.add(pet);

				// recupera os atributos dos pets
				pet.id = c.getLong(idxId);
				pet.nome = c.getString(idxNome);
				pet.animal = c.getString(idxAnimal);
				pet.raca = c.getString(idxRaca);
				pet.sexo = c.getString(idxSexo);
				pet.nascimento = c.getString(idxNascimento);
				pet.peso = c.getString(idxPeso);

			} while (c.moveToNext());
		}

		return pets;
	}

	// Busca o pet pelo nome "select * from pet where nome=?"
	public Pet buscarPetPorNome(String nome) {
		Pet pet = null;

		try {
			// Idem a: SELECT _id,nome,animal,raca,sexo,nascimento,peso from pet where nome = ?
			Cursor c = db.query(NOME_TABELA, Pet.colunas, Pets.NOME + "='"
					+ nome + "'", null, null, null, null);

			// Se encontrou...
			if (c.moveToNext()) {

				pet = new Pet();

				// utiliza os métodos getLong(), getString(), getInt(), etc para
				// recuperar os valores
				pet.id = c.getLong(0);
				pet.nome = c.getString(1);
				pet.animal = c.getString(2);
				pet.raca = c.getString(3);
				pet.sexo = c.getString(4);
				pet.nascimento = c.getString(5);
				pet.peso = c.getString(6);

			}
		} catch (SQLException e) {
			Log.e(CATEGORIA, "Erro ao buscar o pet pelo nome: " + e.toString());
			return null;
		}

		return pet;
	}

	// Busca um pet utilizando as configurações definidas no
	// SQLiteQueryBuilder
	// Utilizado pelo Content Provider de pet
	public Cursor query(SQLiteQueryBuilder queryBuilder, String[] projection,
			String selection, String[] selectionArgs, String groupBy,
			String having, String orderBy) {
		Cursor c = queryBuilder.query(this.db, projection, selection,
				selectionArgs, groupBy, having, orderBy);
		return c;
	}

	// Fecha o banco
	public void fechar() {
		// fecha o banco de dados
		if (db != null) {
			db.close();
		}
	}

}
