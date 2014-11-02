package com.vacinapet;

import java.util.Date;

public class DoseVacina {
	private Vacina vacina;
	private Date dataAgendada;
	private int numeroDaDose;
	private boolean status;
	
	public Vacina getVacina() {
		return vacina;
	}
	
	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}
	
	public Date getDataAgendada() {
		return dataAgendada;
	}
	
	public void setDataAgendada(Date dataAgendada) {
		this.dataAgendada = dataAgendada;
	}
	
	public int getNumeroDaDose() {
		return numeroDaDose;
	}
	
	public void setNumeroDaDose(int numeroDaDose) {
		this.numeroDaDose = numeroDaDose;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
}
