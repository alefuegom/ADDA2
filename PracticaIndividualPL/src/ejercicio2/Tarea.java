package ejercicio2;



public class Tarea {
	

	private Integer duracion;	
	private Integer id;
	
	public Tarea(Integer duracion, Integer id) {
		super();
		this.duracion = duracion;
		this.id = id;
	}
	
	public Integer getDuracion() {
		return duracion;
	}
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "t"+this.getId() +" (" + this.getDuracion()+ ")";
	}
	
	
	
	
	
}
