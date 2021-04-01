package DataStructures;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class Insertion {

    @State(Scope.Benchmark)
    public static class States {

        @Param({"10", "100", "1000"})
        public int noOfElements;

        public int pos = 0;
        public int elem = 0;

        public int[] arr1;
        public int[] arr2;
        public ArrayList arrList1 = new ArrayList<>();
        public ArrayList arrList2 = new ArrayList<>();
        public LinkedList linkedList1 = new LinkedList<>();
        public LinkedList linkedList2 = new LinkedList<>();
        public HashSet hashSet1 = new HashSet<>();
        public HashSet hashSet2 = new HashSet<>();
        public TreeSet treeSet1 = new TreeSet<>();
        public TreeSet treeSet2 = new TreeSet<>();

        @Setup(Level.Invocation)
        public void setup() {
            arr1 = new int[noOfElements + 1];
            arr2 = new int[noOfElements + 1];
            pos = noOfElements / 2;
            elem = noOfElements + 1;
            for(int i = 0; i < noOfElements; i++){
                arr1[i] = i;
                arr2[i] = i;
                arrList1.add(i);
                arrList2.add(i);
                linkedList1.add(i);
                linkedList2.add(i);
                hashSet1.add(i);
                hashSet2.add(i);
                treeSet1.add(i);
                treeSet2.add(i);
            }
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void arrayAddAtIndex(States state, Blackhole blackhole){
        for(int i = state.noOfElements; i > state.pos; i--){
            state.arr1[i] = state.arr1[i - 1];
        }
        state.arr1[state.pos] = state.elem;
        blackhole.consume(state.arr1);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void arrayAddAtEnd(States state, Blackhole blackhole){
        state.arr2[state.noOfElements] = state.elem;
        blackhole.consume(state.arr2);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void arrayListAddAtIndex(States state, Blackhole blackhole){
        state.arrList1.add(state.pos, state.elem);
        blackhole.consume(state.arrList1);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void arrayListAddAtEnd(States state, Blackhole blackhole){
        state.arrList2.add(state.elem);
        blackhole.consume(state.arrList2);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void LinkedListAddAtIndex(States state, Blackhole blackhole){
        state.linkedList1.add(state.pos, state.elem);
        blackhole.consume(state.linkedList1);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void LinkedListAddAtEnd(States state, Blackhole blackhole){
        state.linkedList2.add(state.elem);
        blackhole.consume(state.linkedList2);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void hashSetAdd(States state, Blackhole blackhole){
        state.hashSet1.add(state.elem);
        blackhole.consume(state.hashSet1);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void hashSetAddDuplicate(States state, Blackhole blackhole){
        state.hashSet2.add(state.pos);
        blackhole.consume(state.hashSet2);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void treeSetAdd(States state, Blackhole blackhole){
        state.treeSet1.add(state.elem);
        blackhole.consume(state.treeSet1);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @Fork(value = 1, warmups = 1)
    public void treeSetAddDuplicate(States state, Blackhole blackhole){
        state.treeSet2.add(state.pos);
        blackhole.consume(state.treeSet2);
    }

}
