package com.SetCollections;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class ContainsSet {

    public Integer SIZE = 1000_000;
    public Integer SEARCH_COUNT = 10_000;
    public Random random = new Random();

    public Set<Integer> hashSet;
    public Set<Integer> treeSet;
    public Set<Integer> linkedHashSet;
    public List<Integer> randomNumbers;

    @Setup(Level.Trial)
    public void setUp() {
        hashSet = new HashSet<>();
        treeSet = new TreeSet<>();
        linkedHashSet = new LinkedHashSet<>();

        for (int i = 0; i < SIZE; i++) {
            Integer randomNumber = random.nextInt();
            hashSet.add(randomNumber);
            treeSet.add(randomNumber);
            linkedHashSet.add(randomNumber);
        }

        for (int i = 0; i < SEARCH_COUNT; i++) {
            Integer randomNumber = random.nextInt();
            randomNumbers.add(randomNumber);
        }
    }

    @Benchmark
    public void containsHashSet() {
        for (Integer searchNumber : randomNumbers) {
            hashSet.contains(searchNumber);
        }
    }

    @Benchmark
    public void containsTreeSet() {
        for (Integer searchNumber : randomNumbers) {
            treeSet.contains(searchNumber);
        }
    }

    @Benchmark
    public void containsLinkedHashSet() {
        for (Integer searchNumber : randomNumbers) {
            linkedHashSet.contains(searchNumber);
        }
    }
}