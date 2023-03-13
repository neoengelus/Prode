package clases;

public class Ronda {
	private String nroRonda;
	private Partido partido[];
	
	public String getNroRonda() {
		return nroRonda;
	}
	
	public void setNroRonda(String nroRonda) {
		this.nroRonda = nroRonda;
	}
	
	public Partido[] getPartido() {
		return partido;
	}
	
	public void setPartido(Partido partido[]) {
		this.partido = partido;
	}
	
	public int puntos() {
		return 0;
	}
	
	public Ronda() {
		
	}
	
	public Ronda(String nro, Partido partido[]) {
		this.nroRonda = nro;
		this.partido = partido;
	}
	
	public Ronda(Ronda r) {
		this.nroRonda = r.nroRonda;
		this.partido = r.partido;
	}
}
