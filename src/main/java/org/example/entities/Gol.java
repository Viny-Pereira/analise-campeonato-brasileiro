package org.example.entities;

public class Gol {
    private String idPartida;
    private String atleta;
    private String tipoDeGol;

    public Gol() {
    }

    public Gol(String idPartida, String atleta, String tipoDeGol) {
        this.idPartida = idPartida;
        this.atleta = atleta;
        this.tipoDeGol = tipoDeGol;
    }

    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    public String getAtleta() {
        return atleta;
    }

    public void setAtleta(String atleta) {
        this.atleta = atleta;
    }

    public String getTipoDeGol() {
        return tipoDeGol;
    }

    public void setTipoDeGol(String tipoDeGol) {
        this.tipoDeGol = tipoDeGol;
    }

    @Override
    public String toString() {
        return "Gol{" +
                "idPartida='" + idPartida + '\'' +
                ", atleta='" + atleta + '\'' +
                ", tipoDeGol='" + tipoDeGol + '\'' +
                '}';
    }
}
