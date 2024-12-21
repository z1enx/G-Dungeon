import java.util.Scanner;

public class ListMonster {
    Monster head;
    String modelGodzilla = 
                        "                  *-  *-~-   :=)                               \n" + //
                        "        ^<>% -(^. >[( #^=  - *.^=    :                         \n" + //
                        "    }{##%[]#<    -:^+>)]=+)>>(>+.~=*>~                       \n" + //
                        " ~@@@@@@@@#@%#[><<()()=>}{{((+<><><                        \n" + //
                        "@@@@@@@@@@@@@%@%%{#{[<<(^(><^+)}{{^)                         \n" + //
                        " : @@@@@@@@@@@@@@@@%@#{%##^{#{)^+[~                        \n" + //;
                        "   @@@< -@@@@@@@@@@@@%[#@}^#{-~)<>(([}                       \n" + //
                        "          @@@@@@@@@%#%@@<(%((%{[]>^<{.   +-                    \n" + //
                        "            @@@@@@@@#%@@@@@[#%^%#^+- .+^]<.                    \n" + //
                        "            }@@@@@@@@@@@@@@@@@@@@#@#))[][#=                    \n" + //
                        "            @@@@@@@@@@@@@%@@@@@%@@@@@[)#@#<                    \n" + //
                        "           @@@@@@@@@@@@@@%%@@@@@@@@@##@##+=>                   \n" + //
                        "         @@@@@*  @@@@@@@@@@@@@@@@@@##@@@@[{<                   \n" + //
                        "       ^@@@@@     [@@@@@@@@@@@@@@@%@@@@@@%#>                  :\n" + //
                        "      ^@@@(     <@%@@%@@@@@@@@@@@#@@)@@@@@#=                  ]\n" + //
                        "    <@@@@      )#@@@@@@@@@@@@@@@>@@@)@@@@@%#(*               [}\n" + //
                        "   :@@@@    *%@@@@@@@@@@@@@@@@@@@%@@@@@@@@@##<-            =#{(\n" + //
                        "   @+@]         @@@@@@@@@@@@@@@@@@@@@@@@%@@@###{.  >#  %+%####~\n" + //
                        "                @@@@@@@@@@@@@@@@@@@@@@@@@@@@%#%}##]}}]{####%#  \n" + //
                        "                @@@@@@@@     >@@@@@@@@@@@@@@@###%#%#%##%%@@]-  \n" + //
                        "                @@@@@@@@.     @@@@@@@@@@@@@@@@@##%%%%%%@@[~    \n" + //
                        "                @@@@@@@@      ]@@@@@@@@@@@@@@@@@@@@@@@<:       \n" + //
                        "                @@@@@@@-       =@@@@@@@@@@-~+><(])+.           \n" + //
                        "               >@@@@@@{         )@@@@@@@@@>*+~-.               \n" + //
                        "               @@@@@@@>   ..:----%@@@@@@@@~                    \n" + //
                        "             @@@@@@@@@>~------:---%@@@@@@@#                    \n" + //
                        "           +@@@@@@@@@}=--::::-:::::@@@@@@@@>                   \n" + //
                        "             @@@@@@@>-     .:--==)@@@@@@@                    \n" + //
                        "                           .::->@@@@@@@@@                    \n" + //
                        "                                <@@@@@@@@@@                    \n" + //
                        "                                 @@@@@@@@@@                    \n";
    String modelMonsterZero = 
                        "                     (#                                           }{             \n" + //
                        "                     )%%]                                      ]%%%              \n" + //
                        "                    }%%%%#                                   (%%%%%}<            \n" + //
                        "             (([#%%%%%%%%%[                                 {%%%%%%%%%{][] )#%)  \n" + //
                        "        #%%}}}[[}#%%%%%%%%%]                              <}%%%%%%%%#{[[}}#%     \n" + //
                        "          %%%%#}#%%%%%%%%%%%]                             #%%%%%%%%###%%%%%#     \n" + //
                        "        ]%%%%%%%%%##%%%%%%%%#                            (%%%%%%#%%%%%%%%%%[     \n" + //
                        "      )}#%%%%%%%%%%%%%%%%%%%%(                          ]%%%%%%%%%%%%%%%%%%{]    \n" + //
                        "    (}{####%%%%%%%%%%%%%%%%%%(                         (}%%%%%%%%%%%%%%%####]]%) \n" + //
                        "}#%%%%%%%%%#%%%%%%%%%%%%%{{%%#(                        ]%%{%%%%%%%%%%#%%%%%%%%   \n" + //
                        "     (%%%%%%%%%%%%#%%%%%%%#%%%]                        #%#%%%%%%#%%%%%%%%%%%>    \n" + //
                        "      {%%%%%%%%%%%%%%%%%%%%%%%{                       (%%%%%%%%%%%%%%%%%%%%%     \n" + //
                        "      #%%%%%%%%%%%%%%%%%%%%%%%#              <        {%%%%%%%%%%%%%%%%%%%%%^    \n" + //
                        "     )%%%%%%%%%%%%%%%%%%%%%%%%#            %%%%%}    (%%%%%%%%%%%%%%%%#%%##%[    \n" + //
                        "     [%%#%%%%%%%%%%%%%%%%%%%%%#          )#%%        [#%%%%%%%%%%%%%%%%%%%%%{    \n" + //
                        "     }#%%%%%%%%%%%%%%%%%%%%%%%%{        #%%%%%}%%%%>  {%%%%%%%%%%%%%%%%%%%%%}]   \n" + //
                        "     ]#%%%%%%%%%%%%%%%%%%%%%%%%%[      (%%(%%#%%      %%%%%%%%%%%%%%%%{       }  \n" + //
                        "    #]        {%%%%%%%%%%%%%%%%%%]      %%%(%%%%     ]%%%%%%%%%%%%%#             \n" + //
                        "                #%%%%%%%%%%%%%%%%%[}     %%}}%{#%    {%%%%%%%%%%%%               \n" + //
                        "                  %%%%%%%%%%%%%%%%%%%#{}[ %#[{%%%) ]%%%%%%%%%%%%{                \n" + //
                        "                   [%%%%%%%%%%%%%%%%%%%%%%#%%}%%%#%%%%%%%%%%%%%{                 \n" + //
                        "                     {%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                 \n" + //
                        "                     [%%%%%%%%%%%%%%%%%%%%%%%[[%(#%%%%%%%%%%}(%})                \n" + //
                        "                     #%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%}(<                   \n" + //
                        "                     ][  ([#%%%%%%%%%%%%%%%%%%%%%%%%%%}{(                        \n" + //
                        "                    #%%[      )  {%%%%%%#%%%%%%( ]                               \n" + //
                        "                 %%%[ %%%#[%%%{(#%%%%%%%%[]]%%%])                                \n" + //
                        "                #%%  {#{%%%#}{%%%%%%%%%%%{ (%%%%                                 \n" + //
                        "                         %%%%%%%%%%%%%{     [%%%                                 \n" + //
                        "                                  (%%%%%     {%%%%)";
    String modelKong =  "                     =~   +#@                          \r\n" + //
                        "                    {#%@@@{[+*(]                       \r\n" + //
                        "                  @.@@@@@@@@@@<+=                      \r\n" + //
                        "               @@@%#[< @@@@@@@@@[^<                    \r\n" + //
                        "              @@@@@@#=  @@@@@@@@@()                    \r\n" + //
                        "            @@@@@@@@      @@@@@@@%(                    \r\n" + //
                        "          @@@@@@@@@        @@@@@@@}@                   \r\n" + //
                        "         @@@@@@@@@         @@@@@@@%<                   \r\n" + //
                        "         @@@@@@@     ^+([<)@@@@@@@@{                   \r\n" + //
                        "        @@@@@@@#(~*>)()<<[@@@@@@@@[:~                  \r\n" + //
                        "        @@@@@@@@@{@@@@@](@@@@@@@@@}( >                 \r\n" + //
                        "          @@@@@@@@@@{[(}{@@@{(]@@@%)=                  \r\n" + //
                        "            @@@@@@@@#@@#@@@%]^=]%@@}=                  \r\n" + //
                        "                @@@@#[}%@@@{(^:)]#%%=                  \r\n" + //
                        "                   @%%@@@@###<^()[##=                  \r\n" + //
                        "                    ##%@%@%@%}{[(}#%>                  \r\n" + //
                        "                     )@@%%@@@#%#{%%().                 \r\n" + //
                        "                     {[#%@@%@@@@%%%{)~                 \r\n" + //
                        "                      #@@@@@@@@@@@%{(^ +               \r\n" + //
                        "                       @@@@@@@@@@@###]-                \r\n" + //
                        "                         @@@@@@@@@@@@#]+-              \r\n" + //
                        "                         @@@@@@@@@@@@@@]*:]            \r\n" + //
                        "                         @@@@@@@@@@@@@@@[+*            \r\n" + //
                        "                        @@@@@@@@@) @@@@@@]=:           \r\n" + //
                        "                         @@@@@@@})) @@@@@%)>=>         \r\n" + //
                        "                         @@@@@@@@@@# @@@@@@%]>         \r\n" + //
                        "                           @@@@@@@@@    @@@@@(<        \r\n" + //
                        "                               @@       @@@@@@)        \r\n" + //
                        "                                          @@@@@        \r\n" + //
                        "                                           @           \r\n";
    ListMonster() {
        Monster monster1 = new Monster("Godzilla", modelGodzilla, 300, 250, 10000);
        Monster monster2 = new Monster("Monster Zero", modelMonsterZero, 200, 200, 1500);
        Monster monster3 = new Monster("Kong", modelKong, 150, 150, 2500);
        head = monster1;
        monster1.next = monster2;
        monster2.next = monster3;
    }
    
