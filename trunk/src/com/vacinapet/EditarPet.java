package com.vacinapet;

import com.vacinapet.Pet.Pets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EditarPet extends Activity {

	static final int RESULT_SALVAR = 1;
	static final int RESULT_EXCLUIR = 2;

	private EditText editTextNome;
	private EditText editTextAnimal;
	private EditText editTextRaca;
	private EditText editTextSexo;
	private EditText editTextNascimento;
	private EditText editTextPeso;
	private Long id;

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.cadastropet);

		editTextNome = (EditText) findViewById(R.id.editTextNome);
		editTextAnimal = (EditText) findViewById(R.id.editTextAnimal);
		editTextRaca = (EditText) findViewById(R.id.editTextRaca);
		editTextSexo = (EditText) findViewById(R.id.editTextSexo);
		editTextNascimento = (EditText) findViewById(R.id.editTextNascimento);
		editTextPeso = (EditText) findViewById(R.id.editTextPeso);

		id = null;

		Bundle extras = getIntent().getExtras();
		// Se for para Editar, recuperar os valores ...
		if (extras != null) {
			id = extras.getLong(Pets._ID);

			if (id != null) {
				// é uma edição, busca o pet...
				Pet p = buscarPet(id);
				editTextNome.setText(p.nome);
				editTextAnimal.setText(p.animal);
				editTextRaca.setText(p.raca);
				editTextSexo.setText(p.sexo);
				editTextNascimento.setText(p.nascimento);
				editTextPeso.setText(p.peso);
			}
		}

		Button cancelar = (Button) findViewById(R.id.buttonCancelar);
		cancelar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				setResult(RESULT_CANCELED);
				finish();
			}
		});

		Button salvar = (Button) findViewById(R.id.buttonSalvar);
		salvar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				salvar();
			}
		});

		Button excluir = (Button) findViewById(R.id.buttonExcluir);

		if (id == null) {
			// Se id está nulo, não pode excluir
			excluir.setVisibility(View.INVISIBLE);
		} else {
			// Listener para excluir o pet
			excluir.setOnClickListener(new OnClickListener() {
				public void onClick(View view) {
					excluir();
				}
			});
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		setResult(RESULT_CANCELED);
		finish();
	}

	public void salvar() {

		Pet pet = new Pet();
		if (id != null) {
			// É uma atualização
			pet.id = id;
		}
		pet.nome = editTextNome.getText().toString();
		pet.animal = editTextAnimal.getText().toString();
		pet.raca = editTextRaca.getText().toString();
		pet.sexo = editTextSexo.getText().toString();
		pet.nascimento = editTextNascimento.getText().toString();
		pet.peso = editTextPeso.getText().toString();

		// Salvar
		salvarPet(pet);

		// OK
		setResult(RESULT_OK, new Intent());

		// Fecha a tela
		finish();
	}

	public void excluir() {
		if (id != null) {
			excluirPet(id);
		}

		// OK
		setResult(RESULT_OK, new Intent());

		// Fecha a tela
		finish();
	}

	// Buscar o pet pelo id
	protected Pet buscarPet(long id) {
		return VacinaPet.banco.buscarPet(id);
	}

	// Salvar o pet
	protected void salvarPet(Pet pet) {
		VacinaPet.banco.salvar(pet);
	}

	// Exclui o pet
	protected void excluirPet(long id) {
		VacinaPet.banco.deletar(id);
	}

}
