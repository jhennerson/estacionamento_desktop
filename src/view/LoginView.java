package view;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
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

import dao.UsuarioDAO;
import model.Usuario;

public class LoginView {

	private JFrame frame;
	private JTextField loginField;
	private JPasswordField passwordField;

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

	public LoginView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		loginField = new JTextField();
		loginField.setBounds(198, 102, 124, 20);
		frame.getContentPane().add(loginField);
		loginField.setColumns(10);
		
		Label label2 = new Label("Bem-vindo(a) ao Sistema Estacione Aqui");
		label2.setFont(new Font("Dialog", Font.PLAIN, 20));
		label2.setBounds(27, 46, 375, 22);
		frame.getContentPane().add(label2);
		
		JLabel lblNewLabel = new JLabel("Usuário:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(112, 103, 61, 14);
		frame.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(198, 133, 124, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(112, 134, 61, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Usuario usuario = new Usuario();
					usuario.setPassword(passwordField.getPassword().toString());
					usuario.setUsername(loginField.getText());
					
					UsuarioDAO usuarioDao = new UsuarioDAO();
					ResultSet rsUsuarioDao = usuarioDao.check(usuario);
					
					if(rsUsuarioDao.next()) {
						JOptionPane.showMessageDialog(null, "Logado com sucesso!", "Success", JOptionPane.NO_OPTION);
						MainView mainView = new MainView();						
						mainView.setVisible(true);						
						SwingUtilities.windowForComponent(btnEntrar).dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Login ou senha inválido!", "Ops", JOptionPane.ERROR_MESSAGE);
					}
					
					
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Login ou senha inválido!", "Ops", JOptionPane.ERROR_MESSAGE);
				}
				
				
								
				
				if(checkLogin(loginField.getText(), new String(passwordField.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Logado com sucesso!", "Success", JOptionPane.NO_OPTION);
					
					
					
					
				}
				
				else {
					
				}					
				
			}
		});
		btnEntrar.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnEntrar.setBounds(165, 179, 95, 22);
		frame.getContentPane().add(btnEntrar);
	}
	
	public boolean checkLogin(String login, String password) {
		return login.equals("admin") && password.equals("admin") ||login.equals("usu1") &&password.equals("12345");
	}

	public void setVisible(boolean b) {
		this.frame.setVisible(b);
	}
}
