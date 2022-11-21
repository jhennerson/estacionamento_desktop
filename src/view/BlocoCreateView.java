package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import controller.BlocoController;
import controller.UsuarioController;
import model.Bloco;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class BlocoCreateView {

	private JFrame frame;
	private JTextField txtDescricao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlocoCreateView window = new BlocoCreateView();
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

	public BlocoCreateView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Cadastro de Blocos");
		lblTitulo.setFont(new Font("Unispace", Font.BOLD, 25));
		lblTitulo.setBounds(265, 26, 277, 47);
		frame.getContentPane().add(lblTitulo);
		
		txtDescricao = new JTextField();
		txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescricao.setBounds(353, 132, 211, 33);
		frame.getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JSpinner spinnerVagasCarros = new JSpinner();
		spinnerVagasCarros.setModel(new SpinnerNumberModel(1, 1, 50, 1));
		spinnerVagasCarros.setBounds(353, 220, 211, 33);
		frame.getContentPane().add(spinnerVagasCarros);
		
		JSpinner spinnerVagasMotos = new JSpinner();
		spinnerVagasMotos.setModel(new SpinnerNumberModel(1, 1, 50, 1));
		spinnerVagasMotos.setBounds(353, 264, 211, 33);
		frame.getContentPane().add(spinnerVagasMotos);
		
		JSpinner spinnerVagasDeficientes = new JSpinner();
		spinnerVagasDeficientes.setModel(new SpinnerNumberModel(1, 1, 50, 1));
		spinnerVagasDeficientes.setBounds(353, 308, 211, 33);
		frame.getContentPane().add(spinnerVagasDeficientes);
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(196, 140, 127, 17);
		frame.getContentPane().add(lblDescricao);
		
		JLabel lblOperador = new JLabel("Operador");
		lblOperador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOperador.setBounds(196, 182, 127, 20);
		frame.getContentPane().add(lblOperador);
		
		JLabel lblVagasCarros = new JLabel("Vagas para carros");
		lblVagasCarros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVagasCarros.setBounds(196, 226, 154, 17);
		frame.getContentPane().add(lblVagasCarros);
		
		JLabel lblVagasMotos = new JLabel("Vagas para motos");
		lblVagasMotos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVagasMotos.setBounds(196, 270, 127, 17);
		frame.getContentPane().add(lblVagasMotos);
		
		JLabel lblVagasDeficientes = new JLabel("Vagas para deficientes");
		lblVagasDeficientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVagasDeficientes.setBounds(196, 314, 147, 17);
		frame.getContentPane().add(lblVagasDeficientes);
		
		UsuarioController usuarioCtrl = new UsuarioController();
		
		List<String> operadores = usuarioCtrl.distinctList();
		
		String[] nomes = operadores.toArray(String[] :: new);		
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBoxOperador = new JComboBox(nomes);
		comboBoxOperador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxOperador.setBounds(353, 176, 211, 33);
		frame.getContentPane().add(comboBoxOperador);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Bloco bloco = new Bloco();
				BlocoController blocoCtrl = new BlocoController();
				
				String descricao = txtDescricao.getText();
				String operador = String.valueOf(comboBoxOperador.getSelectedItem());
				Integer vagasCarros = (int)spinnerVagasCarros.getValue();
				Integer vagasMotos = (int)spinnerVagasMotos.getValue();
				Integer vagasDeficientes = (int)spinnerVagasDeficientes.getValue();
				
				bloco.setDescricao(descricao);
				bloco.setOperador(operador);
				bloco.setVagasCarros(vagasCarros);
				bloco.setVagasMotos(vagasMotos);
				bloco.setVagasDeficientes(vagasDeficientes);
				
				blocoCtrl.create(bloco);
				
				JOptionPane.showMessageDialog(null, "Bloco cadastrado com sucesso!", "Success", JOptionPane.NO_OPTION);
				
				txtDescricao.setText("");
				
				AdminMainView admMainView = new AdminMainView();
				admMainView.setVisible(true);
				
				SwingUtilities.windowForComponent(btnCadastrar).dispose();				
			}
		});
		
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(131, 438, 219, 41);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtDescricao.setText("");
				AdminMainView admMainView = new AdminMainView();
				admMainView.setVisible(true);
				SwingUtilities.windowForComponent(btnCadastrar).dispose();
				
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(438, 438, 219, 41);
		frame.getContentPane().add(btnCancelar);
	}
}
