package ejercicio2;

import java.util.List;

public class Tarea {

	private Integer duracion;	
	private List<Integer> procesador;
	
	public Tarea(Integer duracion, List<Integer> procesador) {
		super();
		this.duracion = duracion;
		this.procesador = procesador;
	}
	
	public Integer getDuracion() {
		return duracion;
	}
	public List<Integer> getProcesador() {
		return procesador;
	}
	
	
	
	
}
