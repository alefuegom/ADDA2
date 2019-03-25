package ejercicio2;

import java.util.*;

import us.lsi.lpsolve.solution.*;

public class Ejercicio2PL {
	
	public static int procesadores = 2;
	public static int tareas = 5;
	public static List<Integer> duraciones = new ArrayList<Integer>();
	

	
//	Tareas y procesadores: dada una lista de m tareas, con duraciones d={d1..dm}, y un conjunto
//			de n procesadores, buscar la asignación de tareas a procesadores tal que el tiempo total de ejecución
//			sea mínimo.
//			Como ejemplo concreto, teniendo 2 procesadores p0 y p1, y 5 tareas t0..t4 con duraciones d={5,
//			4, 6, 3, 2}, la solución óptima sería asignar al procesador p0 las tareas t0, t3 y t4 (con duraciones
//			5 + 3 + 2 = 10) y al procesador p1 las tareas t1 y t2 (duraciones 4 + 6 = 10).


	public static void main(String[] args) {
		duraciones.add(5);
		duraciones.add(4);
		duraciones.add(6);
		duraciones.add(3);
		duraciones.add(2);
	
	
		System.out.println("INFORMACIÓN: EL PRIMER NUMERO DESPUES DE LA X SIGNIFICA LA TAREA EN CUESTIÓN, Y EL SEGUNDO NUMERO EL PROCESADOR");
		System.out.println("\nEJEMPLO I: X00 = 1.0 => LA TAREA 0 HA SIDO ASIGNADA AL PROCESADOR 0");
		System.out.println("EJEMPLO II: X00 = 0.0 => LA TAREA 0 NO HA SIDO ASIGNADA AL PROCESADOR 0\n");
		
		
		SolutionPLI s = AlgoritmoPLI.getSolution(getConstraints());
		System.out.println("==SOLUCIÓN GENERADA DESDE ECLIPSE==");
		System.out.println("\nSolucion del problema planteado: " +s.getGoal() +" (unidad de tiempo)");	
		for(int i=0;i<s.getNumVar();i++) {
			System.out.println(s.getName(i)+" = "+s.getSolution()[i]);
		}
		
		System.out.println("\n");
		System.out.println("==SOLUCIÓN TOMADA DESDE FICHERO DE TEXTO==");
		System.out.println("\n");
		
		SolutionPLI a = AlgoritmoPLI.getSolutionFromFile("./ficheros/solucionLineal.txt");
		System.out.println("Solucion del problema planteado: " +a.getGoal() +" (unidad de tiempo)");	
		for(int i=0;i<s.getNumVar();i++) {
			System.out.println(s.getName(i)+" = "+s.getSolution()[i]);}
	



	}
	
	
	public static String getConstraints(){
		Integer durMax = 0;
		for(int i= 0; i<duraciones.size(); i++) {
			durMax = durMax + duraciones.get(i);
		}
		Integer m = tareas;
		Integer n = procesadores;
		List<Integer> d = duraciones;
		Integer size = d.size();
		
		String r = "min: T;"; //Funcion minimo
		r = r+"\n\n";
		
		for (int j = 0; j<n;j++) {
		for(int i = 0; i<size; i++) {
			if(i == size -1) {
				r = r + String.format(" "+duraciones.get(i)+" x%d%d", i,j);
			}else {
			r = r + String.format(" "+duraciones.get(i)+" x%d%d", i,j);
			r = r+ " + " ;}
			
			}	
		
		
		r = r+" <= T";
		r = r+";\n\n";
		}
		
			
		
		for(int i = 0; i<size; i++) {
			for(int j = 0;j<n;j++) {
				if(j == n-1 ) {
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
		for(int i = 0; i<size; i++) {
		for(int j = 0;j<n;j++) {
			if(j==n-1 && i==size-1) {
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
