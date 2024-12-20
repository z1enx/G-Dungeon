<<<<<<< HEAD
import java.util.Scanner;

public class Fight {
    void option(Player player, Monster monster) {
        int choice = 1;
        System.out.println("Option for player");
        System.out.println("1. Attack");
        System.out.println("2. Heal");
        System.out.println("Use 'W' for Up, 'S' for Down, and Enter to Select.");
        switch (choice) {
            case 1: System.out.println("> Attack"); break;
            case 2: System.out.println("> Heal"); break;
        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();
        if (input.equals("W") && choice > 1) {
            choice--;
        } else if (input.equals("S") && choice < 4) {
            choice++;
        } else if (input.equals("")) {
            switch (choice) {
                case 1: monster.HP -= (player.attack - monster.def); break;
                case 2: player.health += 100; break;
            }
        } else {
            System.out.println("Invalid input. Please use 'W' for up, 'S' for down, or press Enter to select.");
        }
        scanner.close();
    }

    void battle(Player player, ListMonster listMonster, Vertex loc) {
        int index = 1;
        Monster monster = null;
        if(loc.id == 3) {
            monster = listMonster.findMonster("Monster Zero");
        }else if(loc.id == 5) {
            monster = listMonster.findMonster("Kong");
        }else if(loc.id == 7) {
            monster = listMonster.findMonster("Godzilla");
        }else {
            System.out.println("There's no monster in this room");
            return;
        }
        while(monster.HP > 0 && player.health > 0){
            System.out.println("There's a monster in this room");
            System.out.printf("Player HP : %s           %d : Monster HP", player.health, monster.HP);
            System.out.println(monster.model);
            if(index % 2 == 1) {
                option(player, monster);
            }else {
                player.health -= (monster.atk - player.defense);
            }
            index++;
        }
    }
}
=======
import java.util.Scanner;

public class Fight {
    void option(Player player, Monster monster) {
        int choice = 1;
        System.out.println("Option for player");
        System.out.println("1. Attack");
        System.out.println("2. Heal");
        System.out.println("Use 'W' for Up, 'S' for Down, and Enter to Select.");
        switch (choice) {
            case 1: System.out.println("> Attack"); break;
            case 2: System.out.println("> Heal"); break;
        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();
        if (input.equals("W") && choice > 1) {
            choice--;
        } else if (input.equals("S") && choice < 4) {
            choice++;
        } else if (input.equals("")) {
            switch (choice) {
                case 1: monster.HP -= (player.attack - monster.def); break;
                case 2: player.health += 100; break;
            }
        } else {
            System.out.println("Invalid input. Please use 'W' for up, 'S' for down, or press Enter to select.");
        }
        scanner.close();
    }

    void battle(Player player, ListMonster listMonster, Vertex loc) {
        int index = 1;
        Monster monster = null;
        if(loc.id == 3) {
            monster = listMonster.findMonster("Monster Zero");
        }else if(loc.id == 5) {
            monster = listMonster.findMonster("Kong");
        }else if(loc.id == 7) {
            monster = listMonster.findMonster("Godzilla");
        }else {
            System.out.println("There's no monster in this room");
            return;
        }
        while(monster.HP > 0 && player.health > 0){
            System.out.println("There's a monster in this room");
            System.out.printf("Player HP : %s           %d : Monster HP", player.health, monster.HP);
            System.out.println(monster.model);
            if(index % 2 == 1) {
                option(player, monster);
            }else {
                player.health -= (monster.atk - player.defense);
            }
            index++;
        }
    }
}
>>>>>>> b145e92e2ec8fb2cb9ccce7e33a605a6ca711b5c
