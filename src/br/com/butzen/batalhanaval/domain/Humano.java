package br.com.butzen.batalhanaval.domain;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Humano extends Jogador {
    public static final int tamanhoDoTabuleiro = 10;

    public Humano(){
        super();
    }

    @Override
    public void venceu() {
        String mensagem = "" +
                "VVVVVVVV           VVVVVVVVEEEEEEEEEEEEEEEEEEEEEENNNNNNNN        NNNNNNNN        CCCCCCCCCCCCCEEEEEEEEEEEEEEEEEEEEEEUUUUUUUU     UUUUUUUU\n" +
                "V::::::V           V::::::VE::::::::::::::::::::EN:::::::N       N::::::N     CCC::::::::::::CE::::::::::::::::::::EU::::::U     U::::::U\n" +
                "V::::::V           V::::::VE::::::::::::::::::::EN::::::::N      N::::::N   CC:::::::::::::::CE::::::::::::::::::::EU::::::U     U::::::U\n" +
                "V::::::V           V::::::VEE::::::EEEEEEEEE::::EN:::::::::N     N::::::N  C:::::CCCCCCCC::::CEE::::::EEEEEEEEE::::EUU:::::U     U:::::UU\n" +
                " V:::::V           V:::::V   E:::::E       EEEEEEN::::::::::N    N::::::N C:::::C       CCCCCC  E:::::E       EEEEEE U:::::U     U:::::U\n" +
                "  V:::::V         V:::::V    E:::::E             N:::::::::::N   N::::::NC:::::C                E:::::E              U:::::D     D:::::U\n" +
                "   V:::::V       V:::::V     E::::::EEEEEEEEEE   N:::::::N::::N  N::::::NC:::::C                E::::::EEEEEEEEEE    U:::::D     D:::::U\n" +
                "    V:::::V     V:::::V      E:::::::::::::::E   N::::::N N::::N N::::::NC:::::C                E:::::::::::::::E    U:::::D     D:::::U\n" +
                "     V:::::V   V:::::V       E:::::::::::::::E   N::::::N  N::::N:::::::NC:::::C                E:::::::::::::::E    U:::::D     D:::::U\n" +
                "      V:::::V V:::::V        E::::::EEEEEEEEEE   N::::::N   N:::::::::::NC:::::C                E::::::EEEEEEEEEE    U:::::D     D:::::U\n" +
                "       V:::::V:::::V         E:::::E             N::::::N    N::::::::::NC:::::C                E:::::E              U:::::D     D:::::U\n" +
                "        V:::::::::V          E:::::E       EEEEEEN::::::N     N:::::::::N C:::::C       CCCCCC  E:::::E       EEEEEE U::::::U   U::::::U\n" +
                "         V:::::::V         EE::::::EEEEEEEE:::::EN::::::N      N::::::::N  C:::::CCCCCCCC::::CEE::::::EEEEEEEE:::::E U:::::::UUU:::::::U\n" +
                "          V:::::V          E::::::::::::::::::::EN::::::N       N:::::::N   CC:::::::::::::::CE::::::::::::::::::::E  UU:::::::::::::UU\n" +
                "           V:::V           E::::::::::::::::::::EN::::::N        N::::::N     CCC::::::::::::CE::::::::::::::::::::E    UU:::::::::UU\n" +
                "            VVV            EEEEEEEEEEEEEEEEEEEEEENNNNNNNN         NNNNNNN        CCCCCCCCCCCCCEEEEEEEEEEEEEEEEEEEEEE      UUUUUUUUU";
        String[] linhas = mensagem.split("\\r?\\n");
        try {
            for (String linha : linhas) {
                System.out.println(linha);
                TimeUnit.MILLISECONDS.sleep(51);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public int setLinha(Scanner sc) {
        int linha = 0;
        boolean ehInteiro = false;
        while (ehInteiro == false) {
            System.out.println("Informe a linha do seu navio:");
            if (sc.hasNextInt()) {
                Integer entrada = getEntrada(sc);
                if (entrada == null) continue;
                linha = entrada;
                ehInteiro = true;
            }
            else if (sc.hasNextLine()) {
                sc.nextLine();
                trataVazio(sc);
            }
        }

        return linha;
    }

    public int setColuna(Scanner sc) {
        int coluna = 0;
        boolean ehInteiro = false;
        while (ehInteiro == false) {
            System.out.println("Informe a coluna do seu navio:");
            if (sc.hasNextInt()) {
                Integer entrada = getEntrada(sc);
                if (entrada == null) continue;
                coluna = entrada;
                ehInteiro = true;
            }
            else if (sc.hasNextLine()) {
                sc.nextLine();
                trataVazio(sc);
            }
        }
        return coluna;
    }

    public int setAtaqueNaLina(Scanner sc) {
        int linha = 0;
        boolean ehInteiro = false;
        while (ehInteiro == false) {
            System.out.println("Informe a linha do navio alvo: ");
            if (sc.hasNextInt()) {
                int tmp = sc.nextInt();
                if((tmp < 0) || (tmp >= tamanhoDoTabuleiro)){
                    System.out.println("Número não está entre 0 e 9!");
                }
                else {
                    linha = tmp;
                    ehInteiro = true;
                }
            }
            else if (sc.hasNextLine()) {
                sc.nextLine();
                trataVazio(sc);
            }
        }

        return linha;
    }

    public int setAtaqueNaColuna(Scanner sc) {
        int coluna = 0;
        boolean ehInteiro = false;
        while (ehInteiro == false) {
            System.out.println("Please enter the column of your target: ");
            if(sc.hasNextInt()){
                int tmp = sc.nextInt();
                if((tmp < 0) || (tmp >= tamanhoDoTabuleiro)){
                    System.out.println("Número não está entre 0 e 9!");
                }
                else {
                    coluna = tmp;
                    ehInteiro = true;
                }
            }
            else if (sc.hasNextLine()) {
                sc.nextLine();
                trataVazio(sc);
            }
        }

        return coluna;
    }

    private Integer getEntrada(Scanner sc) {
        int entrada = sc.nextInt();
        if ((entrada < 0) || (entrada> tamanhoDoTabuleiro-1)) {
            System.out.println("Informe um número entre 0 e 9!");
            return null;
        }
        return entrada;
    }

    private void trataVazio(Scanner sc) {
        int tamanhoDoBuffer = 0;
        try {
            tamanhoDoBuffer = System.in.available();
        } catch (IOException ignored) {
        }
        if (tamanhoDoBuffer > 0) {
            sc.nextLine();
        }

        System.out.println("Só números são aceitos!");
    }
}
