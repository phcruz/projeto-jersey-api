package br.com.phcruz.util;

import java.util.ArrayList;
import java.util.List;

import br.com.phcruz.exception.DataException;
import br.com.phcruz.model.Usuario;

public class UsuarioFactory {

	private static List<Usuario> listaUsuarios;

	public static List<Usuario> getInstance() {
		if (listaUsuarios == null)
			listaUsuarios = criaUsuarios();
		return listaUsuarios;
	}
	
	private static List<Usuario> criaUsuarios() {
		List<Usuario> lista = new ArrayList<>();
		Usuario u1 = new Usuario(1, "Paulo Cruz", "paulo@gmail.com", "123456");
		Usuario u2 = new Usuario(2, "Joao da Silva", "joao@yahoo.com", "3456789");
		Usuario u3 = new Usuario(3, "Raimundo Nonato", "nonato@hotmail.com", "765432");
		
		lista.add(u1);
		lista.add(u2);
		lista.add(u3);
		return lista;
	}
	
	public static Usuario inserirUsuario(Usuario usuario) throws DataException {
		for (Usuario u : getInstance()) {
			if (u.getEmail().equalsIgnoreCase(usuario.getEmail())) {
				throw new DataException("Usuario já cadastrado, tente inserir um email diferente.");
			}
		}
		
		int proxId = 1;
		if (!getInstance().isEmpty()) {
			int tamanho = getInstance().size() - 1;
			proxId = getInstance().get(tamanho).getId() + 1;
		}
		usuario.setId(proxId);
		getInstance().add(usuario);
		return usuario;
	}
	
	public static Usuario buscarUsuarioId(int id) throws DataException {
		for (Usuario u : getInstance()) {
			if (u.getId() == id) {
				return u;
			}
		}
		throw new DataException("Nenhum usuario encontrado com o id informado.");
	}
	
	public static Usuario atualizarUsuarioId(Usuario usuario) throws DataException {
		for (Usuario u : getInstance()) {
			if (u.getId() == usuario.getId()) {
				u.setNome((usuario.getNome() == null || usuario.getNome().isEmpty()) ? u.getNome() : usuario.getNome());
				u.setEmail((usuario.getEmail() == null || usuario.getEmail().isEmpty()) ? u.getEmail() : usuario.getEmail());
				u.setSenha((usuario.getSenha() == null || usuario.getSenha().isEmpty()) ? u.getSenha() : usuario.getSenha());
				
				return u;
			}
		}
		throw new DataException("Usuário não existe na base de dados com o id informado.");
	}
	
	public static Usuario deletarUsuarioId(int id) throws DataException {
		for (Usuario u : getInstance()) {
			if (u.getId() == id) {
				getInstance().remove(u);
				return u;
			}
		}
		throw new DataException("Não foi possivel excluir o usuário com o id informado.");
	}
}
