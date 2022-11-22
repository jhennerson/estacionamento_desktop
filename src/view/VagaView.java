package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.VagaController;
import model.Vaga;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class VagaView {

	private JFrame frame;
	private JLabel lblGerenciamentoDeBlocos;
	private JTable tableVagas;
	private JTextField txtId;
	private JTextField txtCategoria;
	private JTextField txtBloco;
	private JButton btnVoltar;
	private JTextField txtEstado;
	private JTextField txtTimestamp;
	private JButton btnRelatorio;
	private JButton btnCalcular;
	private JLabel lblVagasLivres;
	private JTextField txtVagasLivres;
	private JLabel lblVagasOcupadas;
	private JTextField txtVagasOcupadas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VagaView window = new VagaView();
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
	
	public VagaView() {
		initialize();		
	}
	
	private void formatarCampo(JFormattedTextField formattedTextField) {		
		MaskFormatter mask;
		try {
			mask = new MaskFormatter("##:##");
			mask.install(formattedTextField);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
	}

	@SuppressWarnings("serial")
	private void initialize() {
		
		VagaController vagaCtrl = new VagaController();
		
		Integer vagasLivres = vagaCtrl.countEstado(0);
		Integer vagasOcupadas = vagaCtrl.countEstado(1);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblGerenciamentoDeBlocos = new JLabel("Gerenciamento de Vagas");
		lblGerenciamentoDeBlocos.setFont(new Font("Unispace", Font.BOLD, 25));
		lblGerenciamentoDeBlocos.setBounds(204, 11, 336, 39);
		frame.getContentPane().add(lblGerenciamentoDeBlocos);
		
		JScrollPane scrollPaneTabela = new JScrollPane();
		scrollPaneTabela.setBounds(10, 102, 764, 304);
		frame.getContentPane().add(scrollPaneTabela);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setBounds(10, 417, 91, 30);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setEditable(false);
		txtCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCategoria.setBounds(111, 417, 208, 30);
		frame.getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);
		
		txtBloco = new JTextField();
		txtBloco.setEditable(false);
		txtBloco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBloco.setColumns(10);
		txtBloco.setBounds(329, 417, 208, 30);
		frame.getContentPane().add(txtBloco);
		
		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEstado.setColumns(10);
		txtEstado.setBounds(111, 458, 208, 30);
		frame.getContentPane().add(txtEstado);
		
		txtTimestamp = new JTextField();
		txtTimestamp.setEditable(false);
		txtTimestamp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimestamp.setColumns(10);
		txtTimestamp.setBounds(329, 458, 208, 30);
		frame.getContentPane().add(txtTimestamp);
		
		JFormattedTextField ftfValor = new JFormattedTextField();
		ftfValor.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ftfValor.setHorizontalAlignment(SwingConstants.CENTER);
		ftfValor.setBounds(10, 475, 88, 75);
		frame.getContentPane().add(ftfValor);
		formatarCampo(ftfValor);
		
		JLabel lblCalculo = new JLabel("Tempo Ocupado");
		lblCalculo.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCalculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalculo.setBounds(10, 458, 88, 13);
		frame.getContentPane().add(lblCalculo);
		
		lblVagasLivres = new JLabel("Vagas Livres:");
		lblVagasLivres.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVagasLivres.setBounds(100, 61, 104, 30);
		frame.getContentPane().add(lblVagasLivres);
		
		txtVagasLivres = new JTextField();
		txtVagasLivres.setBackground(new Color(128, 255, 128));
		txtVagasLivres.setHorizontalAlignment(SwingConstants.CENTER);
		txtVagasLivres.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtVagasLivres.setEditable(false);
		txtVagasLivres.setBounds(214, 61, 133, 30);
		frame.getContentPane().add(txtVagasLivres);
		txtVagasLivres.setColumns(10);
		txtVagasLivres.setText(vagasLivres.toString());
		
		lblVagasOcupadas = new JLabel("Vagas Ocupadas:");
		lblVagasOcupadas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVagasOcupadas.setBounds(419, 61, 136, 30);
		frame.getContentPane().add(lblVagasOcupadas);
		
		txtVagasOcupadas = new JTextField();
		txtVagasOcupadas.setBackground(new Color(192, 192, 192));
		txtVagasOcupadas.setHorizontalAlignment(SwingConstants.CENTER);
		txtVagasOcupadas.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtVagasOcupadas.setEditable(false);
		txtVagasOcupadas.setColumns(10);
		txtVagasOcupadas.setBounds(565, 61, 133, 30);
		frame.getContentPane().add(txtVagasOcupadas);
		txtVagasOcupadas.setText(vagasOcupadas.toString());
		
		tableVagas = new JTable();
		tableVagas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tableVagas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tblModel = (DefaultTableModel)tableVagas.getModel();
				
				String tblId = tblModel.getValueAt(tableVagas.getSelectedRow(), 0).toString();
				String tblCategoria = tblModel.getValueAt(tableVagas.getSelectedRow(), 1).toString();
				String tblBloco = tblModel.getValueAt(tableVagas.getSelectedRow(), 2).toString();
				String tblEstado = tblModel.getValueAt(tableVagas.getSelectedRow(), 3).toString();
				String tblTimestamp = tblModel.getValueAt(tableVagas.getSelectedRow(), 4).toString();
				
				txtId.setText(tblId.toString());
				txtCategoria.setText(tblCategoria);
				txtBloco.setText(tblBloco);
				txtEstado.setText(tblEstado);
				txtTimestamp.setText(tblTimestamp);								
			}
		});

		tableVagas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Categoria", "Bloco", "Estado", "In\u00EDcio da Ocupa\u00E7\u00E3o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		tableVagas.getColumnModel().getColumn(0).setPreferredWidth(45);
		tableVagas.getColumnModel().getColumn(1).setPreferredWidth(130);
		tableVagas.getColumnModel().getColumn(2).setPreferredWidth(154);
		tableVagas.getColumnModel().getColumn(3).setPreferredWidth(45);
		tableVagas.getColumnModel().getColumn(4).setPreferredWidth(130);
				
		List<Vaga> vagas = vagaCtrl.getList();
		
		for(Vaga v : vagas) {
			
			DefaultTableModel tblModel = (DefaultTableModel)tableVagas.getModel();
			
			String[] cat = {"Carro", "Moto", "Deficiente"};
			
			String id = v.getId().toString();
			String categoria = cat[v.getCategoria()-1];
			String bloco = v.getBloco();
			String estado = (v.getEstado() == 0) ? "Livre" : "Ocupado";
			String timestamp = (estado.equalsIgnoreCase("Livre")) ? "" : v.getTimestamp().toString();
			
			String[] data = new String[]{id, categoria, bloco, estado, timestamp};
			
			tblModel.addRow(data);
		}
		
		scrollPaneTabela.setViewportView(tableVagas);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.windowForComponent(btnVoltar).dispose();
				AdminMainView admMainView = new AdminMainView();
				admMainView.setVisible(true);				
			}
		});
		
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(550, 503, 224, 47);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnAlterarEstado = new JButton("Alterar Estado");
		btnAlterarEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VagaController vagaCtrl = new VagaController();
				vagaCtrl.alteraEstado(Integer.valueOf(txtId.getText()));
				SwingUtilities.windowForComponent(btnAlterarEstado).dispose();
				VagaView refresh = new VagaView();
				refresh.setVisible(true);				
			}
		});
		
		btnAlterarEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterarEstado.setBounds(550, 415, 224, 75);
		frame.getContentPane().add(btnAlterarEstado);
		
		btnRelatorio = new JButton("Relatório");
		btnRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRelatorio.setBounds(329, 503, 211, 47);
		frame.getContentPane().add(btnRelatorio);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String[] valoresTempo = ftfValor.getText().split(":");
					Float horas = Float.valueOf(valoresTempo[0]);
					Float minutos = Float.valueOf(valoresTempo[1]);
					Float total = (float) ((horas + (minutos / 60)) * 5.00);
					
					System.out.println(total);
					System.out.println(minutos / 60 * 5);
					
					JOptionPane.showMessageDialog(null, String.format("Valor total a cobrar: R$ %.2f", total) + ".", "Success", JOptionPane.NO_OPTION);
					
				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		});
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalcular.setBounds(111, 503, 208, 47);
		frame.getContentPane().add(btnCalcular);
		
		
	}
	

}