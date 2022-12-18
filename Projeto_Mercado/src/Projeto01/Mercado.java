package Projeto01;

public class Mercado {

    Vendedor[] vendedores;
    private int meta;
    private String localizacao;
    private String nome;
    private int totalVendido;

    public Mercado(Vendedor[] vendedores, int meta, String localizacao, String nomeMercado) {
        this.vendedores = vendedores;
        this.meta = meta;
        this.localizacao = localizacao;
        nome = nomeMercado;
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

