package ejercicio2;

import java.util.*;
import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;




public class Ejercicio2AG implements ValuesInRangeProblemAG<Integer, Map<Integer, List<Tarea>>> {
	
	
	private  List<Tarea> tareas;
	private  Integer numProcesadores;
	
	
	public Ejercicio2AG(List<Tarea> tareas, Integer procesadores) {
		
		this.tareas = tareas;
		this.numProcesadores = procesadores;
	}
	@Override
	public Integer getVariableNumber() {

		return tareas.size();
	}


	@Override
	public Integer getMax(Integer i) {
		// TODO Auto-generated method stub
		return numProcesadores;
	}


	@Override
	public Integer getMin(Integer i) {
		i = 0;
		return i;
	}


	@Override
	public Double fitnessFunction(ValuesInRangeChromosome<Integer> cr) {
		List<Integer> l = cr.decode();
		Integer duracion = 0;
		Integer max = 0;
		
		for(int i=0;i<numProcesadores;i++) {
			
			for(int j =0;j<l.size();j++) {
				if(l.get(j) == i) {
					Integer aux = tareas.get(j).getDuracion();
					duracion = duracion + aux;
					}	
			}
			
		if(duracion>max) {
				max = duracion;
		}
		duracion = 0;
			
		}
		
		Double aux = (double) (this.getMaxTime() - max);
		return aux ;
	}


	private Integer getMaxTime() {
		Integer res = 0;
		for(Tarea t : tareas) {
			res = res + t.getDuracion();
		}
		return res;
	}
	@Override
	public Map<Integer, List<Tarea>> getSolucion(ValuesInRangeChromosome<Integer> cr) {
		//Metodo para poner las tareas en un map
		
		List<Integer> l = cr.decode();
		Map<Integer, List<Tarea>> mapa = new HashMap<Integer, List<Tarea>>();
		
		for(int i = 0; i<l.size();i++) {
			
			Tarea t = tareas.get(i);
			Integer j = l.get(i);
			
				if(mapa.containsKey(j)) {
				List<Tarea> lt = mapa.get(j);
				lt.add(t);
				mapa.put(j, lt);}
				
				else{
					List<Tarea> lt = new ArrayList<Tarea>();
					lt.add(t);
					mapa.put(j, lt);	
				}
			
			
		}
		return mapa;
		
	}
	
	
	
	
	

	
	

}
