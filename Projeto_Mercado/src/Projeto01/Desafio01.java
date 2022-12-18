package Projeto01;
import java.util.Random;
public class Desafio01 {
    private static final Random random = new Random();
    private static final String[]nomes = new String[]{"Gabriel","Alessandro","Ariane","Breno","Caio","Wallys","Carlos","Cicero","Débora","Ezio","Luca","Rafael","Vinicius","Jociele","Marina","Vitor"};
    public static Vendedor[] geraVendedor(Vendedor[] vend){

        for (int i=0;i< 10;i++){
            int indiceNome = random.nextInt(nomes.length);
            String nome = nomes[indiceNome];
            vend[i]=new Vendedor(nome);
        }
        return vend;
    }
    public static void maiorLucro(Mercado mercado1, Mercado mercado2, Mercado mercado3){
        int l1= mercado1.getTotal();
        int l2=mercado2.getTotal();
        int l3=mercado3.getTotal();
        if(l1>l2 && l1>l3){
            System.out.println("O mercado mais lucrativo é o "+mercado1.getNome());
        }
        if(l2>l1 && l2>l3){
            System.out.println("O mercado mais lucrativo é o "+mercado2.getNome());
        }
        if(l3>l1 && l3>l2) {
            System.out.println("O mercado mais lucrativo é o "+mercado3.getNome());
        }
    }
    public static void imprimeRanking(Vendedor Maior){

    }
    public static void verificaMaior(Mercado mercado1,Mercado mercado2,Mercado mercado3){
        Vendedor []maior= new Vendedor[3];
        maior[0]=mercado1.vendedores[0];
        maior[0].pagamento(0);
        maior[1]=maior[0];
        maior[2]=maior[0];
        String[] maiorMerc= new String[3];
        for(int i=0;i<10;i++){
            if (mercado1.vendedores[i].getVendas()>maior[0].getVendas()){
                maior[0]=mercado1.vendedores[i];
                maiorMerc[0]=mercado1.getNome();
            }
            if (mercado2.vendedores[i].getVendas()>maior[0].getVendas()){
                maior[0]=mercado2.vendedores[i];
                maiorMerc[0]=mercado2.getNome();
            }
            if (mercado3.vendedores[i].getVendas()>maior[0].getVendas()){
                maior[0]=mercado3.vendedores[i];
                maiorMerc[0]=mercado3.getNome();
            }
        }
        for (int i=1;i<3;i++){
            for (int j=0;j<10;j++){
                if (mercado1.vendedores[j].getVendas()>maior[i].getVendas() &&
                        mercado1.vendedores[j].getVendas()<maior[i-1].getVendas()){
                    maior[i]=mercado1.vendedores[j];
                    maiorMerc[i]=mercado1.getNome();
                }
                if (mercado2.vendedores[j].getVendas()>maior[i].getVendas() &&
                        mercado2.vendedores[j].getVendas()<maior[i-1].getVendas()){
                    maior[i]=mercado2.vendedores[j];
                    maiorMerc[i]=mercado2.getNome();
                }
                if (mercado3.vendedores[j].getVendas()>maior[i].getVendas() &&
                mercado3.vendedores[j].getVendas()<maior[i-1].getVendas()){
                    maior[i]=mercado3.vendedores[j];
                    maiorMerc[i]=mercado3.getNome();
                }
            }
        }
        for (int i=0;i<3;i++){
            System.out.println((i+1)+"º lugar vendedor:"+
                    maior[i].getNomes()+
                    " - Venda:"+maior[i].getVendas()+
                    " - Mercado: "+ maiorMerc[i]);
        }
    }
    public static void imprimir(Mercado mercado){
        System.out.println(mercado);
        System.out.println("SALARIO E BONIFICAÇÃO VENDEDORES");
        System.out.println("------------------------------------------");
        for(int i=0;i<10;i++){
            System.out.println(mercado.vendedores[i]);
        }
    }
    public static void main(String[] args) {

        Vendedor []vendM1 = new Vendedor[10];
        Vendedor []vendM2 = new Vendedor[10];
        Vendedor []vendM3 = new Vendedor[10];
        vendM1=geraVendedor(vendM1);
        vendM2=geraVendedor(vendM2);
        vendM3=geraVendedor(vendM3);

        Mercado mercado1 = new Mercado(vendM1,300,"Curitiba","Mercado 1");
        Mercado mercado2 = new Mercado(vendM2,500,"São Paulo","Mercado 2");
        Mercado mercado3 = new Mercado(vendM3,700,"Belo Horizonte","Mercado 3");
        Comprador comprador = new Comprador();
        Regulador regulador = new Regulador();
        for (int i=0;i<10;i++){
            comprador.comprar(mercado1.vendedores[i]);
            comprador.comprar(mercado2.vendedores[i]);
            comprador.comprar(mercado3.vendedores[i]);
        }

        regulador.aplicar(mercado1);
        regulador.aplicar(mercado2);
        regulador.aplicar(mercado3);

        imprimir(mercado1);
        System.out.println("//////////////////////////////////////////");
        imprimir(mercado2);
        System.out.println("//////////////////////////////////////////");
        imprimir(mercado3);
        verificaMaior(mercado1,mercado2,mercado3);
        maiorLucro(mercado1,mercado2,mercado3);
    }
}



