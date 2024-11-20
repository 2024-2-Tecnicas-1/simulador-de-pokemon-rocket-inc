package BusinessLogic;
public class Batalla {
    private Pokemon pokemon1;
    private Pokemon pokemon2;

    public Batalla(Pokemon pokemon1, Pokemon pokemon2) {
        if (pokemon1 == null || pokemon2 == null) {
            
        }
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    public void iniciarBatalla() {
        
        
        while (pokemon1.getVida() > 0 && pokemon2.getVida() > 0) {
            realizarAtaque(pokemon1, pokemon2);
            if (pokemon2.getVida() <= 0) {
                
                break;
            }
            
            realizarAtaque(pokemon2, pokemon1);
            if (pokemon1.getVida() <= 0) {
                
                break;
            }
        }
    }

    private void realizarAtaque(Pokemon atacante, Pokemon defensor) {
        int daño = atacante.atacar(defensor);
        defensor.recibirDaño(daño);
        System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre() + " y causa " + daño + " puntos de daño.");
        System.out.println(defensor.getNombre() + " ahora tiene " + defensor.getVida() + " puntos de salud.");
    }
}

