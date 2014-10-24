package com.vacinapet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cachorro extends Activity {
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

}
