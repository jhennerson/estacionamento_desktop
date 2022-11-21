package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.UsuarioController;
import model.Operador;

public class LoginView {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
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

	public LoginView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(370, 224, 124, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(284, 225, 61, 14);
		frame.getContentPane().add(lblUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(370, 255, 124, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(284, 256, 61, 14);
		frame.getContentPane().add(lblSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Operador operador = new Operador();
					
					String nome = txtUsername.getText();
					String senha = String.valueOf(passwordField.getPassword());
					
					operador.setPassword(senha);
					operador.setUsername(nome);
					
					UsuarioController usuCtrl = new UsuarioController();
					ResultSet rsUsuarioCtrl = usuCtrl.read(operador);
					
					if(rsUsuarioCtrl.next()) {						
						if(rsUsuarioCtrl.getString("username").equalsIgnoreCase("admin")) {
							JOptionPane.showMessageDialog(null, "Seja bem vindo Administrador!", "Success", JOptionPane.NO_OPTION);
							SwingUtilities.windowForComponent(btnEntrar).dispose();
							AdminMainView admMainView = new AdminMainView();
							admMainView.setVisible(true);							
						} else {
							JOptionPane.showMessageDialog(null, "Logado com sucesso!", "Success", JOptionPane.NO_OPTION);
							SwingUtilities.windowForComponent(btnEntrar).dispose();
							MainView mainView = new MainView();
							mainView.setVisible(true);							
						}						
					} else {
						JOptionPane.showMessageDialog(null, "Login ou senha inválido!", "Ops", JOptionPane.ERROR_MESSAGE);
						txtUsername.setText("");
						passwordField.setText("");
					}					
					
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Login ou senha inválido!", "Ops", JOptionPane.ERROR_MESSAGE);
				}				
				
			}
		});
		btnEntrar.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnEntrar.setBounds(327, 341, 138, 38);
		frame.getContentPane().add(btnEntrar);
		
		lblNewLabel = new JLabel("Faça log-in para acessar o sistema");
		lblNewLabel.setFont(new Font("Unispace", Font.BOLD, 25));
		lblNewLabel.setBounds(130, 68, 510, 38);
		frame.getContentPane().add(lblNewLabel);
	}
}