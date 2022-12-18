package Projeto01;

import java.util.Random;

public class Comprador{
    private static final Random random = new Random();
    private int compras;
    private int totalCompras;
    public void comprar(Vendedor vend){
        compras = random.nextInt(1000);
        vend.pagamento(compras);
        totalCompras+=compras;
    }
    public int getTotalCompras(){
        return totalCompras;
    }
}

