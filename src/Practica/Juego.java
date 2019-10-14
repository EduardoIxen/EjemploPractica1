package Practica;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Denis
 */
public class Juego {

    public String[] imagenesPokemon = new String[3];
    public Pokemon[] ListaPokemon = new Pokemon[10];
    public Batalla[] LstBatallasJ1 = new Batalla[100];
    public Batalla[] LstBatallasJ2 = new Batalla[100];

    public void CargarImagenes() {
        // en esta parte se agregan todas las imagenes que vayamos a utilizar

        this.imagenesPokemon[0] = "            _  _\n"
                + "           (.)(.)\n"
                + "          /  ()  \\\n"
                + "        _ \\ '--' / _\n"
                + "       { '-`\"\"\"\"`-' }\n"
                + "        `\"/      \\\"`\n"
                + "          \\      /\n"
                + "         _/  /\\  \\_\n"
                + "        {   /  \\   }\n"
                + "         `\"`    `\"`";//imagen 0

        this.imagenesPokemon[1] = ",        ,\n"
                + "                          /(        )`\n"
                + "                          \\ \\___   / |\n"
                + "                          /- _  `-/  '\n"
                + "                         (/\\/ \\ \\   /\\\n"
                + "                         / /   | `    \\\n"
                + "                         O O   ) /    |\n"
                + "                         `-^--'`<     '\n"
                + "                        (_.)  _  )   /\n"
                + "                         `.___/`    /\n"
                + "                           `-----' /\n"
                + "              <----.     __ / __   \\\n"
                + "              <----|====O)))==) \\) /====\n"
                + "              <----'    `--' `.__,' \\\n"
                + "                           |        |\n"
                + "                            \\       /\n"
                + "                       ______( (_  / \\______\n"
                + "                     ,'  ,-----'   |        \\\n"
                + "                     `--{__________)        \\/";//imagen 1

        this.imagenesPokemon[2] = "      _, _,\n"
                + "      .' .' |\n"
                + "     /  /   /\n"
                + "    _|_/__.'\n"
                + "   .'   `\\\n"
                + "  ( ^     \\\n"
                + "   '.__    \\\n"
                + "      _)    '.\n"
                + "  _.-'/       '.\n"
                + " (__.'          \\\n"
                + "  .' .-.         ;\n"
                + " (_.'   \\        |`\\\n"
                + "      .--\\      /   |\n"
                + "     (__.-'    /'--'\n"
                + "       (______(";//imagen 2
    }

    public void CargaInicial(String[] Args) { // Metodo que carga los nombres e imagenes desde parametros que se envian desde linea de comandos
        int Contador = 0;
        for (int i = 0; i < Args.length; i += 2) { //ciclo que recorre el arreglo de argumentos con saltos de 2 en 2
            String NombrePokemon = Args[i];
            int posicionImagen = Integer.parseInt(Args[i + 1]);
            if (posicionImagen < imagenesPokemon.length && Contador < 10) { // valida que los parametros no sea mayor a 10, para no desbordar el arreglo. 
                String Imagen = imagenesPokemon[Integer.parseInt(Args[i + 1])];// obtenemos la imagen de nuestro arreglo imagenesPokemon
                Pokemon ObjetoPokemon = new Pokemon();// instancia a un objeto de tipo pokemon
                ObjetoPokemon.setNombrePokemon(NombrePokemon); // le asignamos en nombre del pokemon para el objeto creado
                ObjetoPokemon.setImagenPokemon(Imagen);// le asignamos la imagenes que tenemos en el arreglo imagenesPokemon
                ObjetoPokemon.setContadorAtaque(GenerarNumeroAleatorio(30, 35));
                ObjetoPokemon.setContadorVida(GenerarNumeroAleatorio(120, 160));
                ListaPokemon[Contador] = ObjetoPokemon; // agregamos el pokemon a la lista de pokemon
                Contador++;// incrementamos el contador por si hay que agregar otro pokemon
            }
        }

    }

    public void ObtenerListaPokemon() {
        for (Pokemon P : ListaPokemon) {// ciclo que recorre la lista de pokemon
            if (P != null) {// validamos que en la lista exista un objeto de tipo pokemon
                System.out.println(P.getNombrePokemon());
                System.out.println(P.getImagenPokemon());
            }
        }
    }

