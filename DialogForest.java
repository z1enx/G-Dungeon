import java.util.Scanner;

public class DialogForest {

    String Groot = "      .=+*#+**                                             \n" +
            "                                   .=##*#-#--%.       ..:                                 \n" +
            "                                  .@*---=-*--=* :===++*%%*=:                               \n" +
            "                                  +@---=-==---%**----+@*---*%+:+--                         \n" +
            "                              :.  %#-----=+---=+-----%*--+*=-*%++-.                        \n" +
            "                             :@@=.@+------+-----=----%-------=@@=                          \n" +
            "                            -%*%#%@-------+---------++-------=-+*                          \n" +
            "                           -@=-#-=*--------+--------=----------+@                          \n" +
            "                           #+--=------------------------------**%:                         \n" +
            "                           =+--------------------------------==+#                          \n" +
            "                           .#=--------------------------------==+                          \n" +
            "                            .#=--=#@@@@%*----:::--=#@@@@@#=---=*.                          \n" +
            "                             .%-=@@:.*@@@@-::::::=@@: +@@@@=-=*-                           \n" +
            "                              +++@@#*@@@@@+::::::*@@%#@@@@@+=**                            \n" +
            "                               #-@@@@@#%@@-::::::=@@@@@#@@#-=%.                            \n" +
            "                               +-=*%@@@@*-::::::::-*#%@%#+-=%=                             \n" +
            "                               +---------::::-------------=+@.                             \n" +
            "                               +------------------------===#%                              \n" +
            "                               .+=---------++==++-----====+@:                              \n" +
            "                            .=.  =*+====----+++=---====+*%*:                               \n" +
            "                            *++=: .+%#*+==========++*#%@=  -                               \n" +
            "                            -=+++####+#@%##%%%%@%###%++##-*+                               \n" +
            "                             =.  +#=-=##=--+*%@+---=*@###@+-                               \n" +
            "                               =%+--=*@=--:::+*:::--+@**++%=                               \n" +
            "                              +@%*+#*#%*=----+*----++@*+--###=*=                           \n" +
            "                          #+-#+-#-=*=@#****#*****#**#@*+*++*@*+                            \n" +
            "                         -=**@+%=--=*@#*+*---:--*%-=+#@**%-+=%-                            \n" +
            "                         .#-:+#-#=-+%@*+*%=--+++=#-=+*@*+*--=:*=                           \n" +
            "                        .#-::-#--#+%@%++--=+*+==+=*=#=%@#=---:+*.                          \n" +
            "                        *%:-=-#-==@@@%#*=--*+-==##*+#=#@#=*---#-+                          \n" +
            "                        :+###-+=++@@%*==**+**+++*%*=##%@@+*=-=%*.                          \n" +
            "                           +%%*%%%*.#%+--+-:*@@-:*--*=%@@@###*-.                           \n" +
            "                             .      @**=-*-=%@@**=-=+*%# ..                                \n" +
            "                                   :@++++*=-=@@-=#++==+@                                   \n" +
            "                                   +@=-=--::+@@=-+*--==%=                                  \n" +
            "                                   -%###=#=-#%@#-***==+%*                                  \n" +
            "                                     .:=+++=: .-=-==--::";

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printWithTypingEffect(String text) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void startDialogue(LinkedList list) {
        Scanner scanner = new Scanner(System.in);

        cls();
        System.out.println(Groot);

        printWithTypingEffect("\nYou enter a mystical forest, where the air is thick with magic.");
        printWithTypingEffect("\nA large, ancient tree with a wise face appears in front of you.");
        printWithTypingEffect("\n\n**The Elder Tree (Gyoot) speaks in a deep, resonating voice:**");
        printWithTypingEffect("'Welcome, traveler. I am the guardian of this forest. What brings you here?'");

        printWithTypingEffect("\n\n1. I seek to save this world from the darkness.");
        printWithTypingEffect("\n2. I just want to survive and find my way out.");
        printWithTypingEffect("\n3. I'm drawn to the mysteries of this forest.");
        printWithTypingEffect("\nChoose : ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                printWithTypingEffect("\nGyoot: 'A noble quest you have chosen. The path ahead is fraught with danger, but I see strength in you.'");
                printWithTypingEffect("\n\nGyoot: 'Take this, traveler. It will aid you in your journey.'");
                printWithTypingEffect("\nGyoot gives you a **Mokuton** item.");

                printWithTypingEffect("\n\nGyoot: 'Use it wisely, for the effects are temporary, but powerful. With it, you can immobilize your foes for a short time.'");
                printWithTypingEffect("\n\nPress Enter to continue...");
                scanner.nextLine();

                cls();
                printWithTypingEffect("You have received the **Mokuton** item. Your journey continues...");
                list.addItem("Mokuton", 500);
                break;
            case 2:
                printWithTypingEffect("\nGyoot: 'Ah, a seeker of survival. Even so, the forest has its own way of testing you.'");
                break;
            case 3:
                printWithTypingEffect("\nGyoot: 'The mysteries of the forest are vast, traveler. But you must be careful. Some secrets come at a great cost.'");
                break;
            default:
                printWithTypingEffect("Gyoot: 'You must choose a path to proceed.'");
                return;
        }
    }
}