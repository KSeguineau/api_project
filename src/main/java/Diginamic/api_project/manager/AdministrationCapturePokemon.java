package Diginamic.api_project.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Diginamic.api_project.dao.GetRequest;
import Diginamic.api_project.dao.PokemonDao;
import Diginamic.api_project.model.Equipe;
import Diginamic.api_project.model.Pokemon;

/**
 * gère la capture de pokemon
 * 
 * @author Kevin.s
 *
 */
public class AdministrationCapturePokemon {

	/** sc : Scanner */
	Scanner sc = new Scanner(System.in);
	/** getRequest : GetRequest */
	GetRequest getRequest = new GetRequest();
	/** pokemonDao : PokemonDao */
	PokemonDao pokemonDao = new PokemonDao();

	/** listePokemon : List<Pokemon> */
	List<Pokemon> listePokemon = new ArrayList<>();

	/**
	 * Constructeur
	 * 
	 */
	public AdministrationCapturePokemon() {
	}

	/**
	 * gere le menu utilisateur
	 * 
	 * @throws Exception
	 */
	public void gestionInterface() throws Exception {
		boolean continuer = true;

		while (continuer) {
			System.out.println("1 - capture");
			System.out.println("2 - afficher équipe");
			System.out.println("3 - supprimer équipe");
			System.out.println("4 - modifier équipe");
			System.out.println("0 - sortir");

			String choix = sc.nextLine();
			switch (choix) {
			case "1":
				gestionCapture();
				break;
			case "2":
				afficherEquipe();
				break;
			case "3":
				supprimerEquipe();
				break;
			case "4":
				modifierEquipe();
				break;
			default:
				continuer = false;
			}
		}

	}

	/**
	 * permet de modifier une équipe
	 */
	private void modifierEquipe() {
		System.out.println("id:");
		Integer id = Integer.parseInt(sc.nextLine());
		System.out.println("pokemon 1:");
		Pokemon pokemon1 = new Pokemon(sc.nextLine());
		System.out.println("pokemon 2:");
		Pokemon pokemon2 = new Pokemon(sc.nextLine());
		System.out.println("pokemon 3:");
		Pokemon pokemon3 = new Pokemon(sc.nextLine());
		System.out.println("pokemon 4:");
		Pokemon pokemon4 = new Pokemon(sc.nextLine());
		System.out.println("pokemon 5:");
		Pokemon pokemon5 = new Pokemon(sc.nextLine());
		System.out.println("pokemon 6:");
		Pokemon pokemon6 = new Pokemon(sc.nextLine());

		Equipe equipe = new Equipe(id, pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6);
		pokemonDao.editerEquipe(equipe);
	}

	/**
	 * gere le choix de supprimer une équipe
	 */
	private void supprimerEquipe() {
		System.out.println("id:");
		Integer id = Integer.parseInt(sc.nextLine());
		pokemonDao.supprimerEquipe(id);

	}

	/**
	 * affiche les équipes
	 */
	private void afficherEquipe() {
		List<Equipe> listeEquipe = pokemonDao.recupererEquipe();
		listeEquipe.forEach(e -> System.out.println(e.toString()));

	}

	/**
	 * gère la capture et le choix de l’utilisateur
	 * 
	 * @throws Exception
	 */
	public void gestionCapture() throws Exception {

		while (listePokemon.size() < 6) {
			boolean capture = false;
			int numeroPokemon = (int) (Math.random() * 150) + 1;
			Pokemon pokemon = getRequest.getPokemonName(numeroPokemon);

			System.out.println("vous êtes face à un " + pokemon.getNom() + " vous lancer une pokeball");
			capture = Math.random() < 0.5 ? true : false;
			if (capture) {
				System.out.println("vous l’avez capturé, voulez vous le garder? Y/N");
				String rep = sc.nextLine();
				if (rep.equalsIgnoreCase("y")) {
					listePokemon.add(pokemon);
					System.out.println(pokemon.getNom() + " à été ajouté à votre équipe");
					System.out.println();
				}
			} else {
				System.out.println("il s’est enfui");
				System.out.println();
			}
		}
		Equipe equipe = new Equipe(null, listePokemon.get(0), listePokemon.get(1), listePokemon.get(2), listePokemon
				.get(3), listePokemon.get(4), listePokemon.get(5));
		pokemonDao.ajouterEquipe(equipe);
		System.out.println("la chasse est fini, vous pourrez retrouver votre équipe dans le PokeCentre");

	}

}
