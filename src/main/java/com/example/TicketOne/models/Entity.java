package com.ticketone.progettoTicketOne.models;

import java.lang.reflect.Method;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Entity {

	private int id;

	@Override
	public String toString() {
		String ris = "{ - " + this.getClass().getSimpleName() + "\n";

		for(Entry<String, String> obj : toMap().entrySet())
			ris += "\n\t" + obj.getKey() + " : " + obj.getValue();

		ris += "\n}";

		return ris;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * Reflection
	 * e' la capacita' di un oggetto di riflettere su stesso, guardare proprieta' e metodi
	 * contenuto in se stesso
	 */

	/**
	 * Il metodo toMap trasforma un Entity in una Mappa
	 * I nomi delle proprieta' saranno le chiavi della mappa
	 * I valori delle proprieta' saranno i valori della mappa
	 */
	public Map<String, String> toMap() {

		// Creiamo una mappa di ritorno
		Map<String, String> ris = new HashMap<String, String>();


		String keyProp = "";
		String valueProp = "";
		boolean check = false;

		// tramite reflection possiamo ciclare sulla lista dei metodi
		// in modo da prenderli uno per uno ed usarli per estrarre il valore della proprieta'

		for(Method m : this.getClass().getMethods()) {
			check = false;

			// qui dentro vediamo tutto di tutti i metodi della classe
			// ma abbiamo bisongo solo dei getter per prenderci ogni valore dell'oggetto

			if(m.getName().startsWith("get") && !"getClass".equals(m.getName())) {
				keyProp = m.getName().substring(3);
				check = true;
			} else if(m.getName().startsWith("is")) {
				keyProp = m.getName().substring(2);
				check = true;
			}

			if(check) {
				// Ora devo prendere il valore della proprieta'
				// lo faccio eseguendo il metodo che sto ciclando 
				try {
					valueProp = m.invoke(this)+""; // this.get
				} catch (Exception e) {
					System.err.println("Errore nel metodo toMap di " + this.getClass().getName());
					e.printStackTrace();
				} 
				ris.put(keyProp, valueProp);
			}

		}

		return ris;
	}

	public Entity fromMap(Map<String, String> param) {

		String nomeProp;
		String valoreProp;

		for(Method m : this.getClass().getMethods()) {

			if(m.getName().startsWith("set")) {

				nomeProp = m.getName().substring(3).toLowerCase();

				if(param.containsKey(nomeProp)) {

					valoreProp = param.get(nomeProp);

					String tipo = m.getParameters()[0].getType().getSimpleName();

					try {
						switch (tipo.toLowerCase()) {
						case "string":
							m.invoke(this, valoreProp);
							break;

						case "int":
							m.invoke(this, Integer.parseInt(valoreProp));
							break;

						case "date":
							m.invoke(this, Date.valueOf(valoreProp));
							break;

						case "boolean"	:
							//Per i boolean dobbiamo pensare a tutti i modi in cui
							//potrebbero arrivare i valori boolean:
							//Dal db ad esempio arrivano 1 e 0
							//Dall'utente potrebbe arrivare si, s�, true, etc.
							m.invoke(this,	valoreProp.equals("1")				||
									valoreProp.equalsIgnoreCase("true")	||
									valoreProp.equalsIgnoreCase("t")	||
									valoreProp.equalsIgnoreCase("vero")	||
									valoreProp.equalsIgnoreCase("v")	||
									valoreProp.equalsIgnoreCase("si")	||
									valoreProp.equalsIgnoreCase("s")	||
									valoreProp.equalsIgnoreCase("s�")	||
									valoreProp.equalsIgnoreCase("y"))	;
							break;

						default:
							System.err.println("Non ho riconosciuto il tipo: " + tipo);
							break;
						}

					}catch (Exception e) {
						System.err.println("Errore nel metodo fromMap di " + this.getClass().getName());
						e.printStackTrace();
					}


				}


			}


		}

		return this;
	}






























}
