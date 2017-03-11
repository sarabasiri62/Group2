package metrics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ast.ASTReader;
import ast.ClassObject;

public class DataForHF {
	Set<ClassObject> classes;
	Map<String, Integer> packClasses = new HashMap<String, Integer>();
	Map<String, Integer> baseClasses = new HashMap<String, Integer>();
	double classSizeWithoutContainerClass = 0;

	public DataForHF() {
		super();

	}
	protected void obtainAllPackages(ClassObject classObject) {
		String packPath = initClassObject(classObject);

		if (packClasses.containsKey(packPath)) {
			packClasses.put(packPath, packClasses.get(packPath) + 1);

		} else {
			packClasses.put(packPath, 1);

		}

	}

	
	protected int obtainPackageClassCount(ClassObject classObject) {
		
		String packPath = initClassObject(classObject);
		return packClasses.get(packPath);
	}

	
	private String initClassObject(ClassObject classObject) {
		int index = classObject.getIFile().getFullPath().toString()
				.lastIndexOf("/");
		String Path = classObject.getIFile().getFullPath().toString()
				.substring(0, index);
		return Path;
	}

	
	protected int obtainBaseClassCountWithOutPackageBaseClass(
			ClassObject classObject) {
		
		try
		{
		if (baseClasses.containsKey(classObject.getName())) {

			return baseClasses.get(classObject.getName());
		} 
		}
		catch(NullPointerException e)
		{
			return 0;
		}
		return 0;
	}

	
	public void obtainSuperClass(ClassObject classObject){

    	try
    	{
			String packBasePath = initClassObject(classObject);
			
			ClassObject superclassObject = ASTReader.getSystemObject().getClassObject(classObject.getSuperclass().getClassType());
			
			String packSuperPath = initClassObject(superclassObject);
			
			if(!packBasePath.equals(packSuperPath))
			{							
				String superClassName = classObject.getSuperclass().getClassType();								
								
				if(baseClasses.containsKey(superClassName))
				{					
					
					baseClasses.put(superClassName, baseClasses.get(superClassName) + 1);				
				
				}
				else
				{					
					baseClasses.put(superClassName, 1);					
				}	
			}
    	}
			catch(NullPointerException e)
			{
				
			}
			

    	}

	
	protected double countofClassCall(String fieldType, ClassObject classObject) {
		
		String fieldtype = fieldType;
		double count = 0.0;
		count = obtainPackageClassCount(classObject) - 1d;
		if (fieldtype == "") {
			return count;
		} else if (fieldtype == "public") {
			return (double) this.classes.size() - 1d;
		} else if (fieldtype == "private") {
			return 0d;
		} else if (fieldtype == "proteccted") {
			return (count + obtainBaseClassCountWithOutPackageBaseClass(classObject));
		} else
			return 0;
	}
}