package Projeto01;

import java.util.Random;

public class Comprador{
    private String nome;
    private static final Random random = new Random();
    private int compras;
    private int totalCompras;
    public Comprador(String nome){
        this.nome=nome;
    }
    public void comprar(Vendedor vend){
        compras = random.nextInt(1000);
        vend.pagamento(compras);
        totalCompras+=compras;
    }
    public int getTotalCompras(){
        return totalCompras;
    }
    public String getNome(){
        return nome;
    }
}

