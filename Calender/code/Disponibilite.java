package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Disponibilite {
	
	private String idCamping;
	private String hebergement;
	private List<Stock> stocks = new ArrayList<Stock>();
	
	public String getIdCamping() {
		return idCamping;
	}
	public String getHebergement() {
		return hebergement;
	}
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setIdCamping(String idCamping) {
		this.idCamping = idCamping;
	}
	public void setHebergement(String hebergement) {
		this.hebergement = hebergement;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
}
