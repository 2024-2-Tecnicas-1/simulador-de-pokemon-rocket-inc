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
    HIELO
}
public 

double class calcularFactorMultiplicador 

    (TipoPokemon atacante, TipoPokemon defensor) {
        switch (atacante) {
        case FUEGO:
            switch (defensor) {
                case AGUA:
                case ACERO:
                case FUEGO:
                    return 0.5;
                case PLANTA:
                case ACERO:
                case BICHO:
                case HIELO:
                    return 2.0;
                default:
                    return 1.0;
            }
        case AGUA:
            switch (defensor){
                case AGUA:
                case PLANTA:
                    return 0.5;
                case FUEGO:
                case ROCA:
                case TIERRA;
                return 2.0
                        default:
                            return 1.0;
            }
    }
}
       
