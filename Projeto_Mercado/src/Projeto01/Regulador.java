package Projeto01;

public class Regulador{
    public void aplicar(Mercado mercado){
        for(int i=0;i<10;i++){
            if(mercado.vendedores[i].getVendas()> mercado.getMeta()){
                mercado.vendedores[i].setBonificacao();
            }
        }
        mercado.gerarTotal();
    }
}
