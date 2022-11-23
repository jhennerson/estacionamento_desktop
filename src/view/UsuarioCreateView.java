package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.BlocoController;
import controller.UsuarioController;
import model.Operador;
import model.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class UsuarioCreateView {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private Usuario sessionUsuario;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioCreateView window = new UsuarioCreateView();
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

	public UsuarioCreateView(Usuario sessionUsuario) {
		this.sessionUsuario = sessionUsuario;
		initialize();
	}
	
	public UsuarioCreateView() {
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
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setBounds(335, 165, 184, 29);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(261, 166, 64, 28);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(261, 217, 64, 29);
		frame.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(335, 217, 184, 29);
		frame.getContentPane().add(passwordField);
		
		JLabel lblBloco = new JLabel("Bloco");
		lblBloco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBloco.setBounds(261, 276, 64, 25);
		frame.getContentPane().add(lblBloco);
		
		BlocoController blocosCtrl = new BlocoController();
		
		List<String> blocos = blocosCtrl.distinctList();
		
		String[] descricaoBlocos = blocos.toArray(String[] :: new);		
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBoxBloco = new JComboBox(descricaoBlocos);
		comboBoxBloco.setBounds(335, 272, 184, 29);
		frame.getContentPane().add(comboBoxBloco);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtUsername.getText();
				String senha = String.valueOf(passwordField.getPassword());
				String bloco = String.valueOf(comboBoxBloco.getSelectedItem());
				
				System.out.println(bloco);
				
				UsuarioController usuCtrl = new UsuarioController();
				Operador operadorUpdt = new Operador(nome, senha, bloco);
				
				try {
					usuCtrl.create(operadorUpdt);
					JOptionPane.showMessageDialog(null, "Operador cadastrado com sucesso!", "Success", JOptionPane.NO_OPTION);
					SwingUtilities.windowForComponent(btnCadastrar).dispose();
					AdminMainView admMainView = new AdminMainView(sessionUsuario);
					admMainView.setVisible(true);					
				} catch(Exception err) {
					err.printStackTrace();
				}
			}
		});
		
		btnCadastrar.setBounds(166, 427, 157, 48);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SwingUtilities.windowForComponent(btnCancelar).dispose();
					UsuarioView usuarioView = new UsuarioView(sessionUsuario);
					usuarioView.setVisible(true);
				} catch(Exception err) {
					err.printStackTrace();
				}
			}
		});
		
		btnCancelar.setBounds(459, 427, 157, 48);
		frame.getContentPane().add(btnCancelar);		
	}
}