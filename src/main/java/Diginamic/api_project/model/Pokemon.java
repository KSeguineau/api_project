package Diginamic.api_project.model;

/**
 * represente un pokemon
 * 
 * @author Kevin.s
 *
 */
public class Pokemon {

	/** id : Integer */
	private Integer id;
	/** nom : String */
	private String nom;

	/**
	 * Constructeur
	 * 
	 */
	public Pokemon() {
	}

	/**
	 * Constructeur
	 * 
	 * @param nom
	 */
	public Pokemon(String nom) {
		super();
		this.nom = nom;
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param nom
	 */
	public Pokemon(Integer id, String nom) {
		this(nom);
		this.id = id;
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

	/**
	 * Getter
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setters
	 * 
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
