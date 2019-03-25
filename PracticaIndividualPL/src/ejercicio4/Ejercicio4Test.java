package ejercicio4;

import java.util.*;

import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.ConnectivityInspector;

import tipos.*;
import ejercicio4.Ejercicio4;

public class Ejercicio4Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<Monumento, Tiempo> gfND = Ejercicio4.uploadGraphNotDirected("./ficheros/Ejercicio4G1.txt");
		
		System.out.println("========APARTADO A ==========");
		ConnectivityInspector<Monumento, Tiempo> conexo =
				new ConnectivityInspector<Monumento,Tiempo>(gfND);
		System.out.println("¿Es el grafo conexo?: " +Ejercicio4.esConexo(conexo));
		System.out.println("Las componentes conexas son : { "+conexo.connectedSets() +" }" );
		
				
		System.out.println("\n==========APARTADO B=============");
		Graph<Monumento, Tiempo> gfD = Ejercicio4.uploadGraphDirected("./ficheros/Ejercicio4G2.txt");
		System.out.println("Sitios que se pueden visitar, sin previamente visitar ninguno: ");
		System.out.println(Ejercicio4.primerosMonumentos(gfD));
		
		System.out.println("\n=============APARTADO C=============");
		List<Monumento> monumentos = gfND.vertexSet().stream().collect(Collectors.toList());
		
		List<Monumento> m1 = new ArrayList<Monumento>();
		m1.add(monumentos.get(5));
		m1.add(monumentos.get(7));
		m1.add(monumentos.get(9));
		System.out.println("\n"+Ejercicio4.visitarMonumentos(gfND,gfD, m1)+"\n");
		
		List<Monumento> m2 = new ArrayList<Monumento>();
		m2.add(monumentos.get(4));
		m2.add(monumentos.get(5));
		m2.add(monumentos.get(6));
		System.out.println(Ejercicio4.visitarMonumentos(gfND,gfD, m2)+"\n");
		
		List<Monumento> m3 = new ArrayList<Monumento>();
		m3.add(monumentos.get(0));
		m3.add(monumentos.get(1));
		m3.add(monumentos.get(2));
		System.out.println(Ejercicio4.visitarMonumentos(gfND,gfD, m3));
		
		
		
		
	}

}
