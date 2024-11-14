import java.util.*;

public class MovieRecommandation {
    private final String[] movieTitles;
    private final double[][] ratings;

    public MovieRecommandation(String[] movieTitles, double[][] ratings) {
        this.movieTitles = movieTitles;
        this.ratings = ratings;
    }

    private double cosineSimilarity(double[] user1, double[] user2) {
        double dotProduct = 0.0;
        double normUser1 = 0.0;
        double normUser2 = 0.0;

        for (int i = 0; i < user1.length; i++) {
            dotProduct += user1[i] * user2[i];
            normUser1 += Math.pow(user1[i], 2);
            normUser2 += Math.pow(user2[i], 2);
        }

        return (normUser1 == 0 || normUser2 == 0) ? 0 : dotProduct / (Math.sqrt(normUser1) * Math.sqrt(normUser2));
    }
    private List<Integer> getTopSimilarUsers(int userId, int topN) {
        PriorityQueue<int[]> similarityQueue = new PriorityQueue<>(Comparator.comparingDouble(a -> -a[1]));

        for (int i = 0; i < ratings.length; i++) {
            if (i != userId) {
                double similarity = cosineSimilarity(ratings[userId], ratings[i]);
                similarityQueue.offer(new int[]{i, (int)(similarity * 100)});
            }
        }

        List<Integer> topUsers = new ArrayList<>();
        for (int i = 0; i < topN && !similarityQueue.isEmpty(); i++) {
            topUsers.add(similarityQueue.poll()[0]);
        }

        return topUsers;
    }

    public List<String> recommendMovies(int userId) {
        Map<Integer, Double> movieScores = new HashMap<>();
        List<Integer> topSimilarUsers = getTopSimilarUsers(userId, 3);

        for (int similarUser : topSimilarUsers) {
            for (int movieId = 0; movieId < ratings[similarUser].length; movieId++) {
                if (ratings[userId][movieId] == 0 && ratings[similarUser][movieId] > 0) {
                    movieScores.put(movieId, movieScores.getOrDefault(movieId, 0.0) + ratings[similarUser][movieId]);
                }
            }
        }

        List<Map.Entry<Integer, Double>> sortedScores = new ArrayList<>(movieScores.entrySet());
        sortedScores.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        List<String> recommendations = new ArrayList<>();
        for (int i = 0; i < Math.min(3, sortedScores.size()); i++) {
            recommendations.add(movieTitles[sortedScores.get(i).getKey()]);
        }

        return recommendations;
    }

    public static void main(String[] args) {
        String[] movieTitles = {"Movie A", "Movie B", "Movie C", "Movie D", "Movie E"};
        double[][] ratings = {
                {5, 3, 0, 1, 4},
                {4, 0, 3, 2, 1},
                {3, 5, 4, 0, 0},
                {0, 3, 5, 4, 2},
                {1, 0, 2, 5, 3}
        };

        MovieRecommandation system = new MovieRecommandation(movieTitles, ratings);
        int userId = 0;
        List<String> recommendations = system.recommendMovies(userId);

        System.out.println("Top 3 Movie Recommendations for User " + userId + ": " + recommendations);
    }
}
