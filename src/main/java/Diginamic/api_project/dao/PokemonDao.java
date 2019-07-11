package Diginamic.api_project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Diginamic.api_project.exception.TechnicalException;
import Diginamic.api_project.model.Equipe;
import Diginamic.api_project.model.Pokemon;
import Diginamic.api_project.utils.ConnectionUtils;
import Diginamic.api_project.utils.UpdateQueryUtils;

/**
 * gère la table équipe dans la bdd
 * 
 * @author Kevin.s
 *
 */
public class PokemonDao {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(PokemonDao.class);

	/**
	 * Constructeur
	 * 
	 */
	public PokemonDao() {
	}

	/**
	 * permet de récuperer l’ensemble des équipe de la bdd
	 * 
	 * @return List<Equipe>
	 */
	public List<Equipe> recupererEquipe() {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Equipe> listeMenu = new ArrayList<Equipe>();

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(
					"select * from equipe");
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				Pokemon pokemon1 = new Pokemon(resultSet.getString("pokemon1"));
				Pokemon pokemon2 = new Pokemon(resultSet.getString("pokemon2"));
				Pokemon pokemon3 = new Pokemon(resultSet.getString("pokemon3"));
				Pokemon pokemon4 = new Pokemon(resultSet.getString("pokemon4"));
				Pokemon pokemon5 = new Pokemon(resultSet.getString("pokemon5"));
				Pokemon pokemon6 = new Pokemon(resultSet.getString("pokemon6"));
				Equipe equipe = new Equipe(id, pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6);
				listeMenu.add(equipe);
			}
			return listeMenu;
		} catch (SQLException e) {
			SERVICE_LOG.error("probleme de selection en base", e);
			throw new TechnicalException("probleme de selection en base", e);

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le resultSet", e);
					throw new TechnicalException("impossible de fermer le resultSet", e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					SERVICE_LOG.error("impossible de fermer le statement", e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}

	}

	/**
	 * ajoute une équipe en bdd
	 * 
	 * @param listePokemon
	 */
	public void ajouterEquipe(List<Pokemon> listePokemon) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO `equipe` (`pokemon1`,`pokemon2`,`pokemon3`,`pokemon4`,`pokemon5`,`pokemon6`) VALUES (");
		sb.append('"').append(listePokemon.get(0).getNom()).append('"').append(',');
		sb.append('"').append(listePokemon.get(1).getNom()).append('"').append(',');
		sb.append('"').append(listePokemon.get(2).getNom()).append('"').append(',');
		sb.append('"').append(listePokemon.get(3).getNom()).append('"').append(',');
		sb.append('"').append(listePokemon.get(4).getNom()).append('"').append(',');
		sb.append('"').append(listePokemon.get(5).getNom()).append('"').append(")");

		UpdateQueryUtils.updateQuery(sb.toString());

	}

	/**
	 * permet de supprimer une équipe de la bdd
	 * 
	 * @param id
	 */
	public void supprimerEquipe(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM `equipe` WHERE `id` = ").append(id);

		UpdateQueryUtils.updateQuery(sb.toString());

	}
}
