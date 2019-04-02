package ejercicio2;


import java.util.*;
import ejercicio2.Ejercicio2AG;
import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.ag.agchromosomes.*;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.common.Files2;


public class Ejercicio2AG_Test {
	
	public static Integer id =0;

	public static void main(String[] args) {

		getConditions();
		List<String> s = Files2.getLines("./ficheros/tareasProcesadores.txt");
		List<Tarea> tareas = getTareas(s);
		Integer procesadores = getNumProcesadores(s);
		
	
		ValuesInRangeProblemAG<Integer, Map<Integer, List<Tarea>>> problem =
				new Ejercicio2AG(tareas, procesadores);
		
		AlgoritmoAG<RangeChromosome> alg = 
				AlgoritmoAG.<RangeChromosome>create(ChromosomeType.Range, problem);
		alg.ejecuta();
		
		RangeChromosome bestSolution = alg.getBestChromosome();
		System.out.println("=============================");
		System.out.println("Tiempo calculado más optimo : "+ problem.fitnessFunction(bestSolution));
		System.out.println("Asignación de las tareas a los procesadores:" +problem.getSolucion(bestSolution));
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
	
	private static Integer getNumProcesadores(List<String> s) {
		String ls = s.get(0);
		return Integer.parseInt(ls);
	}


	private static List<Tarea> getTareas(List<String> s) {
		List<Tarea> res = new ArrayList<Tarea>();
		String[] ls = s.get(1).split(",");
		for(String l : ls) {
			Tarea aux = new Tarea(Integer.parseInt(l),id);
			id = id+1;
			res.add(aux);
		}
		return res;
		}


}
