package Beans;

import java.io.Serializable;

public class Objeto implements Serializable{

	// Atributos de la clase

	private int objetosID;
	private String nombre;
	private String descripcion;
	private double precio;
	private int cantidad;

	// Constructor por defecto

	public Objeto() {
	}

	// Constructor parametrizado
	
	public Objeto(int objetosID, String nombre, String descripcion, double precio, int cantidad) {
		this.objetosID = objetosID;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	// Getters y Setters

	public int getObjetosID() {
		return objetosID;
	}

	public void setObjetosID(int objetosID) {
		this.objetosID = objetosID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
