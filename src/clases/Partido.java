package clases;

import clases.Resultado.ResultadoEnum;

public class Partido {
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesE1;
	private int golesE2;
	
	public Equipo getEquipo1() {
		return equipo1;
	}
	
	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}
	
	public Equipo getEquipo2() {
		return equipo2;
	}
	
	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}
	
	public int getGolesE1() {
		return golesE1;
	}
	
	public void setGolesE1(int golesE1) {
		this.golesE1 = golesE1;
	}
	
	public int getGolesE2() {
		return golesE2;
	}
	
	public void setGolesE2(int golesE2) {
		this.golesE2 = golesE2;
	}
	
	public Resultado resultado(Equipo e) {
		return null;
	}
	
	public Partido() {
		
	}
	
	public Partido(Equipo equipo1, Equipo equipo2, int golesE1, int golesE2) {
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.golesE1 = golesE1;
		this.golesE2 = golesE2;
	}
	
	public Partido(Partido p) {
		this.equipo1 = p.equipo1;
		this.equipo2 = p.equipo2;
		this.golesE1 = p.golesE1;
		this.golesE2 = p.golesE2;
	}
	
	public ResultadoEnum determinarResultado() {
		ResultadoEnum resultado = null;
		if (this.golesE1 > this.golesE2) {
			resultado = ResultadoEnum.GANADOR;
		} else if (this.golesE1 == this.golesE2){
			resultado = ResultadoEnum.EMPATE;
		} else {
			resultado = ResultadoEnum.PERDEDOR;
		}
		return resultado;
	}

	@Override
	public String toString() {
		return this.equipo1.getNombre() + " vs " + this.equipo2.getNombre() + "\n" + this.golesE1 + " " + this.golesE2;
	}

}
