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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controller.UsuarioController;
import model.Operador;
import model.Usuario;

public class UsuarioView {

	private JFrame frame;
	private JTable tableOperadores;
	private JTextField txtId;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JButton btnCadastrar;
	private JButton btnAtualizar;
	private JButton btnDeletar;
	private JButton btnVoltar;
	private JTextField txtBloco;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioView window = new UsuarioView();
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

	public UsuarioView() {
		initialize();
	}

	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPaneTabela = new JScrollPane();
		scrollPaneTabela.setBounds(10, 11, 764, 395);
		frame.getContentPane().add(scrollPaneTabela);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setBounds(22, 417, 79, 30);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsername.setBounds(123, 417, 197, 30);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setColumns(10);
		txtPassword.setBounds(361, 417, 218, 30);
		frame.getContentPane().add(txtPassword);
		
		tableOperadores = new JTable();
		tableOperadores.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tableOperadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tblModel = (DefaultTableModel)tableOperadores.getModel();
				
				Integer tblId = Integer.valueOf(tblModel.getValueAt(tableOperadores.getSelectedRow(), 0).toString());
				String tblUsername = tblModel.getValueAt(tableOperadores.getSelectedRow(), 1).toString();
				String tblPassword = tblModel.getValueAt(tableOperadores.getSelectedRow(), 2).toString();
				String tblBloco = tblModel.getValueAt(tableOperadores.getSelectedRow(), 3).toString();
				
				txtId.setText(tblId.toString());
				txtUsername.setText(tblUsername);
				txtPassword.setText(tblPassword);
				txtBloco.setText(tblBloco);
			}
		});

		tableOperadores.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome de Usu\u00E1rio", "Senha", "Bloco"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableOperadores.getColumnModel().getColumn(0).setResizable(false);
		tableOperadores.getColumnModel().getColumn(1).setResizable(false);
		tableOperadores.getColumnModel().getColumn(1).setPreferredWidth(159);
		tableOperadores.getColumnModel().getColumn(2).setResizable(false);
		tableOperadores.getColumnModel().getColumn(2).setPreferredWidth(261);
		tableOperadores.getColumnModel().getColumn(3).setResizable(false);
		tableOperadores.getColumnModel().getColumn(3).setPreferredWidth(122);
		
		UsuarioController usuarioCtrl = new UsuarioController();
		
		List<Usuario> usuarios = usuarioCtrl.getList();
		
		for(Usuario u : usuarios) {
			
			DefaultTableModel tblModel = (DefaultTableModel)tableOperadores.getModel();
			
			String id = u.getId().toString();
			String username = u.getUsername();
			String password = u.getPassword();
			String bloco = u.getBloco();
			
			String[] data = new String[]{id, username, password, bloco};
			
			tblModel.addRow(data);
		}
		
		scrollPaneTabela.setViewportView(tableOperadores);
		
		btnCadastrar = new JButton("Cadastrar Novo");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				BlocoCreateView blocoCreateView = new BlocoCreateView();
				blocoCreateView.setVisible(true);
				SwingUtilities.windowForComponent(btnCadastrar).dispose();				
			}
		});
		
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(22, 481, 166, 47);
		frame.getContentPane().add(btnCadastrar);
		
		btnAtualizar = new JButton(" Atualizar Dados");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				Integer id = Integer.valueOf(txtId.getText());
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				String bloco = txtBloco.getText();
				
				UsuarioController usuarioCtrl = new UsuarioController();				
				Operador operadorUpdt = new Operador(id, username, password, bloco);
				
				try {
					usuarioCtrl.update(operadorUpdt);
					JOptionPane.showMessageDialog(null, "Dados do operador atualizados!", "Success", JOptionPane.NO_OPTION);
					SwingUtilities.windowForComponent(btnAtualizar).dispose();
					UsuarioView usuarioView = new UsuarioView();
					usuarioView.setVisible(true);					
				} catch(Exception err) {
					err.printStackTrace();
					JOptionPane.showMessageDialog(null, "Falha ao atualizar os dados...", "Ops", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizar.setBounds(198, 481, 166, 47);
		frame.getContentPane().add(btnAtualizar);
		
		btnDeletar = new JButton("Deletar Usuário");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioController usuarioCtrl = new UsuarioController();
				Integer id = Integer.valueOf(txtId.getText());
				
				try {
					usuarioCtrl.delete(id);
					JOptionPane.showMessageDialog(null, "Bloco removido da base de dados!", "Success", JOptionPane.NO_OPTION);
					SwingUtilities.windowForComponent(btnAtualizar).dispose();
					UsuarioView usuarioView = new UsuarioView();
					usuarioView.setVisible(true);					
				} catch(Exception err) {
					err.printStackTrace();
					JOptionPane.showMessageDialog(null, "Falha ao remover...", "Ops", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletar.setBounds(374, 481, 166, 47);
		frame.getContentPane().add(btnDeletar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMainView admMainView = new AdminMainView();
				admMainView.setVisible(true);
				SwingUtilities.windowForComponent(btnVoltar).dispose();
			}
		});
		
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(597, 481, 166, 47);
		frame.getContentPane().add(btnVoltar);
		
		txtBloco = new JTextField();
		txtBloco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBloco.setColumns(10);
		txtBloco.setBounds(619, 417, 133, 30);
		frame.getContentPane().add(txtBloco);
	}

}
