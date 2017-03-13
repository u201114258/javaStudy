package effectiveJavaTest.builder;

public class CSPostGraduateExam {
	//一开始这里没有加private final最好还是加上，使程序更加健壮 原修饰符 static int 
	private final int operationSystem;
	private final int dataStructure;
	private final int computerNetworks;
	private final int computerOrganization;
	//一开始没加public 缺省时默认的访问权限是包级别
	public static class Builder{
		//default value
		private int operationSystem = 0;
		private int dataStructure = 0;
		private int computerNetworks = 0;
		private int computerOrganization = 0;
		
		public Builder(int value){
			this.operationSystem = value;
		}
		
		public Builder operationSystem(int value){
			this.operationSystem = value;
			return this;
		}
		public Builder dataStructure(int value){
			this.dataStructure = value;
			return this;
		}
		public Builder computerNetworks(int value){
			this.computerNetworks = value;
			return this;
		}
		public Builder computerOrganization(int value){
			this.computerOrganization = value;
			return this;
		}
		
		public CSPostGraduateExam build(){
			return new CSPostGraduateExam(this);
		}
	}
	
	private CSPostGraduateExam(Builder builder){
		operationSystem = builder.operationSystem;
		dataStructure = builder.dataStructure;
		computerNetworks = builder.computerNetworks;
		computerOrganization = builder.computerOrganization;
	}
	
	public String toString(){
		StringBuffer str = new StringBuffer("");
		str.append("os =" + this.operationSystem + "\nds = " + this.dataStructure + 
				"\ncn = " + this.computerNetworks + "\nco = " + this.computerOrganization);
		return(str.toString());
	}
}
