package main;

import controller.BlocoController;
import controller.UsuarioController;
import controller.VagaController;
import model.Bloco;
import model.Operador;
import model.Usuario;
import model.Vaga;
import view.LoginView;

public class Main {

	public static void main(String[] args) {
		
		Operador operador = new Operador("augusto", "freefire", "Bloco A");
		UsuarioController usuCtr = new UsuarioController();
		usuCtr.create(operador);
		
		LoginView loginView = new LoginView();
		loginView.setVisible(true);
		
		for(Usuario u : usuCtr.getList()) {
			System.out.println("ID: " + u.getId());
			System.out.println("NOME: " + u.getUsername());
			System.out.println("SENHA: " + u.getPassword());
		}
		
		Operador novoUsuario = new Operador(12, "dsadsa", "1234", "Bloco B");
		
		usuCtr.update(novoUsuario);
		
		usuCtr.delete(12);
		
		Vaga vaga1 = new Vaga(1, "Bloco B");
		Vaga vaga2 = new Vaga(2, "Bloco A");
		Vaga vaga3 = new Vaga(2, 3, "Bloco C", 1);
		
		VagaController vagaCtrl = new VagaController();
		
		vagaCtrl.create(vaga1);
		
		vagaCtrl.update(vaga3);
		
		vagaCtrl.delete(3);
		
		
		Bloco bloco = new Bloco("Bloco D", "conrad");
		
		bloco.addVaga(vaga1);
		bloco.addVaga(vaga2);
		bloco.addVaga(vaga3);
		
		BlocoController blocoCtrl = new BlocoController();
		blocoCtrl.create(bloco);
		
		Bloco novoBloco = new Bloco(32,"Bloco B", "cesar", 1, 2, 3);
		
		blocoCtrl.update(novoBloco);
		
		blocoCtrl.delete(6);
	}
}
