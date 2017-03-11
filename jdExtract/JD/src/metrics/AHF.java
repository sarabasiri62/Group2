package metrics;

import java.util.List;
import ast.Access;
import ast.ClassObject;
import ast.FieldObject;
import ast.SystemObject;

public class AHF extends DataForHF{
	int attributs = 0;
	double visibilityofAttribute = 0;
	public AHF(SystemObject system)
	{
		this.classes = system.getClassObjects();		
		classSizeWithoutContainerClass = (double)classes.size() - 1d;
		
		for(ClassObject classObject : classes){	 	
			obtainSuperClass(classObject);
			obtainAllPackages(classObject);
			obtainClassAttributeVisibility(classObject);
		}

	}
	private void obtainClassAttributeVisibility(ClassObject classObject)
	{				
		List<FieldObject> attributes = classObject.getFieldList();
		
		for(FieldObject fieldObject: attributes)
		{			
		    attributs ++;		    
		    
			Access fieldAccess = fieldObject.getAccess();
		
	        String fieldType = fieldAccess.toString();        
	       	
            visibilityofAttribute = visibilityofAttribute + (1d - ((double)countofClassCall(fieldType, classObject)/classSizeWithoutContainerClass));		
		
		}	
	}
	
	private double getAhfValue()
	{
		double AHF = (double)(visibilityofAttribute/attributs)*100;
		
		return AHF;	
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
        sb.append("AHF = ").append(getAhfValue()).append(" %\n");
        return sb.toString();		
	}	   
}
	
	


