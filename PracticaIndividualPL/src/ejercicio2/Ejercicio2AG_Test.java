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
import us.lsi.ag.agchromosomes.RangeChromosome;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;
import us.lsi.ag.anuncios.ProblemaAnunciosAG;
import us.lsi.anuncios.datos.DatosAnuncios;
import us.lsi.anuncios.datos.ListaDeAnunciosAEmitir;

public class Ejercicio2AG_Test {

	public static void main(String[] args) {

		getConditions();
		Tarea t0 = new Tarea(5,0);
		Tarea t1 = new Tarea(4,1);
		Tarea t2 = new Tarea(6,2);
		Tarea t3 = new Tarea(3,3);
		Tarea t4 = new Tarea(2,4);
		
		List<Tarea> tareas = new ArrayList<Tarea>();
		tareas.add(t0);
		tareas.add(t1);
		tareas.add(t2);
		tareas.add(t3);
		tareas.add(t4);
		
	
		ValuesInRangeProblemAG<Integer, Map<Integer, List<Tarea>>> problem =
				new Ejercicio2AG(tareas, 2);
		
		AlgoritmoAG<RangeChromosome> alg = 
				AlgoritmoAG.<RangeChromosome>create(ChromosomeType.Range, problem);
		alg.ejecuta();
		
		RangeChromosome bestSolution = alg.getBestChromosome();
		System.out.println("=============================");
		System.out.println("Tiempo : "+ problem.fitnessFunction(bestSolution));
		System.out.println("Solucion :" +problem.getSolucion(bestSolution));
		System.out.println("Tiempo : "+ problem.fitnessFunction(bestSolution));
		System.out.println("=================================");}
		
	
	
	
	private static void getConditions() {
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.POPULATION_SIZE = 50;
		
		StoppingConditionFactory.NUM_GENERATIONS = 6000;
		StoppingConditionFactory.SOLUTIONS_NUMBER_MIN = 1;
		StoppingConditionFactory.FITNESS_MIN = 623;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionFactory.StoppingConditionType.SolutionsNumber;
	}

}
