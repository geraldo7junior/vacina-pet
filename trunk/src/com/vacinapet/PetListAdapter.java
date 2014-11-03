package com.vacinapet;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PetListAdapter extends BaseAdapter {

	private Context context;
	private List<Pet> lista;

	public PetListAdapter(Context context, List<Pet> lista) {
		this.context = context;
		this.lista = lista;
	}

	public int getCount() {
		return lista.size();
	}

	public Object getItem(int position) {
		return lista.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// Recupera o pet da posição atual
		Pet p = lista.get(position);

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.vacinapet, null);

		// Atualiza o valor do TextView
		TextView nome = (TextView) view.findViewById(R.id.textViewNome);
		nome.setText(p.nome);

		TextView animal = (TextView) view.findViewById(R.id.textViewAnimal);
		animal.setText(p.animal);

		TextView raca = (TextView) view.findViewById(R.id.textViewRaca);
		raca.setText(p.raca);

		TextView sexo = (TextView) view.findViewById(R.id.textViewSexo);
		sexo.setText(p.sexo);

		TextView nascimento = (TextView) view
				.findViewById(R.id.textViewNascimento);
		nascimento.setText(p.nascimento);

		TextView peso = (TextView) view.findViewById(R.id.textViewPeso);
		peso.setText(p.peso);

		return view;
	}

}
