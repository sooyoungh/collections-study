package com.SetCollections;

import org.openjdk.jmh.annotations.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class AddSet {

    public Integer COUNT = 1_000_000;
    public Random random = new Random();

    public Set<Integer> hashSet;
    public Set<Integer> treeSet;
    public Set<Integer> linkedHashSet;

    @Benchmark
    public void addHashSet() {

        hashSet = new HashSet<>();
        for (int i = 0; i < COUNT; i++) {
            Integer randomNumber = random.nextInt();
            hashSet.add(randomNumber);
        }
    }

    @Benchmark
    public void addTreeSet() {

        treeSet = new TreeSet<>();
        for (int i = 0; i < COUNT; i++) {
            Integer randomNumber = random.nextInt();
            treeSet.add(randomNumber);
        }
    }

    @Benchmark
    public void addLinkedHashSet() {

        linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < COUNT; i++) {
            Integer randomNumber = random.nextInt();
            linkedHashSet.add(randomNumber);
        }
    }
}