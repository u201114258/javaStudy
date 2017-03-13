package effectiveJavaTest.item8equal;
class Person {
	protected String name;
	protected int age;
	
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	public Person(){
		
	}
	@Override
	public boolean equals(Object o){
		if (o.getClass() != this.getClass())
			return false;
		Person p = (Person)o;
		return name.equals(p.name) && age == p.age;
	}
}
public class Parent extends Person{
//	private String name;
//	private int age;
	private Person sonOrDaughter;

	public Parent(String name,int age,Person sonOrDaughter){
		super(name,age);
		this.sonOrDaughter = sonOrDaughter;
	}
	
	@Override
	public boolean equals(Object o){
		if (o.getClass() != this.getClass())
			return false;
		Parent p = (Parent) o;
		return name.equals(p.name) && age == p.age && sonOrDaughter.equals(p.sonOrDaughter);
	}
}
