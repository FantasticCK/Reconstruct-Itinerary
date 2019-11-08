package com.CK;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        List<List<String>> tickets = new ArrayList<>();
//        List<String> one = new ArrayList<String>(){{
//            add("MUC");
//            add("LHR");
//        }};
//        tickets.add(one);
//        List<String> two = new ArrayList<String>(){{
//            add("JFK");
//            add("MUC");
//        }};
//        tickets.add(two);
//        List<String> three = new ArrayList<String>(){{
//            add("SFO");
//            add("SJC");
//        }};
//        tickets.add(three);
//        List<String> four = new ArrayList<String>(){{
//            add("LHR");
//            add("SFO");
//        }};
//        tickets.add(four);
        List<List<String>> tickets = new ArrayList<>();
        List<String> one = new ArrayList<String>(){{
            add("JFK");
            add("SFO");
        }};
        tickets.add(one);
        List<String> two = new ArrayList<String>(){{
            add("JFK");
            add("ATL");
        }};
        tickets.add(two);
        List<String> three = new ArrayList<String>(){{
            add("SFO");
            add("ATL");
        }};
        tickets.add(three);
        List<String> four = new ArrayList<String>(){{
            add("ATL");
            add("JFK");
        }};
        tickets.add(four);
        List<String> five = new ArrayList<String>(){{
            add("ATL");
            add("SFO");
        }};
        tickets.add(five);
        new Solution().findItinerary(tickets);
    }
}

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }
        List<String> dfsList = new ArrayList<>();
        dfs(graph, dfsList,"JFK");
        return dfsList;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, List<String> dfsList, String curr){
        while(graph.containsKey(curr) && graph.get(curr).size() > 0){
            String next = graph.get(curr).poll();
            dfs(graph, dfsList, next);
        }
        dfsList.add(0, curr);
    }
}