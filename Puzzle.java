import java.util.Random;
import java.util.Scanner;

class Puzzle {
    private Node head; 
    private int emptyRow, emptyCol; 
    private static final int SIZE = 3;

    // Node untuk LinkedList
    static class Node {
        int value;
        Node right;
        Node down; 

        Node(int value) {
            this.value = value;
            this.right = null;
            this.down = null;
        }
    }

   
    public void initializePuzzle() {
        int num = 1;
        Node currentRowHead = null;
        Node previousRowHead = null;

        for (int i = 0; i < SIZE; i++) {
            Node current = null;

            for (int j = 0; j < SIZE; j++) {
                Node newNode = new Node(num++);

                if (j == 0) {
                    currentRowHead = newNode;
                    if (i == 0) {
                        head = currentRowHead;
                    }
                } else {
                    current.right = newNode;
                }

                current = newNode;

                if (previousRowHead != null) {
                    Node above = getNode(previousRowHead, 0, j);
                    above.down = newNode;
                }
            }
            previousRowHead = currentRowHead;
        }

        setValue(SIZE - 1, SIZE - 1, 0); 
        emptyRow = SIZE - 1;
        emptyCol = SIZE - 1;
    }

    // Acak puzzle
    public void shufflePuzzle() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) { 
            int direction = rand.nextInt(4);
            move(direction);
        }
    }

    // Cetak puzzle
    private void printPuzzle() {
        Puzzle.cls();
        Node row = head;
        System.out.println("+-----+-----+-----+");
        while (row != null) {
            Node current = row;
            while (current != null) {
                System.out.print("|");
                if (current.value == 0) {
                    System.out.print("     ");
                } else {
                    System.out.printf(" %2d  ", current.value);
                }
                current = current.right;
            }
            System.out.println("|"); 
            System.out.println("+-----+-----+-----+"); 
            row = row.down;
        }
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Main game loop
    public void playGame() {
        
        Scanner scanner = new Scanner(System.in);
        int index = 5;
        while(index == 5) {
            
        // while (!isSolved()) {
            System.out.println("\nCurrent Puzzle:");
            printPuzzle();
            System.out.println("Use W/A/S/D to pan (Up/Left/Down/Right):");
            char move = scanner.next().toUpperCase().charAt(0);

            switch (move) {
                case 'W': move(0); break; 
                case 'A': move(1); break;
                case 'S': move(2); break; 
                case 'D': move(3); break;
                case 'C': index = 0;
                default: System.out.println("Invalid input! Use W/A/S/D.");
            }
        }
        System.out.println("\nCongratulations! You've completed the puzzle!");
        printPuzzle();

        // scanner.close();
    }

    
    private boolean isSolved() {
        int num = 1;
        Node row = head;

        for (int i = 0; i < SIZE; i++) {
            Node current = row;
            for (int j = 0; j < SIZE; j++) {
                if (i == SIZE - 1 && j == SIZE - 1) {
                    return current.value == 0; 
                }
                if (current.value != num++) {
                    return false;
                }
                current = current.right;
            }
            row = row.down;
        }
        return true;
    }

   
    private void move(int direction) {
        int newRow = emptyRow, newCol = emptyCol;

        switch (direction) {
            case 0: newRow--; break; 
            case 1: newCol--; break; 
            case 2: newRow++; break; 
            case 3: newCol++; break; 
        }

        if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE) {
    
            int newValue = getValue(newRow, newCol);
            setValue(newRow, newCol, 0);
            setValue(emptyRow, emptyCol, newValue);
            emptyRow = newRow;
            emptyCol = newCol;
        }
    }


    private int getValue(int row, int col) {
        return getNode(head, row, col).value;
    }


    private void setValue(int row, int col, int value) {
        getNode(head, row, col).value = value;
    }

    

    private Node getNode(Node head, int row, int col) {
        Node currentRow = head;
        for (int i = 0; i < row; i++) {
            currentRow = currentRow.down; 
        }
        Node current = currentRow;
        for (int j = 0; j < col; j++) {
            current = current.right; 
        }
        return current;
    }

    public void play(){
        initializePuzzle();
        shufflePuzzle();
        playGame();
    }
}