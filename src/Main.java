import system.AnsiColor;
import system.FileUtils;

import java.util.Scanner;
public class Main {
    private static final Scanner scan = new Scanner(System.in);
    private static final FileUtils fileUtils = new FileUtils();
    private static final Player myPlayer = new Player();
    private static String choice = "";
    private static boolean spielAktiv = true;

    public static void AdminCommands(String pChoice){
        if(pChoice.equalsIgnoreCase("/help")){
            System.out.println(AnsiColor.ANSI_BLUE + "/newPlayerName " + AnsiColor.ANSI_RED + "to select a new player name." + AnsiColor.ANSI_RESET);
            System.out.println(AnsiColor.ANSI_BLUE + "/stats " + AnsiColor.ANSI_RED + "to look at your stats." + AnsiColor.ANSI_RESET);
            System.out.println(AnsiColor.ANSI_BLUE + "/inv " + AnsiColor.ANSI_RED + "to look at your inventory." + AnsiColor.ANSI_RESET);
            System.out.println(AnsiColor.ANSI_BLUE + "/equip " + AnsiColor.ANSI_RED + "to equip an item from the inventory." + AnsiColor.ANSI_RESET);
            System.out.println(AnsiColor.ANSI_BLUE + "/unequip " + AnsiColor.ANSI_RED + "to unequip an item from a slot." + AnsiColor.ANSI_RESET);
            System.out.println(AnsiColor.ANSI_BLUE + "/trash " + AnsiColor.ANSI_RED + "to trash a selected item." + AnsiColor.ANSI_RESET);
            System.out.println(AnsiColor.ANSI_BLUE + "/exit " + AnsiColor.ANSI_RED + "to exit the game." + AnsiColor.ANSI_RESET);
        }else if(pChoice.equalsIgnoreCase("/newPlayerName")){
            System.out.println(AnsiColor.ANSI_RED + "Please choose a name for your player." + AnsiColor.ANSI_RESET);
            System.out.print("> ");
            pChoice = scan.nextLine();

            while (pChoice.length() < 3) {
                System.out.println(AnsiColor.ANSI_RED + "Your name cannot be any shorter, than 3 characters!" + AnsiColor.ANSI_RESET);
                System.out.println(AnsiColor.ANSI_RED + "Please choose a new name." + AnsiColor.ANSI_RESET);
                System.out.print("> ");
                pChoice = scan.nextLine();
            }

            myPlayer.playerName = pChoice;
            System.out.println(AnsiColor.ANSI_RED + "Your new name is now " + AnsiColor.ANSI_WHITE_BOLD + myPlayer.playerName + AnsiColor.ANSI_RED + "." + AnsiColor.ANSI_RESET);
            System.out.println();
        }else if(pChoice.equalsIgnoreCase("/exit")){
            spielAktiv = false;
        }else if(pChoice.equalsIgnoreCase("/stats")){
            myPlayer.printStatus();
            System.out.println();
            myPlayer.showItems();
        }else if(pChoice.equalsIgnoreCase("/inv")){
            myPlayer.showInventory();
        }else if(pChoice.equalsIgnoreCase("/equip")){
            System.out.println(AnsiColor.ANSI_RED + "Which item would you like to equip?" + AnsiColor.ANSI_RESET);
            System.out.print("> ");

            String itemChoice = scan.nextLine();
            myPlayer.equipItem(myPlayer.takeItem(itemChoice));
        }else if(pChoice.equalsIgnoreCase("/unequip")){
            System.out.print("> ");
            pChoice = scan.nextLine();
            while (!pChoice.equalsIgnoreCase("Weapon") && !pChoice.equalsIgnoreCase("Armor") && !pChoice.equalsIgnoreCase("Gloves") && !pChoice.equalsIgnoreCase("Shield") && !pChoice.equalsIgnoreCase("Boots") && !pChoice.equalsIgnoreCase("Helmet")&& !pChoice.equalsIgnoreCase("exit")) {
                System.out.println();
                System.out.println(AnsiColor.ANSI_RED + "Please select a valuable Item type." + AnsiColor.ANSI_RESET);
                System.out.print("> ");
                pChoice = scan.nextLine();
                if(pChoice.equalsIgnoreCase("exit")){
                    System.out.println(AnsiColor.ANSI_RED + "No Item was unequipped." + AnsiColor.ANSI_RESET);
                }
            }
            System.out.println();
            myPlayer.unequipItem(pChoice);
        }else if(pChoice.equalsIgnoreCase("/trash")){
            System.out.println(AnsiColor.ANSI_RED + "Which item would you like to trash?" + AnsiColor.ANSI_RESET);
            System.out.print("> ");

            pChoice = scan.nextLine();
            Item trashedItem = null;
            trashedItem = myPlayer.takeItem(pChoice);
            trashedItem = null;
        }
    }

