package br.com.phcruz.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.phcruz.controller.UsuarioController;
import br.com.phcruz.model.Usuario;
import br.com.phcruz.service.UsuarioService;

@Path("/usuario")
public class UsuarioResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserir(String usuarioJson) {
		try {
			Usuario user = UsuarioService.convertJsonUsuario(usuarioJson);
			UsuarioService.validaInsercaoUsuario(user);
			
			UsuarioController uController = new UsuarioController();

			return Response.status(Status.OK).entity(UsuarioService.convertUsuarioJson(uController.inserir(user))).build();
		} catch (Exception dt) {
			return Response.status(Status.NOT_FOUND).entity(UsuarioService.convertJson(dt.getMessage())).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarId(@PathParam("id") int id) {
		try {
			UsuarioController uController = new UsuarioController();
			
			return Response.status(Status.OK).entity(UsuarioService.convertUsuarioJson(uController.buscarId(id))).build();
		} catch (Exception dt) {
			return Response.status(Status.NOT_FOUND).entity(UsuarioService.convertJson(dt.getMessage())).build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(String usuarioJson) {
		try {
			Usuario user = UsuarioService.convertJsonUsuario(usuarioJson);
			UsuarioService.validaAtualizacaoUsuario(user);
			
			UsuarioController uController = new UsuarioController();
			
			return Response.status(Status.OK).entity(UsuarioService.convertUsuarioJson(uController.atualizar(user))).build();
		}  catch (Exception dt) {
			return Response.status(Status.NOT_FOUND).entity(UsuarioService.convertJson(dt.getMessage())).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		try {
			UsuarioController uController = new UsuarioController();
			
			return Response.status(Status.OK).entity(UsuarioService.convertJson(uController.listar())).build();
		}  catch (Exception dt) {
			return Response.status(Status.NOT_FOUND).entity(UsuarioService.convertJson(dt.getMessage())).build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("id") int id) {
		try {
			UsuarioController uController = new UsuarioController();
			return Response.status(Status.OK).entity(UsuarioService.convertUsuarioJson(uController.excluir(id))).build();
		}  catch (Exception dt) {
			return Response.status(Status.NOT_FOUND).entity(UsuarioService.convertJson(dt.getMessage())).build();
		}
	}
}
