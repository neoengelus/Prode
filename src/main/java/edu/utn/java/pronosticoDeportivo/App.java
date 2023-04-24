package edu.utn.java.pronosticoDeportivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.utn.java.pronosticoDeportivo.clases.Archivo;
import edu.utn.java.pronosticoDeportivo.clases.Equipo;
import edu.utn.java.pronosticoDeportivo.clases.Partido;
import edu.utn.java.pronosticoDeportivo.clases.Pronostico;
import edu.utn.java.pronosticoDeportivo.clases.Resultado;
import edu.utn.java.pronosticoDeportivo.clases.Ronda;
import edu.utn.java.pronosticoDeportivo.clases.Resultado.ResultadoEnum;
import edu.utn.java.pronosticoDeportivo.clases.Conexion;
import edu.utn.java.pronosticoDeportivo.clases.Consulta;

public class App {
    public static void main(String[] args ) {
    	Consulta con = new Consulta();
    	Archivo resultadosCsv = new Archivo("resultados.csv");
    	Archivo pronosticosCsv = new Archivo("pronostico2.csv");
    	List<String> resultado = resultadosCsv.leerArchivo();
    	List<String> pronostico = pronosticosCsv.leerArchivo();
    	List<Partido> listaPartido = new ArrayList<Partido>();
    	Map<Integer,List<Partido>> mapPartido = new HashMap<Integer,List<Partido>>();
    	Map<String,List<Pronostico>> mapPronostico = new HashMap<String,List<Pronostico>>();
//    	con.cargarResultados(resultado);
//    	con.mostrarPartidos();
//    	con.cargarPronostico(pronostico);
//    	con.mostrarPronosticos();
//    	mapPartido = con.partidosPorRonda(8);
//    	for (Entry<Integer, List<Partido>> entry : mapPartido.entrySet()) {
//    	    System.out.println("Ronda N° " + entry.getKey() + ", Partidos " + entry.getValue());
//    	}
    	//System.out.println(mapPartido);
    	mapPronostico = con.pronosticos();
    	for (Entry<String,List<Pronostico>> entry : mapPronostico.entrySet()) {
    	    System.out.println("Participante " + entry.getKey() + ", Pronostico " + entry.getValue());
    	}
    }
}
