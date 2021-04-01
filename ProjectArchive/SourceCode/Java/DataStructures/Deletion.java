package DataStructures;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class Deletion {

    @State(Scope.Benchmark)
    public static class States {

        @Param({"10", "100", "1000"})
        public int noOfElements;

        public int n;

        public int[] arr1;
        public int[] arr2;
        public ArrayList<Integer> arrList;
        public LinkedList<Integer> linkedList;
        public HashSet<Integer> hashSet;
        public TreeSet<Integer> treeSet;

        @Setup(Level.Invocation)
        public void setup() {
            arr1 = new int[1100];
            arr2 = new int[1100];
            arrList = new ArrayList<>();
            linkedList = new LinkedList<>();
            hashSet = new HashSet<>();
            treeSet = new TreeSet<>();
            for(int i = 0; i < 1100; i++){
                arr1[i] = i;
                arr2[i] = i;
                arrList.add(i);
                linkedList.add(i);
                hashSet.add(i);
                treeSet.add(i);
            }
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void arrayIndexDeletion(States state, Blackhole blackhole){
        for(int i = state.n; i < state.noOfElements - 1; i++){
            state.arr1[i] = state.arr1[i + 1];
        }
        blackhole.consume(state.arr1);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void arrayLastDeletion(States state, Blackhole blackhole){
        state.arr2[state.noOfElements - 2] = state.arr2[state.noOfElements - 1];
        blackhole.consume(state.arr2);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void arrayListDeletion(States state, Blackhole blackhole){
        state.arrList.remove(state.arrList.size() / 2);
        blackhole.consume(state.arrList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void linkedListDeletion(States state, Blackhole blackhole){
        state.linkedList.remove(state.linkedList.size() / 2);
        blackhole.consume(state.linkedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void hashSetDeletion(States state, Blackhole blackhole){
        state.hashSet.remove(state.hashSet.size() / 2);
        blackhole.consume(state.hashSet);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void treeSetDeletion(States state, Blackhole blackhole){
        state.treeSet.remove(state.treeSet.size() / 2);
        blackhole.consume(state.treeSet);
    }

}
