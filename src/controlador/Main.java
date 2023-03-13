package controlador;

import java.util.ArrayList;
import java.util.List;

import clases.Archivo;
import clases.Equipo;
import clases.Partido;
import clases.Pronostico;
import clases.Resultado;
import clases.Resultado.ResultadoEnum;

public class Main {

	public static void main(String[] args) {
		Archivo ficheroR = new Archivo("resultados.csv");
		Archivo ficheroP = new Archivo("pronostico.csv");
		List<String> resultado = ficheroR.leerArchivo();
		List<String> pronostico = ficheroP.leerArchivo();
		List<Partido> partidoR = new ArrayList<Partido>();
		List<Pronostico> partidoP = new ArrayList<Pronostico>();
		int puntos = 0;
		
		for (String elemento : resultado) {
			String [] partidoL = elemento.split(";");
			Equipo eq1 = new Equipo(partidoL[0],"Titular"), eq2 = new Equipo(partidoL[0],"Titular"); 
			Partido p = new Partido(eq1,eq2,Integer.parseInt(partidoL[1]),Integer.parseInt(partidoL[2]));
			partidoR.add(p);
		}
		
		for (String elemento : pronostico) {
			int i = 0;
			String [] partidoL = elemento.split(";");
			Resultado res = new Resultado();
			ResultadoEnum resE = res.determinarResultado(partidoL);
			Pronostico pr = new Pronostico(partidoR.get(i), partidoR.get(i).getEquipo1(), partidoR.get(i).getEquipo2(), resE);
			i++;
			partidoP.add(pr);
		}
		
		for (int i = 0; i < partidoP.size(); i++) {
			boolean x = (partidoR.get(i).determinarResultado() == partidoP.get(i).getResultado());
			if (partidoR.get(i).determinarResultado() == partidoP.get(i).getResultado()) {
				puntos += 1;
			}
		}
		System.out.println("Puntos: " +puntos);
	}
}
