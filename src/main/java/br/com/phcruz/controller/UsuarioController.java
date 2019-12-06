package br.com.phcruz.controller;

import java.util.List;

import br.com.phcruz.dao.UsuarioDAOImpl;
import br.com.phcruz.exception.DataException;
import br.com.phcruz.model.Usuario;

public class UsuarioController {

	private UsuarioDAOImpl usuarioDAO;
	
	public UsuarioController() throws DataException {
		this.usuarioDAO = new UsuarioDAOImpl();
	}

	public Usuario inserir(Usuario usuario) throws DataException {
		return usuarioDAO.inserir(usuario);
	}

	public Usuario buscarId(int id) throws DataException {
		return usuarioDAO.buscarId(id);
	}

	public Usuario atualizar(Usuario usuario) throws DataException {
		return usuarioDAO.atualizar(usuario);
	}

	public List<Usuario> listar() throws DataException {
		return usuarioDAO.listar();
	}

	public Usuario excluir(int id) throws DataException {
		return usuarioDAO.excluir(id);
	}
}
