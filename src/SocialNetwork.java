import java.util.*;

/**
 * Class representing a User node in the Social Network Graph.
 */
class User {
    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}

/**
 * Main Social Network Analyzer using an Adjacency List Graph structure.
 */
public class SocialNetwork {
    private final Map<Integer, User> userMap = new HashMap<>();
    private final Map<Integer, List<Integer>> adjList = new HashMap<>();

    /**
     * Adds a user node to the network.
     */
    public void addUser(int id, String name) {
        if (userMap.containsKey(id)) {
            System.out.println("User with ID " + id + " already exists.");
            return;
        }
        User user = new User(id, name);
        userMap.put(id, user);
        adjList.put(id, new ArrayList<>());
        System.out.println("User '" + name + "' (ID: " + id + ") added successfully.");
    }

    /**
     * Establishes a bidirectional friendship edge between two users.
     */
    public void addFriendship(int id1, int id2) {
        if (!userMap.containsKey(id1) || !userMap.containsKey(id2)) {
            System.out.println("One or both user IDs do not exist.");
            return;
        }
        adjList.get(id1).add(id2);
        adjList.get(id2).add(id1);
        System.out.println("Friendship established between " + userMap.get(id1).getName()
                + " and " + userMap.get(id2).getName() + ".");
    }

    /**
     * Uses Breadth-First Search (BFS) to find the shortest path and degrees of separation.
     */
    public void findDegreesOfSeparation(int startId, int targetId) {
        if (!userMap.containsKey(startId) || !userMap.containsKey(targetId)) {
            System.out.println("Invalid User ID(s).");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> dist = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(startId);
        visited.add(startId);
        dist.put(startId, 0);

        boolean found = false;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == targetId) {
                found = true;
                break;
            }

            for (int neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    dist.put(neighbor, dist.get(current) + 1);
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        if (!found) {
            System.out.println("No connection path exists between "
                    + userMap.get(startId).getName() + " and "
                    + userMap.get(targetId).getName() + ".");
            return;
        }

        System.out.println("Degrees of Separation: " + dist.get(targetId));
        List<Integer> path = new ArrayList<>();
        for (Integer curr = targetId; curr != null; curr = parent.get(curr)) {
            path.add(curr);
            if (curr == startId) break;
        }
        Collections.reverse(path);

        System.out.print("Path: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(userMap.get(path.get(i)).getName()
                    + (i + 1 < path.size() ? " -> " : ""));
        }
        System.out.println();
    }

    /**
     * Recommends non-connected friends based on common mutual neighbors count.
     */
    public void recommendFriends(int userId) {
        if (!userMap.containsKey(userId)) {
            System.out.println("User not found.");
            return;
        }

        Set<Integer> directFriends = new HashSet<>(adjList.get(userId));
        Map<Integer, Integer> mutualCount = new HashMap<>();

        for (int friendId : directFriends) {
            for (int friendOfFriend : adjList.get(friendId)) {
                if (friendOfFriend != userId && !directFriends.contains(friendOfFriend)) {
                    mutualCount.put(friendOfFriend, mutualCount.getOrDefault(friendOfFriend, 0) + 1);
                }
            }
        }

        List<Map.Entry<Integer, Integer>> recommendations = new ArrayList<>(mutualCount.entrySet());
        recommendations.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Friend Recommendations for " + userMap.get(userId).getName() + ":");
        if (recommendations.isEmpty()) {
            System.out.println("  No recommendations available.");
            return;
        }

        for (Map.Entry<Integer, Integer> rec : recommendations) {
            System.out.println("  - " + userMap.get(rec.getKey()).getName()
                    + " (ID: " + rec.getKey() + ") with "
                    + rec.getValue() + " mutual friend(s)");
        }
    }

    /**
     * Displays all users and their direct adjacency connections.
     */
    public void displayNetwork() {
        System.out.println("\n--- Social Network Connections ---");
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.print(userMap.get(entry.getKey()).getName() + " (ID: " + entry.getKey() + "): ");
            for (int friendId : entry.getValue()) {
                System.out.print(userMap.get(friendId).getName() + " ");
            }
            System.out.println();
        }
    }

    /**
     * Driver Main Method.
     */
    public static void main(String[] args) {
        SocialNetwork sn = new SocialNetwork();

        // 1. Add Users
        sn.addUser(101, "Alice");
        sn.addUser(102, "Bob");
        sn.addUser(103, "Charlie");
        sn.addUser(104, "Diana");
        sn.addUser(105, "Ethan");

        // 2. Add Friendship Edges
        sn.addFriendship(101, 102); // Alice <-> Bob
        sn.addFriendship(102, 103); // Bob <-> Charlie
        sn.addFriendship(101, 104); // Alice <-> Diana
        sn.addFriendship(104, 103); // Diana <-> Charlie

        // 3. Display Graph Connections
        sn.displayNetwork();

        // 4. Test Traversal & Pathfinding
        System.out.println("\n--- Traversal Test ---");
        sn.findDegreesOfSeparation(101, 103);

        // 5. Test Mutual Friends Recommendation
        System.out.println("\n--- Recommendation Test ---");
        sn.recommendFriends(101);
    }
}
