package it.polito.tdp.genes.model;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;


public class Simulatore {

	//codaEventi
	private PriorityQueue<Evento> coda;
	
	//parametriIniziali
	private int nIng;
	private Genes geneP;
	
	//output
	private List<Ingegnere> listaIngegneri;
	
	//statoDelMondo
	private Graph<Genes,DefaultWeightedEdge> grafo;
	
	public Simulatore(Graph<Genes,DefaultWeightedEdge> grafo) {
		this.grafo = grafo;
	}
	
	public void init(int nIng, Genes geneP) {
		this.nIng = nIng;
		this.geneP = geneP;
		this.listaIngegneri = new LinkedList<Ingegnere>();
		
		for(int i=0; i<this.nIng; i++) {
			this.listaIngegneri.add(new Ingegnere(i, geneP));
		}
		
		//CaricolaCoda
		this.coda = new PriorityQueue<>();
		for(int i=0; i<this.nIng; i++) {
			this.coda.add(new Evento(1, listaIngegneri.get(i), geneP));
		}
		
	}
	
	public void run() {
		while(!this.coda.isEmpty()) {
			Evento e = this.coda.poll();		
			processEvent(e);
		}
	}

	private void processEvent(Evento e) {
	
		if(e.getTime()<36) { //seNonHoRaggiunto3AnniContinuo
			if(Math.random()<0.3) {
				this.coda.add(new Evento(e.getTime()+1, e.getIng(), e.getG())); //continuoAstudiareLoStessoGene
			}else {
				
			}
		}
		
	}
	
	public Genes geneScelto(Genes g) {
		double caso = Math.random();
		List<Genes> vicini = new LinkedList<>(Graphs.neighborListOf(this.grafo, g));
		double somma = 0.0;
		List<Double> percentuali = new LinkedList<>();
		Genes scelto = null;
		List<Double> percCum = new LinkedList<>();
		
		for(Genes ge : vicini) {
			somma += this.grafo.getEdgeWeight(this.grafo.getEdge(g, ge));
		}
		
		for(Genes ge : vicini) {
			percentuali.add(this.grafo.getEdgeWeight(this.grafo.getEdge(g, ge))/somma);
		}
		
		for(Double p : percentuali) {
			
		}
		
		double cum = 0;
		for(int i=0; i<vicini.size(); i++) {
			if(ca)
		}
		
		return scelto;
	}
	
}
