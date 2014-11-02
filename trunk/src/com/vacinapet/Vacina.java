package com.vacinapet;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Vacina extends Activity {
	private String nome;
	private String descricao;
	private Date dataSugerida;
	private int tipo;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vacinas);
		
		Button obrigatorias = (Button) findViewById(R.id.buttonVacinasObrigatorias);		
		obrigatorias.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaobg();
			}
		});
		
		Button cadastroVacina = (Button) findViewById(R.id.buttonCadastrarVacina);		
		cadastroVacina.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaCadastroVacinas();
			}
		});
		
		Button notificacao = (Button) findViewById(R.id.buttonNotificacao);		
		notificacao.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaNotificacao();
			}
		});

	}
	
	public void chamaobg(){
		Intent entra = new Intent(this, VacinaObg.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	public void chamaCadastroVacinas(){
		Intent entra = new Intent(this, CadastroVacina.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	public void chamaNotificacao(){
		Intent entra = new Intent(this, Notificacao.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataSugerida() {
		return dataSugerida;
	}

	public void setDataSugerida(Date dataSugerida) {
		this.dataSugerida = dataSugerida;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public void cadastrarVacina(){
		
	}
	
	public void editarVacina(){
		
	}
	
	public void deletarVacina(){
		
	}
	
	public void notificar(){
		
	}

}
