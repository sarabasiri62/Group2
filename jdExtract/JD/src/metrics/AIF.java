

package metrics;

import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import ast.ClassObject;
import ast.FieldObject;
import ast.SystemObject;

public class AIF {
	
	private int numerator; 
	private int denominator; 
	private SystemObject system;

	public AIF(SystemObject system) {

		this.system = system;
		Set<ClassObject> classes = system.getClassObjects();

		for (ClassObject classObject : classes) {
			int m = 0; 
			int n = 0; 
			m = getAttributesInherited(classObject);
			n = getAttributesDeclared(classObject);
			numerator = numerator + m;
			denominator = denominator +(m + n);
		}
	}
	public int getAttributesInherited(ClassObject classObject) {
		
		List<FieldObject> attributes = classObject.getFieldList();
		List<FieldObject> inheritedAttributes = new ArrayList<FieldObject>();
		ClassObject subClassObject = classObject;

		while ((subClassObject.getSuperclass() != null)
				&& (system.getClassObject(subClassObject.getSuperclass().getClassType())) != null) {

			ClassObject superClassObject = system.getClassObject(subClassObject
					.getSuperclass().getClassType());
			
			List<FieldObject> superAttributes = superClassObject.getFieldList();

			
			for (FieldObject fieldObject : superAttributes) {
				if (!fieldObject.getAccess().toString().equals("private")) {
					inheritedAttributes.add(fieldObject);
				}
			}
			
			subClassObject = superClassObject;
		}

		int m = inheritedAttributes.size(); 

		
		for (FieldObject fieldObject : attributes) {
			if (inheritedAttributes.contains(fieldObject)) {
				m--;
			}
		}
		return m;
	}
	public int getAttributesDeclared(ClassObject classObject) {
		return classObject.getFieldList().size();
	}
	public double getAIF() {
		return 100 * ((double) numerator / denominator);
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append("AIF = ").append(getAIF()).append(" %\n");
        return sb.toString();
	}
}