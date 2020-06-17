package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import main.Main;
import vista.mainMenu;

//Controlador del menu principal

public class MenuC implements ActionListener {

	// Utilizaremos la vista del menu principal y la clase MenuGeneral para
	// controlar la navegacion

	private mainMenu view;
	private Main mg;

	// Asignaremos eventos de accion en el constructor a los botones para cargar la
	// vista que necesitemos

	public MenuC(mainMenu view) {

		this.view = view;
		this.view.btnCoche.addActionListener(this);
		this.view.btnObjetos.addActionListener(this);

	}

	public void start() {
		view.setTitle("PROYECTO ALEX");
		view.setLocationRelativeTo(null);

	}

	// Funciones para programar el funcionamiento de las acciones en relacion con
	// los botones de la vista

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// Boton coche, que cargara el menu de operaciones de coches

		if (e.getSource() == view.btnCoche) {
			mg = new Main();
			view.dispose();
			mg.showMenuCoche();

		}

		// Boton objetos, que cargara el menu de operaciones de objetos

		if (e.getSource() == view.btnObjetos) {
			mg = new Main();
			view.dispose();
			mg.showMenuObjeto();

		}

	}

}
