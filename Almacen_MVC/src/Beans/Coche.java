package Beans;

import java.io.Serializable;

public class Coche implements Serializable{

	// Atributos de la clase

	private int cocheID;
	private String marca;
	private String modelo;
	private double precio;
	private int cantidad;

	// Constructor por defecto
	public Coche() {

	}

	// Constructor parametrizado
	
	public Coche(int cocheID, String marca, String modelo, double precio, int cantidad) {
		this.cocheID = cocheID;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	// Getters y Setters
	public int getCocheID() {
		return cocheID;
	}

	public void setCocheID(int cocheID) {
		this.cocheID = cocheID;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
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
