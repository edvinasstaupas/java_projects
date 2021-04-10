package lt.staupasedvinas;

public class Main {

    public static void main(String[] args) {
        Benchmark benchmark = new TestBenchmark();
        System.out.println(benchmark.repeat(1000));
    }
}

class TestBenchmark extends Benchmark {
    protected void work() {
        Math.sin(Math.PI);
    }
}

abstract class Benchmark {
    /**
     * Method call to be evaluated
     */
    protected abstract void work();

    /**
     * Return how long runs iDo() code
     */
    public double repeat(long count) {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            work(); // Note: "abstract" call
        }
        long end = System.currentTimeMillis();
        return (end - begin) / (double) count / 1000; // To seconds
    }
}