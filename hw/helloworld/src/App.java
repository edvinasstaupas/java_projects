import java.security.cert.X509CRLSelector;

public class App {
    public static void main(String[] args) throws Exception {
        String x = "55";
        x = myMethod(x);
        x = myMethod(x);
    }
    static String myMethod (String x){
        System.out.println(x);
        return "a";
    }
}
