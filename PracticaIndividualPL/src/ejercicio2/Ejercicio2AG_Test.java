package ejercicio2;

import java.util.ArrayList;
import java.util.List;

import ejercicio2.Ejercicio2AG;
import tipos.*;
import us.lsi.ag.IndexChromosome;
import us.lsi.ag.IndexProblemAG;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;
import us.lsi.ag.anuncios.ProblemaAnunciosAG;
import us.lsi.anuncios.datos.DatosAnuncios;
import us.lsi.anuncios.datos.ListaDeAnunciosAEmitir;

public class Ejercicio2AG_Test {

	public static void main(String[] args) {

		getConditions();
		Tarea t0 = new Tarea(5, new ArrayList<Integer>());
		Tarea t1 = new Tarea(4, new ArrayList<Integer>());
		Tarea t2 = new Tarea(6, new ArrayList<Integer>());
		Tarea t3 = new Tarea(3, new ArrayList<Integer>());
		Tarea t4 = new Tarea(2, new ArrayList<Integer>());
		
		List<Tarea> tareas = new ArrayList<Tarea>();
		tareas.add(t0);
		tareas.add(t1);
		tareas.add(t2);
		tareas.add(t3);
		tareas.add(t4);
		
		imprimeSolucion(tareas,1);
	}
	
	private static void imprimeSolucion(List<Tarea> tareas, int i) {
		IndexProblemAG<List<Tarea>> p = new Ejercicio2AG(tareas,i);
		AlgoritmoAG<IndexChromosome> alg = AlgoritmoAG.create(ChromosomeType.IndexPermutation, p);
		
		IndexChromosome sol = alg.getBestChromosome();
		List<Tarea> problemaSol = p.getSolucion(sol);
		
		System.out.println("Solucion : "+problemaSol );
		
		for(int j= 0;j<problemaSol.size();j++) {
			
			System.out.println("Tarea "+j+ "con duracion "+ problemaSol.get(j).getDuracion() +
					"asignada al procesador "+problemaSol.get(j).getProcesador().get(0));
			
		}
		
		
		
	}

	private static void getConditions() {
		AlgoritmoAG.ELITISM_RATE = 0.2;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.8;
		AlgoritmoAG.INITIAL_TIME = 300;
		
		StoppingConditionFactory.NUM_GENERATIONS = 3000;
		StoppingConditionFactory.SOLUTIONS_NUMBER_MIN = 1;
		StoppingConditionFactory.FITNESS_MIN = 0.;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionType.SolutionsNumber;
	}

}
