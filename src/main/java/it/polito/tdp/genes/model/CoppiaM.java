package it.polito.tdp.genes.model;

public class CoppiaM implements Comparable<CoppiaM>{

	private Genes g;
	private double peso;
	
	public CoppiaM(Genes g, double peso) {
		super();
		this.g = g;
		this.peso = peso;
	}

	public Genes getG() {
		return g;
	}

	public void setG(Genes g) {
		this.g = g;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public int compareTo(CoppiaM o) {
		return (int) -((this.peso*100)-(o.peso*100));
	}
	
	
	
	
}
