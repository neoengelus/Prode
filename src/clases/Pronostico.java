package clases;

import clases.Resultado.ResultadoEnum;

public class Pronostico {
	private Partido partido;
	private Equipo equipo1;
	private Equipo equipo2;
	private ResultadoEnum resultado;
	
	public Partido getPartido() {
		return partido;
	}
	
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	
	public Equipo getEquipo() {
		return equipo1;
	}
	
	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}
	
	public void setEquipo(Equipo equipo) {
		this.equipo1 = equipo;
	}
	
	public ResultadoEnum getResultado() {
		return resultado;
	}
	
	public void setResultado(ResultadoEnum resultado) {
		this.resultado = resultado;
	}
	
	public int puntos() {
		return 0;
	}
	
	public Pronostico() {
		
	}
	
	public Pronostico(Partido partido, Equipo equipo1, Equipo equipo2, ResultadoEnum resultado) {
		this.partido = partido;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.resultado = resultado;
	}
	
	public Pronostico(Pronostico p) {
		this.partido = p.partido;
		this.equipo1 = p.equipo1;
		this.resultado = p.resultado;
	}
	
	public Pronostico(Partido partido, ResultadoEnum resultado) {
		this.partido = partido;
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return partido + "\n" + resultado;
	}
	
	
}
