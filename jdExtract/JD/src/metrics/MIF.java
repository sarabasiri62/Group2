package metrics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ast.ClassObject;
import ast.MethodObject;
import ast.SystemObject;

public class MIF {
	
	private int numerator; 
	private int denominator; 
	private SystemObject system;
	
	public MIF(SystemObject system){
		
		this.system = system;
		Set<ClassObject> classes = system.getClassObjects();
		
		for(ClassObject classObject : classes) {
			
			int m = 0;
			m = getMethodsInherited(classObject);
			int n= 0;
			n = getMethodsDeclared(classObject);
			
			numerator = numerator + m;
			denominator = denominator + (m + n);		
		}
	}
	public int getMethodsInherited(ClassObject classObject)
	{
		int m = 0;
				
		List<MethodObject> methods=classObject.getMethodList();
		List<MethodObject> overridingMethods = new ArrayList<MethodObject>();
		List<MethodObject> inheritedMethods =  new ArrayList<MethodObject>();
		ClassObject subClassObject = classObject;
		

		for(MethodObject methodObject : methods){
			
			if(methodObject.overridesMethod()){
				overridingMethods.add(methodObject);
			}
		}
		 while((subClassObject.getSuperclass()!= null) && (system.getClassObject(subClassObject.getSuperclass().getClassType())) != null){
		 
			 ClassObject superClassObject = system.getClassObject(subClassObject.getSuperclass().getClassType());
			 inheritedMethods.addAll(superClassObject.getMethodList());
			 subClassObject=superClassObject;
		 }
		for(MethodObject inheritedMethodObject : inheritedMethods){
			for(MethodObject overridingMethodObject : overridingMethods){
				if(!overridingMethodObject.getSignature().equals(inheritedMethodObject.getSignature())){
					m++;
				}
			}	
		}
		return m;
	}
	public int getMethodsDeclared(ClassObject classObject)
	{
		return classObject.getNumberOfMethods();
	}

	public double getMIF(){

		return 100 * ((double) numerator/ denominator);
				
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
        sb.append("MIF = ").append(getMIF()).append(" %\n");
        return sb.toString();
	}
	
}
