package estacionamento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import database.DBConnection;
import database.DBQuery;

public class Estacionamento {

	private JFrame frame;
	private JTextField loginField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estacionamento window = new Estacionamento();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Estacionamento() {
		initialize();
		//DBConnection conexao = new DBConnection();
		String[] fields = new String[]{"1", "usuario", "senha"};
		DBQuery query = new DBQuery("usuarios","id,usuario,senha","1");
		query.insert(fields);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		loginField = new JTextField();
		loginField.setBounds(198, 78, 86, 20);
		frame.getContentPane().add(loginField);
		loginField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setBounds(144, 81, 44, 14);
		frame.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(198, 109, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(152, 112, 36, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkLogin(loginField.getText(), new String(passwordField.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Logado com sucesso!", "Success", JOptionPane.NO_OPTION);
				} else {
					JOptionPane.showMessageDialog(null, "Login ou senha inválido!", "Ops", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(175, 140, 91, 45);
		frame.getContentPane().add(btnNewButton);
	}
	
	public boolean checkLogin(String login, String password) {
		return login.equals("admin") && password.equals("admin");
	}
}
