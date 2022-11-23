package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import model.Usuario;

public class OperadorMainView {

	private JFrame frame;
	private JButton btnSair;
	private Usuario sessionUsuario;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperadorMainView window = new OperadorMainView();
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
	
	public OperadorMainView(Usuario sessionUsuario) {
		this.sessionUsuario = sessionUsuario;
		initialize();
	}
	
	public OperadorMainView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Parkinson Control Center");
		lblTitle.setFont(new Font("Unispace", Font.BOLD, 25));
		lblTitle.setBounds(205, 28, 366, 31);
		frame.getContentPane().add(lblTitle);
		
		JButton btnAdminBlocos = new JButton("Gerenciar Blocos");
		btnAdminBlocos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdminBlocos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.windowForComponent(btnAdminBlocos).dispose();
				BlocoView blocoView = new BlocoView(sessionUsuario);
				blocoView.setVisible(true);								
			}
		});
		
		btnAdminBlocos.setBounds(237, 220, 315, 67);
		frame.getContentPane().add(btnAdminBlocos);
		
		JButton btnAdminVagas = new JButton("Gerenciar Vagas");
		btnAdminVagas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.windowForComponent(btnAdminBlocos).dispose();
				VagaView vagasView = new VagaView(sessionUsuario);
				vagasView.setVisible(true);
			}
		});
		btnAdminVagas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdminVagas.setBounds(237, 142, 315, 67);
		frame.getContentPane().add(btnAdminVagas);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SwingUtilities.windowForComponent(btnSair).dispose();
					LoginView loginView = new LoginView();
					loginView.setVisible(true);
				} catch(Exception err) {
					err.printStackTrace();
				}				
			}
		});
		
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.setBounds(615, 519, 159, 31);
		frame.getContentPane().add(btnSair);
	}

}
