package edu.utn.java.pronosticoDeportivo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import edu.utn.java.pronosticoDeportivo.clases.Archivo;
import edu.utn.java.pronosticoDeportivo.clases.Partido;
import edu.utn.java.pronosticoDeportivo.clases.Pronostico;
import edu.utn.java.pronosticoDeportivo.clases.Resultado;
import edu.utn.java.pronosticoDeportivo.clases.Resultado.ResultadoEnum;
import edu.utn.java.pronosticoDeportivo.clases.Consulta;

public class App {
    public static void main(String[] args ) {
    	Consulta con = new Consulta();
    	Archivo resultadosCsv = new Archivo("resultados.csv");
    	Archivo pronosticosCsv = new Archivo("pronostico.csv");
    	List<String> resultado = resultadosCsv.leerArchivo();
    	List<String> pronostico = pronosticosCsv.leerArchivo();
    	Map<Integer,List<Partido>> mapPartido = new HashMap<Integer,List<Partido>>();
    	Map<String,List<Pronostico>> mapPronostico = new HashMap<String,List<Pronostico>>();
    	List<String> participantes = new ArrayList<String>();
    	List<Integer> puntajes = new ArrayList<Integer>();
    	con.cargarResultados(resultado);
    	con.mostrarPartidos();
    	con.cargarPronostico(pronostico);
    	con.mostrarPronosticos();
    	mapPartido = con.partidosPorRonda(1);
    	for (Entry<Integer, List<Partido>> entry : mapPartido.entrySet()) {
    	    System.out.println("Ronda N° " + entry.getKey() + ", Partidos " + entry.getValue());
    	}
    	System.out.println(mapPartido);
    	mapPronostico = con.pronosticos();
    	System.out.println(mapPronostico);
    	for (Entry<String,List<Pronostico>> entry : mapPronostico.entrySet()) {
    	    System.out.println("Participante " + entry.getKey() + ", Pronostico " + entry.getValue());
    	}
    	for (Entry<String,List<Pronostico>> pro : mapPronostico.entrySet()) {
    	    System.out.println("Participante " + pro.getKey() + ", Pronostico " + pro.getValue());
    		participantes.add(pro.getKey());
			int contador = 0;
    		for (Entry<Integer,List<Partido>> par : mapPartido.entrySet()) {
    			for(Partido lp : par.getValue()) {
    				for (Pronostico p : pro.getValue()) {
	    				Resultado res = new Resultado();
	    				ResultadoEnum resul = null;
	    				resul = res.determinarResultado(lp.getGolesE1(), lp.getGolesE2());
	    				if (resul == p.getResultado()) {
	    					contador++;
	    				}
    				}
    			}
    		}
    		puntajes.add(contador);
    	}
    	for (int i = 0; i < participantes.size(); i++) {
    		System.out.println("Participante: " +participantes.get(i) + " Puntaje: " +puntajes.get(i));
    	}
    }
}
