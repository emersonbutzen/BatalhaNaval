package br.com.butzen.batalhanaval.domain;

public class MostraTabuleiro {
    private String separador;
    private String espacos = "\t\t\t\t\t\t";
    private int linha;
    private int coluna;

    public MostraTabuleiro(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
        setSeparador(coluna);
    }

    public void mostra(String[][] array) {
        this.mostraCabecalho(this.coluna);
        for (int i = 0; i < this.linha; i++) {
            String numeroDaLinha = String.valueOf(i);
            String tmp = numeroDaLinha + "\t|";
            for (int j = 0; j < this.coluna; j++) {
                if (array[i][j].equals("[]")) {
                    String celulasVazias = String.format("%4s|"," ");
                    tmp += celulasVazias;
                }
                else {
                    String symbol = String.format("%1s%2s%2s|"," ",array[i][j]," ");
                    tmp += symbol;
                }
            }

            System.out.format(tmp+"\n");
            System.out.println(this.separador);
        }

        this.mostraColuna(this.coluna);
    }

    public void mostra(String[][] array1, String[][] array2) {
        String output = String.format("Seu tabuleiro\t     \t     \t     Tabuleiro do Computador");
        System.out.println(output);
        this.mostraCabecalho(this.coluna);
        for(int i=0; i<array1.length; i++) {
            String numeroDaLinha = String.valueOf(i);
            String tmp1 = numeroDaLinha + "\t|";
            String tmp2 = numeroDaLinha + String.format("\t|");
            for(int j=0; j<array1[0].length; j++){
                if(array1[i][j].equals("[]")){
                    String emptyCells = String.format("%4s|"," ");
                    tmp1 += emptyCells;
                } if(array2[i][j].equals("[]")){
                    String emptyCells = String.format("%4s|"," ");
                    tmp2 += emptyCells;
                } if(!array1[i][j].equals("[]")){
                    String symbol = String.format("%1s%2s%2s|"," ",array1[i][j]," ");
                    tmp1 += symbol;
                } if(!array2[i][j].equals("[]")){
                    String symbol = String.format("%1s%2s%2s|"," ",array2[i][j]," ");
                    tmp2 += symbol;
                }
            }

            System.out.format(tmp1+ espacos + tmp2 + "\n");
            System.out.println(this.separador + espacos + this.separador);
        }

        System.out.println(this.mostraColuna(this.coluna) + espacos + this.mostraColuna(this.coluna));
        System.out.println();
    }

    public String mostraColuna(int col) {
        String linhaColuna = String.format("\t|");
        for (int j = 0; j < col; j++) {
            String num = String.valueOf(j);
            linhaColuna += String.format("%1s%2s%2s|"," ",num," ");
        }

        return linhaColuna;
    }

    public void mostraCabecalho(int coluna) {
        String linha = "-------------------------------------------------------";
        String jogador = "                       JOGADOR                         ";
        String tmp = String.format("%4s|", " ");
        for (int i = 0; i < coluna; i++) {
            tmp += String.format("%4s|", " ");
        }

        System.out.format(linha + "\n");
        System.out.format(jogador + "\n");
        System.out.format(linha + "\n");
        System.out.format(tmp + "\n");
        System.out.println(this.separador);
    }

    public void setSeparador(int coluna) {
        String separador = "-----";
        for (int i = 0; i < coluna; i ++) {
            separador += "-----";
        }

        this.separador = separador;
    }
}
