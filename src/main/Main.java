package main;

import dao.UsuarioDAO;
import model.Usuario;
import view.LoginView;
import view.MainView;

public class Main {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario("usuario1", "1234", 0);
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuarioDao.save(usuario);
		
		LoginView loginView = new LoginView();
		loginView.setVisible(true);
	}

}
