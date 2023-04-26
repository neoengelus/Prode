package edu.utn.java.pronosticoDeportivo.clases;

public class Resultado {
	public enum ResultadoEnum {GANADOR,EMPATE,PERDEDOR};
	
	public ResultadoEnum determinarResultado(String[] lista) {
		ResultadoEnum res = null;
	
		for (int i = 2; i <= 4; i++) {
			if (lista[i].equals("X")) {
				switch (i) {
					case 2:
						res = ResultadoEnum.GANADOR;
						break;
					case 3:
						res = ResultadoEnum.EMPATE;
						break;
					case 4:
						res = ResultadoEnum.PERDEDOR;
						break;
				}			
			}
		}
		return res;
	}
	
	public int posicionResultado(String[] lista) {
		int pos = 0;
		
		for (String elemento : lista) {
			if (elemento == "X") {
				pos = elemento.indexOf("X");
			}
		}
		return pos;
	}
	
	public ResultadoEnum determinarResultado(String resultado) {
		ResultadoEnum res = null;
		switch (resultado) {
		case "G":
			res = ResultadoEnum.GANADOR;
			break;
		case "E":
			res = ResultadoEnum.EMPATE;
			break;
		case "P":
			res = ResultadoEnum.PERDEDOR;
			break;
			}
		return res;
		}
	
	public ResultadoEnum determinarResultado(int a, int b) {
		ResultadoEnum res = null;
		if (a > b) {
			res = ResultadoEnum.GANADOR;
		} else if (a < b) {
			res = ResultadoEnum.PERDEDOR;
		} else if (a == b) {
			res = ResultadoEnum.EMPATE;
		}
		return res;
	}
}
