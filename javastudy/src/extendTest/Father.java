package extendTest;

/**
 * Created by cchen on 6/6/2017.
 */
public class Father {
    public synchronized void say(){
        System.out.println("I am the father.I say:"
                + words
        );
    }

    private String words;
    public Father(String words){
        this.words = words;
    }

    //if there is no default conductor stated explicitly, Son is not allowed to get conductor with parameter
    public Father(){}
}
