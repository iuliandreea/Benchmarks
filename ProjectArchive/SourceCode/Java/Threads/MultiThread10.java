package Threads;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class MultiThread10 {

    public Semaphore s1, s2;

    @Setup(Level.Iteration)
    public void setup(){
        s1 = new Semaphore(2);
        s2 = new Semaphore(0);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void start() {
        Thread t1 = new MyThread(s1, s2);
        Thread t2 = new MyThread(s1, s2);

        Thread t3 = new MyThread(s2, s1);
        Thread t4 = new MyThread(s2, s1);

        Thread t5 = new MyThread(s2, s1);
        Thread t6 = new MyThread(s2, s1);

        Thread t7 = new MyThread(s2, s1);
        Thread t8 = new MyThread(s2, s1);

        Thread t9 = new MyThread(s2, s1);
        Thread t10 = new MyThread(s2, s1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
}
