package com.vacinapet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cachorro extends Activity implements Animal {
	private String nome = null;
	private char sexo;
	private Float peso;
	private Date dataNasc;
	private Raca raca;
	private List<DoseVacina> listaDose = new ArrayList<DoseVacina>(20);

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cachorro);

		Button vacina = (Button) findViewById(R.id.buttonVacinas);
		vacina.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaVacinas();
			}
		});
	}

	public void chamaVacinas() {
		Intent entra = new Intent(this, Vacina.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}

	public String getNome() {
		return this.nome;
	}	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return this.sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Float getPeso() {
		return this.peso;
	}
	
	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Date getDataNasc() {
		return this.dataNasc;
	}
	
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void cadastarAnimal() {

	}

	public void editarAnimal(Animal animal) {

	}

	public void deletarAnimal(Animal animal) {

	}

	public void vacinar(Animal animal) {

	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public List<DoseVacina> getListaDose() {
		return this.listaDose;
	}

	public void setDoseVacina(DoseVacina doseVacina) {
		this.listaDose.add(doseVacina);
	}

}
