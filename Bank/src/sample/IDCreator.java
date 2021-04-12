package sample;

class IDCreator {
    private static int IDCounter = 1;

    static synchronized int createID() {
        return IDCounter++;
    }
}
