package it.polito.tdp.genes.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.genes.model.Coppia;
import it.polito.tdp.genes.model.Genes;


public class GenesDao {
	
	public List<Genes> getAllGenes(){
		String sql = "SELECT DISTINCT GeneID, Essential, Chromosome FROM Genes";
		List<Genes> result = new ArrayList<Genes>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Genes genes = new Genes(res.getString("GeneID"), 
						res.getString("Essential"), 
						res.getInt("Chromosome"));
				result.add(genes);
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<Genes> getGenesEss(Map<String,Genes> map){
		String sql = "SELECT g.GeneID,g.Essential,g.Chromosome "
				+ "FROM genes g "
				+ "WHERE g.Essential = 'Essential' "
				+ "GROUP BY g.GeneID ";
		List<Genes> result = new LinkedList<>();
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Genes genes = new Genes(res.getString("GeneID"), 
						res.getString("Essential"), 
						res.getInt("Chromosome"));
				result.add(genes);
				map.put(genes.getGeneId(), genes);
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public List<Coppia> getCoppie(){
		String sql = "SELECT i.GeneID1 as g1, i.GeneID2 as g2,g1.Chromosome as c1,g2.Chromosome as c2, ABS(i.Expression_Corr) as corr "
				+ "FROM interactions i,genes g1, genes g2 "
				+ "WHERE g1.GeneID = i.GeneID1 AND g2.GeneID = i.GeneID2 AND  i.GeneID1 != i.GeneID2 AND i.GeneID1 IN (SELECT g.GeneID "
				+ "                                               FROM genes g "
				+ "                                               WHERE g.Essential = 'Essential' "
				+ "                                               GROUP BY g.GeneID) AND i.GeneID2 IN (SELECT g.GeneID "
				+ "                                               FROM genes g "
				+ "                                               WHERE g.Essential = 'Essential' "
				+ "                                               GROUP BY g.GeneID) "
				+ "GROUP BY i.GeneID1, i.GeneID2                                             ";
				
		List<Coppia> result = new LinkedList<Coppia>();
		
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Coppia c = new Coppia(res.getString("g1"), res.getString("g2"), res.getInt("c1"), res.getInt("c2"), res.getDouble("corr"));
				result.add(c);
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
		
	}


	
}
