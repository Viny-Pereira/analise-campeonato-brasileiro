package org.example.repository;

import org.example.entities.Gol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.util.TratamentoDados.tratarCSV;

public class GolRepository {
    private static List<Gol> gols = new ArrayList<>();
    private String caminhoArquivo;

    public GolRepository() {
        this.caminhoArquivo = "campeonato-brasileiro-gols.csv";
    }

    private List<Gol> setGols() {
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            while ((line = br.readLine()) != null) {

                String[] golString = line.split(csvSplitBy);

                golString = tratarCSV(golString);

                // Ignora cabeçalho
                if (!golString[0].equals("partida_id")) {
                    Gol gol = new Gol();
                    gol.setIdPartida(!golString[0].isEmpty() ? (golString[0]) : String.valueOf(-1));
                    gol.setAtleta(!golString[3].isEmpty() ? (golString[3]) : String.valueOf(-1));
                    gol.setTipoDeGol(!golString[5].isEmpty() ? (golString[5]) : String.valueOf(-1));

                    gols.add(gol);

                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gols;
    }

}
