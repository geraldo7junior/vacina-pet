package com.vacinapet;

import java.util.Date;
import java.util.List;

public interface Animal {
	String getNome();
	char getSexo();
	Float getPeso();
	Date getDataNasc();
	Raca getRaca();
	List<DoseVacina> getListaDose();
	
	public void setNome(String nome);
	public void setSexo(char sexo);
	public void setPeso(Float peso);
	public void setDataNasc(Date dataNasc);
	public void setRaca(Raca raca);
	public void setDoseVacina(DoseVacina doseVacina);
	
	public void cadastarAnimal();
	public void editarAnimal(Animal animal);
	public void deletarAnimal(Animal animal);
	public void vacinar(Animal animal);
	

}
