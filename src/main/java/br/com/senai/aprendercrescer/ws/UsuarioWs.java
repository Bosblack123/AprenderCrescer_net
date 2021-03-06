package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.Controller.UsuarioController;
import br.com.senai.aprendercrescer.model.Web;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
    @Path("/getusuarios")
    @Produces("application/json")
    public Response getAllUsuarios() {
        // ArrayList<JSONObject> listaJson = new ArrayList<JSONObject>();

        try {
            UsuarioController ususarioControler;
            ususarioControler = new UsuarioController();
            ArrayList<Web> lista = ususarioControler.getUsuarios();

            JSONObject jUsuario;
            StringBuilder retorno = new StringBuilder();
            retorno.append("[");
            boolean controle = false;
            for (Web usuario : lista) {
                if (controle) {
                    retorno.append(" , ");
                }

                jUsuario = new JSONObject();
                jUsuario.put("idUsuario", usuario.getIdUsuario());
                jUsuario.put("login", usuario.getLogin());
                jUsuario.put("senha", usuario.getSenha());
                jUsuario.put("nome", usuario.getNome());
                jUsuario.put("flagnativo", usuario.getFlagnativo() + "");
                retorno.append(jUsuario.toString());
                controle = true;
            }

            retorno.append("]");
            return Response.status(200).entity(retorno.toString()).build();
        } catch (Exception ex) {
            System.out.println("Erro:" + ex);
            return Response.status(200).entity(
                    "{erro : \"" + ex + "\"}").build();

        }
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
            Web usuario = new Web();
            //usuario.setIdusuario(resposta.getInt("IDUsuario"));
            usuario.setLogin(resposta.getString("login"));
            usuario.setSenha(resposta.getInt("senha") + "");
            usuario.setNome(resposta.getString("nome"));
            usuario.setFlagnativo(resposta.getString("flagnativo").toCharArray()[0]);
            usuario.setDtalteracao(new Date());

            if (new UsuarioController().insereUsuario(usuario)) {
                return Response.status(200).entity("{\"result\"" + ":\"Cadastro\"}").build();
            } else {
                return Response.status(501).entity("{\"result\"" + ":\"Erro no Cadastro\"}").build();
            }

        } catch (Exception ex) {
            return Response.status(501).entity(ex.toString()).build();
        }

    }

    @POST
    @Path("/updateusuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUsuario(InputStream dadosServ) {

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
            Web usuario = new Web();
            usuario.setIdUsuario(resposta.getInt("idUsuario"));
            usuario.setLogin(resposta.getString("login"));
            usuario.setSenha(resposta.getString("senha"));
            usuario.setNome(resposta.getString("nome"));
            usuario.setFlagnativo(resposta.getString("flagnativo").toCharArray()[0]);
            usuario.setDtalteracao(new Date());

            if (new UsuarioController().insereUsuario(usuario)) {
                return Response.status(200).entity("{\"result\"" + ":\"Cadastro\"}").build();
            } else {
                return Response.status(501).entity("{\"result\"" + ":\"Erro no Cadastro\"}").build();
            }

        } catch (Exception ex) {
            return Response.status(501).entity(ex.toString()).build();
        }

    }

    @DELETE
    @Path(("/deleteusuario"))
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUsuario(InputStream dadosServ) {
        StringBuilder requisisaoFinal = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(dadosServ));
            String requisicao = null;
            while((requisicao = in.readLine()) != null){
                requisisaoFinal.append(requisicao);
            }
            System.out.println(requisisaoFinal.toString());
            JSONObject resposta = new JSONObject(requisisaoFinal.toString());
            System.out.println(""+resposta.getInt("idUsuario"));
            int idUsuario = resposta.getInt("idUsuario");
            if(new UsuarioController().deleteUsuario(idUsuario)){
                return Response.status(200).entity("{\"result\"" + ":\"succes\"}").build();
            }else{
                return Response.status(501).entity("{\"result\"" + ":\"error\"}").build();
            }
        } catch (Exception ex) {
           return Response.status(500).entity(ex.toString()).build();
        }
        
    }
}
