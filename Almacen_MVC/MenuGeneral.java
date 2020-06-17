package projectExe;

import Beans.Coche;
import Beans.Objetos;
import Controller.CocheController;
import Controller.MenuController;
import Controller.ObjetoController;
import Model.CRUDCoches;
import Model.CRUDObjetos;
import View.frmCoche;
import View.frmObjeto;
import View.mainMenu;

//Clase para ejecutar la navegacion entre menus y la ejecucion principal del proyecto


public class MenuGeneral {

	// Declaramos e instanciamos los modelos, vistas y CRUD de cada elemento del
	// proyecto

	static mainMenu view = new mainMenu();

	Coche modCoche = new Coche();
	CRUDCoches cochesConsulting = new CRUDCoches();
	static frmCoche viewCoche = new frmCoche();

	Objetos modObjetos = new Objetos();
	CRUDObjetos objetosConsulting = new CRUDObjetos();
	static frmObjeto viewObjetos = new frmObjeto();

	// Ejecucion principal del proyecto

	public static void main(String[] args) {

		MenuController mc = new MenuController(view);
		mc.start();
		view.setVisible(true);

	}

	// Menu principal

	public void showMenu() {
		MenuController mc = new MenuController(view);
		mc.start();
		view.setVisible(true);

	}

	// Menu coche

	public void showMenuCoche() {
		CocheController cc = new CocheController(modCoche, cochesConsulting, viewCoche);
		cc.start();
		viewCoche.setVisible(true);

	}

	// Menu Objeto

	public void showMenuObjeto() {
		ObjetoController oc = new ObjetoController(modObjetos, objetosConsulting, viewObjetos);
		oc.start();
		viewObjetos.setVisible(true);

	}

}
