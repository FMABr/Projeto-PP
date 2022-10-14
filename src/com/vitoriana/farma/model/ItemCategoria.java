package com.vitoriana.farma.model;

public enum ItemCategoria {
    ALIMENTO, SANEAMENTO, MEDICAMENTO, COSMETICO;

    public static String[] names() {
        String[] names = { ItemCategoria.ALIMENTO.name(), ItemCategoria.SANEAMENTO.name(),
                ItemCategoria.MEDICAMENTO.name(), ItemCategoria.COSMETICO.name(), };

        return names;
    }

    public static ItemCategoria of(String value) {
        return switch (value) {
            case "ALIMENTO" -> ItemCategoria.ALIMENTO;
            case "SANEAMENTO" -> ItemCategoria.SANEAMENTO;
            case "MEDICAMENTO" -> ItemCategoria.MEDICAMENTO;
            case "COSMETICO" -> ItemCategoria.COSMETICO;
            default -> ItemCategoria.MEDICAMENTO;
        };
    }
}
