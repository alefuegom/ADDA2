package ejercicio2;

import java.util.*;

import us.lsi.common.Files2;
import us.lsi.lpsolve.solution.*;

public class Ejercicio2PL {
	
	public static int procesadores = 2;
	

	public static void main(String[] args) {
		List<String> s = Files2.getLines("./ficheros/tareasProcesadores.txt");
		List<Integer> tareas = getTareas(s);
		
		System.out.println("INFORMACIÓN: EL PRIMER NUMERO DESPUES DE LA X SIGNIFICA LA TAREA EN CUESTIÓN, Y EL SEGUNDO NUMERO EL PROCESADOR");
		System.out.println("\nEJEMPLO I: X00 = 1.0 => LA TAREA 0 HA SIDO ASIGNADA AL PROCESADOR 0");
		System.out.println("EJEMPLO II: X00 = 0.0 => LA TAREA 0 NO HA SIDO ASIGNADA AL PROCESADOR 0\n");
		
		
		SolutionPLI sol = AlgoritmoPLI.getSolution(getConstraints(tareas, procesadores));
		System.out.println("==SOLUCIÓN GENERADA DESDE ECLIPSE==");
		System.out.println("\nSolucion del problema planteado: " +sol.getGoal() +" (unidad de tiempo)");	
		for(int i=0;i<sol.getNumVar();i++) {
			System.out.println(sol.getName(i)+" = "+sol.getSolution()[i]);
		}
		
		System.out.println("\n");
		System.out.println("==SOLUCIÓN TOMADA DESDE FICHERO DE TEXTO==");
		System.out.println("\n");
		
		SolutionPLI a = AlgoritmoPLI.getSolutionFromFile("./ficheros/solucionLineal.txt");
		System.out.println("Solucion del problema planteado: " +a.getGoal() +" (unidad de tiempo)");	
		for(int i=0;i<a.getNumVar();i++) {
			System.out.println(a.getName(i)+" = "+a.getSolution()[i]);}
	



	}
	

	private static List<Integer> getTareas(List<String> s) {
		List<Integer> res = new ArrayList<Integer>();
		String[] ls = s.get(0).split(",");
		for(String l : ls) {
			Integer aux = Integer.parseInt(l);
			res.add(aux);
		}
		
		
	return res;
}


	public static String getConstraints(List<Integer> tareas, Integer numProcesadores){
		Integer durMax = 0;
		for(int i= 0; i<tareas.size(); i++) {
			durMax = durMax + tareas.get(i);
		}
		
		
		String r = "min: T;"; //Funcion minimo
		r = r+"\n\n";
		
		for (int j = 0; j<numProcesadores;j++) {
		for(int i = 0; i<tareas.size(); i++) {
			if(i == tareas.size() -1) {
				r = r + String.format(" "+tareas.get(i)+" x%d%d", i,j);
			}else {
			r = r + String.format(" "+tareas.get(i)+" x%d%d", i,j);
			r = r+ " + " ;}
			
			}	
		
		
		r = r+" <= T";
		r = r+";\n\n";
		}
		
			
		
		for(int i = 0; i<tareas.size(); i++) {
			for(int j = 0;j<numProcesadores;j++) {
				if(j == numProcesadores-1 ) {
			r = r + String.format("x%d%d",i,j);
			}
				else {
					r = r + String.format("x%d%d + ",i,j);
					
				}
				
			}
			r = r + "= 1;";
			r = r+"\n";
			}
		r = r+"\n";
		
		
		r = r + "T <= "+durMax +";";
		r = r+"\n"+"int T;";
		 r =r+"\n"+ "bin ";
		for(int i = 0; i<tareas.size(); i++) {
		for(int j = 0;j<numProcesadores;j++) {
			if(j==numProcesadores-1 && i==tareas.size()-1) {
				r = r + String.format("x%d%d",i,j );
			}
			else {
				r = r + String.format("x%d%d, ",i,j );
			}
		}
			
		}
		r = r+";";
		
		return r;
}
}
