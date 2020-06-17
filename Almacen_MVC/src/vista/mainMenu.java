package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class mainMenu extends JFrame {

	public JPanel contentPane;
	public JButton btnCoche;
	public JButton btnObjetos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenu frame = new mainMenu();
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
	public mainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCoche = new JButton("Coches");
		btnCoche.setBounds(59, 91, 143, 68);
		contentPane.add(btnCoche);

		btnObjetos = new JButton("Objetos");
		btnObjetos.setBounds(228, 91, 143, 68);
		contentPane.add(btnObjetos);
	}

}
