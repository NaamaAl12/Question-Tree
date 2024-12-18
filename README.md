# ❓ 20 Questions Game - Question Tree

This project is a **Java-based console application** that implements a version of the **20 Questions Game**, where the program uses a binary tree structure to guess the user’s object. If it guesses incorrectly, it learns and expands its knowledge tree with new questions and answers.

---

## **Features**

1. **Dynamic Tree Expansion**:
   - Learns new objects and questions when the program's guess is wrong.
   - Expands its decision tree dynamically for future games.

2. **Binary Tree Implementation**:
   - Uses a binary tree (`QuestionNode`) to store questions and answers.
   - Traverses the tree based on user responses (yes/no).

3. **Game Stats**:
   - Tracks the total games played and the number of games the computer has won.

4. **Persistence**:
   - Save the current state of the question tree to a file and load it for future games.

5. **Interactive Console UI**:
   - Menu-driven interface for a smooth gaming experience.

---

## **How It Works**

### 🎯 Gameplay
1. The game starts with a basic question tree containing a single answer ("Jedi").
2. The user thinks of an object, and the game tries to guess it by asking yes/no questions.
3. If the guess is incorrect:
   - The game asks for the correct object and a distinguishing question.
   - Updates the tree with the new question and object for future games.

---

### 🛠 Program Structure

1. **Core Classes**:
   - **`QuestionNode`**:
     - Represents a single node in the binary tree.
     - Contains data (question/answer) and references to `yes` and `no` child nodes.
   - **`QuestionTree`**:
     - Handles the game logic, including tree traversal, saving, and loading.
   - **`QuestionMain`**:
     - Provides the text-based user interface and overall game loop.

2. **Tree Traversal**:
   - The tree is traversed recursively, with each node representing a question or answer.
   - The game ends when a leaf node (an answer) is reached.

---

## **Getting Started**

### Prerequisites
- **Java Development Kit (JDK)** 8 or higher.

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/20QuestionsGame.git
   cd 20QuestionsGame
