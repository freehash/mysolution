package com.queue;

import java.util.*;

/**
 * Created by hattur on 11/8/17.
 */
public class DoubleEndedBfs {

    public static void main(String[] args) {
        String startWord = "hit";
        String stopWord = "cog";

        String words[] = {"hot", "dot", "dog", "lot", "log", "cog", "hit"};
        LinkedList<String> transform = transform(startWord, stopWord, words);
        System.out.println(transform);
    }

    private static LinkedList<String> transform(String startWord, String stopWord, String words[]) {
        HashMap<String, List<String>> wildCardToWordMap = createWildCardToWordMap(words);

        BFSData sourceData = new BFSData(startWord);
        BFSData destData = new BFSData(stopWord);

        while(!sourceData.isFinished() && !destData.isFinished()) {
            String collision = searchLevel(wildCardToWordMap, sourceData, destData);
            if(collision != null) {
                return mergePaths(sourceData, destData, collision);
            }

            collision = searchLevel(wildCardToWordMap, destData, sourceData);
            if(collision != null) {
                return mergePaths(sourceData, destData, collision);
            }
        }
        return null;
    }
    private static String searchLevel(HashMap<String, List<String>> wildCardToWordList, BFSData primary, BFSData secondary) {
        int count = primary.toVisit.size();
        for (int i = 0; i < count; i++) {
            PathNode pathNode = primary.toVisit.poll();
            String word = pathNode.getWord();

            if (secondary.visited.containsKey(word)) {
                return word;
            }

            ArrayList<String> words = getValidLinkedWords(word, wildCardToWordList);
            for (String w : words) {
                PathNode next = new PathNode(w, pathNode);
                primary.visited.put(w, next);
                primary.toVisit.add(next);
            }
        }
        return null;
    }

    private static LinkedList<String> mergePaths(BFSData bfs1, BFSData bfs2, String connection) {
        PathNode end1 = bfs1.visited.get(connection);
        PathNode end2 = bfs2.visited.get(connection);
        LinkedList<String> pathOne = end1.collapse(false);
        LinkedList<String> pathTwo = end2.collapse(true);
        pathTwo.removeFirst();
        pathOne.addAll(pathTwo);
        return pathOne;
    }

    private static HashMap<String, List<String>> createWildCardToWordMap(String[] words) {
        HashMap<String, List<String>> wildCardToWords = new HashMap<>();
        for(String word : words) {
            ArrayList<String> linked = getWildcardRoots(word);
            for(String linkedWord : linked) {
                if(wildCardToWords.containsKey(linkedWord)) {
                    wildCardToWords.get(linkedWord).add(word);
                }
                else {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(word);
                    wildCardToWords.put(linkedWord, list);
                }
            }
        }
        return wildCardToWords;
    }

    private static ArrayList<String> getValidLinkedWords(String word, HashMap<String, List<String>> wildCardToWords) {
        ArrayList<String> wildcards = getWildcardRoots(word);
        ArrayList<String> linkedWords = new ArrayList<>();
        for(String wildcard : wildcards) {
            List<String> words = wildCardToWords.get(wildcard);
            for(String linkedWord : words) {
                if(!linkedWord.equals(word)) {
                    linkedWords.add(linkedWord);
                }
            }
        }
        return linkedWords;
    }

    private static ArrayList<String> getWildcardRoots(String word) {
        ArrayList<String> words = new ArrayList<>();
        for(int i = 0; i < word.length(); i++) {
            String w = word.substring(0,i) + "_" + word.substring(i+1);
            words.add(w);
        }
        return words;
    }
}
class BFSData {
    public Queue<PathNode> toVisit = new LinkedList<>();
    public HashMap<String, PathNode> visited = new HashMap<>();

    public BFSData(String root) {
        PathNode sourcePath = new PathNode(root, null);
        toVisit.add(sourcePath);
        visited.put(root, sourcePath);
    }

    public boolean isFinished() {
        return toVisit.isEmpty();
    }

}

class PathNode {
    private String word = null;
    private PathNode previousNode = null;
    public PathNode(String word, PathNode previous) {
        this.word = word;
        this.previousNode = previous;
    }

    public String getWord() {
        return word;
    }

    public LinkedList<String> collapse(boolean startsWithRoot) {
        LinkedList<String> path = new LinkedList<>();
        PathNode node = this;
        while(node != null) {
            if(startsWithRoot) {
                path.addLast(node.word);
            }
            else {
                path.addFirst(node.word);
            }
            node = node.previousNode;
        }
        return path;
    }
}