package ejercicio2;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.jgrapht.Graph;


import tipos.*;
import us.lsi.ag.IndexChromosome;
import us.lsi.ag.IndexProblemAG;
import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.ag.agchromosomes.BinaryChromosome;



public class Ejercicio2AG implements IndexProblemAG<List<Tarea>> {
	
	
	private  List<Tarea> tareas;
	private  Integer procesadores;
	
	
	public Ejercicio2AG(List<Tarea> tareas, Integer procesadores) {
		
		this.tareas = tareas;
		this.procesadores = procesadores;
	}
	
	
	@Override
	public Integer getObjectsNumber() {
		return tareas.size();
	}

	
	private Double restriccionDuracionTareas(List<List<Integer>> duracionProcesadores, Double duracion) {
		Double res = 0.;
		Integer aux= 0;
		for(List<Integer> i : duracionProcesadores) {
			for(int j = 0; j<i.size(); j++) {
				aux = aux + i.get(j);
	
			}
			if(aux>duracion) {
				res = duracion;
			}
		}
		return res;
		
		
	}
	
	private Double restriccionNumeroProcesador(List<Tarea> tareas) {
		Double res = 0.;
		for(Tarea t : tareas) {
			if(t.getProcesador().size()>1) {
				res = res + t.getProcesador().size();
			}
			
		}
		return res;
	}



	
	public Double fitnessFunction(IndexChromosome cr) {
		// TODO Auto-generated method stub
		Double k = 1000000.0;
		Double res = 0.0;
		Double duracion = 0.;
		List<List<Integer>> duracionProcesadores = new ArrayList<List<Integer>>();
		List<Integer> duracionProcesador = new ArrayList<Integer>();
		List<Tarea> l = getSolucion(cr);
	
		for(Tarea t: l) {
			Integer aux = t.getDuracion();
			Integer p = t.getProcesador().get(0);
			duracionProcesador.add(aux);
			duracionProcesadores.add(p, duracionProcesador);
			duracion = duracion +aux;
		 }
		Integer max = 0;
		Integer aux = 0;
		for(int i = 0;i<duracionProcesadores.size(); i++) {
			
			for(int j = 0; j<duracionProcesador.size();j++) {
				aux = aux + duracionProcesador.get(j);	
			}
			if(aux>max) {
				max = aux;
			}	
		}
		
		res = duracion - max;
		
		
		res = -res -k*(Math.pow((restriccionDuracionTareas(duracionProcesadores, duracion)), 2)+
				Math.pow(restriccionNumeroProcesador(l), 2));
		
		
		
	return res;	
	}
	
	public List<Tarea> getSolucion(IndexChromosome cr) {
		List<Integer> cromo = cr.decode();
		List<Tarea> res = new ArrayList<Tarea>();
		
		for (int i = 0; i < cromo.size(); i++) {
			Integer aux = cromo.get(i);
			tareas.get(i).getProcesador().add(aux);
			res.add(tareas.get(i));
		}
		return res;
	}
	
	
	
	
	

	
	

}
