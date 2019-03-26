package ejercicio2;



import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;


import tipos.*;
import us.lsi.ag.IndexChromosome;
import us.lsi.ag.IndexProblemAG;
import us.lsi.ag.agchromosomes.BinaryChromosome;



public class Ejercicio2AG implements IndexProblemAG<List<Tarea>> {
	
	
	private  List<Tarea> tareas;
	private  Integer procesadores;
	
	
	public Ejercicio2AG(List<Integer> Tareaes, Integer procesadores, List<Tarea> tareas) {
		
		this.tareas = tareas;
		this.procesadores = procesadores;
	}
	
	
	@Override
	public Integer getObjectsNumber() {
		return tareas.size();
	}


	@Override
	public Double fitnessFunction(IndexChromosome cr) {
		// TODO Auto-generated method stub
		Double k = 0.0;
		Double res = 0.0;
		Integer duracion = 0;
		List<Tarea> l = getSolucion(cr);
		
		for(int i=0;i<l.size();i++) {
		 for(int j= 0; i<procesadores;j++) {
		Tarea t = l.get(i);
		//TODO
			 
		 } 
		 }
		
		
	return res;	
	}


	@Override
	public List<Tarea> getSolucion(IndexChromosome cr) {
		List<Integer> cromo = cr.decode();
		List<Tarea> res = new ArrayList<Tarea>();
		
		for (int i = 0; i < cromo.size(); i++) {
			res.add(tareas.get(cromo.get(i)));
		}
		return res;
	}
	
	
	
	
	
	

	
	

}
