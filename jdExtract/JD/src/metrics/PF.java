package metrics;

import java.util.List;
import java.util.Set;

import ast.ClassObject;
import ast.MethodObject;
import ast.SystemObject;


public class PF {

	int numerator = 0; 
	int denominator = 0; 
	int m = 0; 
	int n = 0;

	SystemObject systemObject;
	Set<ClassObject> classes;

	public PF(SystemObject system) {

		systemObject = system;
		classes = system.getClassObjects();

		for (ClassObject classObject : classes) {

			numerator = numerator + getOverridingMethods(classObject);
			
			m = getDescendingClasses(classObject);
			n = getNewMethods(classObject);
			
			denominator = denominator + m * n;
		}
	}
	public int getOverridingMethods(ClassObject classObject) {

		int overiddingMethods = 0;
		List<MethodObject> listOfMethods = classObject.getMethodList();

		for (MethodObject methodObject : listOfMethods) {

			if (methodObject.overridesMethod(systemObject)) {
					overiddingMethods++;
			}
		}

		return overiddingMethods;
	}

	public int getDescendingClasses(ClassObject classObject) {

		int descendingClasses = 0;
		for (ClassObject currentClassObject : classes) {
			
			List<String> superClasses = null;
			try {
				superClasses = currentClassObject.getSuperclassList();
				if (superClasses.contains(classObject.getName()))
					descendingClasses++;
			} catch(NullPointerException e) {} 
			
		}

		return descendingClasses;
	}
	
	public int getNewMethods(ClassObject classObject) {

		int newMethods = 0;
		List<MethodObject> listOfMethods = classObject.getMethodList();

		for (MethodObject methodObject : listOfMethods) {

			if (!methodObject.overridesMethod()) {
				newMethods++;
			}
		}

		return newMethods;
	}

	public double getPF() {
		return 100 * ((double) numerator / denominator);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append("PF = ").append(getPF()).append(" %\n");
        return sb.toString();
	}

}
