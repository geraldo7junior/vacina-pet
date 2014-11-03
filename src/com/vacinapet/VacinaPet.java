package com.vacinapet;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.vacinapet.Pet.Pets;

public class VacinaPet extends ListActivity {
	protected static final int INSERIR_EDITAR = 1;
	protected static final int BUSCAR = 2;

	public static BancoPet banco;

	private List<Pet> pets;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		banco = new BancoPetScript(this);
		atualizarLista();
	}

	protected void atualizarLista() {
		// Pega a lista de pets e exibe
		pets = banco.listarPets();

		// Coloca para cada linha ser um pet
		setListAdapter(new PetListAdapter(this, pets));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.vacina_pet, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_atualizar:
			atualizarLista();
			break;
		case R.id.action_cadastrar:
			Intent mudarDeTela = new Intent(this, EditarPet.class);
			startActivity(mudarDeTela);
			return true;
		}

		return true;
	}

	@Override
	protected void onListItemClick(ListView l, View v, int posicao, long id) {
		super.onListItemClick(l, v, posicao, id);
		editarPet(posicao);
	}

	// Recupera o id do pet e abre a tela de edicao
	protected void editarPet(int posicao) {
		// Recupera o pet selecionado
		Pet pet = pets.get(posicao);
		Intent it = new Intent(this, EditarPet.class);
		// Passa o id do pet como parametro
		it.putExtra(Pets._ID, pet.id);
		startActivityForResult(it, INSERIR_EDITAR);
	}

	@Override
	protected void onActivityResult(int codigo, int codigoRetorno, Intent it) {
		super.onActivityResult(codigo, codigoRetorno, it);
		// Quando EditarPet retornar, atualiza a lista
		if (codigoRetorno == RESULT_OK) {
			atualizarLista();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		banco.fechar();
	}

}
