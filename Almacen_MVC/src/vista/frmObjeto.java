package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class frmObjeto extends JFrame {

	public JPanel contentPane;
	public JTextField textNombre;
	public JTextField textDescripcion;
	public JTextField textPrecio;
	public JTextField textCantidad;
	public JTextField textID;
	public JTable objetosTable;
	public JButton btnAdd;
	public JButton btnDelete;
	public JButton btnUpdate;
	public JButton btnExit;
	public JButton btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmObjeto frame = new frmObjeto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmObjeto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 51, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		lblNewLabel_1.setBounds(10, 76, 72, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(10, 101, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Cantidad");
		lblNewLabel_3.setBounds(10, 126, 46, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("MENU DE OPERACIONES DE OBJETOS");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 11, 414, 33);
		contentPane.add(lblNewLabel_4);

		textNombre = new JTextField();
		textNombre.setBounds(81, 48, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textDescripcion = new JTextField();
		textDescripcion.setBounds(81, 73, 86, 20);
		contentPane.add(textDescripcion);
		textDescripcion.setColumns(10);

		textPrecio = new JTextField();
		textPrecio.setBounds(81, 98, 86, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);

		textCantidad = new JTextField();
		textCantidad.setBounds(81, 123, 86, 20);
		contentPane.add(textCantidad);
		textCantidad.setColumns(10);

		btnAdd = new JButton("A\u00F1adir");
		btnAdd.setBounds(38, 151, 89, 23);
		contentPane.add(btnAdd);

		btnDelete = new JButton("Eliminar");
		btnDelete.setBounds(137, 151, 89, 23);
		contentPane.add(btnDelete);

		btnUpdate = new JButton("Modificar");
		btnUpdate.setBounds(236, 151, 89, 23);
		contentPane.add(btnUpdate);

		btnExit = new JButton("Salir");
		btnExit.setBounds(335, 151, 89, 23);
		contentPane.add(btnExit);

		btnSearch = new JButton("Buscar");
		btnSearch.setBounds(194, 47, 89, 23);
		contentPane.add(btnSearch);

		textID = new JTextField();
		textID.setBounds(194, 73, 89, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		/*objetosTable = new JTable();
		objetosTable.setBounds(24, 198, 436, 257);
		contentPane.add(objetosTable);*/
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 209, 457, 254);
		contentPane.add(scrollPane);
		
		objetosTable = new JTable();
		objetosTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Descripcion", "Precio", "Cantidad"
			}
		));
		scrollPane.setViewportView(objetosTable);
	}
}
