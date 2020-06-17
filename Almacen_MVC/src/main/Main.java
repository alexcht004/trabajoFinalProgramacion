package main;

import Beans.Coche;
import Beans.Objeto;
import controlador.CocheC;
import controlador.MenuC;
import controlador.ObjetoC;
import modelo.Coches;
import modelo.Objetos;
import vista.frmCoche;
import vista.frmObjeto;
import vista.mainMenu;

//Clase para ejecutar la navegacion entre menus y la ejecucion principal del proyecto


public class Main {

	// Declaramos e instanciamos los modelos, vistas y CRUD de cada elemento del
	// proyecto

	static mainMenu view = new mainMenu();

	Coche modCoche = new Coche();
	Coches cochesConsulting = new Coches();
	static frmCoche viewCoche = new frmCoche();

	Objeto modObjetos = new Objeto();
	Objetos objetosConsulting = new Objetos();
	static frmObjeto viewObjetos = new frmObjeto();

	// Ejecucion principal del proyecto

	public static void main(String[] args) {

		MenuC mc = new MenuC(view);
		mc.start();
		view.setVisible(true);

	}

	// Menu principal

	public void showMenu() {
		MenuC mc = new MenuC(view);
		mc.start();
		view.setVisible(true);

	}

	// Menu coche

	public void showMenuCoche() {
		CocheC cc = new CocheC(modCoche, cochesConsulting, viewCoche);
		cc.start();
		viewCoche.setVisible(true);

	}

	// Menu Objeto

	public void showMenuObjeto() {
		ObjetoC oc = new ObjetoC(modObjetos, objetosConsulting, viewObjetos);
		oc.start();
		viewObjetos.setVisible(true);

	}

}
