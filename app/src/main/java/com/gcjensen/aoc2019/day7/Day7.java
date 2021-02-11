package com.gcjensen.aoc2019.day7;

import com.google.common.collect.Collections2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gcjensen.aoc2019.Day;
import com.gcjensen.aoc2019.Intcode.Intcode;
import com.gcjensen.aoc2019.Intcode.IntcodeMachine;

public class Day7 extends Day<Long> {
    public Day7() {
        super(7);
    }

    @Override
    public List<Long> parseInput(Stream<String> input) {
        String inputStr = input.findFirst().map(Object::toString).orElse(null);
        Stream<String> stream = Arrays.stream(inputStr.split(","));
        return stream.map(Long::parseLong).collect(Collectors.toList());
    }

    @Override
    public Integer solvePart1(List<Long> input) {
        return this.getMaxThrusterSignal(input, List.of(0L, 1L, 2L, 3L, 4L));
    }

    @Override
    public Integer solvePart2(List<Long> input) {
        return this.getMaxThrusterSignal(input, List.of(5L, 6L, 7L, 8L, 9L));
    }

    private int getMaxThrusterSignal(List<Long> program, List<Long> phases) {
        //noinspection UnstableApiUsage
        return Collections2.permutations(phases).stream()
                .mapToInt(settings -> this.runWithPhaseSettings(program, settings))
                .max()
                .orElseThrow();
    }

    private List<BlockingQueue<Long>> initialiseIOQueues(List<Long> settings) {
        var queues = new ArrayList<BlockingQueue<Long>>();

        // Initialise a queue for each phase setting (and therefore each amplifier)
        for (Long setting : settings) {
            var queue = new LinkedBlockingQueue<Long>(2);
            queue.offer(setting);
            queues.add(queue);
        }

        // As well as the phase setting, the first amplifier also needs an input signal of 0
        queues.get(0).offer(0L);

        return queues;
    }

    private int runWithPhaseSettings(List<Long> program, List<Long> settings) {
        var queues = this.initialiseIOQueues(settings);

        var threads = new Thread[settings.size()];
        for (var i = 0; i < threads.length; i++) {
            var input = queues.get(i);

            // Wrap back round to the first queue if we're at the end
            var output = queues.get((i + 1) % threads.length);

            var machine = new IntcodeMachine(new Intcode(program), new AmplifierIO(input, output));
            var thread = new Thread(machine::run);
            thread.start();

            threads[i] = thread;
        }


        /*
         * Wait for threads to finish and then get the final output which will have been pushed back
         * round to the first queue
         */
        try {
            for (var thread : threads) thread.join();
            return queues.get(0).take().intValue();
        } catch (InterruptedException e) {
            throw new IllegalStateException();
        }
    }

}

