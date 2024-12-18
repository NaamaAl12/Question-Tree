// Naama Al-Musawi, CS 145
// Assignment: QuestionTree Project - (QuestionNode class)

public class QuestionNode {
    public String data;  // The question or answer stored in this node
    public QuestionNode yes;  // The child node for a 'yes' response
    public QuestionNode no;   // The child node for a 'no' response

    /**
     * Constructs a QuestionNode with given data and null references for yes and no children.
     * @param data, The data to be stored in this node, representing a question or an answer.
     */
    public QuestionNode(String data) {
        this(data, null, null);
    }

    /**
     * Constructs a QuestionNode with given data, and references to yes and no children.
     * @param data, The data to be stored in this node, representing a question or an answer.
     * @param yes, The QuestionNode that represents the 'yes' child of this node.
     * @param no, The QuestionNode that represents the 'no' child of this node.
     */
    public QuestionNode(String data, QuestionNode yes, QuestionNode no) {
        this.data = data;
        this.yes = yes;
        this.no = no;
    }
}