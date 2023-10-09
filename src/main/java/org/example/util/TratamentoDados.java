package org.example.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TratamentoDados {
    public static LocalDate tratarData(String data) {
// Analise a data no formato específico
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        return LocalDate.parse(data, formatter);
    }


    public static String[] tratarCSV(String[] csv) {
        for (int i = 0; i < csv.length; i++) {
            csv[i] = csv[i].replace("\"", "");
        }
        return csv;
    }

    public static int tratarMinutos(String minutos) {
        if (minutos.contains("+")) {
            int tempo = Integer.parseInt(minutos.split("\\+")[0]);
            int acrescimo = Integer.parseInt(minutos.split("\\+")[1]);
            return tempo + acrescimo;
        } else if (minutos.equals("")) {
            return -1;
        } else {
            return Integer.parseInt(minutos);
        }
    }

}
