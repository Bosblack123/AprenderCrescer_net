package br.com.senai.aprendercrescer.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author Daniel
 */
@Path("/usuario")
public class UsuarioWs {

    @GET
    @Path("/getusuario")
    @Produces("application/json")
    public Response getUsuario() {
        
        String Resposta = "{'nome':'Daniel'}";
        
        return Response.status(200).entity(Resposta).build();
    }
}