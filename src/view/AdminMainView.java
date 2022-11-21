package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
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
		btnAdminEstacionamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BlocoCreateView blocoCreateView = new BlocoCreateView();
				blocoCreateView.setVisible(true);
				SwingUtilities.windowForComponent(btnAdminEstacionamento).dispose();
				
			}
		});
		btnAdminEstacionamento.setBounds(132, 491, 176, 23);
		frame.getContentPane().add(btnAdminEstacionamento);
		
		JButton btnAdminUsuarios = new JButton("Gerenciar Usuarios");
		btnAdminUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		

				UsuarioCreateView usuCadView = new UsuarioCreateView();
				usuCadView.setVisible(true);
				SwingUtilities.windowForComponent(btnAdminEstacionamento).dispose();				
				
			}
		});
		btnAdminUsuarios.setBounds(480, 491, 176, 23);
		frame.getContentPane().add(btnAdminUsuarios);
	}
}