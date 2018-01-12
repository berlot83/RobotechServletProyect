package com.cognizant.controllers;

public class ControladorJugadores {

	int jugadoresActuales = 0;
	static Jugador[] mesa = new Jugador[5];

	public boolean addJugador(String nombre) {
		boolean add = false;

		Jugador jugador = new Jugador(nombre);
		mesa[jugadoresActuales] = jugador;
		
		/* Agregamos acá los jugadores al array */
		
		if (nombre.equalsIgnoreCase(mesa[jugadoresActuales].getNombre()) && mesa[jugadoresActuales].getNombre() != null) {
			jugadoresActuales++;
			add = true;
		} else {
			add = false;
		}
		return add;
	}

	public static void main(String[] args) {
		ControladorJugadores mj = new ControladorJugadores();
		System.out.println("Agregando a " + mj.addJugador("Marcelo"));
		System.out.println("Agregando a " + mj.addJugador("Batistuta"));
		System.out.println("Agregando a " + mj.addJugador("Verinky"));
		System.out.println("Agregando a " + mj.addJugador("Verinky"));
		System.out.println("Agregando a " + mj.addJugador("Verinky"));

		System.out.println("Esta es la cantidad total al momento: " + mj.jugadoresActuales);

		for (Jugador item : mesa) {
			System.out.println(item.getNombre());
		}
	}

}