    public int GenerarNumeroAleatorio(int minimo, int maximo) {
        Random r = new Random();
        int Num = r.nextInt(maximo - minimo + 1) + minimo;
        return Num;
    }

    public void EditarPokemon() {
        int ContadorPokemon = -1;
        for (Pokemon P : ListaPokemon) {
            if (P != null) {
                ContadorPokemon++;
                System.out.println(ContadorPokemon + " -- Para Editar " + P.getNombrePokemon());
            }
        }
        System.out.println(ContadorPokemon + 1 + " -- Para Cancelar la edicion ");
        boolean sal = false;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Ingrese el numero de Pokemon a Editar ");
            int pos = in.nextInt();
            if (pos > ContadorPokemon) {
                if ((ContadorPokemon + 1) == pos) {
                    sal = true;
                } else {
                    System.out.println("El pokemon seleccionado no existe");
                }
            } else {
                System.out.println("-----Esta editando el pokemon: " + ListaPokemon[pos].getNombrePokemon() + "-----");
                System.out.println(" Desea editar el nombre del pokemon " + ListaPokemon[pos].getNombrePokemon() + "  ( s/n)");
                if (in.next().equalsIgnoreCase("s")) {
                    System.out.println("Ingrese el nombre: ");
                    String Nombre = in.next();
                    ListaPokemon[pos].setNombrePokemon(Nombre);
                }
                System.out.println(" Desea editar la vida del pokemon " + ListaPokemon[pos].getNombrePokemon() + "  ( s/n )");
                if (in.next().equalsIgnoreCase("s")) {
                    System.out.println("Ingrese la vida: ");
                    int vida = in.nextInt();
                    ListaPokemon[pos].setContadorVida(vida);
                }
                System.out.println(" Desea editar el ataque del pokemon " + ListaPokemon[pos].getNombrePokemon() + "  ( s/n )");
                if (in.next().equalsIgnoreCase("s")) {
                    System.out.println("Ingrese el ataque: ");
                    int ataque = in.nextInt();
                    ListaPokemon[pos].setContadorAtaque(ataque);
                }
                System.out.println("Datos editados Correctamente!!");
                System.out.println("Desea Editar Otro Pokemon? (s/n )");
                if (in.next().equalsIgnoreCase("n")) {
                    sal = false;
                } else {
                    ContadorPokemon = -1;
                    for (Pokemon P : ListaPokemon) {
                        if (P != null) {
                            ContadorPokemon++;
                            System.out.println(ContadorPokemon + " -- Para Editar " + P.getNombrePokemon());
                        }
                    }
                    System.out.println(ContadorPokemon + 1 + " -- Para Cancelar la edicion ");
                }
            }
        } while (!sal);

    }

    public void Batallar() {
        Scanner in = new Scanner(System.in);
        System.out.println("---------Inicio Batalla---------");
        for (int i = 1; i < 3; i++) {
            System.out.println("Ingrese el Nombre del Jugador " + i);
            String Nombre = in.next();
            if (!Nombre.isEmpty()) {
                Batalla ObjetoBatalla = new Batalla();
                ObjetoBatalla.setNombreJugador(Nombre);
                int ContadorPokemon = -1;
                for (Pokemon P : ListaPokemon) {
                    if (P != null) {
                        ContadorPokemon++;
                        System.out.println("   " + ContadorPokemon + " -- Para Seleccionar El pokemon " + P.getNombrePokemon());
                    }
                }
                System.out.println("Seleccione el pokemon 1  Para el jugador " + i);
                int Pokemon1 = in.nextInt();
                if (Pokemon1 > -1 && Pokemon1 < (ContadorPokemon + 1)) {
                    ObjetoBatalla.setPokemon1(ListaPokemon[Pokemon1]);
                }
                System.out.println("Seleccione el pokemon 2  Para el jugador " + i);
                int Pokemon2 = in.nextInt();
                if (Pokemon2 > -1 && Pokemon2 < (ContadorPokemon + 1)) {
                    ObjetoBatalla.setPokemon2(ListaPokemon[Pokemon2]);
                }
                if (i == 1) {// Guardar el la lista de jugador 1
                    int contadorJ1 = 0;
                    for (Batalla B : LstBatallasJ1) {
                        if (B != null) {
                            contadorJ1++;
                        } else {
                            LstBatallasJ1[contadorJ1] = ObjetoBatalla;
                        }
                    }
                } else {// Guardar el la lista de jugador 2
                    int contadorJ2 = 0;
                    for (Batalla B : LstBatallasJ2) {
                        if (B != null) {
                            contadorJ2++;
                        } else {
                            LstBatallasJ2[contadorJ2] = ObjetoBatalla;
                        }
                    }
                }
            }
        }

        System.out.println(PosBatallaActual());
    }

    public int PosBatallaActual() {
        int ContadorBatallas = -1;
        for (Batalla B : LstBatallasJ1) {
            if (B != null) {
                ContadorBatallas++;
            } else {
                return ContadorBatallas;
            }
        }
        return ContadorBatallas;
    }

    public void Atacar() {
        Scanner in = new Scanner(System.in);
        boolean Continuar = true;
        int Turno = GenerarNumeroAleatorio(1, 2);
        int c = 0;
        while (Continuar) {
            c++;
            if (Turno == 1) { // Si es turno del jugador1
                if (LstBatallasJ1[PosBatallaActual()].getPokemon1().getContadorVida() > 0 || LstBatallasJ1[PosBatallaActual()].getPokemon2().getContadorVida() > 0) {
                    System.out.println("**********Turno del Jugador 1: " + LstBatallasJ1[PosBatallaActual()].getNombreJugador() + "*******");
                    System.out.println("Seleccione el Pokemon con el que desea atacar: ");
                    System.out.println("  1) Para Usar " + LstBatallasJ1[PosBatallaActual()].getPokemon1().getNombrePokemon());
                    System.out.println("  2) Para Usar " + LstBatallasJ1[PosBatallaActual()].getPokemon2().getNombrePokemon());
                    int PokemonAtacante = in.nextInt();
                    System.out.println("Seleccione el Pokemon al que desea atacar: ");
                    System.out.println("  1) Para Usar " + LstBatallasJ2[PosBatallaActual()].getPokemon1().getNombrePokemon());
                    System.out.println("  2) Para Usar " + LstBatallasJ2[PosBatallaActual()].getPokemon2().getNombrePokemon());
                    int PokemonAtacado = in.nextInt();
                    System.out.println("Desea Atacar? (S/N)");
                    System.out.println("Pokemon1 J1 " + LstBatallasJ1[PosBatallaActual()].getPokemon1().getNombrePokemon());
                    System.out.println("Pokemon2 J1 " + LstBatallasJ1[PosBatallaActual()].getPokemon2().getNombrePokemon());
                    System.out.println("Vida Pokemon1 J1 " + LstBatallasJ1[PosBatallaActual()].getPokemon1().getContadorVida());
                    System.out.println("Vida Pokemon2 J1 " + LstBatallasJ1[PosBatallaActual()].getPokemon2().getContadorVida());
                    System.out.println("ataque Pokemon1 J1 " + LstBatallasJ1[PosBatallaActual()].getPokemon1().getContadorAtaque());
                    System.out.println("ataque Pokemon2 J1 " + LstBatallasJ1[PosBatallaActual()].getPokemon2().getContadorAtaque());

                    System.out.println("Pokemon1 J2 " + LstBatallasJ2[PosBatallaActual()].getPokemon1().getNombrePokemon());
                    System.out.println("Pokemon2 J2 " + LstBatallasJ2[PosBatallaActual()].getPokemon2().getNombrePokemon());
                    System.out.println("Vida Pokemon1 J2 " + LstBatallasJ2[PosBatallaActual()].getPokemon1().getContadorVida());
                    System.out.println("Vida Pokemon2 J2 " + LstBatallasJ2[PosBatallaActual()].getPokemon2().getContadorVida());
                    System.out.println("ataque Pokemon1 J2 " + LstBatallasJ2[PosBatallaActual()].getPokemon1().getContadorAtaque());
                    System.out.println("ataque Pokemon2 J2 " + LstBatallasJ2[PosBatallaActual()].getPokemon2().getContadorAtaque());
                    if (in.next().equalsIgnoreCase("S")) {
                        // Atacar unicamente restar la vida del pokemon atacante al pokemon atacado
                        if (PokemonAtacado == 1) {
                            int VidaActual = LstBatallasJ2[PosBatallaActual()].getPokemon1().getContadorVida();
                            int VidaAQuitar = 0;
                            if (PokemonAtacante == 1) {
                                VidaAQuitar = LstBatallasJ1[PosBatallaActual()].getPokemon1().getContadorAtaque();
                            } else {
                                VidaAQuitar = LstBatallasJ1[PosBatallaActual()].getPokemon2().getContadorAtaque();
                            }
                            int VidaResultante = VidaActual - VidaAQuitar;
                            LstBatallasJ2[PosBatallaActual()].getPokemon1().setContadorVida(VidaResultante);
                            System.out.println("Ataque exitoso!!!!!!");
                        } else {
                            int VidaActual = LstBatallasJ2[PosBatallaActual()].getPokemon2().getContadorVida();
                            int VidaAQuitar = 0;
                            if (PokemonAtacante == 1) {
                                VidaAQuitar = LstBatallasJ1[PosBatallaActual()].getPokemon1().getContadorAtaque();
                            } else {
                                VidaAQuitar = LstBatallasJ1[PosBatallaActual()].getPokemon2().getContadorAtaque();
                            }
                            int VidaResultante = VidaActual - VidaAQuitar;
                            LstBatallasJ2[PosBatallaActual()].getPokemon2().setContadorVida(VidaResultante);
                            System.out.println("Ataque exitoso!!!!!!");
                        }
                    }
                    System.out.println("Pokemon1 J1 " + LstBatallasJ1[PosBatallaActual()].getPokemon1().getNombrePokemon());
                    System.out.println("Pokemon2 J1 " + LstBatallasJ1[PosBatallaActual()].getPokemon2().getNombrePokemon());
                    System.out.println("Vida Pokemon1 J1 " + LstBatallasJ1[PosBatallaActual()].getPokemon1().getContadorVida());
                    System.out.println("Vida Pokemon2 J1 " + LstBatallasJ1[PosBatallaActual()].getPokemon2().getContadorVida());
                    System.out.println("ataque Pokemon1 J1 " + LstBatallasJ1[PosBatallaActual()].getPokemon1().getContadorAtaque());
                    System.out.println("ataque Pokemon2 J1 " + LstBatallasJ1[PosBatallaActual()].getPokemon2().getContadorAtaque());

                    System.out.println("Pokemon1 J2 " + LstBatallasJ2[PosBatallaActual()].getPokemon1().getNombrePokemon());
                    System.out.println("Pokemon2 J2 " + LstBatallasJ2[PosBatallaActual()].getPokemon2().getNombrePokemon());
                    System.out.println("Vida Pokemon1 J2 " + LstBatallasJ2[PosBatallaActual()].getPokemon1().getContadorVida());
                    System.out.println("Vida Pokemon2 J2 " + LstBatallasJ2[PosBatallaActual()].getPokemon2().getContadorVida());
                    System.out.println("ataque Pokemon1 J2 " + LstBatallasJ2[PosBatallaActual()].getPokemon1().getContadorAtaque());
                    System.out.println("ataque Pokemon2 J2 " + LstBatallasJ2[PosBatallaActual()].getPokemon2().getContadorAtaque());
                    System.out.println("sssssssssssssssss");
                } else {
                    System.out.println("Muerte1");
                    return;
                }
                Turno = 2;
            } else {// Si es turno del jugador2
                if (LstBatallasJ2[PosBatallaActual()].getPokemon1().getContadorVida() > 0 || LstBatallasJ2[PosBatallaActual()].getPokemon2().getContadorVida() > 0) {
                    System.out.println("Atacar2");
                } else {
                    System.out.println("Muerte2");
                    return;
                }
                Turno = 1;
            }
        }
    }

}
