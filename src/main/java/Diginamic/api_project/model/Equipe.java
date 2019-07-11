package Diginamic.api_project.model;

/**
 * représente une équipe pokemon
 * 
 * @author Kevin.s
 *
 */
public class Equipe {

	/** id : Integer */
	Integer id;
	/** pokemon1 : Pokemon */
	private Pokemon pokemon1;
	/** pokemon2 : Pokemon */
	private Pokemon pokemon2;
	/** pokemon3 : Pokemon */
	private Pokemon pokemon3;
	/** pokemon4 : Pokemon */
	private Pokemon pokemon4;
	/** pokemon5 : Pokemon */
	private Pokemon pokemon5;
	/** pokemon6 : Pokemon */
	private Pokemon pokemon6;

	/**
	 * Constructeur
	 * 
	 */
	public Equipe() {
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param pokemon1
	 * @param pokemon2
	 * @param pokemon3
	 * @param pokemon4
	 * @param pokemon5
	 * @param pokemon6
	 */
	public Equipe(Integer id, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4, Pokemon pokemon5,
			Pokemon pokemon6) {
		super();
		this.id = id;
		this.pokemon1 = pokemon1;
		this.pokemon2 = pokemon2;
		this.pokemon3 = pokemon3;
		this.pokemon4 = pokemon4;
		this.pokemon5 = pokemon5;
		this.pokemon6 = pokemon6;
	}

	@Override
	public String toString() {
		return "Equipe " + id + " [" + pokemon1.getNom() + " " + pokemon2.getNom() + " " + pokemon3.getNom() + " "
				+ pokemon4.getNom() + " " + pokemon5.getNom() + " " + pokemon6.getNom() + "]";
	}

	/**
	 * Getter
	 * 
	 * @return the pokemon1
	 */
	public Pokemon getPokemon1() {
		return pokemon1;
	}

	/**
	 * Setters
	 * 
	 * @param pokemon1
	 *            the pokemon1 to set
	 */
	public void setPokemon1(Pokemon pokemon1) {
		this.pokemon1 = pokemon1;
	}

	/**
	 * Getter
	 * 
	 * @return the pokemon2
	 */
	public Pokemon getPokemon2() {
		return pokemon2;
	}

	/**
	 * Setters
	 * 
	 * @param pokemon2
	 *            the pokemon2 to set
	 */
	public void setPokemon2(Pokemon pokemon2) {
		this.pokemon2 = pokemon2;
	}

	/**
	 * Getter
	 * 
	 * @return the pokemon3
	 */
	public Pokemon getPokemon3() {
		return pokemon3;
	}

	/**
	 * Setters
	 * 
	 * @param pokemon3
	 *            the pokemon3 to set
	 */
	public void setPokemon3(Pokemon pokemon3) {
		this.pokemon3 = pokemon3;
	}

	/**
	 * Getter
	 * 
	 * @return the pokemon4
	 */
	public Pokemon getPokemon4() {
		return pokemon4;
	}

	/**
	 * Setters
	 * 
	 * @param pokemon4
	 *            the pokemon4 to set
	 */
	public void setPokemon4(Pokemon pokemon4) {
		this.pokemon4 = pokemon4;
	}

	/**
	 * Getter
	 * 
	 * @return the pokemon5
	 */
	public Pokemon getPokemon5() {
		return pokemon5;
	}

	/**
	 * Setters
	 * 
	 * @param pokemon5
	 *            the pokemon5 to set
	 */
	public void setPokemon5(Pokemon pokemon5) {
		this.pokemon5 = pokemon5;
	}

	/**
	 * Getter
	 * 
	 * @return the pokemon6
	 */
	public Pokemon getPokemon6() {
		return pokemon6;
	}

	/**
	 * Setters
	 * 
	 * @param pokemon6
	 *            the pokemon6 to set
	 */
	public void setPokemon6(Pokemon pokemon6) {
		this.pokemon6 = pokemon6;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setters
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
