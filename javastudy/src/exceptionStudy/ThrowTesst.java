package exceptionStudy;

import java.io.IOException;

public class ThrowTesst {
	public static void main(String[] args) {
//		try{
//			throwChecked(3);
//		}
//		catch (Exception ex){
//			System.out.println(ex.getMessage());
//		}
		throwRuntime(-3);
	}
	public static void throwChecked(int a) throws Exception {
		if (a > 0){
			throw new Exception("a should not bigger than o!");
		}
	}
	public static void throwRuntime(int a){
		if (a > 0){
			throw new RuntimeException("a should not bigger than o!");
		}
	}
}
