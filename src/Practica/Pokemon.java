package Practica;

/**
 *
 * @author Denis
 */
public class Pokemon {
    private String nombrePokemon; // validar que sea unico
    private int contadorVida;
    private boolean  estado; //vivo o muerto
    private int contadorAtaque;
    private String imagenPokemon;

    public Pokemon() {
    }

    public Pokemon(String nombrePokemon, int contadorVida, boolean estado, int contadorAtaque, String imagenPokemon) {
        this.nombrePokemon = nombrePokemon;
        this.contadorVida = contadorVida;
        this.estado = estado;
        this.contadorAtaque = contadorAtaque;
        this.imagenPokemon = imagenPokemon;
    }

    public String getNombrePokemon() {
        return nombrePokemon;
    }

    public void setNombrePokemon(String nombrePokemon) {
        this.nombrePokemon = nombrePokemon;
    }

    public int getContadorVida() {
        return contadorVida;
    }

    public void setContadorVida(int contadorVida) {
        this.contadorVida = contadorVida;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getContadorAtaque() {
        return contadorAtaque;
    }

    public void setContadorAtaque(int contadorAtaque) {
        this.contadorAtaque = contadorAtaque;
    }

    public String getImagenPokemon() {
        return imagenPokemon;
    }

    public void setImagenPokemon(String imagenPokemon) {
        this.imagenPokemon = imagenPokemon;
    }

    
}
