package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.UsuarioController;
import model.Operador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;

public class UsuarioCadastroView {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioCadastroView window = new UsuarioCadastroView();
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

	public UsuarioCadastroView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Cadastro de Operadores");
		lblTitulo.setFont(new Font("Unispace", Font.BOLD, 25));
		lblTitulo.setBounds(229, 49, 330, 38);
		frame.getContentPane().add(lblTitulo);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(335, 165, 184, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(261, 166, 64, 17);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(261, 206, 64, 17);
		frame.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(335, 205, 184, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblArea = new JLabel("Área");
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArea.setBounds(261, 249, 64, 17);
		frame.getContentPane().add(lblArea);
		
		JSpinner areaSpinner = new JSpinner();
		areaSpinner.setBounds(335, 248, 85, 20);
		frame.getContentPane().add(areaSpinner);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Operador operador = new Operador();
				
				String nome = txtUsername.getText();
				String senha = String.valueOf(passwordField.getPassword());
				Integer bloco = Integer.valueOf(areaSpinner.getValue().toString());
				
				operador.setPassword(senha);
				operador.setUsername(nome);
				operador.setBloco(bloco);
				
				UsuarioController usuCtrl = new UsuarioController();
				usuCtrl.create(operador);
				
				JOptionPane.showMessageDialog(null, "Operador cadastrado com sucesso!", "Success", JOptionPane.NO_OPTION);
				
				txtUsername.setText("");
				passwordField.setText("");
				AdminMainView admMainView = new AdminMainView();
				admMainView.setVisible(true);
				SwingUtilities.windowForComponent(btnCadastrar).dispose();
			}
		});
		btnCadastrar.setBounds(212, 427, 117, 23);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
				txtUsername.setText("");
				passwordField.setText("");
				AdminMainView admMainView = new AdminMainView();
				admMainView.setVisible(true);
				SwingUtilities.windowForComponent(btnCadastrar).dispose();

			}
		});
		btnCancelar.setBounds(472, 427, 117, 23);
		frame.getContentPane().add(btnCancelar);
		
	}
}