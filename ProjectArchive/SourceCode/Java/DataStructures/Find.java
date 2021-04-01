package DataStructures;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class Find {

    @State(Scope.Benchmark)
    public static class States {

        @Param({"10", "100", "1000"})
        public int noOfElements;

        public int succ = 0;
        public int fail = 0;

        public int[] arr;
        public ArrayList<Integer> arrList;
        public LinkedList<Integer> linkedList;
        public HashSet<Integer> hashSet;
        public TreeSet<Integer> treeSet;

        @Setup(Level.Invocation)
        public void setup() {
            arrList = new ArrayList<>();
            linkedList = new LinkedList<>();
            hashSet = new HashSet<>();
            treeSet = new TreeSet<>();
            arr = new int[noOfElements];
            succ = noOfElements / 2;
            fail = noOfElements + 1;
            for(int i = 0; i < noOfElements; i++){
                arr[i] = i;
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
    public void succArrayFind(States state, Blackhole blackhole){
        for(int i = 0; i < state.noOfElements; i++){
            if(state.arr[i] == state.succ){
                break;
            }
        }
        blackhole.consume(state.arr);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void failArrayFind(States state, Blackhole blackhole){
        for(int i = 0; i < state.noOfElements; i++){
            if(state.arr[i] == state.fail){
                break;
            }
        }
        blackhole.consume(state.arr);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void succArrayListFind(States state, Blackhole blackhole){
        state.arrList.contains(state.succ);
        blackhole.consume(state.arrList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void failArrayListFind(States state, Blackhole blackhole){
        state.arrList.contains(state.fail);
        blackhole.consume(state.arrList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void succLinkedListFind(States state, Blackhole blackhole){
        state.linkedList.contains(state.succ);
        blackhole.consume(state.linkedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void failLinkedListFind(States state, Blackhole blackhole){
        state.linkedList.contains(state.fail);
        blackhole.consume(state.linkedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void succHashSetFind(States state, Blackhole blackhole){
        state.hashSet.contains(state.succ);
        blackhole.consume(state.hashSet);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void failHashSetFind(States state, Blackhole blackhole){
        state.hashSet.contains(state.fail);
        blackhole.consume(state.hashSet);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void succTreeSetFind(States state, Blackhole blackhole){
        state.treeSet.contains(state.succ);
        blackhole.consume(state.treeSet);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void failTreeSetFind(States state, Blackhole blackhole){
        state.treeSet.contains(state.fail);
        blackhole.consume(state.treeSet);
    }
}
