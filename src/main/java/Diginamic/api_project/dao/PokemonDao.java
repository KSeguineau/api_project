package Diginamic.api_project.dao;

import java.sql.CallableStatement;
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
	 * @param Equipe
	 */
	public void ajouterEquipe(Equipe equipe) {
		/*
		 * StringBuilder sb = new StringBuilder(); sb.
		 * append("INSERT INTO `equipe` (`pokemon1`,`pokemon2`,`pokemon3`,`pokemon4`,`pokemon5`,`pokemon6`) VALUES ("
		 * ); sb.append('"').append(listePokemon.get(0).getNom()).append('"').
		 * append(',');
		 * sb.append('"').append(listePokemon.get(1).getNom()).append('"').
		 * append(',');
		 * sb.append('"').append(listePokemon.get(2).getNom()).append('"').
		 * append(',');
		 * sb.append('"').append(listePokemon.get(3).getNom()).append('"').
		 * append(',');
		 * sb.append('"').append(listePokemon.get(4).getNom()).append('"').
		 * append(',');
		 * sb.append('"').append(listePokemon.get(5).getNom()).append('"').
		 * append(")");
		 * 
		 * UpdateQueryUtils.updateQuery(sb.toString());
		 */

		try {
			String sql = "{call ajout_equipe(?,?,?,?,?,?)}";
			CallableStatement callStmt = ConnectionUtils.getInstance().prepareCall(sql);
			callStmt.setString(1, equipe.getPokemon1().getNom());
			callStmt.setString(2, equipe.getPokemon2().getNom());
			callStmt.setString(3, equipe.getPokemon3().getNom());
			callStmt.setString(4, equipe.getPokemon4().getNom());
			callStmt.setString(5, equipe.getPokemon5().getNom());
			callStmt.setString(6, equipe.getPokemon6().getNom());
			callStmt.execute();
			ConnectionUtils.doCommit();
			callStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

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

	public void editerEquipe(Equipe equipe) {
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(
					"UPDATE equipe SET pokemon1 = ?, pokemon2 = ?,pokemon3 = ?,pokemon4 = ?,pokemon5 = ?,pokemon6 = ?4 WHERE id=?");
			preparedStatement.setString(1, equipe.getPokemon1().getNom());
			preparedStatement.setString(2, equipe.getPokemon2().getNom());
			preparedStatement.setString(3, equipe.getPokemon3().getNom());
			preparedStatement.setString(4, equipe.getPokemon4().getNom());
			preparedStatement.setString(5, equipe.getPokemon5().getNom());
			preparedStatement.setString(6, equipe.getPokemon6().getNom());
			preparedStatement.setInt(7, equipe.getId());
			preparedStatement.executeUpdate();

			ConnectionUtils.doCommit();

		} catch (SQLException e) {
			SERVICE_LOG.error("probleme de selection en base", e);
			throw new TechnicalException("probleme de selection en base", e);

		} finally {

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
}
