package Conexion;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;

public class Conexion {

	/*
	 * Variables para conectar con la base de datos base: nombre de la base de datos
	 * user: usuario de la base de datos password: contraseña de la base de datos
	 * url: enlace para la conexion a la base de datos indicando que utilizareoms
	 * jdbc y mysql con: clase Connextion necesaria para realizar la conexion
	 */

	private final String base = "concesionario";
	private final String user = "root";
	private final String password = "manolo";
	private final String url = "jdbc:mysql://localhost:3307/" + base;
	private Connection con = null;

	// Funcion para conectar
	
	public Connection getConexion() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);

		} catch (SQLException e) {
			System.err.println(e);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
		}
		return con;
	}

}

