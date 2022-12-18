package Projeto01;

public class Vendedor{
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
                " vendeu " + getVendas()+
                " reais e foi bonificado com " + getBonificacao() +
                " reais" ;
    }

}
