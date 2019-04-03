package enumStudy;

/**
 * Created by cchen on 1/29/2019.
 */
//defalt sigleton by InteliJ
public class SingletonTest {

    private static SingletonTest ourInstance = new SingletonTest();

    public static SingletonTest getInstance() {
        return ourInstance;
    }

    private SingletonTest() {
    }
}
