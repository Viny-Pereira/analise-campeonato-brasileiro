package org.example.repository;

import org.example.entities.Gol;
import org.example.entities.Partida;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.util.TratamentoDados.tratarCSV;
import static org.example.util.TratamentoDados.tratarData;

public class PartidasRepository {
    private static List<Partida> partidas = new ArrayList<>();
    private String caminhoArquivo;

    public PartidasRepository() {
        this.caminhoArquivo = "campeonato-brasileiro-full.csv";
    }

    private List<Partida> setPartidas() {
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            while ((line = br.readLine()) != null) {

                String[] partidaString = line.split(csvSplitBy);

                partidaString = tratarCSV(partidaString);

                // Ignora cabeçalho
                if (!partidaString[0].equals("partida_id")) {
                    Partida partida = new Partida();
                    partida.setIdPartida(!partidaString[0].isEmpty() ? (partidaString[0]) : String.valueOf(-1));
                    partida.setMandante(!partidaString[4].isEmpty() ? (partidaString[4]) : String.valueOf(-1));
                    partida.setVisitante(!partidaString[5].isEmpty() ? (partidaString[5]) : String.valueOf(-1));
                    partida.setTimeVencedor(!partidaString[10].isEmpty() ? (partidaString[10]) : String.valueOf(-1));
                    partida.setPlacarMandante(!partidaString[12].isEmpty() ? (partidaString[12]) : String.valueOf(-1));
                    partida.setPlacarVisitante(!partidaString[13].isEmpty() ? (partidaString[13]) : String.valueOf(-1));
                    partida.setEstadoJogo(!partidaString[14].isEmpty() ? (partidaString[14]) : String.valueOf(-1));

                    String data = partidaString[2];

                    partida.setDataJogo(tratarData(data));

                    partidas.add(partida);

                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return partidas;
    }

}
