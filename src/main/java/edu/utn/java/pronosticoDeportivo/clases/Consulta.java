package edu.utn.java.pronosticoDeportivo.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.utn.java.pronosticoDeportivo.clases.Resultado.ResultadoEnum;

public class Consulta {
	Conexion conn = new Conexion();
	Connection usarConexion = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps;
	
	public Consulta() {
		super();
	}
	
	public Equipo buscarEquipo(String codigo) {
		Equipo eq = new Equipo();
		try {
			usarConexion = conn.conectar(); 
			String consulta = "SELECT * FROM equipo WHERE codigo_iso='"+codigo+"'";
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta); 
			if (rs.next()) {
				eq.setDescripcion(rs.getString(1));
				eq.setNombre(rs.getString(2));
				} else eq = null;
			usarConexion.close();
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado, intente de nuevo " +e);
		}
		return eq;
	}
	
	public void mostrarPartidos() {
		try {
			Connection usarConexion2 = conn.conectar(); 
			String consulta = "SELECT * FROM Partido";
			stm = usarConexion2.createStatement();
			rs = stm.executeQuery(consulta); 
			List<Partido> listaPartido = new ArrayList<Partido>();
			List<String> lista = new ArrayList<String>();
			
			while (rs.next()) {
				lista.add(rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " " +rs.getInt(5));
			}
			for (String elemento : lista) {
				String equipo[] = elemento.split(" ");
				Equipo eq1 = new Equipo (buscarEquipo(equipo[0]));
				Equipo eq2 = new Equipo (buscarEquipo(equipo[1]));
				Partido p = new Partido(eq1, eq2, Integer.parseInt(equipo[2]), Integer.parseInt(equipo[3]));
				listaPartido.add(p);
			}
			for (Partido p : listaPartido) {
				System.out.println(p);
			}
			usarConexion.close();
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado, intente de nuevo " +e);
		}
	}
	
	public void cargarResultados(List<String> listaResultados) {
		try {
			usarConexion = conn.conectar();
			String consulta = "UPDATE partido SET golesA=?, golesB=? WHERE equipoA=?  AND equipoB =?";
			for (String elemento : listaResultados) {
				String[] partido = elemento.split(";");
				ps = usarConexion.prepareStatement(consulta);
				ps.setObject(1, partido[3]);
				ps.setObject(2, partido[4]);
				ps.setObject(3, partido[1]);
				ps.setObject(4, partido[2]);
				ps.executeUpdate();
			}
			System.out.println("Se cargaron correctamente los resultados de los partidos");
			usarConexion.close();
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}
	}
	
	public void cargarPronostico(List<String> listaPronosticos) {
		try {
			usarConexion = conn.conectar();
			int i = 0;
			String consulta = "INSERT INTO pronostico (id_partido, equipo, resultado, usuario) VALUES (?,?,?,?)";
			for (String elemento : listaPronosticos) {
				if (i == 0) { //para saltear el encabezado y no de error
					i++;
				} else {
					String[] partido = elemento.split(";");
					ps = usarConexion.prepareStatement(consulta);
					ps.setObject(1, Integer.parseInt(partido[0]));
					ps.setObject(2, partido[1]);
					ps.setObject(3, partido[3]);
					ps.setObject(4, partido[4]);
					ps.executeUpdate();
				}
			}
			System.out.println("Se cargaron correctamente los pronosticos de los partidos");
			usarConexion.close();
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}
	}
	
	public void mostrarPronosticos() {
		try {
			Pronostico pr = new Pronostico();
			usarConexion = conn.conectar(); 
			String consulta = "SELECT * FROM pronostico";
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta);
			System.out.println("Partido Nº Equipo 1 Resultado Usuario");
			while (rs.next()) {
				System.out.println(rs.getString(2) + " " +rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
				}
			usarConexion.close();
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}
	}
	
	public Partido buscarPartido(int id_partido) {
		Partido pa = null;
		try {
			usarConexion = conn.conectar(); 
			String consulta = "SELECT * FROM partido WHERE id_partido='"+id_partido+"'";
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta); 
			if (rs.next()) {
				String eq1 = rs.getString(2), eq2 = rs.getString(3);
				int goles1 = rs.getInt(4), goles2 = rs.getInt(5);
				Equipo equipoA = new Equipo(buscarEquipo(eq1)), equipoB = new Equipo(buscarEquipo(eq2));
				pa = new Partido (equipoA, equipoB, goles1 ,goles2);
				} else pa = null;
			usarConexion.close();
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado, intente de nuevo " +e);
		}
		return pa;
	}
	
	public List<Partido> devolverPartidos(int id_ronda){
		//Si id_ronda = 0 devuelve todos los partidos caso contrario devuelve los partidos de esa ronda
		List<Partido> listaPartido = new ArrayList<Partido>();
		try {
			if (id_ronda == 0) {
				Connection usarConexion = conn.conectar(); 
				String consulta = "SELECT * FROM Partido";
				stm = usarConexion.createStatement();
				rs = stm.executeQuery(consulta); 
				List<String> lista = new ArrayList<String>();
				
				while (rs.next()) {
					lista.add(rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " " +rs.getInt(5));
				}
				for (String elemento : lista) {
					String equipo[] = elemento.split(" ");
					Equipo eq1 = new Equipo (buscarEquipo(equipo[0]));
					Equipo eq2 = new Equipo (buscarEquipo(equipo[1]));
					Partido p = new Partido(eq1, eq2, Integer.parseInt(equipo[2]), Integer.parseInt(equipo[3]));
					listaPartido.add(p);
				}
			} else {
				Connection usarConexion = conn.conectar(); 
				String consulta = "SELECT * FROM Partido WHERE id_ronda ='"+id_ronda+"'";
				stm = usarConexion.createStatement();
				rs = stm.executeQuery(consulta); 
				List<String> lista = new ArrayList<String>();
				
				while (rs.next()) {
					lista.add(rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " " +rs.getInt(5));
				}
				for (String elemento : lista) {
					String equipo[] = elemento.split(" ");
					Equipo eq1 = new Equipo (buscarEquipo(equipo[0]));
					Equipo eq2 = new Equipo (buscarEquipo(equipo[1]));
					Partido p = new Partido(eq1, eq2, Integer.parseInt(equipo[2]), Integer.parseInt(equipo[3]));
					listaPartido.add(p);
				}
			}
			usarConexion.close();
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado, intente de nuevo " +e);
		}
		return listaPartido;
	}
	
	public Map<Integer,List<Partido>> partidosPorRonda(int cantRonda){
		Map<Integer,List<Partido>> mapPartido = new HashMap<Integer,List<Partido>>();
		try {
			for (int i = 1; i <= cantRonda; i++) {
				mapPartido.put(i, devolverPartidos(i));
			}
		} catch (Exception e) {
			System.out.println("Ocurrio un error inesperado, intente de nuevo " +e);
		}
		return mapPartido;
	}
	
	public Map<String,List<Pronostico>> pronosticos(){
		List<Pronostico> listaPronostico = new ArrayList<Pronostico>();
		List<String> listaAux = new ArrayList<String>();
		Map<String,List<Pronostico>> mapPronostico = new HashMap<String,List<Pronostico>>();
		List<String> listaParticipantes = new ArrayList<String>();
		try {
			int i = 0;
			Connection usarConexion = conn.conectar(); 
			String consulta = "SELECT * FROM Pronostico";
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta); 
			while (rs.next()) {
				listaAux.add(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
				if (i == 0) {
					listaParticipantes.add(rs.getString(5));
					i++;
				} else {
					if (!listaParticipantes.contains(rs.getString(5))) {
						listaParticipantes.add(rs.getString(5));
					}
				}
			}
			for (String lp : listaParticipantes) {
				for (String elemento : listaAux) {
					String separado[] = elemento.split(" ");
					if (lp.equals(separado[4])) {
						Partido par = buscarPartido(Integer.parseInt(separado[1]));
						Equipo eq = buscarEquipo(separado[2]);
						Resultado resultado = new Resultado();
						ResultadoEnum res = resultado.determinarResultado(separado[3]);
						Pronostico pro = new Pronostico(par,eq,res);
						listaPronostico.add(pro);
					} else {
						mapPronostico.put(lp, listaPronostico);
						listaPronostico.clear();
					}
				}
			}
			usarConexion.close();
		} catch (Exception e) {
			System.out.println("Ocurrio un error inesperado, intente de nuevo " +e);
		}
		return mapPronostico;
	}
}
