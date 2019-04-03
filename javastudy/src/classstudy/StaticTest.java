package classstudy;

/**
 * Created by cchen on 1/18/2019.
 */
public class StaticTest {

    private static int testNum;
    public StaticTest(){
        System.out.println("Start...");
    }
    private static class StaticClass{
        private int staticClassNum = 2;
    }

    public static void main(String[] args){
        StaticTest test1 = new StaticTest();
        test1.testNum = 1;
        StaticTest test2 = new StaticTest();
        System.out.println(test2.testNum);

        StaticTest.StaticClass inner = new StaticClass();
        inner.staticClassNum++;
        System.out.println(inner.staticClassNum);
        StaticTest.StaticClass inner2 = new StaticClass();
        System.out.println(inner2.staticClassNum);
    }
}
