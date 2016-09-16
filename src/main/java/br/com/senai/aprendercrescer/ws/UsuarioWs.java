package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.Controller.UsuarioController;
import br.com.senai.aprendercrescer.model.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

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
        try {
            JSONObject retorno = new JSONObject();
            retorno.put("nome", "Luciano");
            retorno.put("idade", 29);
            return Response.status(200).entity(retorno.toString()).build();
        } catch (JSONException ex) {
            Logger.getLogger(UsuarioWs.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.status(500).build();
    }

    @GET
    @Path("/getusuarios")
    @Produces("application/json")
    public Response getUsuarios() {
        UsuarioController usuarioController;
        usuarioController = new UsuarioController();

        ArrayList<Usuario> lista
                = usuarioController.getUsuarios();
        JSONObject retorno = new JSONObject();
        JSONObject jUsuario;
        for (Usuario usuario : lista) {
            try {
                jUsuario = new JSONObject();
                jUsuario.put("idUsuario", usuario.getIdusuario());
                jUsuario.put("nome", usuario.getNome());
                retorno.put("usuario" + usuario.getIdusuario(), jUsuario.toString());
            } catch (JSONException ex) {
                Logger.getLogger(UsuarioWs.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return Response.status(200).entity(retorno.toString()).build();
    }
}
