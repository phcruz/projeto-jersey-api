package br.com.phcruz.dao;

import java.util.List;

import br.com.phcruz.exception.DataException;
import br.com.phcruz.interfaces.UsuarioDAO;
import br.com.phcruz.model.Usuario;
import br.com.phcruz.util.UsuarioFactory;

public class UsuarioDAOImpl extends UsuarioFactory implements UsuarioDAO {

	@Override
	public Usuario inserir(Usuario usuario) throws DataException {
		return inserirUsuario(usuario);
	}

	@Override
	public Usuario buscarId(int id) throws DataException {
		return buscarUsuarioId(id);
	}

	@Override
	public Usuario atualizar(Usuario usuario)  throws DataException {
		return atualizarUsuarioId(usuario);
	}

	@Override
	public List<Usuario> listar() throws DataException {
		return getInstance();
	}

	@Override
	public Usuario excluir(int id) throws DataException {
		return deletarUsuarioId(id);
	}

}
