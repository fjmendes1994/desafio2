package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EstacaoController  {

    @RequestMapping("/estacao")
    public String estacao (@RequestParam double lati, @RequestParam double longi) throws IOException{
       

        // URI do API BikeRio
        final String uri = "http://dadosabertos.rio.rj.gov.br/apiTransporte/apresentacao/rest/index.cfm/estacoesBikeRio";
        
        RestTemplate restTemplate = new RestTemplate();

        ObjectMapper mapper = new ObjectMapper();

        // Acesso a API BikeRio
        String result = restTemplate.getForObject(uri, String.class);
        
        // Acessa o campo DATA do documento JSON
        final JsonNode values = mapper.readTree(result).get("DATA");
        
        //EstacoesRio estacoes = new EstacoesRio();
        ArrayList<Estacao> estacoes = new ArrayList();

        // Aqui eu acesso o array dentro do arrayNode
        if (values.isArray()) {
            for (int i = 0; i < values.size(); i++) {
               estacoes.add(new Estacao(values.get(i).get(0).toString(),
                                                 values.get(i).get(1).toString(),
                                                 values.get(i).get(2).toString(),
                                                 values.get(i).get(3).toString(),
                                                 values.get(i).get(4).toString(),
                                                 values.get(i).get(5).toString(),
                                                 values.get(i).get(6).toString() ));
            
                System.out.println( "Estacao : " + values.get(i).get(1) + " adicionada !");

            }
        } 
        
        ArrayList<EstacaoDistancia> estacoesDistancia = new ArrayList();

        

        for(Estacao estacao : estacoes){
            if(!estacao.getEstacao().contains("Rua da Passagem")){
                estacoesDistancia.add(new EstacaoDistancia(estacao.getEstacao(), estacao.calcDistancia(-22.9012257, -43.224256)));
                //System.out.println("Distancia da estacao " + estacao.getEstacao() + " é " + estacao.calcDistancia(-22.9012257, -43.224256));
                
            }

        }

        Collections.sort(estacoesDistancia, new Comparator<EstacaoDistancia>() {
            @Override
            public int compare(EstacaoDistancia est1, EstacaoDistancia est2) {
                return Double.compare(est1.getDistancia(), est2.getDistancia());
            }
        });
        for(EstacaoDistancia estacaoDistancia : estacoesDistancia){

            System.out.println("Distancia da estacao " + estacaoDistancia.getEstacao() + " é de " + estacaoDistancia.getDistancia());
        }
 
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println(lati);
        System.out.println(longi);
        System.out.println("-----------------------");
        System.out.println("-----------------------");


        
        return "estacao";
    }

}