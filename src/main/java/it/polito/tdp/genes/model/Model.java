package it.polito.tdp.genes.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.genes.db.GenesDao;

public class Model {
	
	private Graph<Genes,DefaultWeightedEdge> grafo;
	private GenesDao dao;
	private Map<String,Genes> mapId;
	
	public Model() {
		this.dao = new GenesDao();
		this.mapId = new HashMap<String,Genes>();
	}
	
	public String creaGrafo() {
		this.grafo = new SimpleWeightedGraph<Genes,DefaultWeightedEdge>(DefaultWeightedEdge.class);
		List<Genes> vertici = dao.getGenesEss(this.mapId);
		Graphs.addAllVertices(this.grafo, vertici);
		
		List<Coppia> coppie = dao.getCoppie();
		for(Coppia c : coppie) {
			if(c.getC1()==c.getC2()) {
				Graphs.addEdgeWithVertices(this.grafo, this.mapId.get(c.getG1()), this.mapId.get(c.getG2()), 2*c.getCorr());
			}else {
				Graphs.addEdgeWithVertices(this.grafo, this.mapId.get(c.getG1()), this.mapId.get(c.getG2()), c.getCorr());
			}
		}
		return "Grafo creato con "+this.grafo.vertexSet().size()+" vertici e "+this.grafo.edgeSet().size()+" archi";
	}
	
	
	public List<Genes> getV(){
		List<Genes> v = new LinkedList<>(this.grafo.vertexSet());
		return v;
	}
	
	public List<CoppiaM> getAdiacenti(Genes g){
		
		List<CoppiaM> adiacenti = new LinkedList<>();
		
		for(Genes gg : Graphs.neighborListOf(this.grafo, g)) {
			adiacenti.add(new CoppiaM(gg, this.grafo.getEdgeWeight(this.grafo.getEdge(g, gg))));
		}
		
		Collections.sort(adiacenti);
		
		return adiacenti;
		
		
	}
	
}
