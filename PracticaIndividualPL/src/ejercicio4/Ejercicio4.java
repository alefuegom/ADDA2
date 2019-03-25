package ejercicio4;


import java.util.*;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;


import tipos.*;
import us.lsi.graphs.GraphsReader;

public class Ejercicio4 {


	 static String visitarMonumentos(Graph<Monumento, Tiempo> g, Graph<Monumento, Tiempo> g2, List<Monumento> l) {
		 //Con este método se puede determinar dado un grafo y una lista de monumentos a visitar:
		 //Si los monumentos estan conectados entre si, y si lo están te devuelve la ruta más optima.
		 
		Double tiempo = 0.0;
		List<Monumento> m = new ArrayList<Monumento>();
		ShortestPathAlgorithm<Monumento, Tiempo> gfND = new DijkstraShortestPath<Monumento, Tiempo>(g);
		ShortestPathAlgorithm<Monumento, Tiempo> gfD = new DijkstraShortestPath<Monumento, Tiempo>(g2);
		
		for (int i = 0; i < l.size() - 1; i++) {
			GraphPath<Monumento, Tiempo> rutaND = gfND.getPath(l.get(i), l.get(i + 1));
			GraphPath<Monumento, Tiempo> rutaD = gfD.getPath(l.get(i), l.get(i + 1));
			
			if (rutaND == null) {
				return "No es posible según el grafo de conexiones visitar : " + l.toString();
				}
			
			else if (rutaD == null) {
				return "No es posible según el grafo de precedencias visitar en tal orden : " + l.toString();
				}
			
			else {
				for (Tiempo t : rutaND.getEdgeList()) {
					tiempo = tiempo + t.getMinutos();

					Monumento m1 = t.getM1();
					Monumento m2 = t.getM2();

					if (!m.contains(m1))
						m.add(m1);
					if (!m.contains(m2))
						m.add(m2);
				}
		}


		}
		return "Visita de "+l.toString()+" respetando el orden con menor tiempo + "
				+ "("+ tiempo +" mins): \n"+l.toString() ;
		
		
	}



	static List<Monumento> primerosMonumentos(Graph<Monumento, Tiempo> g2) {
		//Con este método podemos saber que monumentos o vértices no reciben ninguna arista, por lo tanto
		//tienen que ser los primeros en visitarse.
		
		List<Monumento> res = new ArrayList<Monumento>();
		List<Tiempo> tiempos = g2.edgeSet().stream().collect(Collectors.toList());
		List<Monumento> monumentos = g2.vertexSet().stream().collect(Collectors.toList());
		res.addAll(monumentos);
		
		for (Tiempo t : tiempos) {
			if (res.contains(t.getM2())) {
				res.remove(t.getM2());
			}
		}
		return res;
	}


	 static String esConexo(ConnectivityInspector<Monumento, Tiempo> conexo) {
		 //Este método formatea la devolución del método isConnected()
		 
		 if(conexo.isConnected()==false)
			return "NO";
		
		else
		return "SI";
	}

	static Graph<Monumento, Tiempo> uploadGraphNotDirected(String filesName) {
		// Carga un grafo no dirigido a través de un fichero de texto
		 return GraphsReader.newGraph(filesName,
				 					Monumento::create, Tiempo::create,
				 					()->new SimpleWeightedGraph<Monumento, Tiempo>(Monumento::create,Tiempo::create));
	}
	
	 static Graph<Monumento, Tiempo> uploadGraphDirected(String filesName) {
			// Carga un grafo dirigido a través de un fichero de texto
		// TODO Auto-generated method stub
		 return GraphsReader.newGraph(filesName,
				 					Monumento::create, Tiempo::create,
				 					()->new SimpleDirectedGraph<Monumento, Tiempo>(Tiempo.class));
	}
	
	
}
