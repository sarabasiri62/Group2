package metrics;

import java.util.ArrayList;
import ast.ClassObject;
import ast.SystemObject;


public class CF {

	double numerator = 0;
	double denominator = 0;
	double cf = 0;
	int tc;
	
	public CF(SystemObject system) {

		ArrayList<ClassObject> classes = new ArrayList<ClassObject>();

		classes.addAll(system.getClassObjects());
		tc = classes.size();
		denominator = tc * tc - tc;

		for (int i = 0; i < tc; i++) {
			ClassObject object_1 = classes.get(i);
			for (int j = 0; j < tc; j++) {
				ClassObject object_2 = classes.get(j);
				
				
				if (!(object_1.equals(object_2)) && object_1.isFriend(object_2.getName())) 
					 numerator ++;
			}
		}
	}

	
	public double getCF() {
			
		cf = 100 * ( numerator / denominator);
		return cf;
		
	}

	 public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("CF = ").append(getCF()).append(" %\n");
	        return sb.toString();
	    }
}
