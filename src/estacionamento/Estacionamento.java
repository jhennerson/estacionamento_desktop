package estacionamento;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
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
	//private JFrame frame2;
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

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkLogin(loginField.getText(), new String(passwordField.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Logado com sucesso!", "Success", JOptionPane.NO_OPTION);
					
					
					if(loginField.getText().equals("admin")) {
					SwingUtilities.windowForComponent(btnNewButton).dispose();
					//Segunda tela do administrador
					JFrame frame2 = new JFrame(); 
					frame2.setVisible(true);
					frame2.setBounds(100, 100, 450, 300);
					frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame2.getContentPane().setLayout(null);
					
					JButton btnCadastrar = new JButton("Cadastrar Usuário");
					btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
					btnCadastrar.setBounds(48, 104, 157, 23);
					frame2.getContentPane().add(btnCadastrar);
					
					btnCadastrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//Tela de cadastro de novo usuário
							SwingUtilities.windowForComponent(btnCadastrar).dispose();
							JFrame frame3 = new JFrame(); 
							frame3.setVisible(true);
							frame3.setBounds(100, 100, 450, 300);
							frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							frame3.getContentPane().setLayout(null);
							
							Label label = new Label("Cadastrar Novo Usuário");
							label.setFont(new Font("Dialog", Font.PLAIN, 20));
							label.setBounds(105, 55, 241, 22);
							frame3.getContentPane().add(label);
							
							Label label_1 = new Label("Usuário:");
							label_1.setFont(new Font("Dialog", Font.PLAIN, 15));
							label_1.setBounds(66, 97, 62, 22);
							frame3.getContentPane().add(label_1);
							
							TextField textField = new TextField();
							textField.setBounds(134, 97, 184, 22);
							frame3.getContentPane().add(textField);
							
							Label label_2 = new Label("Senha:");
							label_2.setFont(new Font("Dialog", Font.PLAIN, 15));
							label_2.setBounds(66, 138, 62, 22);
							frame3.getContentPane().add(label_2);
							
							passwordField = new JPasswordField();
							passwordField.setBounds(134, 140, 184, 20);
							frame3.getContentPane().add(passwordField);
							
							Button button = new Button("Cadastrar");
							button.setFont(new Font("Dialog", Font.PLAIN, 15));
							button.setBounds(66, 185, 84, 22);
							frame3.getContentPane().add(button);
							
							Button button_1 = new Button("Deletar");
							button_1.setFont(new Font("Dialog", Font.PLAIN, 15));
							button_1.setBounds(167, 185, 84, 22);
							frame3.getContentPane().add(button_1);
							
							Button button_2 = new Button("Atualizar");
							button_2.setFont(new Font("Dialog", Font.PLAIN, 15));
							button_2.setBounds(270, 185, 70, 22);
							frame3.getContentPane().add(button_2);
						}
					});
					
					JButton btnEstacionamento = new JButton("Estacionamento");
					btnEstacionamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
					btnEstacionamento.setBounds(225, 104, 142, 23);
					frame2.getContentPane().add(btnEstacionamento);
					}
					
					if(!loginField.getText().equals("admin")) {
						
						SwingUtilities.windowForComponent(btnNewButton).dispose();
						JFrame frame4 = new JFrame(); 
						frame4.setBounds(100, 100, 450, 300);
						frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame4.getContentPane().setLayout(null);
						frame4.setVisible(true);
						
						JButton btnEstacionamento = new JButton("Estacionamento");
						btnEstacionamento.setFont(new Font("Tahoma", Font.PLAIN, 20));
						btnEstacionamento.setBounds(122, 108, 186, 33);
						frame4.getContentPane().add(btnEstacionamento);
						
					}
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Login ou senha inválido!", "Ops", JOptionPane.ERROR_MESSAGE);
				}
				
				 
					
				
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton.setBounds(165, 179, 95, 22);
		frame.getContentPane().add(btnNewButton);
	}
	
	public boolean checkLogin(String login, String password) {
		return login.equals("admin") && password.equals("admin") ||login.equals("usu1") &&password.equals("12345");
	}
	
}



