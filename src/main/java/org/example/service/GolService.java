package org.example.service;

import org.example.entities.Gol;
import org.example.repository.GolRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GolService {
    GolRepository golRepository = new GolRepository();

    public GolService() {
    }

    public List<Map.Entry<String, Long>> getJogadorMaisGols() {
        List<Gol> golsFeitos = golRepository.getGols();

        Map<String, Long> listaGolsJogadores = golsFeitos.stream()
                .collect(Collectors.groupingBy(Gol::getAtleta, Collectors.counting()));

        Long maisGols = listaGolsJogadores.values().stream()
                .mapToLong(v -> v)
                .max()
                .orElse(0);
        List<Map.Entry<String, Long>> jogadoresMaisGols = listaGolsJogadores
                .entrySet().stream()
                .filter(entry -> entry.getValue() == maisGols)
                .toList();


        return jogadoresMaisGols;
    }

    public List<Map.Entry<String, Long>> getJogadorMaisGolsPorTipo(String tipoGol) {
        List<Gol> golsFeitos = golRepository.getGols();
        Map<String, Long> listaGolsPorTipo = golsFeitos.stream()
                .filter(gol -> gol.getTipoDeGol().equals(tipoGol))
                .collect(Collectors.groupingBy(Gol::getAtleta, Collectors.counting()));

        Long maisGolsPorTipo = listaGolsPorTipo.values().stream()
                .mapToLong(v -> v)
                .max()
                .orElse(0);

        List<Map.Entry<String, Long>> jogadoresMaisGolsPorTipo = listaGolsPorTipo
                .entrySet().stream()
                .filter(entry -> entry.getValue() == maisGolsPorTipo)
                .toList();
        return jogadoresMaisGolsPorTipo;
    }

    public List<Map.Entry<String, Long>> getJogadorMaisGolsPenalts() {
        return getJogadorMaisGolsPorTipo("Penalty");
    }

    public List<Map.Entry<String, Long>> getJogadorMaisGolsGolsContra() {
        return getJogadorMaisGolsPorTipo("Gol Contra");
    }


}
