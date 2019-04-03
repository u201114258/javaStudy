package extendTest;

/**
 * Created by cchen on 6/6/2017.
 * It seems that once the father class is innitialed as its subclass.It can no longer use the method,witch is overrided by its subclass!
 */
public class Son extends Father{
    String words;
    public synchronized void say(){
        System.out.println("I am the son");
        super.say();
    }
//
    public Son(String words){
        this.words = words;
    }

    public static void main(String[] args){
        String words = "Hi!";
        Father father = new Son(words);
        father.say();
        Father father1 = new Father(words);
        father1.say();
        father1 = new Father();
        father1.say();
        // no default conductor, so the following code is wrong:
//        Son son = new Son();
//        son.say();
    }
}
