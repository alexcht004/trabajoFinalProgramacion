package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import Beans.Objeto;
import Conexion.Conexion;

/* Clase para programar las funciones Create Read Update Delete de la clase, 
 * debe de extender de Conexion para tener conectividad con la base de datos
 * */

public class Objetos extends Conexion {

	/*
	 * Funcion para añadir el objeto, nos devolvera true en el caso en el que se
	 * haya realizado con exito, pasamos por parametro el objeto Objetos del que
	 * queremos obtener los datos para ejecutar las Query
	 */

	public boolean addObjeto(Objeto o) {

		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO objeto (nombre, descripcion, precio, cantidad) VALUES (?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, o.getNombre());
			ps.setString(2, o.getDescripcion());
			ps.setDouble(3, o.getPrecio());
			ps.setInt(4, o.getCantidad());
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
	 * Funcion para modificar el objeto, nos devolvera true en el caso en el que se
	 * haya realizado con exito, pasamos por parametro el objeto Objetos del que
	 * queremos obtener los datos para ejecutar las Query
	 */

	public boolean updateObjeto(Objeto o) {

		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE objeto SET nombre=?, descripcion=?, precio=?, cantidad=? WHERE objetoID=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, o.getNombre());
			ps.setString(2, o.getDescripcion());
			ps.setDouble(3, o.getPrecio());
			ps.setInt(4, o.getCantidad());
			ps.setInt(5, o.getObjetosID());
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
	 * Funcion para borrar el objeto, nos devolvera true en el caso en el que se
	 * haya realizado con exito, pasamos por parametro el objeto Objetos del que
	 * queremos obtener los datos para ejecutar las Query
	 */

	public boolean deleteObjeto(Objeto o) {

		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "DELETE FROM objeto WHERE objetoID=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, String.valueOf(o.getObjetosID()));
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
	 * Funcion para buscar el objeto, nos devolvera true en el caso en el que se
	 * haya realizado con exito, pasamos por parametro el objeto Objetos del que
	 * queremos obtener los datos para ejecutar las Query utilizaremos la clase
	 * ArrayList ya que las busquedas las realizaremos por nombre y pueden haber
	 * varios elementos con el mismo valor, en el caso de no introducir la marca
	 * mostrará todo el contenido
	 */

	public ArrayList<Objeto> searchObjeto(Objeto o) {

		ArrayList<Objeto> arrayObjetos = new ArrayList<Objeto>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		String sql;

		if (o.getNombre().isEmpty()) {
			sql = "SELECT * FROM objeto";
		} else {
			sql = "SELECT * FROM objeto WHERE nombre=?";

		}

		Objeto obj;

		try {
			ps = con.prepareStatement(sql);
			if (!o.getNombre().isEmpty()) {
				ps.setString(1, o.getNombre());
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				obj = new Objeto(Integer.parseInt(rs.getString("objetoID")), rs.getString("Nombre"),
						rs.getString("Descripcion"), Double.parseDouble(rs.getString("Precio")),
						Integer.parseInt(rs.getString("Cantidad")));
				arrayObjetos.add(obj);

			}
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		return arrayObjetos;

	}

}