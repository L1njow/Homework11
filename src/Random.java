import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Random {
    private long a, c, m;
    private long x;

    public Random(long a, long c, long m) {
        this.a = a;
        this.c = c;
        this.m = m;
    }

    private Random withSeed(long seed) {
        this.x = seed;
        return this;
    }

    private long next() {
        return (a * x + c) % m;
    }

    public static Stream<Long> generateStream(long a, long c, long m) {
        Random r = new Random(a, c, m);
        return Stream.iterate(55L, seed -> r.withSeed(seed).next());
    }
}
