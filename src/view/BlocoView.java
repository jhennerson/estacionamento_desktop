package view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.BlocoController;
import model.Bloco;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Font;

public class BlocoView {

	private JFrame frame;
	private JTable tableBlocos;
	private JTextField txtId;
	private JTextField txtDescricao;
	private JTextField txtOperador;
	private JSpinner spinnerVagasCarros;
	private JSpinner spinnerVagasMotos;
	private JSpinner spinnerVagasDeficientes;

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

	public BlocoView() {
		initialize();
	}

	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPaneTabela = new JScrollPane();
		scrollPaneTabela.setBounds(10, 11, 764, 301);
		frame.getContentPane().add(scrollPaneTabela);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setBounds(20, 321, 79, 30);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescricao.setBounds(121, 321, 151, 30);
		frame.getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtOperador = new JTextField();
		txtOperador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtOperador.setColumns(10);
		txtOperador.setBounds(296, 321, 133, 30);
		frame.getContentPane().add(txtOperador);
		
		spinnerVagasCarros = new JSpinner();
		spinnerVagasCarros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerVagasCarros.setBounds(456, 321, 79, 30);
		frame.getContentPane().add(spinnerVagasCarros);
		
		spinnerVagasMotos = new JSpinner();
		spinnerVagasMotos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerVagasMotos.setBounds(559, 321, 79, 30);
		frame.getContentPane().add(spinnerVagasMotos);
		
		spinnerVagasDeficientes = new JSpinner();
		spinnerVagasDeficientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerVagasDeficientes.setBounds(664, 321, 79, 30);
		frame.getContentPane().add(spinnerVagasDeficientes);
		
		tableBlocos = new JTable();
		tableBlocos.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
				
				txtId.setText(tblId);
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
		
		BlocoController blocoCtrl = new BlocoController();
		
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
	}
}
