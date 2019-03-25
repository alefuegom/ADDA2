package tipos;

public class Tiempo {
	
	private Monumento m1;
	private Monumento m2;
	private Double minutos;
	
	public static Tiempo create() {
		return new Tiempo();
	}
	public static Tiempo create(Monumento m1, Monumento m2) {
		return new Tiempo(m1,m2);
	}
	public static Tiempo create(Monumento m1, Monumento m2, Double minutos) {
		return new Tiempo(m1, m2, minutos);
	}
	public static Tiempo create(Monumento m1, Monumento m2, String[] formato) {
		return new Tiempo(m1,m2, formato);
	}
	
	
	private Tiempo(Monumento m1, Monumento m2, String[] formato) {
		this.m1 = m1;
		this.m2 = m2;
		this.minutos = Double.parseDouble(formato[2]);
	}

	
	private Tiempo(Monumento m1, Monumento m2) {
		super();
		this.m1 = m1;
		this.m2 = m2;
		this.minutos = 0.;
	}
	private Tiempo() {
		this.m1 = null;
		this.m2 = null;
		this.minutos = 0.;
	}
	
	private Tiempo(Monumento m1, Monumento m2, Double minutos) {
		super();
		this.m1 = m1;
		this.m2 = m2;
		this.minutos = minutos;
	}

	public Monumento getM1() {
		return m1;
	}

	public Monumento getM2() {
		return m2;
	}

	public Double getMinutos() {
		return minutos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((m1 == null) ? 0 : m1.hashCode());
		result = prime * result + ((m2 == null) ? 0 : m2.hashCode());
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
		Tiempo other = (Tiempo) obj;
		if (m1 == null) {
			if (other.m1 != null)
				return false;
		} else if (!m1.equals(other.m1))
			return false;
		if (m2 == null) {
			if (other.m2 != null)
				return false;
		} else if (!m2.equals(other.m2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getMinutos() + " (minutos)";
	} 
	
	
	
	
}
