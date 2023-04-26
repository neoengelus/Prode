package edu.utn.java.pronosticoDeportivo.clases;

import java.util.List;

public class Ronda {
	private String nroRonda;
	private List<Partido> partidoR;
	
	public String getNroRonda() {
		return nroRonda;
	}
	
	public void setNroRonda(String nroRonda) {
		this.nroRonda = nroRonda;
	}
	
	public List<Partido> getPartidoR() {
		return partidoR;
	}

	public void setPartidoR(List<Partido> partidoR) {
		this.partidoR = partidoR;
	}
	
	public int puntos() {
		return 0;
	}
	
	public Ronda() {
		
	}
	
	public Ronda(String nroRonda, List<Partido> partidoR) {
		super();
		this.nroRonda = nroRonda;
		this.partidoR = partidoR;
	}
	
	public Ronda(Ronda r) {
		super();
		this.nroRonda = r.nroRonda;
		this.partidoR = r.partidoR;
	}
	
	public Ronda(List<Partido> partidoR, List<Pronostico> partidoP) {
		super();
		this.partidoR = partidoR;
	}
	
	public int determinarRonda(List<String> resultado) {
		int ronda = 0;
		for (String elemento : resultado) {
			String [] partidoL = elemento.split(";");
			int aux = Integer.parseInt(partidoL[0]);
			if (aux > ronda) ronda = aux;
		}
		return ronda;
	}

	@Override
	public String toString() {
		return "Nº Ronda " + nroRonda + " Partidos " + partidoR;
	}
	
	
}
