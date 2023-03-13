package clases;

public class Resultado {
	public enum ResultadoEnum {GANADOR,EMPATE,PERDEDOR};
	
	public ResultadoEnum determinarResultado(String[] lista) {
		ResultadoEnum res = null;
		int i = 1;
		for (i = 1; i <= 3; i++) {
			if (lista[i].equals("X")) {
				switch (i) {
					case 1:
						res = ResultadoEnum.GANADOR;
						break;
					case 2:
						res = ResultadoEnum.EMPATE;
						break;
					case 3:
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
}
