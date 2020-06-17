package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import Beans.Coche;
import Conexion.Conexion;

/* Clase para programar las funciones Create Read Update Delete de la clase, 
 * debe de extender de Conexion para tener conectividad con la base de datos
 * */

public class Coches extends Conexion {

	/*
	 * Funcion para añadir el coche, nos devolvera true en el caso en el que se haya
	 * realizado con exito, pasamos por parametro el objeto Coche del que queremos
	 * obtener los datos para ejecutar las Query
	 */

	public boolean addCoche(Coche c) {

		// Obtenemos la conexion, preparamos el statement y la sentencia SQL

		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO coche (marca, modelo, precio, cantidad) VALUES (?,?,?,?)";

		try {

			// Asignamos la sentencia SQL y modificamos los valores de los interrogantes por
			// los valores del objeto

			ps = con.prepareStatement(sql);
			ps.setString(1, c.getMarca());
			ps.setString(2, c.getModelo());
			ps.setDouble(3, c.getPrecio());
			ps.setInt(4, c.getCantidad());
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}

	}

	/*
	 * Funcion para modificar el coche, nos devolvera true en el caso en el que se
	 * haya realizado con exito, pasamos por parametro el objeto Coche del que
	 * queremos obtener los datos para ejecutar las Query
	 */

	public boolean updateCoche(Coche c) {

		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE coche SET marca=?, modelo=?, precio=?, cantidad=? WHERE cocheID=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, c.getMarca());
			ps.setString(2, c.getModelo());
			ps.setDouble(3, c.getPrecio());
			ps.setInt(4, c.getCantidad());
			ps.setInt(5, c.getCocheID());
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}

	}

	/*
	 * Funcion para eliminar el coche, nos devolvera true en el caso en el que se
	 * haya realizado con exito, pasamos por parametro el objeto Coche del que
	 * queremos obtener los datos para ejecutar las Query
	 */

	public boolean deleteCoche(Coche c) {

		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "DELETE FROM coche WHERE cocheID=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, String.valueOf(c.getCocheID()));
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}

	}

	/*
	 * Funcion para buscar el coche, nos devolvera true en el caso en el que se haya
	 * realizado con exito, pasamos por parametro el objeto Coche del que queremos
	 * obtener los datos para ejecutar las Query utilizaremos la clase ArrayList ya
	 * que las busquedas las realizaremos por marca y pueden haber varios elementos
	 * con el mismo valor, en el caso de no introducir la marca mostrará todo el
	 * contenido
	 */

	public ArrayList<Coche> searchCoche(Coche c) {

		ArrayList<Coche> arrayCoches = new ArrayList<Coche>();

		PreparedStatement ps = null;
		ResultSet rs = null;/////////
		Connection con = getConexion();
		
		String sql;//////

		if (c.getMarca().isEmpty()) {
			sql = "SELECT * FROM coche";
		} else {
			sql = "SELECT * FROM coche WHERE marca=?";

		}

		Coche coche;

		try {
			ps = con.prepareStatement(sql);
			if (!c.getMarca().isEmpty()) {
				ps.setString(1, c.getMarca());///////////////
			}
			rs = ps.executeQuery();//////////////////
			while (rs.next()) {
				coche = new Coche(Integer.parseInt(rs.getString("cocheID")), rs.getString("Marca"),
						rs.getString("Modelo"), Double.parseDouble(rs.getString("Precio")),
						Integer.parseInt(rs.getString("Cantidad")));
				arrayCoches.add(coche);

			}
		} catch (SQLException e) {
			System.err.println(e);
		} finally {///////////
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		return arrayCoches;

	}

}
