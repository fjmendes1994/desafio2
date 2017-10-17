package hello;


public class EstacaoDistancia  {

    private final String estacao;
    private final double distancia;

    public EstacaoDistancia(String estacao, double distancia)  {
        this.estacao = estacao;
        this.distancia = distancia; 
    }

    public String getEstacao() {
        return this.estacao;
    }

    public double getDistancia(){
        return this.distancia;
    }

    
}