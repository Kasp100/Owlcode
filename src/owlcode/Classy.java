package owlcode;

public class Classy {
	public String className;
	
	public OwlyObject createInstance() {
		OwlyObject createdObject = new OwlyObject();
		createdObject.instanceOf = this;
		return createdObject;
	}
}
