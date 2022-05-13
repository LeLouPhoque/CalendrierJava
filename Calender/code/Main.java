package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) {

		Date aujourdhui = new Date();
		List<ICal> lesCalendries = new ArrayList<ICal>();
		ObjectMapper mapper = new ObjectMapper();
		Disponibilite Emplacement = new Disponibilite();

		try {

			File file = new File("C:\\Users\\DEV3\\Desktop\\Calender\\dispo_emplacement_nu.json");  // find the .json file
			Emplacement = mapper.readValue(file, Disponibilite.class);

			String idCamping = Emplacement.getIdCamping();
			String hebergement = Emplacement.getHebergement();

			Emplacement.getStocks().stream().filter(pasDeStock -> pasDeStock.getStock().equals("0")).forEach(stock -> {
				lesCalendries.add(new ICal(aujourdhui, Integer.parseInt(stock.getDate()), "Reservation de " + idCamping,
						" Tous les emplacements de l'herbergement " + hebergement + " sont pris", "",Integer.parseInt(stock.getDate())));
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Calendries ecriture = new Calendries();
		ecriture.write("leCalendrie", lesCalendries);
	}
}
