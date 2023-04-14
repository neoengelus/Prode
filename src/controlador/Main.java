package controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import clases.Archivo;
import clases.Equipo;
import clases.Partido;
import clases.Pronostico;
import clases.Resultado;
import clases.Resultado.ResultadoEnum;
import clases.Ronda;

public class Main {

	public static void main(String[] args) {
		Archivo ficheroR = new Archivo("resultados.csv");
		Archivo ficheroP = new Archivo("pronostico.csv");
		List<String> resultado = ficheroR.leerArchivo();
		List<String> pronostico = ficheroP.leerArchivo();
		List<Partido> partidoR = new ArrayList<Partido>();
		List<Pronostico> partidoP = new ArrayList<Pronostico>();
		List<Ronda> rondaL = new ArrayList<Ronda>();
		List<String> participantes = new ArrayList<String>();
		int i = 0, nroRonda = 0, nro = 0; String aux = "";
		Map<Integer, List<Partido>> partido = new HashMap<Integer, List<Partido>>();
		Map<String, List<Pronostico>> apuesta = new HashMap<String, List<Pronostico>>();

		
		for (String elemento : resultado) {
				String [] partidoL = elemento.split(";");
				Equipo eq1 = new Equipo(partidoL[1],"Titular"), eq2 = new Equipo(partidoL[4],"Titular"); 
				Partido p = new Partido(eq1,eq2,Integer.parseInt(partidoL[2]),Integer.parseInt(partidoL[3]));
				partidoR.add(p);
				if (nroRonda < Integer.parseInt(partidoL[0])) {
					nroRonda = Integer.parseInt(partidoL[0]);
					partido.put(nroRonda, partidoR);
					partidoR.clear();
				}
			}
//			System.out.println(elemento);
		for (String elemento : pronostico) {
				String [] partidoL = elemento.split(";");
				Resultado res = new Resultado();
				ResultadoEnum resE = res.determinarResultado(partidoL);
				Pronostico pr = new Pronostico(partidoR.get(i), resE);
				i++;
				if (i == 15) i = 0;
				partidoP.add(pr);
				if (!aux.equals(partidoL[0])) {
					participantes.add(partidoL[0]);
					aux = partidoL[0];
					apuesta.put(aux, partidoP);
					partidoP.clear();
				}
//				System.out.println(elemento);
		}
//		for (Partido par : partidoR) {
//			System.out.println(par.getGolesE1() + " " + par.getGolesE2() + " " + par.getEquipo1().getNombre() + " " + par.getEquipo2().getNombre());
//		}
//		for (Pronostico pro : partidoP) {
//			System.out.println(pro.getPartido().getEquipo1().getNombre() +" " + pro.getPartido().getEquipo2().getNombre() + " " + pro.getResultado());
//		}
//		Ronda ronda = new Ronda(partidoR, partidoP);
//		ronda.setNroRonda(Integer.toString(nroRonda));
//		rondaL.add(ronda);
//		for (Ronda ron : rondaL) {
//			for (Partido par : ron.getPartidoR()) {
//				System.out.println(par.getEquipo1().getNombre() + " " + par.getEquipo2().getNombre() + " " + par.determinarResultado());
//			}
//		}
//		for (Map.Entry<Integer, List<Partido>> entry : partido.entrySet()) {
//		    System.out.println("Ronda Nº " + entry.getKey());
//		    for (Partido par : entry.getValue() ) { 
//		    	System.out.println(par.toString());
//		    }
//		}
//		for (Map.Entry<String, List<Pronostico>> entry : apuesta.entrySet()) {
//		    System.out.println("Jugador: " + entry.getKey() + "\nPronostico");
//		    for (Pronostico pro : entry.getValue()) {
//		    	System.out.println(pro.toString());
//		    }
//		}
		for (i = 0; i < participantes.size(); i++) {
			if (nro < nroRonda) nro++;
			Ronda ronda = new Ronda(Integer.toString(i+1), partido.get(nro), apuesta.get(participantes.get(i)));
			rondaL.add(ronda);
		}
		for (Ronda ron : rondaL) {
			System.out.println("Puntos " + ron.determinarPuntos());
			}
		}
}
