package ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ejercicio2.Ejercicio2AG;
import tipos.*;

import us.lsi.ag.IndexChromosome;
import us.lsi.ag.IndexProblemAG;
import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;
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
		Tarea t0 = new Tarea(5);
		Tarea t1 = new Tarea(4);
		Tarea t2 = new Tarea(6);
		Tarea t3 = new Tarea(3);
		Tarea t4 = new Tarea(2);
		
		List<Tarea> tareas = new ArrayList<Tarea>();
		tareas.add(t0);
		tareas.add(t1);
		tareas.add(t2);
		tareas.add(t3);
		tareas.add(t4);
		
	
		ValuesInRangeProblemAG<Integer, Map<Integer, List<Tarea>>> problem =
				new Ejercicio2AG(tareas, 2);
		
		AlgoritmoAG<ValuesInRangeChromosome<Integer>> alg = 
				AlgoritmoAG.<ValuesInRangeChromosome<Integer>>create(ChromosomeType.Range, problem);
		alg.ejecuta();
		
		ValuesInRangeChromosome<Integer> bestSolution = alg.getBestChromosome();
		System.out.println("=============================");
		System.out.println("Way :" +problem.getSolucion(bestSolution));
		System.out.println("Cost: "+ problem.fitnessFunction(bestSolution)*-1);
		System.out.println("=================================");}
		
	
	
	
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
