public class second {
    public static void main(String[] args) {
        Main myObj = new Main();
        myObj.x = 15;
        myObj.a = String.valueOf(myObj.x) + myObj.y;
        System.out.println(myObj.a);
    }
}
