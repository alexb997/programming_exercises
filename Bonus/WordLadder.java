import java.util.*;

public class WordLadder {
    public List<String> findLadder(String start, String end, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(end)) return Collections.emptyList();
        
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(Arrays.asList(start));
        Set<String> visited = new HashSet<>();
        visited.add(start);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> levelVisited = new HashSet<>();
            
            for (int i = 0; i < size; i++) {
                List<String> path = queue.poll();
                String lastWord = path.get(path.size() - 1);
                
                if (lastWord.equals(end)) return path;
                
                for (String neighbor : getNeighbors(lastWord, wordSet)) {
                    if (!visited.contains(neighbor)) {
                        List<String> newPath = new ArrayList<>(path);
                        newPath.add(neighbor);
                        queue.add(newPath);
                        levelVisited.add(neighbor);
                    }
                }
            }
            visited.addAll(levelVisited);
        }
        return Collections.emptyList();
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != originalChar) {
                    chars[i] = c;
                    String newWord = new String(chars);
                    if (wordSet.contains(newWord)) neighbors.add(newWord);
                }
            }
            chars[i] = originalChar;
        }
        return neighbors;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        String start = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        
        List<String> path = wordLadder.findLadder(start, end, wordList);
        System.out.println("Transformation path: " + path);
    }
}
