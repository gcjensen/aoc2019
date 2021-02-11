package uk.gcjensen.aoc2019.day6;

import java.util.*;

public class OrbitalTransfers {
    private List<String> transfers = new LinkedList<>();

    public List<String> findRoute(SpaceObject from, SpaceObject to) {
        var visited = new HashSet<String>();

        var stack = new Stack<String>();
        DFS(visited, from, to, stack);

        return this.transfers;
    }

    // Do a DFS from each node, and then from the node's parent recursively
    private void DFS(Set<String> visited, SpaceObject from, SpaceObject to, Stack<String> stack) {
        stack.add(from.getName());

        if (from.getName().equals(to.getName())) {
            this.transfers = new LinkedList<>(stack);
            return;
        }

        visited.add(from.getName());

        for (var child : from.getChildren()) {
            if (!visited.contains(child.getName())) {
                DFS(visited, child, to, stack);
            }
        }

        if (from.getParent() != null && !visited.contains(from.getParent().getName())) {
            DFS(visited, from.getParent(), to, stack);
        }

        stack.pop();
    }
}
