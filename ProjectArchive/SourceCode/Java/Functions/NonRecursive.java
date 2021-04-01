package Functions;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class NonRecursive {

    @State(Scope.Benchmark)
    public static class States {

        @Param({"10", "100", "1000"})
        public int noOfElements;

        public int cd1 = 0;
        public int cd2 = 0;

        @Setup(Level.Iteration)
        public void setup(){
            Random rand = new Random();
            cd1 = rand.nextInt(noOfElements);
            cd2 = rand.nextInt(noOfElements);
        }
    }

    public boolean primeUtil(int num){
        for(int i = 2; i <= num / 2; i++){
            if(num % i == 0){
                return true;
            }
        }
        return false;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void nonRecFactorial(States state, Blackhole blackhole){
        int result = 1;
        for(int i = 1; i <= state.noOfElements; i++){
            result *= i;
        }
        blackhole.consume(result);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void nonRecCommonDivisor(States state, Blackhole blackhole){
        int gcd = 1;
        for(int i = 1; i <= state.cd1 && i <= state.cd2; i++){
            if(state.cd1 % i == 0 && state.cd2 % i == 0){
                gcd = i;
            }
        }
        blackhole.consume(gcd);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void primeNumbers(States state, Blackhole blackhole){
        int num = state.noOfElements;
        while(num >= 2){
            primeUtil(num);
            num--;
        }
        blackhole.consume(num);
    }
}
