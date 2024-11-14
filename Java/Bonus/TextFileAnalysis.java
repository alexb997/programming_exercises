import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextFileAnalysis {
    private Map<String, Integer> wordFrequency = new HashMap<>();
    private Map<String, List<String>> wordGraph = new HashMap<>();

    public void analyzeFile(String filename) throws IOException {
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.toLowerCase().replaceAll("[^a-zA-Z0-9 ]",
                        "").split("\\s+");
                for (String word : tokens) {
                    if (!word.isEmpty()) {
                        words.add(word);
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }

        for (int i = 0; i < words.size() - 1; i++) {
            String word1 = words.get(i);
            String word2 = words.get(i + 1);
            wordGraph.computeIfAbsent(word1, k -> new ArrayList<>()).add(word2);
            wordGraph.computeIfAbsent(word2, k -> new ArrayList<>()).add(word1);
        }
    }

    public int findShortestPath(String start, String end) {
        if (!wordGraph.containsKey(start) || !wordGraph.containsKey(end)) return -1;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, Integer> distance = new HashMap<>();

        queue.add(start);
        visited.add(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(end)) return distance.get(current);

            for (String neighbor : wordGraph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    distance.put(neighbor, distance.get(current) + 1);
                    queue.add(neighbor);
                }
            }
        }

        return -1;
    }

    public void printAnalysis() {
        System.out.println("Word Frequency: " + wordFrequency);
    }

    public static void main(String[] args) throws IOException {
        TextFileAnalysis analysis = new TextFileAnalysis();
        analysis.analyzeFile("textfile.txt");
        analysis.printAnalysis();

        String startWord = "cat";
        String endWord = "dog";
        int shortestPath = analysis.findShortestPath(startWord, endWord);
        System.out.println("Shortest path from '" + startWord + "' to '" + endWord + "': " + shortestPath);
    }
}