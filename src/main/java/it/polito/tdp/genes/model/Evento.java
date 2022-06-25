package it.polito.tdp.genes.model;

public class Evento implements Comparable<Evento>{
	
	private int time;
	private Ingegnere ing;
	private Genes g;
	
	public Evento(int time, Ingegnere ing, Genes g) {
		super();
		this.time = time;
		this.ing = ing;
		this.g = g;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Ingegnere getIng() {
		return ing;
	}

	public void setIng(Ingegnere ing) {
		this.ing = ing;
	}

	public Genes getG() {
		return g;
	}

	public void setG(Genes g) {
		this.g = g;
	}

	@Override
	public int compareTo(Evento o) {
		return this.time - o.time;
	}
	
	
	
	
	
	
}
