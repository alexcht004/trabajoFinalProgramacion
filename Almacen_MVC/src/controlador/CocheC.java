package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Beans.Coche;
import main.Main;
import modelo.Coches;
import vista.frmCoche;

/* Controlador de la clase coche, utilizado para implementar los eventos de accion de formulario y comunicar la estructura MVC
 * referidos a la clase Coche
 */

public class CocheC implements ActionListener {

	// Declaraciones de los atributos del controlador, en este caso declararemos el
	// modelo, el CRUD y la vista.

	private Coche model;//////////////////////////////////////// coche model que es el beans??
	private Coches modelConsulting;
	private frmCoche view;

	/*
	 * Constructor de la clase teniendo como argumentos del parametro el modelo, la
	 * vista y el CRUD, en este mismo constructor añadiremos los eventos a los
	 * botones de la vista
	 */

	public CocheC(Coche model, Coches modelConsulting, frmCoche view) {
		this.model = model;
		this.modelConsulting = modelConsulting;
		this.view = view;
		
		
		this.view.btnAdd.addActionListener(this);/////////////////
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

			boolean success = true;

			if (view.textMarca.getText().isEmpty() || view.textPrecio.getText().isEmpty()
					|| view.textModelo.getText().isEmpty() || view.textCantidad.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Alguno de los registros esta vacio.");
				success = false;
				clean();

			}

			if (success) {
				String aux;
				aux = view.textPrecio.getText();
				model.setMarca(view.textMarca.getText());
				model.setModelo(view.textModelo.getText());

				if (view.textPrecio.getText().contains(",")) {
					aux = view.textPrecio.getText().replace(",", ".");
				}

				model.setPrecio(Double.parseDouble(aux));
				model.setCantidad(Integer.parseInt(view.textCantidad.getText()));

				if (modelConsulting.addCoche(model)) {
					JOptionPane.showMessageDialog(null, "Registro correctamente añadido");
					clean();
				} else {
					JOptionPane.showMessageDialog(null, "Se ha producido un error al añadir");
					clean();
				}

			}
		}

		// Boton borrar

		if (e.getSource() == view.btnDelete) {
			model.setCocheID(Integer.parseInt(view.textID.getText()));

			if (modelConsulting.deleteCoche(model)) {
				JOptionPane.showMessageDialog(null, "Registro correctamente eliminado");
				clean();
			} else {
				JOptionPane.showMessageDialog(null, "Se ha producido un error al eliminar");
				clean();
			}
		}

		// Boton modificar

		if (e.getSource() == view.btnUpdate) {
			model.setMarca(view.textMarca.getText());
			model.setModelo(view.textModelo.getText());
			model.setPrecio(Double.parseDouble(view.textPrecio.getText()));
			model.setCantidad(Integer.parseInt(view.textCantidad.getText()));
			model.setCocheID(Integer.parseInt(view.textID.getText()));
			if (modelConsulting.updateCoche(model)) {
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

			view.cochesTable.setModel(
					new DefaultTableModel(null, new String[] { "ID", "Modelo", "Marca", "Precio", "Cantidad" }));

			model.setMarca(view.textMarca.getText());

			ArrayList<Coche> array = modelConsulting.searchCoche(model);
			DefaultTableModel tableAux = (DefaultTableModel) view.cochesTable.getModel();

			// Instrucciones para almacenar los datos necesarios en filas y posteriormente
			// realizar la asignacion

			Object[] row = new Object[5];
			for (int i = 0; i < array.size(); i++) {
				row[0] = array.get(i).getCocheID();
				row[1] = array.get(i).getMarca();
				row[2] = array.get(i).getModelo();
				row[3] = array.get(i).getPrecio();
				row[4] = array.get(i).getCantidad();
				tableAux.addRow(row);
			}

			view.cochesTable.setModel(tableAux);
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
		view.textMarca.setText(null);
		view.textModelo.setText(null);
		view.textPrecio.setText(null);
		view.textCantidad.setText(null);

	}

}
