package enumStudy;

/**
 * Created by cchen on 1/29/2019.
 */
public class GmoCacheTest {

    public static void main(String[] args) {
        GmoCache.INSTANCE.add("Hello", "world!");
        System.out.println(GmoCache.INSTANCE.findCardDetail("Hello"));
    }
}
