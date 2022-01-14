package br.com.butzen.batalhanaval.domain;

public class Navio {

    private String celula = " ";
    private boolean estaBombardeado = false;
    private int linha;
    private int coluna;

    public boolean getEstaBombardeado(){
        return this.estaBombardeado;
    }

    public void setBombardeado(String simbolo){
        this.celula = simbolo;
        this.estaBombardeado = true;
    }

    public void setLinha(int linha){
        this.linha = linha;
    }

    public void setColuna(int coluna){
        this.coluna = coluna;
    }

    public int getLinha(){
        return this.linha;
    }

    public int getColuna(){
        return this.coluna;
    }
}
