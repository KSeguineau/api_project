package Diginamic.api_project.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import Diginamic.api_project.model.Pokemon;

/**
 * permet de récuperer un pokemon depuis l’api pokeapi
 * 
 * @author Kevin.s
 *
 */
public class GetRequest {

	/** USER_AGENT : String */
	private final String USER_AGENT = "Mozilla/5.0";

	/**
	 * request get vers l’api
	 * 
	 * @param numero
	 *            numero du pokemon
	 * @return Pokemon
	 * @throws Exception
	 */
	public Pokemon getPokemonName(Integer numero) throws Exception {

		String url = "https://pokeapi.co/api/v2/pokemon/" + numero + "/";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-Type", "application/json");

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		JsonObject jsonObj = new Gson().fromJson(response.toString(), JsonObject.class);

		Pokemon pokemon = new Pokemon(jsonObj.get("name").getAsString());

		return pokemon;

	}

}