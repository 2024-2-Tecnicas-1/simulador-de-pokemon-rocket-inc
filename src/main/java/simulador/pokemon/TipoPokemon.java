package simulador.pokemon;

public enum TipoPokemon {
    FUEGO,
    AGUA,
    PLANTA,
    VENENO,
    ELECTRICO,
    PSIQUICO,
    ROCA,
    TIERRA,
    VOLADOR,
    NORMAL,
    LUCHA,
    ACERO,
    BICHO,
    HIELO;

    public double calcularFactorMultiplicador(TipoPokemon atacante, TipoPokemon defensor) {
        switch (atacante) {
            case FUEGO:
                switch (defensor) {
                    case AGUA:
                    case ACERO:
                    case FUEGO:
                        return 0.5;
                    case PLANTA:
                    case BICHO:
                    case HIELO:
                        return 2.0;
                    default:
                        return 1.0;
                }
            case AGUA:
                switch (defensor) {
                    case AGUA:
                    case PLANTA:
                        return 0.5;
                    case FUEGO:
                    case ROCA:
                    case TIERRA:
                        return 2.0;
                    default:
                        return 1.0;
                }
            case PLANTA:
                switch (defensor) {
                    case FUEGO:
                    case VOLADOR:
                    case VENENO:
                        return 0.5;
                    case AGUA:
                    case TIERRA:
                        return 2.0;
                    default:
                        return 1.0;
                }
            case ELECTRICO:
                switch (defensor) {
                    case AGUA:
                    case VOLADOR:
                        return 2.0;
                    case TIERRA:
                        return 0.0; // No afecta
                    case ELECTRICO:
                        return 0.5;
                    default:
                        return 1.0;
                }
            case TIERRA:
                switch (defensor) {
                    case AGUA:
                    case PLANTA:
                    case HIELO:
                        return 0.5;
                    case FUEGO:
                    case ROCA:
                    case ELECTRICO:
                        return 2.0;
                    default:
                        return 1.0;
                }
            case VOLADOR:
                switch (defensor) {
                    case LUCHA:
                    case BICHO:
                    case PLANTA:
                        return 2.0;
                    case ELECTRICO:
                    case ROCA:
                        return 0.5;
                    default:
                        return 1.0;
                }
            case LUCHA:
                switch (defensor) {
                    case NORMAL:
                    case ROCA:
                    case HIELO:
                        return 2.0;
                    case PSIQUICO:
                    case VOLADOR:
                        return 0.5;
                    default:
                        return 1.0;
                }
            case PSIQUICO:
                switch (defensor) {
                    case LUCHA:
                    case VENENO:
                        return 2.0;
                    case BICHO:
                    case PSIQUICO:
                        return 0.5;
                    default:
                        return 1.0;
                }
            case ROCA:
                switch (defensor) {
                    case VOLADOR:
                    case FUEGO:
                    case BICHO:
                    case HIELO:
                        return 2.0;
                    case LUCHA:
                    case TIERRA:
                        return 0.5;
                    default:
                        return 1.0;
                }
            case HIELO:
                switch (defensor) {
                    case FUEGO:
                    case LUCHA:
                    case ROCA:
                        return 0.5;
                    case VOLADOR:
                    case TIERRA:
                    case PLANTA:
                        return 2.0;
                    default:
                        return 1.0;
                }
            case ACERO:
                switch (defensor) {
                    case FUEGO:
                    case LUCHA:
                    case TIERRA:
                        return 0.5;
                    case HIELO:
                    case BICHO:
                        return 2.0;
                    default:
                        return 1.0;
                }
            case VENENO:
                switch (defensor) {
                    case PLANTA:
                        return 2.0;
                    case VENENO:
                        return 0.5;
                    default:
                        return 1.0;
                }
            case BICHO:
                switch (defensor) {
                    case FUEGO:
                    case VOLADOR:
                    case ROCA:
                    case LUCHA:
                        return 0.5;
                    case PLANTA:
                        return 2.0;
                    default:
                        return 1.0;
                }
            case NORMAL:
                return 1.0;

            default:
                return 1.0;
        }
    }
}

