package br.com.phcruz.service;

import java.util.List;

import com.google.gson.Gson;

import br.com.phcruz.model.Usuario;

public class UsuarioService {

	public static Usuario convertJsonUsuario(String usuarioJson) {
		Gson gson = new Gson();
		return gson.fromJson(usuarioJson, Usuario.class);
	}
	
	public static String convertUsuarioJson(Usuario usuario) {
		Gson gson = new Gson();
		return gson.toJson(usuario, Usuario.class);
	}
	
	public static String convertJson(List<Usuario> list) {
		Gson gson = new Gson();
		return gson.toJson(list);
	}
	
	public static Usuario validaInsercaoUsuario(Usuario usuario) throws Exception {
		if (usuario != null && (usuario.getNome() != null && !usuario.getNome().isEmpty())
				&& (usuario.getEmail() != null && !usuario.getEmail().isEmpty())
				&& (usuario.getSenha() != null && !usuario.getSenha().isEmpty())) {
			return usuario;
		}
		throw new Exception("Todos os campos devem ser preenchidos.");
	}
	
	public static Usuario validaAtualizacaoUsuario(Usuario usuario) throws Exception {
		if (usuario != null && usuario.getId() != 0) {
			return usuario;
		}
		throw new Exception("O id do usuário deve ser forncecido.");
	}

	public static String convertJson(String message) {
		Gson gson = new Gson();
		return gson.toJson(message);
	}
}
