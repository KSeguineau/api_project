package Diginamic.api_project;

import Diginamic.api_project.manager.AdministrationCapturePokemon;

/**
 * point d’entrée de l’appli
 * 
 * @author Kevin.s
 *
 */
public class Main {

	/**
	 * Constructeur
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		AdministrationCapturePokemon adm = new AdministrationCapturePokemon();
		adm.gestionInterface();

	}

}
