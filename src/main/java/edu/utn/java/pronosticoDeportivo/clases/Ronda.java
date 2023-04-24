package edu.utn.java.pronosticoDeportivo.clases;

import java.util.List;

public class Ronda {
	private String nroRonda;
	private List<Partido> partidoR;
	//private List<Pronostico> partidoP;
	
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

//	public List<Pronostico> getPartidoP() {
//		return partidoP;
//	}
//
//	public void setPartidoP(List<Pronostico> partidoP) {
//		this.partidoP = partidoP;
//	}
	
	public int puntos() {
		return 0;
	}
	
	public Ronda() {
		
	}
	
	public Ronda(String nroRonda, List<Partido> partidoR, List<Pronostico> partidoP) {
		super();
		this.nroRonda = nroRonda;
		this.partidoR = partidoR;
//		this.partidoP = partidoP;
	}
	
	public Ronda(Ronda r) {
		super();
		this.nroRonda = r.nroRonda;
		this.partidoR = r.partidoR;
//		this.partidoP = r.partidoP;
	}
	
	public Ronda(List<Partido> partidoR, List<Pronostico> partidoP) {
		super();
//		this.partidoP = partidoP;
		this.partidoR = partidoR;
	}

//	public int determinarPuntos() {
//		int puntos = 0 , i = 0;
//		
//		for (Pronostico pro : this.partidoP) {
//			if (i == 16) i = 0;
//			if (this.partidoR.get(i).determinarResultado() == pro.getPartido().determinarResultado()) {
//				puntos += 1;
//			}
//		}
//		return puntos;
//	}
	
	public int determinarRonda(List<String> resultado) {
		int ronda = 0;
		for (String elemento : resultado) {
			String [] partidoL = elemento.split(";");
			int aux = Integer.parseInt(partidoL[0]);
			if (aux > ronda) ronda = aux;
		}
		return ronda;
	}
}
