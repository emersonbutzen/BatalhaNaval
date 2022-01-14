package br.com.butzen.batalhanaval.domain;

import java.util.Random;

public abstract class Jogador {

    protected static final int tamanhoDoTabuleiro = 10;
    
    private static Random rand = new Random();

    public abstract void venceu();

    public int generateNum(){
        return rand.nextInt(tamanhoDoTabuleiro);
    }
}
