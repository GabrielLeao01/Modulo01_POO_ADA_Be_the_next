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
        System.out.println("Nome mercado: "+mercado1.getNome()+"\nLocal:"+mercado1.getLocal()+"\nMeta:"+ mercado1.getMeta()+"\nVendedores:"+ mercado1.getVendedores());

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

}
class Regulador{

}
class Comprador{
    private static final Random random = new Random();
    public void comprar(Vendedor vend){
        vend.pagamento(random.nextInt(1000));
    }
}
