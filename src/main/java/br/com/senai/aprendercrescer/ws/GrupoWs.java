package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.Controller.GrupoController;
import br.com.senai.aprendercrescer.model.Grupo;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
 * @author Senai
 */
@Path("/grupo")
public class GrupoWs {
    @GET
    @Path("/getgrupos")
    @Produces("application/json")
    public Response getGrupos() {
        GrupoController grupoController;
        grupoController = new GrupoController();

        ArrayList<Grupo> lista
                = grupoController.getGrupos();
        JSONObject retorno = new JSONObject();
        JSONObject jGrupo;
        for (Grupo grupo : lista) {
            try {
                jGrupo = new JSONObject();
                jGrupo.put("idGrupo", grupo.getIdgrupo());
                jGrupo.put("tipousuario", grupo.getTipousuario());
                jGrupo.put("descricaogrupo", grupo.getDescricaogrupo());
                retorno.put("grupo" + grupo.getIdgrupo(), jGrupo.toString());
            } catch (JSONException ex) {
                Logger.getLogger(UsuarioWs.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return Response.status(200).entity(retorno.toString()).build();
    }

    
    
    
    
    @POST
    @Path("/setgrupo")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setGrupo(InputStream dadosServ) {

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
            Grupo grupo = new Grupo();
            grupo.setTipousuario(resposta.getString("Tipo"));
            grupo.setDescricaogrupo(resposta.getString("Descricao"));

            new GrupoController().insereGrupo(grupo);

            Response.status(200).entity(
                    requisicaoFinal.toString()).build();
        } catch (Exception ex) {
            return Response.status(501).entity(ex.toString()).build();
        }

        return null;
    }
}
