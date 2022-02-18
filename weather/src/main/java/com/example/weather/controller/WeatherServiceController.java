package com.example.weather.controller;


import com.example.weather.domain.Ville;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "Swagger2DemoRestController", description = "REST Apis related to Ville Entity!!!!")
@RestController
public class WeatherServiceController {

	private static Map<String, ArrayList<Ville>> villeDB = new HashMap<String, ArrayList<Ville>>();

	static {
		// create static bd
		villeDB = new HashMap<String, ArrayList<Ville>>();

		ArrayList<Ville> lst = new ArrayList<Ville>();
		Ville std = new Ville("Cannes", 6400, "nuageux");
		lst.add(std);
		std = new Ville("Paris", 92000, "pluvieux");
		lst.add(std);

		villeDB.put("France", lst);

		lst = new ArrayList<Ville>();
		std = new Ville("Barcelone", 8000, "soleil");
		lst.add(std);
		std = new Ville("Madrid", 28000, "nuageux");
		lst.add(std);

		villeDB.put("Espagne", lst);

	}


	@ApiOperation(value = "Get meteo in the System ", response = Ville.class, tags = "getWeatherBycity")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })


	///récupération de la météo avec le nom de la ville
	@RequestMapping(value = "/getWeatherDetailsByName/{villeName}", method = RequestMethod.GET)
	public String getWeatherBycity(@PathVariable String villeName) {
		for(String country : villeDB.keySet()){    //liste des pays
			for(Ville city : villeDB.get(country)){
				if(city.getNom().equals(villeName)){
					return city.getMeteo();
				}
			}
		}
		return "Aucune météo trouvée";
	}

	@ApiOperation(value = "Get meteo in the System ", response = Ville.class, tags = "getWeatherByZip")
	///récupération de la météo avec le code postal
	@RequestMapping(value = "/getWeatherDetailsByZip/{zip}", method = RequestMethod.GET)
	public String getWeatherByZip(@PathVariable Integer zip) {
		for (String country : villeDB.keySet()) {
			for (Ville city : villeDB.get(country)) {
				if (city.getCodePostal() == zip) {
					return city.getMeteo();
				}
			}
		}
		return "Aucune météo trouvée";
	}

	@ApiOperation(value = "Get specific Student By Country in the System ", response = Ville.class, tags = "getWeatherByCountry")
	///récupération des météos d'un pays
	@RequestMapping(value = "/getWeatherDetailsByCountry/{pays}", method = RequestMethod.GET)
	public String getWeatherByCountry(@PathVariable String pays) {
		ArrayList<Ville> ville = new ArrayList<Ville>();
		for (String country : villeDB.keySet()) {
			if(country.equals(pays)) {
				ville = villeDB.get(country);
			}
		}
		if(ville.isEmpty()) {
			return "Aucune météo trouvée";
		}
		String weather = "";
		for (Ville v : ville) {
			weather += v.getNom()+"("+v.getMeteo()+"), ";
		}
		return "Météo " +pays+ " : " +weather;
	}

}
