// Naama Al-Musawi, CS 145
// Assignment: QuestionTree Project - (QuestionTree class)

import java.io.*;
import java.util.*;

public class QuestionTree {
    private UserInterface my;
    private QuestionNode overallRoot;
    private int totalGame;
    private int gameWon;
    
    
    /**
     * Constructs a new QuestionTree with a single answer node.
     * @param ui, The user interface for interaction with the user.
     */
    public QuestionTree(UserInterface ui) {
        my = ui;
        overallRoot = new QuestionNode("Jedi");
        totalGame = 0;
        gameWon = 0;
    }
    
    /**
     * Checks if a given node is a leaf node (i.e., an answer node).
     * @param node, The node to check.
     * @return true if the node is a leaf node, false otherwise.
     */
    private boolean isLeaf(QuestionNode node) {
        return (node.yes == null && node.no == null);
    }
    
    
    /**
     * Starts the 20 Questions game and plays it until it's over.
     */
    public void play() {
        overallRoot = play(overallRoot);
    }
    
    
    /**
     * Plays a round of 20 Questions using recursion, expanding the tree with new questions and answers
     * if the computer fails to guess the user's object.
     * @param node, The current node in the game.
     * @return the updated node after playing.
     */
    private QuestionNode play(QuestionNode node) {
        if (node == null) throw new IllegalArgumentException("Node cannot be null");

        if (isLeaf(node)) {
            my.print("Would your object happen to be " + node.data + "? ");
            boolean yesNo = my.nextBoolean();
            if (yesNo) {
                my.println("I win!");
                gameWon++;
            } else {
                node = handleIncorrectGuess(node);  // Update the node
            }
            totalGame++;
        } else {
            my.print(node.data + " ");
            boolean yesNo = my.nextBoolean();
            if (yesNo) node.yes = play(node.yes);  // Update the 'yes' child
            else node.no = play(node.no);          // Update the 'no' child
        }
        return node;
    }
    
    /**
     * Handles the situation when the computer makes an incorrect guess by learning a new question and answer.
     * @param node, The node where the incorrect guess occurred.
     * @return a new QuestionNode that replaces the current node in the tree.
     */
    private QuestionNode handleIncorrectGuess(QuestionNode node) {
        my.print("I lose. What is your object? ");
        QuestionNode answer = new QuestionNode(my.nextLine());
        my.print("Type a yes/no question to distinguish your item from " + node.data + ": ");
        String question = my.nextLine();
        my.print("And what is the answer for your object? ");

        boolean yesNo2 = my.nextBoolean();
        return new QuestionNode(question, yesNo2 ? answer : node, yesNo2 ? node : answer);
    }
    
    /**
     * Saves the current state of the question tree to the given PrintStream.
     * @param output, The PrintStream to write the tree state to.
     */
    public void save(PrintStream output) {
        savePreorder(overallRoot, output);
    }
     
    /**
     * Performs a preorder traversal of the tree, saving each node to the given PrintStream.
     * @param node, The current node being visited.
     * @param output, The PrintStream to write to.
     */
    private void savePreorder(QuestionNode node, PrintStream output) {
        if (node == null) return;
        output.println((isLeaf(node) ? "A:" : "Q:") + node.data);
        savePreorder(node.yes, output);
        savePreorder(node.no, output);
    }
    
    /**
     * Loads a question tree from the given Scanner.
     * @param input, The Scanner from which to read the tree data.
     */
    public void load(Scanner input) {
        overallRoot = loadTree(input);
    }
    
    /**
     * Recursively loads a question tree from a Scanner.
     * @param input, The Scanner to read the tree data from.
     * @return the root node of the loaded tree.
     */
    private QuestionNode loadTree(Scanner input) {
        if (!input.hasNextLine()) return null;
        String line = input.nextLine();
        String data = line.substring(2);
        if (line.startsWith("Q:")) {
            return new QuestionNode(data, loadTree(input), loadTree(input));
        } else {
            return new QuestionNode(data);
        }
    }
    
    /**
     * Returns the total number of games played.
     * @return the total number of games played.
     */
    public int totalGames() {
        return totalGame;
    }

    /**
     * Returns the number of games won by the computer.
     * @return the number of games won.
     */
    public int gamesWon() {
        return gameWon;
    }
}