    void displayMonster(String nama) {
        Monster temp = head;
        while(temp != null) {
            if(temp.name.equals(nama)) break;
            else temp = temp.next;
        }
        if(temp == null) System.out.println("Monster not found!");
        else {
            System.out.println(temp.name);
            System.out.println(temp.model);
        }
    }

    public Monster findMonster(String nama) {
        Monster temp = head;
        while(temp != null) {
            if(temp.name.equals(nama)) break;
            else temp = temp.next;
        }
        if(temp == null) return null;
        else {
            return temp;
        }
    }

    public Boolean battle(Player player, String nama, Graph graf, int idVertex, LinkedList list) {
        Scanner memindai = new Scanner(System.in);
        int index = 1;
        Monster monster = findMonster(nama);
        if(monster.name.equals("Godzilla") && monster.HP <= 0) {
            System.exit(0);
        }
        if(monster.live == false) {
            return false;
        }
        while(true){
            cls();
            if(monster.def <= 0) monster.def = 0;
            if(index % 2 == 0) {
                if(monster.HP <= 500) {
                    monster.atk += 20;
                    banner("MONSTER ATTACK +20");
                    cls();
                }
            }
            System.out.println("##" + "=".repeat(71) + "##");
            System.out.println("||" + " ".repeat(20) + "There's a monster in this room!" + " ".repeat(20) + "||");
            System.out.println("##" + "=".repeat(71) + "##");
            System.out.println(monster.model);
            System.out.println("##" + "=".repeat(71) + "##");
            System.out.printf("|| %-14s : %-20d || %-15s : %-10d ||%n", "Player HP", player.HP, "Monster HP", monster.HP);
            System.out.printf("|| %-14s : %-20d || %-15s : %-10d ||%n", "Player Attack", player.atk, "Monster Attack", monster.atk);
            System.out.printf("|| %-14s : %-20d || %-14s : %-10d ||%n", "Player Defense", player.def, "Monster Defense", monster.def);
            System.out.println("##" + "=".repeat(71) + "##");
            if(index % 2 == 1) {
                System.out.println("Option for player");
                System.out.println("1. Attack");
                System.out.println("2. Heal");
                System.out.println("3. Use Item");
                if(player.role.equalsIgnoreCase("Mage")) {
                    System.out.println("4. View Map");
                    System.out.println("Choose 1, 2, 3 or 4");
                }else {
                    System.out.println("Choose 1, 2 or 3");
                }
                String input = memindai.nextLine();
                    if (input.equals("1")) {
                        if (monster.def <= 0) {
                            monster.def = 0;
                            monster.HP -= (player.atk - monster.def);
                            if (monster.def < 0 ) {
                                monster.HP += monster.def;
                            }
                        }else {
                            if(monster.def < player.atk) {
                                monster.HP -= (player.atk - monster.def);
                                monster.def = 0;
                            }else {
                                monster.def -= player.atk;
                            }
                        }
                        banner("PLAYER ATTACK");
                    }else if (input.equals("2")) {
                        player.HP += 100;
                        banner("PLAYER HEAL");
                    }else if(input.equals("3")) {
                        if(list.head == null) {
                            System.out.println("You have no item!");
                            continue;
                        }
                        list.displayItem();
                        System.out.print("Item name: ");
                        input = memindai.nextLine();
                        int damage = list.findItem(input);
                        if (monster.def <= 0) {
                            monster.def = 0;
                            monster.HP -= (damage - monster.def);
                            if (monster.def < 0 ) {
                                monster.HP += monster.def;
                            }
                        }else {
                            if(monster.def < damage) {
                            monster.HP -= (damage - monster.def);
                            monster.def = 0;
                            }else {
                                monster.def -= damage;
                            }
                        }
                        String text = "PLAYER USE " + input;
                        list.delete(input);
                        banner(text);
                    }else if(input.equals("4")) {
                        Graph graph = new Graph();
                        MageSkill specialSkill = new MageSkill();
                        specialSkill.findPath(graf, idVertex);
                        graph.resetGraph();
                    }
                    else {
                        System.out.println("Invalid input. Please use 'W' for up, 'S' for down, or press Enter to select.");
                    }
            }else {
                if (player.def <= 0) {
                    player.def = 0;
                    player.HP -= (monster.atk - player.def);
                    if (player.def < 0 ) {
                        player.HP += player.def;
                    }
                }else {
                    if(player.def < monster.atk) {
                        player.HP -= (monster.atk-player.def);
                        player.def = 0;
                    }else {
                        player.def -= monster.atk;
                    }
                }
                banner("MONSTER ATTACK");
            }
            index++;
            if(monster.HP <= 0 || player.HP <= 0) {
                break;
            }
        }
        if(monster.HP <= 0) {
            cls();
            monster.live = false;
            if(monster.name.equals("Godzilla")) {
                banner("YOU'VE FINISH THE DUNGEON");
                System.exit(0);
            }else {
                String text = monster.name.toUpperCase() + " DEFEATED";
                banner(text);
                return false;
            }
        }else if(player.HP <= 0) {
            cls();
            banner("YOU HAVE BEEN SLAIN");
            return true;
        }
        return false;
    }
    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void banner(String text) {
        int length1 = (31 - text.length())/2;
        int length2;
        if(text.length() % 2 == 1) length2 = length1;
        else length2 = length1 + 1;
        System.out.println("##" + "=".repeat(31) +  "##");
        System.out.println("||" +" ".repeat(length1) + text + " ".repeat(length2) + "||" );
        System.out.println("##" + "=".repeat(31) +  "##");
        Scanner pemindai = new Scanner(System.in);
        System.out.println("Press Enter to continue...");
        pemindai.nextLine();
    }
}