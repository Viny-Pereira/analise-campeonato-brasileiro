package org.example.entities;

public class Cartao {
    private String idPartida;
    private String cartao;
    private String atleta;

    public Cartao() {
    }

    public Cartao(String idPartida, String cartao, String atleta) {
        this.idPartida = idPartida;
        this.cartao = cartao;
        this.atleta = atleta;
    }

    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public String getAtleta() {
        return atleta;
    }

    public void setAtleta(String atleta) {
        this.atleta = atleta;
    }

    @Override
    public String toString() {
        return "Cartoes{" +
                "id='" + idPartida + '\'' +
                ", cartao='" + cartao + '\'' +
                ", atleta='" + atleta + '\'' +
                '}';
    }
}