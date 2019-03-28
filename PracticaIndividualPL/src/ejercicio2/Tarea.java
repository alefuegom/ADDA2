package ejercicio2;



public class Tarea {
	

	private Integer duracion;	
	private Integer id = 0;
	
	public Tarea(Integer duracion) {
		super();
		this.duracion = duracion;
		this.id = id+1;
	}
	
	public Integer getDuracion() {
		return duracion;
	}
	public Integer getId() {
		return id;
	}
	
	
	
	
}
