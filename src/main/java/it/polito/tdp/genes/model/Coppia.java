package it.polito.tdp.genes.model;

public class Coppia {

	private String g1;
	private String g2;
	private int c1;
	private int c2;
	private double corr;
	
	public Coppia(String g1, String g2, int c1, int c2, double corr) {
		super();
		this.g1 = g1;
		this.g2 = g2;
		this.c1 = c1;
		this.c2 = c2;
		this.corr = corr;
	}

	public String getG1() {
		return g1;
	}

	public void setG1(String g1) {
		this.g1 = g1;
	}

	public String getG2() {
		return g2;
	}

	public void setG2(String g2) {
		this.g2 = g2;
	}

	public int getC1() {
		return c1;
	}

	public void setC1(int c1) {
		this.c1 = c1;
	}

	public int getC2() {
		return c2;
	}

	public void setC2(int c2) {
		this.c2 = c2;
	}

	public double getCorr() {
		return corr;
	}

	public void setCorr(double corr) {
		this.corr = corr;
	}

	
	
}
