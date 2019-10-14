package Practica;

import java.util.Scanner;

/**
 *
 * @author Denis
 */
public class Principal {

    public static void main(String[] args) {
        Juego J = new Juego();
        J.CargarImagenes();// carga el arreglo de imagenes de todos los pokemon en memoria
        J.CargaInicial(args); // 
        //J.ObtenerListaPokemon();
        // J.EditarPokemon();
         J.Batallar();
        J.Atacar();
    }
}
