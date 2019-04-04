package excercise;

import java.util.*;

import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPDR;


public class Excercise1 implements ProblemaPDR<List<Integer>, Integer, Excercise1>{
								//Solution type, type, Class' name

	private Integer position;
	private List<Integer> list;
	
	public static Excercise1 create(List<Integer> list) {
		return new Excercise1(list);
	}
	
	public Excercise1 clone() {
		Excercise1 newProblem = new Excercise1(this.list);
		return newProblem;
	}
	
	private Excercise1( List<Integer> list) {
		super();
		this.position = 0;
		this.list = list;
	}

	@Override
	public Tipo getTipo() {
		//We have to minimize the number of jumpings
		return Tipo.Min;
	}

	@Override
	public int size() {
		
		return this.list.size() - (position+1);
	}

	@Override
	public boolean esCasoBase() {
		//The last item of the list
		return ((this.list.size()-1)==this.position);
	}

	@Override
	public Sp<Integer> getSolucionParcialCasoBase() {

		return Sp.create(0, 0.);
	}

	@Override
	public Excercise1 getSubProblema(Integer a) {
		Excercise1 newProblem = this.clone();
		newProblem.position = this.position + a;
		return newProblem;
	}

	@Override
	public Sp<Integer> getSolucionParcialPorAlternativa(Integer a, Sp<Integer> s) {
		
		return Sp.create(a, s.propiedad + 1);
	}

	@Override
	public List<Integer> getAlternativas() {
		List<Integer> sol = new ArrayList<Integer>();
		if(this.list.get(position)!=0) {
			for(int i = 1;i<= this.list.get(this.position);i++) {
				if(this.position + i == this.list.size()){
					break;
				}
				sol.add(i);
			}
		}
		return sol;
	}

	@Override
	public List<Integer> getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		return new ArrayList<Integer>();
	}

	@Override
	public List<Integer> getSolucionReconstruidaCasoRecursivo(Sp<Integer> sp, List<Integer> s) {
		// The method is calling itself getting several choices
		s.add(0, sp.alternativa);
		return s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		Excercise1 other = (Excercise1) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}
	
	
	

}
