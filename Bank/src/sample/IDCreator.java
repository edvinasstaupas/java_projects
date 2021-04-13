package sample;

class IDCreator {
    private static int IDCounter = 1;

    static synchronized int createID() {
        return IDCounter++;
    }

    public static void setID(String s) {
        IDCounter = Integer.parseInt(s);
    }
}
