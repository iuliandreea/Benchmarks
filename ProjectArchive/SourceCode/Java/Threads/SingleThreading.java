package Threads;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class SingleThreading  {

    public Semaphore s1, s2;

    @Setup(Level.Iteration)
    public void setup(){
        s1 = new Semaphore(1);
        s2 = new Semaphore(0);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void start(){
        Thread t = new MyThread(s1, s2);
        t.start();
    }
}
