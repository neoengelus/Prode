package edu.utn.java.pronosticoDeportivo.clases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Archivo {
	private Path ruta;
	
	public void asignarRuta(String ruta) {
		this.ruta = Paths.get(ruta).toAbsolutePath();
	}

	public Path getRuta() {
		return ruta;
	}

	public void setRuta(Path ruta) {
		this.ruta = ruta;
	}
	
	public Archivo() {
		
	}

	public Archivo(Path ruta) {
		super();
		this.ruta = ruta;
	}
	
	public Archivo(String ruta) {
		super();
		this.asignarRuta(ruta);
	}
	
	public List<String> leerArchivo(){
		List<String> lineas = null;
		try {
			lineas = Files.readAllLines(ruta);
			
		} catch (IOException e) {
			System.out.println("Se produjo un error: "+ e);
		}
		//lineas.remove(0);
		return lineas;
	}
	
	public byte[] leerJson() {
		byte mapData[] = null;
		
		try {
			mapData = Files.readAllBytes(ruta);
		} catch (IOException e) {
			System.out.println("Se produjo un error: "+ e);
		}
		return mapData;
	}

	public List<Map<String, List<String>>> procesarApuestas(byte[] pronostico) {
		List<Map<String, List<String>>> pronosticoMap = new ArrayList<Map<String, List<String>>>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			pronosticoMap = objectMapper.readValue(pronostico, List.class);
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println("Map is: "+pronosticoMap);
		return pronosticoMap;
	}
}