package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainView {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tela Principal Operador");
		lblNewLabel.setBounds(151, 59, 111, 14);
		frame.getContentPane().add(lblNewLabel);		
	}
	
	public void setVisible(boolean b) {
		this.frame.setVisible(b);
	}
}
