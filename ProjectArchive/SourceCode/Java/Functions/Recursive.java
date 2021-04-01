package Functions;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Recursive {

    @State(Scope.Benchmark)
    public static class States {

        @Param({"10", "100", "1000"})
        public int noOfElements;

        public int cd1 = 0;
        public int cd2 = 0;

        public String str = "";

        @Setup(Level.Iteration)
        public void setup(){
            Random rand = new Random();
            cd1 = rand.nextInt(noOfElements);
            cd2 = rand.nextInt(noOfElements);

            for(int i = 0; i < noOfElements; i++){
                str += "a";
            }
        }
    }

    public int factorialUtil(int number){
        if (number >= 1){
            return number * factorialUtil(number - 1);
        }
        else{
            return 1;
        }
    }

    public int commonDivisorUtil(int n1, int n2){
        if(n2 == 0){
            return n1;
        }
        return commonDivisorUtil(n2, n1 % n2);
    }

    public String reverseUtil(String string){
        if(string.isEmpty()){
            return string;
        }
        return reverseUtil(string.substring(1)) + string.charAt(0);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void recFactorial(States state, Blackhole blackhole){
        int result = 1;
        result = factorialUtil(state.noOfElements);
        blackhole.consume(result);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void recCommonDivisor(States state, Blackhole blackhole){
        int gcd = 1;
        gcd = commonDivisorUtil(state.cd1, state.cd2);
        blackhole.consume(gcd);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void reverseString(States state, Blackhole blackhole){
        String string = "";
        string = reverseUtil(state.str);
        blackhole.consume(string);
    }
}
