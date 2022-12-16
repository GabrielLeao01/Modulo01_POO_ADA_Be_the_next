package Projeto01;
import java.util.Random;
public class marketClass {
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


    }
}
class Mercado{

    Vendedor[] vendedores;
    private int meta;
    private String localizacao;
    private String nome;
    private int totalVendido;
    public Mercado(Vendedor[] vendedores, int meta, String localizacao,String nomeMercado){
        this.vendedores = vendedores;
        this.meta=meta;
        this.localizacao=localizacao;
        nome=nomeMercado;
    }

    public void gerarTotal(){
        for (int i=0;i<10;i++){
            totalVendido+=vendedores[i].getVendas();
        }
    }
    public String getNome(){
        return nome;
    }
    public String getLocal(){
        return localizacao;
    }

    public int getMeta(){return this.meta;}

    public Vendedor[] getVendedores(){
        return vendedores;
    }
    public int getTotal(){
        return totalVendido;
    }
    public String toString(){
        return "Nome: "+getNome()+
                "\nLocal: "+ getLocal()+
                "\nMeta vendedores: "+getMeta()+
                "\nTotal:"+getTotal();
    }

}
class Vendedor{
    private String nome;
    private int valorVendas;
    private int bonificacao;
    public Vendedor(String nome){
        this.nome=nome;}
    public void pagamento(int valor){
        this.valorVendas+=valor;}

    public String getNomes(){
        return nome;
    }
    public int getVendas(){
        return valorVendas;
    }
    public void setBonificacao(){
        bonificacao = (int) (valorVendas*0.1);
    }
    public int getBonificacao(){
        return bonificacao;
    }

    public String toString(){
       return getNomes() +
               ":" + getVendas()+
               " + " + getBonificacao() +
                " de bonificação" ;
    }

}
class Regulador{
    public void aplicar(Mercado mercado){
        for(int i=0;i<10;i++){
            if(mercado.vendedores[i].getVendas()> mercado.getMeta()){
                mercado.vendedores[i].setBonificacao();
            }
        }
        mercado.gerarTotal();
    }
}
class Comprador{
    private static final Random random = new Random();
    public void comprar(Vendedor vend){
        vend.pagamento(random.nextInt(1000));
    }
}
