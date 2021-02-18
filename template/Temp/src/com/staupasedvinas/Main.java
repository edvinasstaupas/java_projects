package com.staupasedvinas;

public class Main {
    int x; // Laukas pradedamas mažąja raide
    int y;
    public Main (int a, int b) {
        this.x = a;
        this.y = b;
    }
    public static void main(String[] args) {
        Main p = new Main(1, 2);   // (0,0)
        //p.x = 1; p.y = 2;          // (1,2)

        System.out.println("(" + p.x + "," + p.y + ")"); // (1,2)

        int dx = p.x;
        System.out.println("dx=" + dx);
    }
}
