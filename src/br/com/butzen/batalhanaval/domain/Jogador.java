package br.com.butzen.batalhanaval.domain;

import java.util.Random;

public abstract class Jogador {

    protected static final int tamanhoDoTabuleiro = 10;
    protected int posicaoX;
    protected int posicaoY;
    
    private static Random rand = new Random();
    protected String symbol;

    public void setPosicaoX(int x){
        // seta atual posição
        this.posicaoX = x;
    }

    public int getPosicaoX(){
        // retorna atual posição
        return this.posicaoX;
    }

    public void setPosicaoY(int y){
        // seta atual posição
        this.posicaoY = y;
    }

    public int getPosicaoY(){
        // retorna atual posição
        return this.posicaoY;
    }

    public abstract void venceu();

    public void setSymbol(String symbol){
        // set the symbol
        this.symbol = symbol;
    }

    public String getSymbol(){
        return this.symbol;
    };

    public int generateNum(){
        return rand.nextInt(tamanhoDoTabuleiro);
    }
}
