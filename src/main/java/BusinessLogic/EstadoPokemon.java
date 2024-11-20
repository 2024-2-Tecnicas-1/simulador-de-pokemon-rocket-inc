package BusinessLogic;

public enum EstadoPokemon {
    NORMAL(0,0),
    PARALIZADO(0, 0.5),     
    QUEMADO(10, 0),         
    CONGELADO(0, 0),        
    VENENO(5, 0),           
    DORMIDO(0, 0),          
    CONFUSO(0, 0),          
    FURIA(0, 1.5);          

    private final int dañoPorTurno; 
    private final double modificadorAtaque;

    EstadoPokemon(int dañoPorTurno, double modificadorAtaque) {
        this.dañoPorTurno = dañoPorTurno;
        this.modificadorAtaque = modificadorAtaque;
    }

    public int getDañoPorTurno() {
        return dañoPorTurno;
    }

    public double getModificadorAtaque() {
        return modificadorAtaque;
    }
}


