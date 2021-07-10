import java.util.ArrayList;
import java.util.Collections;

public class test {
    private test(){
        ArrayList<String> a = new ArrayList<String>();
        a.add("hello");
        a.add("world");
        a.add("feello");
        Collections.shuffle(a);
        System.out.println(a);

    }
}
