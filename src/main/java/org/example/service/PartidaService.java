package org.example.service;

import org.example.entities.Partida;
import org.example.repository.PartidasRepository;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartidaService {
    PartidasRepository partidasRepository = new PartidasRepository();
    List<Partida> partidas = partidasRepository.getPartidas();

    public List<Map.Entry<String, Long>> getTimeMaisVenceu(int ano) {

        Map<String, Long> listaVitorias = partidas.stream()
                .filter(jogo -> jogo.getDataJogo().getYear() == ano)
                .filter(jogo -> !jogo.getTimeVencedor().equals("-"))
                .collect(Collectors.groupingBy(Partida::getTimeVencedor, Collectors.counting()));

        Long maisVitorias = listaVitorias.values().stream()
                .mapToLong(v -> v)
                .max()
                .orElse(0);


        List<Map.Entry<String, Long>> timesMaisVitorias = listaVitorias
                .entrySet().stream()
                .filter(entry -> entry.getValue() == maisVitorias)
                .toList();

        return timesMaisVitorias;
    }

    public List<Map.Entry<String, Long>> getEstadoMenosJogos() {
        Map<String, Long> listaMandos = partidas.stream()
                .collect(Collectors.groupingBy(Partida::getMandante, Collectors.counting()));

        Long menosMando = listaMandos.values().stream()
                .mapToLong(v -> v)
                .min()
                .orElse(0);

        List<Map.Entry<String, Long>> estadosMenosMandos = listaMandos
                .entrySet().stream()
                .filter(entry -> entry.getValue() == menosMando)
                .toList();

        return estadosMenosMandos;

    }


    public List<Map.Entry<String, Long>> getPlacarPartidaMaisGols() {

        int maxGols = partidas.stream()
                .mapToInt(partida -> Integer.parseInt(partida.getPlacarMandante()) + Integer.parseInt(partida.getPlacarVisitante()))
                .max()
                .orElse(0);


        List<Partida> jogosComMaisGols = partidas.stream()
                .filter(partida -> Integer.parseInt(partida.getPlacarMandante()) + Integer.parseInt(partida.getPlacarVisitante()) == maxGols)
                .toList();


        List<Map.Entry<String, Long>> listaFinal = jogosComMaisGols.stream()
                .map(jogo -> new AbstractMap.SimpleEntry<>(
//                        jogo.getMandante() + " x " + jogo.getVisitante(),
                        jogo.getMandante() + " " + jogo.getPlacarMandante() + " x " + jogo.getPlacarVisitante() + " " + jogo.getVisitante(),
                        Long.valueOf(jogo.getDataJogo().getYear())
                ))
                .collect(Collectors.toList());

        return listaFinal;
    }
}
