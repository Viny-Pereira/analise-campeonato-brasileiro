package org.example.repository;

import org.example.entities.Cartao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.util.TratamentoDados.tratarCSV;

public class CartaoRepository {
    private static List<Cartao> cartoes = new ArrayList<>();
    private String caminhoArquivo;

    public CartaoRepository() {
        this.caminhoArquivo = "campeonato-brasileiro-cartoes.csv";
    }

    private List<Cartao> setCartoes() {
        String line;
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            while ((line = br.readLine()) != null) {

                String[] cartaoString = line.split(csvSplitBy);

                cartaoString = tratarCSV(cartaoString);

                // Ignora cabeçalho
                if (!cartaoString[0].equals("partida_id")) {
                    Cartao cartao = new Cartao();

                    cartao.setIdPartida(!cartaoString[0].isEmpty() ? (cartaoString[0]) : String.valueOf(-1));
                    cartao.setCartao(!cartaoString[3].isEmpty() ? (cartaoString[3]) : String.valueOf(-1));
                    cartao.setAtleta(!cartaoString[4].isEmpty() ? (cartaoString[4]) : String.valueOf(-1));

                    cartoes.add(cartao);
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cartoes;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

}
