package br.com.butzen.batalhanaval;

import br.com.butzen.batalhanaval.domain.Jogo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jogo game = new Jogo(sc);
    }
}
