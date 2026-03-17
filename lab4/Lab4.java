package com.mycompany.lab4;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import com.github.javafaker.Faker;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;

public class Lab4 {

    public static void main(String[] args) {

        Faker faker = new Faker();

        var nodes = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Intersection(faker.address().streetName()))
                .toArray(Intersection[]::new);

        List<Street> streets = new LinkedList<>();

        Street s1 = new Street(faker.address().streetName(), faker.number().numberBetween(5, 20), nodes[1], nodes[2]);
        Street s2 = new Street(faker.address().streetName(), faker.number().numberBetween(5, 20), nodes[1], nodes[5]);
        Street s3 = new Street(faker.address().streetName(), faker.number().numberBetween(5, 20), nodes[1], nodes[4]);
        Street s4 = new Street(faker.address().streetName(), faker.number().numberBetween(5, 20), nodes[6], nodes[7]);
        Street s5 = new Street(faker.address().streetName(), faker.number().numberBetween(5, 20), nodes[8], nodes[9]);

        streets.add(s1);
        streets.add(s2);
        streets.add(s3);
        streets.add(s4);
        streets.add(s5);

        streets.sort(Comparator.comparingInt(Street::getLen));

        Set<Intersection> set = new HashSet<>();
        for (var i : nodes) {
            set.add(i);
        }

        int minLength = 7;

        City city = new City(set, streets);

        Map<Intersection, Long> degree = city.getStreets().stream()
                .flatMap(s -> Stream.of(s.getA(), s.getB()))
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        city.getStreets().stream()
                .filter(s -> s.getLen() > minLength)
                .filter(s -> degree.get(s.getA()) >= 3 || degree.get(s.getB()) >= 3)
                .forEach(System.out::println);

        Graph<Intersection, DefaultWeightedEdge> graph =
                new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        city.getIntersection().forEach(graph::addVertex);

        for (Street s : city.getStreets()) {
            var e = graph.addEdge(s.getA(), s.getB());
            graph.setEdgeWeight(e, s.getLen());
        }

        KruskalMinimumSpanningTree<Intersection, DefaultWeightedEdge> mst =
                new KruskalMinimumSpanningTree<>(graph);

        double cost = mst.getSpanningTree().getWeight();
        System.out.println("MST cost: " + cost);

        List<Set<DefaultWeightedEdge>> solutions = new LinkedList<>();

        List<DefaultWeightedEdge> edges = new LinkedList<>(graph.edgeSet());

        for (DefaultWeightedEdge removed : edges) {

            Graph<Intersection, DefaultWeightedEdge> temp =
                    new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

            city.getIntersection().forEach(temp::addVertex);

            for (DefaultWeightedEdge e : edges) {
                if (!e.equals(removed)) {
                    var src = graph.getEdgeSource(e);
                    var tgt = graph.getEdgeTarget(e);
                    var w = graph.getEdgeWeight(e);

                    var newEdge = temp.addEdge(src, tgt);
                    temp.setEdgeWeight(newEdge, w);
                }
            }

            var mstSol = new KruskalMinimumSpanningTree<>(temp).getSpanningTree();

            if (mstSol.getEdges().size() == city.getIntersection().size() - 1) {
                solutions.add(mstSol.getEdges());
            }
        }

        solutions.sort(Comparator.comparingDouble(sol ->
                sol.stream().mapToDouble(graph::getEdgeWeight).sum()
        ));

        int limita = 3;

        solutions.stream()
                .limit(limita)
                .forEach(sol -> {
                    double total = sol.stream()
                            .mapToDouble(graph::getEdgeWeight)
                            .sum();

                    System.out.println("Solution cost: " + total);
                    sol.forEach(System.out::println);
                    System.out.println();
                });
    }
}