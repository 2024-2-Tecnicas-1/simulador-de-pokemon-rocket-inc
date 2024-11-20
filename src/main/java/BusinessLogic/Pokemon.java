package BusinessLogic;

public abstract class Pokemon {
    private String nombre;
    private TipoPokemon tipo;
    private EstadoPokemon estadoActual;
    private int vida;
    private int puntosAtaque;

    public Pokemon(String nombre, TipoPokemon tipo, int vida, int puntosAtaque) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        this.puntosAtaque = puntosAtaque;
        this.estadoActual = EstadoPokemon.NORMAL;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public int getVida() {
        return vida;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public EstadoPokemon getEstadoActual() {
        return estadoActual;
    }

    public void aplicarEstado(EstadoPokemon estado) {
        this.estadoActual = estado;
    }
    public void recibirDaño(int daño) {
        vida -= daño;
        if (vida < 0) {
            vida = 0; 
        }
    }
    public abstract void atacar(int indiceAtaque);
    public abstract void entrenar();

    public void mostrarEfectoDelEstado() {
        if (estadoActual == EstadoPokemon.NORMAL) {
            return;
        }
        switch (estadoActual) {
            case PARALIZADO:
                puntosAtaque = (int) (puntosAtaque * 0.5);
                break;
            case QUEMADO:
                recibirDaño(estadoActual.getDañoPorTurno());
                break;
            case CONGELADO:
                break;
            case VENENO:
                recibirDaño(estadoActual.getDañoPorTurno());
                break;
            case DORMIDO:
                break;
            case CONFUSO:
                break;
            case FURIA:
                puntosAtaque = (int) (puntosAtaque * estadoActual.getModificadorAtaque());
                break;
            default:
                break;
        }
    }
}

