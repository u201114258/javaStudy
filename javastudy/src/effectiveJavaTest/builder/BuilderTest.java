package effectiveJavaTest.builder;

public class BuilderTest {
	public static void main(String[] args){
		CSPostGraduateExam csexam = new CSPostGraduateExam.
				Builder(1).computerNetworks(30).computerOrganization(20).build();
		System.out.println(csexam.toString());
	}
}
