package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.Controller.UsuarioController;
import br.com.senai.aprendercrescer.model.Usuario;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
                jUsuario.put("Senha", usuario.getSenha());
                jUsuario.put("Flagnativo", usuario.getFlagnativo());
                retorno.put("usuario" + usuario.getIdusuario(), jUsuario.toString());
            } catch (JSONException ex) {
                Logger.getLogger(UsuarioWs.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return Response.status(200).entity(retorno.toString()).build();
    }

    
    
    
    
    @POST
    @Path("/setusuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setUsuario(InputStream dadosServ) {

        StringBuilder requisicaoFinal = new StringBuilder();

        try {
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(dadosServ));

            String requisicao = "";
            while ((requisicao = in.readLine()) != null) {
                requisicaoFinal.append(requisicao);

            }
            System.out.println(requisicaoFinal.toString());

            JSONObject resposta = new JSONObject(requisicaoFinal.toString());
            Usuario usuario = new Usuario();
            //usuario.setIdusuario(resposta.getInt("IDUsuario"));
            usuario.setLogin(resposta.getString("login"));
            usuario.setSenha(resposta.getInt("senha") + "");
            usuario.setNome(resposta.getString("nome"));
            usuario.setFlagnativo(resposta.getString("flagnativo").toCharArray()[0]);
            usuario.setDtalteracao(new Date());

            new UsuarioController().insereUsuario(usuario);

            Response.status(200).entity(
                    requisicaoFinal.toString()).build();
        } catch (Exception ex) {
            return Response.status(501).entity(ex.toString()).build();
        }

        return null;
    }
}
