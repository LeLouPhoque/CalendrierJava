package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) {

		Date aujourdhui = new Date();
		List<ICal> lesCals = new ArrayList<ICal>();
		ObjectMapper mapper = new ObjectMapper();
		Disponibilite dispo = new Disponibilite();

		try {

			File file = new File("C:\\Users\\DEV3\\Desktop\\Calender\\dispo_emplacement_nu.json");
			dispo = mapper.readValue(file, Disponibilite.class);

			String idCamping = dispo.getIdCamping();
			String hebergement = dispo.getHebergement();

			dispo.getStocks().stream().filter(pasDeStock -> pasDeStock.getStock().equals("0")).forEach(stock -> {
				lesCals.add(new ICal(aujourdhui, stock.getDate(), "Reservation de " + idCamping,
						" Tous les emplacements de l'herbergement " + hebergement + " sont pris", "",stock.getDate()));
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Calendries theWriter = new Calendries();
		theWriter.writes("thatworking", lesCals);
	}
}
