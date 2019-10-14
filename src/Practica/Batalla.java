package Practica;

/**
 *
 * @author Denis
 */
public class Batalla {
    private String NombreJugador;
    private Pokemon Pokemon1;
    private Pokemon Pokemon2;
    private int numeroAtaques;

    public Batalla() {
    }

    public Batalla(String NombreJugador, Pokemon Pokemon1, Pokemon Pokemon2, int numeroAtaques) {
        this.NombreJugador = NombreJugador;
        this.Pokemon1 = Pokemon1;
        this.Pokemon2 = Pokemon2;
        this.numeroAtaques = numeroAtaques;
    }

    public String getNombreJugador() {
        return NombreJugador;
    }

    public void setNombreJugador(String NombreJugador) {
        this.NombreJugador = NombreJugador;
    }

    public Pokemon getPokemon1() {
        return Pokemon1;
    }

    public void setPokemon1(Pokemon Pokemon1) {
        this.Pokemon1 = Pokemon1;
    }

    public Pokemon getPokemon2() {
        return Pokemon2;
    }

    public void setPokemon2(Pokemon Pokemon2) {
        this.Pokemon2 = Pokemon2;
    }

    public int getNumeroAtaques() {
        return numeroAtaques;
    }

    public void setNumeroAtaques(int numeroAtaques) {
        this.numeroAtaques = numeroAtaques;
    }
    
    
}
