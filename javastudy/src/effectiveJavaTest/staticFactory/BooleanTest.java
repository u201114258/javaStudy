package effectiveJavaTest.staticFactory;

import effectiveJavaTest.builder.CSPostGraduateExam;

public class BooleanTest {
	public static void main(String[] args){
		CSPostGraduateExam csexam = new CSPostGraduateExam.
				Builder(1).computerNetworks(30).computerOrganization(20).build();
		System.out.println(csexam.toString());
	}
}
