package DataStructures;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class Creation {

    @State(Scope.Benchmark)
    public static class States {

        @Param({"10", "100", "1000"})
        public int noOfElements;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void arrayCreation(States state, Blackhole blackhole){
        int[] arr = new int[state.noOfElements];
        for(int i = 0; i < state.noOfElements; i++){
            arr[i] = i;
        }
        blackhole.consume(arr);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void arrayListCreation(States state, Blackhole blackhole){
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i = 0; i < state.noOfElements; i++){
            arrList.add(i);
        }
        blackhole.consume(arrList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void linkedListCreation(States state, Blackhole blackhole){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < state.noOfElements; i++){
            linkedList.add(i);
        }
        blackhole.consume(linkedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void HashSetCreation(States state, Blackhole blackhole){
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0; i < state.noOfElements; i++){
            hashSet.add(i);
        }
        blackhole.consume(hashSet);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void TreeSetCreation(States state, Blackhole blackhole){
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 0; i < state.noOfElements; i++){
            treeSet.add(i);
        }
        blackhole.consume(treeSet);
    }

}
