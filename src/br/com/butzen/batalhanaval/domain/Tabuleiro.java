package br.com.butzen.batalhanaval.domain;

public class Tabuleiro {
    public static final int tamanhoDoTabuleiro = 10;
    private Celula[][] tabuleiro = new Celula[tamanhoDoTabuleiro][tamanhoDoTabuleiro];

    public Tabuleiro() {
        for (int i = 0; i < tamanhoDoTabuleiro; i++){
            for (int j = 0; j < tamanhoDoTabuleiro; j++){
                this.tabuleiro[i][j] = new Celula();
            }
        }
    }

    public String[][] getTabuleiro(){
        String[][] array = new String[tamanhoDoTabuleiro][tamanhoDoTabuleiro];
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                array[i][j] = this.tabuleiro[i][j].getCelula();
            }
        }

        return array;
    }

    public void setNavio(int x, int y){
        if(this.tabuleiro[x][y].getEstaOcupado() == false){
            this.tabuleiro[x][y].setOcupado();
        }
    }

    public void setTiroCerteiro(int x, int y){
        this.tabuleiro[x][y].setTiroCerteiro();
    }

    public void setTiroNaAgua(int x, int y){ this.tabuleiro[x][y].setTiroNaAgua(); }

    public boolean ehLugarValido(int x, int y){
        int tamanhoDoNavio = 1;
        if ((x >= tamanhoDoTabuleiro) || (x < 0) || (y < 0) || (y >= 10)) {
            return false;
        }
        else {
            if ((x + tamanhoDoNavio - 1) >= tamanhoDoTabuleiro) {
                System.out.println("Navio fora do tabuleiro.");
                return false;
            }
            else {
                for(int i = x; i < x + tamanhoDoNavio; i++) {
                    if (this.tabuleiro[i][y].getEstaOcupado() == true) {
                        System.out.println("Já tem um navio aqui.");
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean jogadaEhValida(int x, int y) {
        if ((x >= tamanhoDoTabuleiro) || (x < 0) || (y < 0) || (y >= tamanhoDoTabuleiro)) {
            return false;
        }
        else if (this.tabuleiro[x][y].getEstaBombardeada() == true) {
            System.out.println("Você já atirou nesta coordenada.");
            return false;
        }

        return true;
    }

    public boolean getEstaAcertado(int x, int y) {
        if((this.tabuleiro[x][y].getEstaOcupado() == true) && (this.tabuleiro[x][y].getEstaBombardeada() == false)) {
            return true;
        }

        return false;
    }
}
