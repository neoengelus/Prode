package clases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
		lineas.remove(0);
		return lineas;
	}
}
