package ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleWeightedGraph;

import tipos.*;

import us.lsi.ag.IndexChromosome;
import us.lsi.graphs.GraphsReader;

public class Ejercicio2AG {
	
	private List<Monumento> monumentos;
	private Graph<Monumento, Tiempo> grafo;
	private static Double PESO_TOTAL;

	public Ejercicio2AG(String g) {
		// TODO Auto-generated constructor stub
		grafo = cargaGrafo(g);
		monumentos = new ArrayList<Monumento>(grafo.vertexSet());
		PESO_TOTAL = grafo.edgeSet().stream().mapToDouble(Tiempo::getMinutos).sum();
	}
	
	private Graph<Monumento, Tiempo> cargaGrafo(String fichero) {
		// TODO Auto-generated method stub
		Supplier<Graph<Monumento, Tiempo>> creator =
				()-> new SimpleWeightedGraph<Monumento,Tiempo>(Monumento::create, Tiempo::create);
		
		return GraphsReader.newGraph(fichero, Monumento::create, Tiempo::create,
				creator, Tiempo::getMinutos);
	}
	
	public Double fitnessFunction(IndexChromosome cr) {
		// If it considered an irreal edge, it will be punished
		List<Monumento> sol = getSolucion(cr);
		return - sumaPeso(sol);
	}
	
	
	public Integer getObjectsNumber() {
		//Primero tengo que saber cuantos Objetos tengo
		return grafo.vertexSet().size();
	}
	
	
	private Double  sumaPeso(List<Monumento> sol) {
		// TODO Auto-generated method stub
		return IntStream.range(0, monumentos.size()-1).boxed().
				mapToDouble(i -> pesoArista(monumentos.get(i), monumentos.get(i+1))).sum();
		
	}

	private Double pesoArista(Monumento m1, Monumento m2) {
		if(grafo.containsEdge(m1,m2)) {
			return grafo.getEdge(m1, m2).getMinutos();
		}else {
			return PESO_TOTAL;
		}
	
	}
	
	public List<Monumento> getSolucion(IndexChromosome cr) {
		// TODO Auto-generated method stub
		List<Integer> chromosome = cr.decode();
		List<Monumento> res = new ArrayList<>();
		for (Integer i : chromosome) {
			res.add(monumentos.get(i));
		}
		res.add(res.get(0));
		
		return res;
	}

}
