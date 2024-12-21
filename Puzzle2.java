import java.util.Scanner;

class puzzle2 {
    private Node top;
    private int size;

    public puzzle2() {
        top = null;
        size = 0;
    }

    private static class Node {
        String color;
        Node next;

        public Node(String color) {
            this.color = color;
            this.next = null;
        }
    }

    public void fill(String color) {
        Node newNode = new Node(color);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public String peek() {
        return (top == null) ? "Empty" : top.color;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == 4;
    }

    public void pour(puzzle2 other) {
        if (!this.isEmpty()) {
            String color = this.top.color;
            this.top = this.top.next;
            size--;

            if (other.isEmpty() || other.peek().equals(color)) {
                other.fill(color);
                if (other.getSize() == 3 && other.isConsistent()) {
                    System.out.println("The destination box is already filled with the same 3 colors!");
                }
            } else {
                this.fill(color);
                System.out.println("Can't move colors " + color + " to another box");
            }
        }
    }

    public boolean isConsistent() {
        if (this.size < 3) return false;

        String color = this.peek();
        int count = 0;
        Node current = top;
        while (current != null) {
            if (current.color.equals(color)) {
                count++;
            }
            current = current.next;
        }
        return count == 3;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("[Empty]");
        } else {
            Node current = top;
            while (current != null) {
                System.out.println(getColorCode(current.color) + current.color + "\033[0m");
                current = current.next;
            }
        }
    }

    private String getColorCode(String color) {
        switch (color.toLowerCase()) {
            case "red":
                return "\033[0;31m";
            case "blue":
                return "\033[0;34m";
            case "green":
                return "\033[0;32m";
            case "yellow":
                return "\033[0;33m";
            default:
                return "\033[0m";
        }
    }

    public int getSize() {
        return size;
    }

    public static boolean isGameFinished(puzzle2... boxes) {
        int consistentBoxCount = 0;

        for (puzzle2 box : boxes) {
            if (!box.isEmpty() && box.getSize() == 3) {
                String color = box.peek();
                Node current = box.top;
                boolean isConsistent = true;

                while (current != null) {
                    if (!current.color.equals(color)) {
                        isConsistent = false;
                        break;
                    }
                    current = current.next;
                }

                if (isConsistent) {
                    consistentBoxCount++;
                }
            }
        }

        return consistentBoxCount == 3;
    }

    public static puzzle2 getbox(int number, puzzle2 box1, puzzle2 box2, puzzle2 box3, puzzle2 box4) {
        switch (number) {
            case 1:
                return box1;
            case 2:
                return box2;
            case 3:
                return box3;
            case 4:
                return box4;
            default:
                throw new IllegalArgumentException("Invalid select Box.");
        }
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        puzzle2 box1 = new puzzle2();
        puzzle2 box2 = new puzzle2();
        puzzle2 box3 = new puzzle2();
        puzzle2 box4 = new puzzle2();
        box1.fill("Blue");
        box1.fill("Red");
        box1.fill("Green");

        box2.fill("Blue");
        box2.fill("Green");
        box2.fill("Red");

        box3.fill("Green");
        box3.fill("Blue");

        box4.fill("Red");

        while (true) {
            cls();
            if (puzzle2.isGameFinished(box1, box2, box3, box4)) break;

            System.out.println("\nFill the Box Vertically: ");

            System.out.println("Box 1:");
            box1.show();
            System.out.println();

            System.out.println("Box 2:");
            box2.show();
            System.out.println();

            System.out.println("Box 3:");
            box3.show();
            System.out.println();

            System.out.println("Box 4:");
            box4.show();
            System.out.println();

            System.out.print("Pilih Box sumber (1-4): ");
            int source = scanner.nextInt();

            System.out.print("Pilih Box tujuan (1-4): ");
            int target = scanner.nextInt();

            puzzle2 sourceBox = puzzle2.getbox(source, box1, box2, box3, box4);
            puzzle2 targetBox = puzzle2.getbox(target, box1, box2, box3, box4);

            sourceBox.pour(targetBox);
        }

        System.out.println("\nCongratulations! You successfully completed the game!");
    }
}