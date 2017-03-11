
package metrics;


import java.util.List;
import ast.Access;
import ast.ClassObject;
import ast.MethodObject;
import ast.SystemObject;


public class MHF extends DataForHF {
	
	
	int toMethods = 0;
	double methodVisibilty = 0;
	
	public MHF(SystemObject system)
	{
		this.classes = system.getClassObjects();		
		classSizeWithoutContainerClass = (double)classes.size() - 1d;
		for(ClassObject classObject : classes){	 		
			obtainSuperClass(classObject);
			obtainAllPackages(classObject);
			obtainClassMethodVisibility(classObject);
		
		}

	}
	
	private void obtainClassMethodVisibility(ClassObject classObject)
	{
		List<MethodObject> methods = classObject.getMethodList();
		
		for (MethodObject methodObject: methods)
		{			
		    toMethods ++;		    
			Access methodAccess = methodObject.getAccess();
	        String methodType = methodAccess.toString();        
	        methodVisibilty = methodVisibilty + (1d - ((double)countofClassCall(methodType, classObject)/classSizeWithoutContainerClass));		
		
		}	
	}
	private double getMHFValue()
	{
		double MHF = (double)(methodVisibilty/toMethods)*100;
		
		return MHF;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
        sb.append("MHF = ").append(getMHFValue()).append(" %\n");
        return sb.toString();
		
	}
}
	
	


