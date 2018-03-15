package mundo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MetodosPais {

	private Connection conn;

	public MetodosPais() {
		// TODO Auto-generated constructor stub

		String servidor = "localhost";
		String porta = "3306";
		String database = "mundo";
		String usuario = "alunos";
		String senha = "alunos";

		try {

			this.conn = DriverManager.getConnection("jdbc:mysql://" + servidor + ":" + porta + "/" + database + "?user="
					+ usuario + "&password=" + senha);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Pais maiorPop() {

		String query = "SELECT * FROM pais WHERE populacao IN (SELECT MAX(populacao) FROM pais)";

		try {

			PreparedStatement stm = this.conn.prepareStatement(query);

			ResultSet rs = stm.executeQuery();

			Pais pais = new Pais();

			if (rs.next()) {

				pais.setNome(rs.getString("nome"));
				pais.setPopulacao(rs.getLong("populacao"));
				pais.setArea(rs.getDouble("area"));

			}

			return pais;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public Pais menorArea() {

		String query = "SELECT * FROM pais WHERE area IN (SELECT MIN(area) FROM pais)";

		try {

			PreparedStatement stm = this.conn.prepareStatement(query);

			ResultSet rs = stm.executeQuery();

			Pais pais = new Pais();

			if (rs.next()) {

				pais.setNome(rs.getString("nome"));
				pais.setPopulacao(rs.getLong("populacao"));
				pais.setArea(rs.getDouble("area"));

			}

			return pais;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public ArrayList<Pais> vetPais() {

		String query = "SELECT * FROM pais LIMIT 3";

		try {

			PreparedStatement stm = this.conn.prepareStatement(query);

			ResultSet rs = stm.executeQuery();

			ArrayList<Pais> vet = new ArrayList<Pais>();
			
			while (rs.next()) {

				Pais pais = new Pais();
				
				pais.setNome(rs.getString("nome"));
				pais.setPopulacao(rs.getLong("populacao"));
				pais.setArea(rs.getDouble("area"));
				
				vet.add(pais);
				
			}

			return vet;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}