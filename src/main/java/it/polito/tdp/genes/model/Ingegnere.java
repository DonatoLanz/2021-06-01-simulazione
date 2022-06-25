package it.polito.tdp.genes.model;

public class Ingegnere {

	private int id;
	private Genes gene;
	
	public Ingegnere(int id, Genes gene) {
		super();
		this.id = id;
		this.gene = gene;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Genes getGene() {
		return gene;
	}

	public void setGene(Genes gene) {
		this.gene = gene;
	}
	
	
	
}
