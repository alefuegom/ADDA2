package excercise;

import java.util.Arrays;

import us.lsi.pd.AlgoritmoPD;

public class Test_Excercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlgoritmoPD.isRandomize = false;
		
		Excercise1 problem = Excercise1.create(Arrays.asList(2,0,5,4,1,0));
		//Var: Ask for the type of the variable
		var a= AlgoritmoPD.createPDR(problem);
		a.ejecuta();
		
		if(a.getSolucion() == null) {
			System.out.println("There aren't any solution");
		}
		else {
			System.out.println("Solution: "+a.getSolucion());
			System.out.println("Number of jumpings: "+a.getSolucion().size());
		}
		
	}

}
