package br.com.butzen.batalhanaval.domain;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Computador extends Jogador {

    public static final int tamanhoDoTabuleiro = 9;
    private static Random rand = new Random();

    public Computador() {
        super();
    }

    public int geraLinha() {
        return rand.nextInt(tamanhoDoTabuleiro);
    }

    public int geraColuna() {
        return rand.nextInt(tamanhoDoTabuleiro);
    }

    public int[] geraAtaque() {
        int[] ans = new int[2];
        ans[0] = geraLinha();
        ans[1] = geraColuna();
        return ans;
    }

    @Override
    public void venceu() {
        String mensagem = "" +
                "                                                                        dddddddd                                      \n" +
                "PPPPPPPPPPPPPPPPP                                                       d::::::d                                      \n" +
                "P::::::::::::::::P                                                      d::::::d                                      \n" +
                "P::::::PPPPPP:::::P                                                     d::::::d                                      \n" +
                "PP:::::P     P:::::P                                                    d:::::d                                       \n" +
                "  P::::P     P:::::P    eeeeeeeeeeee    rrrrr   rrrrrrrrr       ddddddddd:::::d     eeeeeeeeeeee    uuuuuu    uuuuuu  \n" +
                "  P::::P     P:::::P  ee::::::::::::ee  r::::rrr:::::::::r    dd::::::::::::::d   ee::::::::::::ee  u::::u    u::::u  \n" +
                "  P::::PPPPPP:::::P  e::::::eeeee:::::eer:::::::::::::::::r  d::::::::::::::::d  e::::::eeeee:::::eeu::::u    u::::u  \n" +
                "  P:::::::::::::PP  e::::::e     e:::::err::::::rrrrr::::::rd:::::::ddddd:::::d e::::::e     e:::::eu::::u    u::::u  \n" +
                "  P::::PPPPPPPPP    e:::::::eeeee::::::e r:::::r     r:::::rd::::::d    d:::::d e:::::::eeeee::::::eu::::u    u::::u  \n" +
                "  P::::P            e:::::::::::::::::e  r:::::r     rrrrrrrd:::::d     d:::::d e:::::::::::::::::e u::::u    u::::u  \n" +
                "  P::::P            e::::::eeeeeeeeeee   r:::::r            d:::::d     d:::::d e::::::eeeeeeeeeee  u::::u    u::::u  \n" +
                "  P::::P            e:::::::e            r:::::r            d:::::d     d:::::d e:::::::e           u:::::uuuu:::::u  \n" +
                "PP::::::PP          e::::::::e           r:::::r            d::::::ddddd::::::dde::::::::e          u:::::::::::::::uu\n" +
                "P::::::::P           e::::::::eeeeeeee   r:::::r             d:::::::::::::::::d e::::::::eeeeeeee   u:::::::::::::::u\n" +
                "P::::::::P            ee:::::::::::::e   r:::::r              d:::::::::ddd::::d  ee:::::::::::::e    uu::::::::uu:::u\n" +
                "PPPPPPPPPP              eeeeeeeeeeeeee   rrrrrrr               ddddddddd   ddddd    eeeeeeeeeeeeee      uuuuuuuu  uuuu";
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
}