    public static void main(String[] args) {

        myPlayer.saveToConfig();
        String eingabe = "";
        Weapon test = new Weapon("test", 35, "Rare", 4, 7, "IncreasedDMG", 3, "IncreasedGold", 10);
        myPlayer.storeItem(test);
        Helmet brille = new Helmet("Brille", 15, "Magical", 5, 5, "increasedHP", "", 0);
        myPlayer.storeItem(brille);
        myPlayer.storeItem(Items.WOODEN_AXE.getItem());

        System.out.println("Welcome!");
        System.out.println("Please give yourself a name.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("> ");
        eingabe = scan.nextLine();
        while (eingabe.length() < 3) {
            System.out.println(AnsiColor.ANSI_RED + "Your name cannot be any shorter, than 3 characters!" + AnsiColor.ANSI_RESET);
            System.out.println(AnsiColor.ANSI_RED + "Please choose a new name." + AnsiColor.ANSI_RESET);
            System.out.print("> ");
            eingabe = scan.nextLine();
        }
        myPlayer.playerName = eingabe;
        System.out.println("Great! Welcome " + AnsiColor.ANSI_WHITE_BOLD + myPlayer.playerName + AnsiColor.ANSI_RESET + ".");
        System.out.println();

        while (spielAktiv) {
            System.out.println();

            //Command List
            System.out.println("To see player stats, type 'stats'");
            System.out.println("To show the inventory, type 'inv'");
            System.out.println("To end the game, type 'exit'");
            System.out.print("> ");

            //Check player choice
            choice = scan.nextLine();
            if(choice.startsWith("/")){
                AdminCommands(choice);
            }else if (choice.equalsIgnoreCase("exit")) {
                spielAktiv = false;
            } else if (choice.equalsIgnoreCase("stats")) {
                boolean statusOpen = true;

                while (statusOpen) {
                    System.out.println();
                    myPlayer.printStatus();
                    System.out.println();
                    myPlayer.showItems();
                    System.out.println();
                    System.out.println("To unequip an equipped item, type 'unequip'");
                    System.out.println("To exit out of the Status menu, type 'close'");
                    System.out.print("> ");
                    choice = scan.nextLine();

                    if(choice.startsWith("/")){
                        AdminCommands(choice);
                    }else if (choice.equalsIgnoreCase("unequip")) {
                        System.out.println("Which Item Slot would you like to unequip from?");
                        System.out.print("> ");
                        choice = scan.nextLine();
                        if(choice.startsWith("/")){
                            AdminCommands(choice);
                        }
                        while (!choice.equalsIgnoreCase("Weapon") && !choice.equalsIgnoreCase("Armor") && !choice.equalsIgnoreCase("Gloves") && !choice.equalsIgnoreCase("Shield") && !choice.equalsIgnoreCase("Boots") && !choice.equalsIgnoreCase("Helmet")&& !choice.equalsIgnoreCase("exit")) {
                            System.out.println();
                            System.out.println(AnsiColor.ANSI_RED + "Please select a valuable Item type." + AnsiColor.ANSI_RESET);
                            System.out.print("> ");
                            choice = scan.nextLine();
                            if(choice.startsWith("/")){
                                AdminCommands(choice);
                            }else if(choice.equalsIgnoreCase("exit")){
                                System.out.println(AnsiColor.ANSI_RED + "No Item was unequipped." + AnsiColor.ANSI_RESET);
                            }
                        }
                        System.out.println();
                        myPlayer.unequipItem(choice);
                    } else if (choice.equalsIgnoreCase("close")) {
                        statusOpen = false;
                    } else {
                        System.out.println();
                        System.out.println("Command not recognized");
                    }
                }
            } else if (choice.equalsIgnoreCase("inv")) {
                boolean inventoryOpen = true;

                while (inventoryOpen) {
                    System.out.println();
                    myPlayer.showInventory();
                    System.out.println();
                    System.out.println("To equip an item, type 'equip'");
                    System.out.println("To delete an item, type 'trash'");
                    System.out.println("To exit out of the Inventory, type 'close'");
                    System.out.print("> ");

                    choice = scan.nextLine();
                    if(choice.startsWith("/")){
                        AdminCommands(choice);
                    }else if (choice.equalsIgnoreCase("DEBUG")) {
                        Weapon debugWeapon = new Weapon("DEBUG", 1, "Normal", 999, 999, "", 0, "", 0);
                        myPlayer.storeItem(debugWeapon);
                    } else if (choice.equalsIgnoreCase("equip")) {
                        System.out.println();
                        System.out.println("Which item would you like to equip?");
                        System.out.print("> ");

                        String itemChoice = scan.nextLine();
                        if(choice.startsWith("/")){
                            AdminCommands(choice);
                        }
                        myPlayer.equipItem(myPlayer.takeItem(itemChoice));
                    } else if (choice.equalsIgnoreCase("trash")) {
                        System.out.println();
                        System.out.println("Which item would you like to trash?");
                        System.out.print("> ");

                        choice = scan.nextLine();
                        if(choice.startsWith("/")){
                            AdminCommands(choice);
                        }
                        Item trashedItem = null;
                        trashedItem = myPlayer.takeItem(choice);
                        trashedItem = null;
                    } else if (choice.equalsIgnoreCase("close")) {
                        inventoryOpen = false;
                    } else {
                        System.out.println();
                        System.out.println(AnsiColor.ANSI_RED + "Command not recognized" + AnsiColor.ANSI_RESET);
                    }
                }
            }
        }
    }

    public static FileUtils getFileUtils() {
        return fileUtils;
    }

    public static Scanner getScan() {
        return scan;
    }

    public static Player getMyPlayer() {
        return myPlayer;
    }
}