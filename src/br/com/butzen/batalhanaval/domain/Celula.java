package br.com.butzen.batalhanaval.domain;

public class Celula {
    private boolean acertado = false;
    private boolean ocupado = false;
    private String navioPosicionado = "N";
    private String tiroCerteiro = "*";
    private String tiroNaAgua = "-";
    private String tiroCerteiroComNavio = "X";
    private String tiroNaAguaComNavio = "n";

    private String celula = "[]";

    public void setOcupado(){
        this.ocupado = true;
        this.celula = navioPosicionado;
    }

    public void setTiroCerteiro() {
        this.acertado = true;
        if (!ocupado){
            this.celula = tiroCerteiro;
        }
        else {
            this.celula = tiroCerteiroComNavio;
        }
    }

    public void setTiroNaAgua(){
        this.acertado = false;
        if (!ocupado){
            this.celula = tiroNaAgua;
        }
        else {
            this.celula = tiroNaAguaComNavio;
        }
    }

    public String getCelula(){
        return this.celula;
    }

    public boolean getEstaOcupado(){
        return this.ocupado;
    }

    public boolean getEstaBombardeada(){
        return this.acertado;
    }
}
