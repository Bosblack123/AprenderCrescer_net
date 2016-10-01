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
    public Response getAllGrupos() {
        // ArrayList<JSONObject> listaJson = new ArrayList<JSONObject>();

        try {
            GrupoController grupoControler;
            grupoControler = new GrupoController();
            ArrayList<Grupo> lista = grupoControler.getGrupos();

            JSONObject jGrupo;
            StringBuilder retorno = new StringBuilder();
            retorno.append("[");
            boolean controle = false;
            for (Grupo grupo : lista) {
                if (controle) {
                    retorno.append(" , ");
                }

                jGrupo = new JSONObject();
                jGrupo.put("idGrupo", grupo.getIdgrupo());
                jGrupo.put("tipousuario", grupo.getTipousuario());
                jGrupo.put("descricaogrupo", grupo.getDescricaogrupo());
                retorno.append(jGrupo.toString());
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
