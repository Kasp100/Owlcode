package owly;

public class Classy {
	public String className;
	public String localPackage;
	public Classy[] imports;
	
	public ClassyObject createInstance() {
		ClassyObject createdObject = new ClassyObject();
		createdObject.instanceOf = this;
		return createdObject;
	}
}
