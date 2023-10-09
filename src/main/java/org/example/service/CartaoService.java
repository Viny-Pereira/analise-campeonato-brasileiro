package org.example.service;

import org.example.entities.Cartao;
import org.example.repository.CartaoRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CartaoService {
    CartaoRepository cartaoRepository = new CartaoRepository();

    public CartaoService() {
    }

    public List<Map.Entry<String, Long>> getJogadorMaisCartao(String corCartao) {

        List<Cartao> cartoesTotais = cartaoRepository.getCartoes();

        Map<String, Long> cartoesJogador = cartoesTotais.stream()
                .filter(cartao -> cartao.getCartao().equals(corCartao))
                .collect(Collectors.groupingBy(Cartao::getAtleta, Collectors.counting()));

        Long maisCartao = cartoesJogador.values().stream()
                .mapToLong(v -> v)
                .max()
                .orElse(0);

        List<Map.Entry<String, Long>> jogadoresMaisCartao = cartoesJogador.entrySet().stream()
                .filter(jogador -> jogador.getValue() == maisCartao).toList();


        return jogadoresMaisCartao;
    }

    public List<Map.Entry<String, Long>> getJogadorMaisCartaoAmarelo() {
        return getJogadorMaisCartao("Amarelo");
    }

    public List<Map.Entry<String, Long>> getJogadorMaisCartaoVermelho() {
        return getJogadorMaisCartao("Vermelho");
    }
}
