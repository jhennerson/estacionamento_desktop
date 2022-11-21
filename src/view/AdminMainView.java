package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMainView {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainView window = new AdminMainView();
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

	public AdminMainView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Parkinson Admin Mode");
		lblTitle.setFont(new Font("Unispace", Font.BOLD, 25));
		lblTitle.setBounds(237, 28, 315, 31);
		frame.getContentPane().add(lblTitle);
		
		JButton btnAdminEstacionamento = new JButton("Gerenciar Estacionamento");
		btnAdminEstacionamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdminEstacionamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.windowForComponent(btnAdminEstacionamento).dispose();
				BlocoView blocoView = new BlocoView();
				blocoView.setVisible(true);								
			}
		});
		
		btnAdminEstacionamento.setBounds(132, 491, 195, 42);
		frame.getContentPane().add(btnAdminEstacionamento);
		
		JButton btnAdminUsuarios = new JButton("Gerenciar Usuarios");
		btnAdminUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdminUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.windowForComponent(btnAdminEstacionamento).dispose();
				UsuarioView usuarioView = new UsuarioView();
				usuarioView.setVisible(true);				
			}
		});
		
		btnAdminUsuarios.setBounds(461, 491, 195, 42);
		frame.getContentPane().add(btnAdminUsuarios);
	}
}