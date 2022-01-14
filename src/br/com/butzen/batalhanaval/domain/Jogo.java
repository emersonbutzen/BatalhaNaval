package br.com.butzen.batalhanaval.domain;

import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Jogo {
    private Humano jogadorHumano;
    private Computador jogadorComputador;
    private int tamanhoDoTabuleiro = 10;
    private Tabuleiro humano = new Tabuleiro();
    private Tabuleiro computador = new Tabuleiro();
    private Tabuleiro ataquesDoHumanoNoComputador = new Tabuleiro();
    private Tabuleiro ataquesDoComputadorNoHumano = new Tabuleiro();
    private MostraTabuleiro mostraTabuleiro = new MostraTabuleiro(this.tamanhoDoTabuleiro, this.tamanhoDoTabuleiro);
    private long navioHumano = 10;
    private long navioComputador = 10;

    public Jogo(Scanner sc) {
        jogadorHumano = new Humano();
        jogadorComputador = new Computador();
        this.mostraTabuleiro(humano);
        this.setNavios(sc);
        this.mostraTabuleiro(humano);
        this.setNavioAutomatico(computador, jogadorComputador);
        this.jogar(sc);
    }

    public void setNavios(Scanner sc) {
        while(true) {
            System.out.println("Inserir manualmente os navios? S para 'sim' e N para 'não'.");
            String entrada = sc.nextLine();
            if (entrada.toUpperCase(Locale.ROOT).equals("S")) {
                this.setNavioManual(sc);
                break;
            } else if (entrada.toUpperCase(Locale.ROOT).equals("N")) {
                this.setNavioAutomatico(humano, jogadorHumano);
                break;
            } else {
                System.out.println("Somente S ou N.");
            }
        }
    }

    public void setNavioManual(Scanner sc) {
        int x, y;
        for (int idx = 0; idx < tamanhoDoTabuleiro; idx++) {
            System.out.println(String.format("informe os dados do Navio: %d, ", idx));
            x = jogadorHumano.setLinha(sc);
            y = jogadorHumano.setColuna(sc);
            if (humano.ehLugarValido(x, y) == true) {
                humano.setNavio(x, y);
            }
        }
    }

    public void setNavioAutomatico(Tabuleiro tabuleiro, Jogador jogador) {
        for (int idx = 0; idx < tamanhoDoTabuleiro; idx++) {
            int x = jogador.generateNum();
            int y = jogador.generateNum();
            if(tabuleiro.ehLugarValido(x, y) == true){
                tabuleiro.setNavio(x, y);
            }
        }
    }

    public void jogar(Scanner sc){
        String turno;
        while (true) {
            turno = "humano";
            this.humanoJoga(sc);
            mostraTabuleiro(humano, ataquesDoHumanoNoComputador);
            if (verificaSeVenceu() == true) {
                break;
            }

            turno = "computador";
            this.computadorJoga();
            mostraTabuleiro(humano, ataquesDoHumanoNoComputador);
            if (verificaSeVenceu() == true){
                break;
            }
        }

        this.declaraVencedor(turno);
    }

    public void mostraTabuleiro(Tabuleiro board1) {
        String[][] array1 = board1.getTabuleiro();
        mostraTabuleiro.mostra(array1);
    }

    public void humanoJoga(Scanner sc) {
        boolean movimentoValido = false;
        int x, y;
        try {
            while (movimentoValido == false) {
                x = jogadorHumano.setAtaqueNaLina(sc);
                y = jogadorHumano.setAtaqueNaColuna(sc);
                if (computador.jogadaEhValida(x, y) == true) {
                    if (computador.getEstaAcertado(x, y) == true) {
                        printEEspera("Voce acertou o navio!", 1500);
                        this.navioComputador -= 1;
                        ataquesDoHumanoNoComputador.setTiroCerteiro(x, y);
                        humano.setTiroCerteiro(x, y);
                        computador.setTiroCerteiro(x, y);
                    }
                    else {
                        printEEspera("Você não acertou.", 1500);
                        ataquesDoHumanoNoComputador.setTiroNaAgua(x, y);
                        humano.setTiroNaAgua(x, y);
                        computador.setTiroNaAgua(x, y);
                    }

                    movimentoValido = true;
                }
            }
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public void mostraTabuleiro(Tabuleiro board1, Tabuleiro board2) {
        String[][] array1 = board1.getTabuleiro();
        String[][] array2 = board2.getTabuleiro();
        mostraTabuleiro.mostra(array1, array2);
    }

    public boolean verificaSeVenceu(){
        if ((navioHumano <= 0) || (navioComputador <= 0)) {
            return true;
        }

        return false;
    }

    public void computadorJoga() {
        try {
            boolean movimentoValido = false;
            int x, y;
            int[] movimento;
            while (movimentoValido == false) {
                movimento = jogadorComputador.geraAtaque();
                x = movimento[0];
                y = movimento[1];
                if (humano.jogadaEhValida(x, y) == true) {
                    if (humano.getEstaAcertado(x, y) == true) {
                        String s = String.format("O computador acertou seu navio na posicao %d e %d.\n", x, y);
                        printEEspera(s, 2000);
                        this.navioHumano -= 1;
                        ataquesDoComputadorNoHumano.setTiroCerteiro(x, y);
                        humano.setTiroCerteiro(x, y);
                    }
                    else {
                        printEEspera("O computador perdeu o tiro!", 2000);
                        humano.setTiroNaAgua(x, y);
                        ataquesDoComputadorNoHumano.setTiroNaAgua(x, y);
                    }

                    movimentoValido = true;
                }
            }
        }
        catch(InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void declaraVencedor(String lastTurn) {
        try {
            if (lastTurn.equals("Humano!!!")) {
                jogadorHumano.venceu();
                return;
            }

            printEEspera("Computador!", 2000);
            jogadorComputador.venceu();
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printEEspera(String str, long tempo) throws InterruptedException {
        System.out.println(str);
        TimeUnit.MILLISECONDS.sleep(tempo);
    }
}
