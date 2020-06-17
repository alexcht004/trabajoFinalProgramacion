package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmCoche extends JFrame {

	public JPanel contentPane;
	public JTextField textMarca;
	public JTextField textModelo;
	public JTextField textPrecio;
	public JTextField textCantidad;
	public JTextField textID;
	public JButton btnAdd;
	public JButton btnUpdate;
	public JButton btnDelete;
	public JButton btnExit;
	public JButton btnSearch;
	public JTable cochesTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCoche frame = new frmCoche();
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
	public frmCoche() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Marca");
		lblNewLabel.setBounds(10, 59, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 84, 46, 14);
		contentPane.add(lblModelo);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 109, 46, 14);
		contentPane.add(lblPrecio);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 134, 46, 14);
		contentPane.add(lblCantidad);

		textMarca = new JTextField();
		textMarca.setBounds(78, 56, 86, 20);
		contentPane.add(textMarca);
		textMarca.setColumns(10);

		textModelo = new JTextField();
		textModelo.setColumns(10);
		textModelo.setBounds(78, 81, 86, 20);
		contentPane.add(textModelo);

		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(78, 106, 86, 20);
		contentPane.add(textPrecio);

		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		textCantidad.setBounds(78, 131, 86, 20);
		contentPane.add(textCantidad);

		btnAdd = new JButton("A\u00F1adir");
		btnAdd.setBounds(20, 162, 89, 23);
		contentPane.add(btnAdd);

		btnUpdate = new JButton("Modificar");
		btnUpdate.setBounds(119, 162, 89, 23);
		contentPane.add(btnUpdate);

		btnDelete = new JButton("Eliminar");
		btnDelete.setBounds(218, 162, 89, 23);
		contentPane.add(btnDelete);

		btnExit = new JButton("Salir");
		btnExit.setBounds(335, 162, 89, 23);
		contentPane.add(btnExit);

		JLabel lblNewLabel_1 = new JLabel("MENU DE OPERACIONES DE COCHES");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 393, 37);
		contentPane.add(lblNewLabel_1);

		btnSearch = new JButton("Buscar");
		btnSearch.setBounds(218, 55, 89, 23);
		contentPane.add(btnSearch);

		textID = new JTextField();
		textID.setBounds(218, 81, 89, 20);
		contentPane.add(textID);
		textID.setColumns(10);

		/*cochesTable = new JTable();
		cochesTable.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] {

		}));
		cochesTable.setBounds(20, 233, 492, 244);
		contentPane.add(cochesTable);*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 209, 457, 254);
		contentPane.add(scrollPane);
		
		cochesTable = new JTable();
		cochesTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Modelo", "Marca", "Precio", "Cantidad"
			}
		));
		scrollPane.setViewportView(cochesTable);
		

	}
}