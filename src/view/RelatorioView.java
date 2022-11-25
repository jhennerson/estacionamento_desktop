package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controller.VendaController;
import model.Usuario;
import model.Venda;
import javax.swing.SwingConstants;

public class RelatorioView {

	private JFrame frame;
	private JButton btnVoltar;
	private JTable tableVendas;
	private JTextField txtId;
	private JTextField txtValor;
	private JTextField txtDataHora;
	private JTextField txtTotal;
	private JLabel lblTotal;
	private Usuario sessionUsuario;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioView window = new RelatorioView();
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

	public RelatorioView(Usuario sessionUsuario) {
		this.sessionUsuario = sessionUsuario;
		initialize();
	}
	
	public RelatorioView() {
		initialize();
	}

	@SuppressWarnings("serial")
	private void initialize() {
		
		VendaController vendaCtrl = new VendaController();
		
		Double total = 0d;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPaneTabela = new JScrollPane();
		scrollPaneTabela.setBounds(10, 70, 764, 336);
		frame.getContentPane().add(scrollPaneTabela);
		
		txtId = new JTextField();
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setEditable(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setBounds(10, 417, 79, 30);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setEditable(false);
		txtValor.setBounds(99, 417, 303, 30);
		frame.getContentPane().add(txtValor);
		txtValor.setColumns(10);
		
		txtDataHora = new JTextField();
		txtDataHora.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataHora.setEditable(false);
		txtDataHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDataHora.setColumns(10);
		txtDataHora.setBounds(412, 417, 362, 30);
		frame.getContentPane().add(txtDataHora);
		
		tableVendas = new JTable();
		tableVendas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tableVendas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tblModel = (DefaultTableModel)tableVendas.getModel();
				
				Integer tblId = Integer.valueOf(tblModel.getValueAt(tableVendas.getSelectedRow(), 0).toString());
				String tblValor = tblModel.getValueAt(tableVendas.getSelectedRow(), 1).toString();
				String tblDataHora = tblModel.getValueAt(tableVendas.getSelectedRow(), 2).toString();
				
				txtId.setText(tblId.toString());
				txtValor.setText(tblValor);
				txtDataHora.setText(tblDataHora);
			}
		});

		tableVendas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Valor", "Data/Hora"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		tableVendas.getColumnModel().getColumn(1).setPreferredWidth(247);
		tableVendas.getColumnModel().getColumn(2).setPreferredWidth(295);		
		
		List<Venda> vendas = vendaCtrl.getList();
		
		for(Venda v : vendas) {
			
			DefaultTableModel tblModel = (DefaultTableModel)tableVendas.getModel();
			
			String id = v.getId().toString();
			String valor = String.format("%.2f",v.getValor());
			String dataHora = v.getTimestamp().toString();
			total += v.getValor();
			
			String[] data = new String[]{id, valor, dataHora};
			
			tblModel.addRow(data);
		}
		
		scrollPaneTabela.setViewportView(tableVendas);
		
		JLabel lblTitle = new JLabel("Relatório de Vendas");
		lblTitle.setFont(new Font("Unispace", Font.BOLD, 25));
		lblTitle.setBounds(237, 28, 290, 31);
		frame.getContentPane().add(lblTitle);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					SwingUtilities.windowForComponent(btnVoltar).dispose();
					VagaView vagasView = new VagaView(sessionUsuario);
					vagasView.setVisible(true);
				} catch(Exception err) {
					err.printStackTrace();
				}				
			}
		});
		
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(550, 503, 224, 47);
		frame.getContentPane().add(btnVoltar);
		
		txtTotal = new JTextField();
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setEditable(false);
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTotal.setColumns(10);
		txtTotal.setBounds(99, 475, 176, 47);
		frame.getContentPane().add(txtTotal);		
		txtTotal.setText(String.format("R$: %.2f", total));
		
		lblTotal = new JLabel("Valor total:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotal.setBounds(10, 475, 87, 47);
		frame.getContentPane().add(lblTotal);
	}
}
