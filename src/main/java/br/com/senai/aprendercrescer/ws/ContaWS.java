package br.com.senai.aprendercrescer.ws;
import br.com.senai.aprendercrescer.Controller.ContaController;
import br.com.senai.aprendercrescer.model.Conta;
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
 * @author Senai
 */
@Path("/conta")
public class ContaWS {
    @GET
    @Path("/getcontas")
    @Produces("application/json")
    public Response getConta() {
        ContaController contaController;
        contaController = new ContaController();

        ArrayList<Conta> lista
                = contaController.getContas();
        JSONObject retorno = new JSONObject();
        JSONObject jConta;
        for (Conta conta : lista) {
            try {
                jConta = new JSONObject();
                jConta.put("idconta", conta.getIdconta());
                jConta.put("descricao", conta.getDescricao());
                jConta.put("tipoconta", conta.getTipoconta());
                jConta.put("valor", conta.getValor());
                retorno.put("conta" + conta.getIdconta(), jConta.toString());
            } catch (JSONException ex) {
                Logger.getLogger(UsuarioWs.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return Response.status(200).entity(retorno.toString()).build();
    }
    
    @POST
    @Path("/setconta")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setConta(InputStream dadosServ) {

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
            Conta conta = new Conta();
            //usuario.setIdusuario(resposta.getInt("IDUsuario"));
            conta.setDescricao(resposta.getString("Descricao"));
            conta.setTipoconta(resposta.getString("TipoConta"));
            conta.setValor(resposta.getDouble("valor"));

            new ContaController().insereConta(conta);

            Response.status(200).entity(
                    requisicaoFinal.toString()).build();
        } catch (Exception ex) {
            return Response.status(501).entity(ex.toString()).build();
        }

        return null;
    }
}
