package com.vacinapet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class VacinaPetActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vacina_pet);
		
		ImageButton cadastrarDog = (ImageButton) findViewById(R.id.imageButtonAdicionarPet);		
		cadastrarDog.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaCadastrarDog();
			}
		});
		
		Button luck = (Button) findViewById(R.id.buttonLuck);		
		luck.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaLuck();
			}
		});
	}
	
	public void chamaCadastrarDog(){
		Intent entra = new Intent(this, CadastroDog.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	public void chamaLuck(){
		Intent entra = new Intent(this, Cachorro.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}

}
