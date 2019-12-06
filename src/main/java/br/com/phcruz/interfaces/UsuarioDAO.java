package br.com.phcruz.interfaces;

import java.util.List;

import br.com.phcruz.exception.DataException;
import br.com.phcruz.model.Usuario;

public interface UsuarioDAO {
	Usuario inserir(Usuario usuario) throws DataException ;
	Usuario buscarId(int id) throws DataException;
	Usuario atualizar(Usuario usuario) throws DataException ;
	List<Usuario> listar() throws DataException ;
	Usuario excluir(int id) throws DataException ;
}
