package tipos;

public class Monumento {
	
	private String nombre;
	
	public  static Monumento create() {
		return new Monumento();
	}
	
	public static Monumento create(String s) {
		return new Monumento(s);
	}
	
	public static Monumento create (String[] formato) {
		return new Monumento(formato);
	}
	
	private Monumento(String[] formato){
		super();
		this.nombre = formato[0];}

	private Monumento() {
		this.nombre = "";

	}
	
	private Monumento(String nombre) {
		super();
		this.nombre = nombre;

	}

	public String getNombre() {
		return nombre;
	}
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monumento other = (Monumento) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getNombre();
	}
	
}
