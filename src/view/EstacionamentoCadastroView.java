package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class EstacionamentoCadastroView {

	private JFrame frame;
	private JLabel lblTitulo;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstacionamentoCadastroView window = new EstacionamentoCadastroView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setVisible(boolean b) {
		this.frame.setVisible(b);
	}

	public EstacionamentoCadastroView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Cadastro de Áreas");
		lblTitulo.setFont(new Font("Unispace", Font.BOLD, 25));
		lblTitulo.setBounds(262, 33, 265, 49);
		frame.getContentPane().add(lblTitulo);
		
		textField = new JTextField();
		textField.setBounds(355, 140, 160, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}