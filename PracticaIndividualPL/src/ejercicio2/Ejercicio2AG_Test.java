package ejercicio2;

import java.util.List;

import ejercicio2.Ejercicio2AG;
import tipos.*;
import us.lsi.ag.IndexChromosome;
import us.lsi.ag.IndexProblemAG;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;

public class Ejercicio2AG_Test {

	public static void main(String[] args) {

		getConditions();
		
		// TODO 
		IndexProblemAG<List<Monumento>> problem =
				new Ejercicio2AG("./files/graph.txt");
		AlgoritmoAG<IndexChromosome> alg = 
				AlgoritmoAG.<IndexChromosome>create(ChromosomeType.IndexPermutation, problem);
		alg.ejecuta();
		
		IndexChromosome bestSolution = alg.getBestChromosome();
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
