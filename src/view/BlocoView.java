package view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.BlocoController;
import controller.VagaController;
import model.Bloco;
import model.Usuario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class BlocoView {

	private JFrame frame;
	private JLabel lblGerenciamentoDeBlocos;
	private JTable tableBlocos;
	private JTextField txtId;
	private JTextField txtDescricao;
	private JTextField txtOperador;
	private JSpinner spinnerVagasCarros;
	private JSpinner spinnerVagasMotos;
	private JSpinner spinnerVagasDeficientes;
	private JButton btnCadastrar;
	private JButton btnAtualizar;
	private JButton btnDeletar;
	private JButton btnVoltar;
	private Usuario sessionUsuario;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlocoView window = new BlocoView();
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

	public BlocoView(Usuario sessionUsuario) {
		this.sessionUsuario = sessionUsuario;
		initialize();
	}
	
	public BlocoView() {
		initialize();
	}

	@SuppressWarnings("serial")
	private void initialize() {
		
		BlocoController blocoCtrl = new BlocoController();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblGerenciamentoDeBlocos = new JLabel("Gerenciamento de Blocos");
		lblGerenciamentoDeBlocos.setFont(new Font("Unispace", Font.BOLD, 25));
		lblGerenciamentoDeBlocos.setBounds(204, 11, 345, 39);
		frame.getContentPane().add(lblGerenciamentoDeBlocos);
		
		JScrollPane scrollPaneTabela = new JScrollPane();
		scrollPaneTabela.setBounds(10, 70, 764, 336);
		frame.getContentPane().add(scrollPaneTabela);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setBounds(22, 417, 79, 30);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescricao.setBounds(123, 417, 151, 30);
		frame.getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtOperador = new JTextField();
		txtOperador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtOperador.setColumns(10);
		txtOperador.setBounds(298, 417, 133, 30);
		frame.getContentPane().add(txtOperador);
		
		spinnerVagasCarros = new JSpinner();
		spinnerVagasCarros.setModel(new SpinnerNumberModel(1, 0, 50, 1));
		spinnerVagasCarros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerVagasCarros.setBounds(458, 417, 79, 30);
		frame.getContentPane().add(spinnerVagasCarros);
		
		spinnerVagasMotos = new JSpinner();
		spinnerVagasMotos.setModel(new SpinnerNumberModel(1, 0, 50, 1));
		spinnerVagasMotos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerVagasMotos.setBounds(561, 417, 79, 30);
		frame.getContentPane().add(spinnerVagasMotos);
		
		spinnerVagasDeficientes = new JSpinner();
		spinnerVagasDeficientes.setModel(new SpinnerNumberModel(1, 0, 50, 1));
		spinnerVagasDeficientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerVagasDeficientes.setBounds(666, 417, 79, 30);
		frame.getContentPane().add(spinnerVagasDeficientes);
		
		tableBlocos = new JTable();
		tableBlocos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tableBlocos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tblModel = (DefaultTableModel)tableBlocos.getModel();
				
				String tblId = tblModel.getValueAt(tableBlocos.getSelectedRow(), 0).toString();
				String tblDescricao = tblModel.getValueAt(tableBlocos.getSelectedRow(), 1).toString();
				String tblOperador = tblModel.getValueAt(tableBlocos.getSelectedRow(), 2).toString();
				Integer tblVagasCarros = Integer.valueOf(tblModel.getValueAt(tableBlocos.getSelectedRow(), 3).toString());
				Integer tblVagasMotos = Integer.valueOf(tblModel.getValueAt(tableBlocos.getSelectedRow(), 4).toString());
				Integer tblVagasDeficientes = Integer.valueOf(tblModel.getValueAt(tableBlocos.getSelectedRow(), 5).toString());
				
				txtId.setText(tblId.toString());
				txtDescricao.setText(tblDescricao);
				txtOperador.setText(tblOperador);
				spinnerVagasCarros.setValue(tblVagasCarros);
				spinnerVagasMotos.setValue(tblVagasMotos);
				spinnerVagasDeficientes.setValue(tblVagasDeficientes);				
			}
		});

		tableBlocos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Descri\u00E7\u00E3o", "Operador", "Vagas Carro", "Vagas Moto", "Vagas Deficiente"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		tableBlocos.getColumnModel().getColumn(0).setResizable(false);
		tableBlocos.getColumnModel().getColumn(1).setResizable(false);
		tableBlocos.getColumnModel().getColumn(1).setPreferredWidth(156);
		tableBlocos.getColumnModel().getColumn(2).setResizable(false);
		tableBlocos.getColumnModel().getColumn(2).setPreferredWidth(136);
		tableBlocos.getColumnModel().getColumn(3).setResizable(false);
		tableBlocos.getColumnModel().getColumn(4).setResizable(false);
		tableBlocos.getColumnModel().getColumn(5).setResizable(false);
		tableBlocos.getColumnModel().getColumn(5).setPreferredWidth(92);
		
		List<Bloco> blocos = blocoCtrl.getList();
		
		for(Bloco b : blocos) {
			
			DefaultTableModel tblModel = (DefaultTableModel)tableBlocos.getModel();
			
			String id = b.getId().toString();
			String descricao = b.getDescricao();
			String operador = b.getOperador();
			String vagasCarros = b.getVagasCarros().toString();
			String vagasMotos = b.getVagasMotos().toString();
			String vagasDeficientes = b.getVagasDeficientes().toString();
			
			String[] data = new String[]{id, descricao, operador, vagasCarros, vagasMotos, vagasDeficientes};
			
			tblModel.addRow(data);
		}
		
		scrollPaneTabela.setViewportView(tableBlocos);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.windowForComponent(btnCadastrar).dispose();
				BlocoCreateView blocoCreateView = new BlocoCreateView(sessionUsuario);
				blocoCreateView.setVisible(true);
			}
		});
		
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(22, 503, 166, 47);
		frame.getContentPane().add(btnCadastrar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				Integer id = Integer.valueOf(txtId.getText());
				String descricao = txtDescricao.getText();
				String operador = txtOperador.getText();
				Integer vagasCarros = (int)spinnerVagasCarros.getValue();
				Integer vagasMotos = (int)spinnerVagasMotos.getValue();
				Integer vagasDeficientes = (int)spinnerVagasDeficientes.getValue();
				
				BlocoController blocoCtrl = new BlocoController();
				
				Bloco blocoUpdt = new Bloco(id, descricao, operador, vagasCarros, vagasMotos, vagasDeficientes);
				
				try {
					blocoCtrl.update(blocoUpdt);
					JOptionPane.showMessageDialog(null, "Dados do bloco atualizados!", "Success", JOptionPane.NO_OPTION);					
					SwingUtilities.windowForComponent(btnAtualizar).dispose();
					BlocoView blocoView = new BlocoView(sessionUsuario);
					blocoView.setVisible(true);					
				} catch(Exception err) {
					err.printStackTrace();
					JOptionPane.showMessageDialog(null, "Falha ao atualizar os dados...", "Ops", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizar.setBounds(198, 503, 166, 47);
		frame.getContentPane().add(btnAtualizar);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BlocoController blocoCtrl = new BlocoController();
				VagaController vagaCtrl = new VagaController();
				Integer id = Integer.valueOf(txtId.getText());
				String descricao = txtDescricao.getText();
				
				try {
					blocoCtrl.delete(id);
					vagaCtrl.deleteAll(descricao);
					JOptionPane.showMessageDialog(null, "Bloco removido da base de dados!", "Success", JOptionPane.NO_OPTION);					
					SwingUtilities.windowForComponent(btnAtualizar).dispose();
					BlocoView blocoView = new BlocoView(sessionUsuario);
					blocoView.setVisible(true);					
				} catch(Exception err) {
					err.printStackTrace();
					JOptionPane.showMessageDialog(null, "Falha ao remover...", "Ops", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletar.setBounds(374, 503, 166, 47);
		frame.getContentPane().add(btnDeletar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(!sessionUsuario.getUsername().equals("admin")) {
						SwingUtilities.windowForComponent(btnVoltar).dispose();
						OperadorMainView oprMainView = new OperadorMainView(sessionUsuario);
						oprMainView.setVisible(true);
					} else {
						SwingUtilities.windowForComponent(btnVoltar).dispose();
						AdminMainView admMainView = new AdminMainView(sessionUsuario);
						admMainView.setVisible(true);
					}					
				} catch(Exception err) {
					err.printStackTrace();
				}				
			}
		});
		
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(550, 503, 224, 47);
		frame.getContentPane().add(btnVoltar);
	}
}
