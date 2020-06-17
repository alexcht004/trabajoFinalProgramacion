package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Beans.Objeto;
import main.Main;
import modelo.Objetos;
import vista.frmObjeto;

/* Controlador de la clase objeto, utilizado para implementar los eventos de accion de formulario y comunicar la estructura MVC
 * referidos a la clase Objetos
 */

public class ObjetoC implements ActionListener {

	// Declaraciones de los atributos del controlador, en este caso declararemos el
	// modelo, el CRUD y la vista.

	private Objeto model;
	private Objetos modelConsulting;
	private frmObjeto view;

	/*
	 * Constructor de la clase teniendo como argumentos del parametro el modelo, la
	 * vista y el CRUD, en este mismo constructor añadiremos los eventos a los
	 * botones de la vista
	 */

	public ObjetoC(Objeto model, Objetos modelConsulting, frmObjeto view) {
		this.model = model;
		this.modelConsulting = modelConsulting;
		this.view = view;
		this.view.btnAdd.addActionListener(this);
		this.view.btnUpdate.addActionListener(this);
		this.view.btnDelete.addActionListener(this);
		this.view.btnExit.addActionListener(this);
		this.view.btnSearch.addActionListener(this);
	}

	// Funcion para pequeñas modificaciones de la vista

	public void start() {
		view.setTitle("PROYECTO ALEX");
		view.setLocationRelativeTo(null);

	}

	// Funciones para programar el funcionamiento de las acciones en relacion con
	// los botones de la vista

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		/*
		 * Boton añadir, obtendremos las variables de los textField y realizaremos
		 * operaciones para controlar ciertos fallos que pueden producirse,
		 * modificaremos los atributos del modelo para realizar la llamada al CRUD con
		 * el objeto del modelo esta estrategia la seguiremos en el resto de botones.
		 */

		if (e.getSource() == view.btnAdd) {
			String aux;
			aux = view.textPrecio.getText();
			model.setNombre(view.textNombre.getText());
			model.setDescripcion(view.textDescripcion.getText());
			if (view.textPrecio.getText().contains(",")) {
				aux = view.textPrecio.getText().replace(",", ".");
			}

			model.setPrecio(Double.parseDouble(aux));
			model.setCantidad(Integer.parseInt(view.textCantidad.getText()));
			if (modelConsulting.addObjeto(model)) {
				JOptionPane.showMessageDialog(null, "Registro correctamente añadido");
				clean();
			} else {
				JOptionPane.showMessageDialog(null, "Se ha producido un error al añadir");
				clean();
			}
		}

		// Boton borrar

		if (e.getSource() == view.btnDelete) {
			model.setObjetosID(Integer.parseInt(view.textID.getText()));

			if (modelConsulting.deleteObjeto(model)) {
				JOptionPane.showMessageDialog(null, "Registro correctamente eliminado");
				clean();
			} else {
				JOptionPane.showMessageDialog(null, "Se ha producido un error al eliminar");
				clean();
			}
		}

		// Boton modificar

		if (e.getSource() == view.btnUpdate) {
			model.setNombre(view.textNombre.getText());
			model.setDescripcion(view.textDescripcion.getText());
			model.setPrecio(Double.parseDouble(view.textPrecio.getText()));
			model.setCantidad(Integer.parseInt(view.textCantidad.getText()));
			model.setObjetosID(Integer.parseInt(view.textID.getText()));
			if (modelConsulting.updateObjeto(model)) {
				JOptionPane.showMessageDialog(null, "Registro correctamente editado");
				clean();
			} else {
				JOptionPane.showMessageDialog(null, "Se ha producido un error al editar");
				clean();
			}
		}

		/*
		 * Boton buscar, para evitar la duplicacion de tablas primeramente debemos de
		 * limpiar la tabla existente y posteriormente programamos la funcionalidad para
		 * cargar la tabla, recurriremos a la clase DefaultTableModel para ello
		 */

		if (e.getSource() == view.btnSearch) {
			model.setNombre(view.textNombre.getText());

			ArrayList<Objeto> array = modelConsulting.searchObjeto(model);
			view.objetosTable.setModel(
					new DefaultTableModel(null, new String[] { "ID", "Nombre", "Descripcion", "Precio", "Cantidad" }));
			DefaultTableModel tableAux = (DefaultTableModel) view.objetosTable.getModel();

			// Instrucciones para almacenar los datos necesarios en filas y posteriormente
			// realizar la asignacion

			Object[] row = new Object[5];
			for (int i = 0; i < array.size(); i++) {
				row[0] = array.get(i).getObjetosID();
				row[1] = array.get(i).getNombre();
				row[2] = array.get(i).getDescripcion();
				row[3] = array.get(i).getPrecio();
				row[4] = array.get(i).getCantidad();
				tableAux.addRow(row);
			}

			view.objetosTable.setModel(tableAux);
			

		}

		// Boton salir, utilizado para navegar entre menus

		if (e.getSource() == view.btnExit) {
			view.dispose();
			Main em = new Main();
			em.showMenu();

		}

	}

	// Posible funcion para limpiar los campos de textField y asi tener un manejo
	// mas comodo

	public void clean() {
		view.textID.setText(null);
		view.textNombre.setText(null);
		view.textDescripcion.setText(null);
		view.textPrecio.setText(null);
		view.textCantidad.setText(null);

	}

}