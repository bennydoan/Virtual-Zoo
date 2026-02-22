import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dinh Tuan Doan, 2323333 and doan0050
 */
public class VirtualZoo {
    private static Scanner scan;
    private static int numberAnimals; // automatically updated
    private static ArrayList<String> usedNames = new ArrayList<>(); // Create an arraylist that strores all previously entered names
    private static int totalCost = 0; // calculate the accumulative cost


    public static int getTotalCost() //getter
    {
        return totalCost;
    }


    public static void setTotalCost(int totalCost) // setter
    {
        VirtualZoo.totalCost = totalCost;
    }

    //Scanner object
    public VirtualZoo() {
        scan = new Scanner(System.in);
    }

    public static int askNumberAnimals() {
        while (true)   // create while loop until it encounter break
        {
            System.out.println("How many animals are at your zoo?");
            String userResponse = scan.nextLine();
            try {
                numberAnimals = Integer.parseInt(userResponse);  // convert Strint to Integer to compare with 0

                if (numberAnimals > 0) {

                    break; // if number of Animal is > 0 --> we get what we want, stop the loop
                } else {
                    System.out.println("Please enter a positive number of animals"); // if not
                }
            } catch (Exception e) // if user type in  a String
            {
                System.out.println("Please enter a valid number of animals");
            }
        }
        return numberAnimals;
    }

    public static String askAnimalName(int id) {
        System.out.println("What is the name of animal #" + id + "?");
        String animalName = scan.nextLine();

        // The first animalName will never be the same as the previous name
        while (usedNames.contains(animalName)) // while - loop for typing the same name
        {
            System.out.println("That name is already taken");
            System.out.println("What is the name of animal #" + id + "?");
            animalName = scan.nextLine();
        }
        usedNames.add(animalName); // Store in array
        return animalName;
    }

    public static Animal askAnimalSpecies(String name) {
        Animal animal;
        do {
            System.out.println("What is the species of " + name + "?");
            String species = scan.nextLine().toLowerCase();
            switch (species) {
                case "tiger":
                    animal = new Tiger(name);
                    break;
                case "giraffe":
                    animal = new Giraffe(name);
                    break;
                case "hippo":
                    animal = new Hippo(name);
                    break;
                case "panda":
                    animal = new Panda(name);
                    break;
                case "monkey":
                    animal = new Monkey(name);
                    break;
                default:
                    System.out.println("That is not a valid species");
                    animal = null;
            }
        } while (animal == null);
        return animal;

    }
    

//    public static Animal askAnimalSpecies(String name) {
//        String[] animalList = {"Tiger", "Giraffe", "Hippo", "Panda", "Monkey"}; // store the all animal species
//
//        while (true) {
//            System.out.println("What is the species of " + name + "?");
//            String animalSpecies = scan.nextLine();
//
//            for (int i = 0; i < animalList.length; i++) // or can use enhanced for
//            {
//                String nameCheck = animalList[i];
//                if (nameCheck.equalsIgnoreCase(animalSpecies)) {
//                    return new Animal(name, nameCheck.substring(0, 1).toUpperCase() + nameCheck.substring(1).toLowerCase());
//                }
//            }
//            System.out.println("That is not a valid species");
//        }
//    }

    public static ArrayList<Animal> animalSelection() {
        int askNumberAnimals = askNumberAnimals(); // ask the number


        System.out.println();

        // Create an ArrayList to store the Animal objects

        ArrayList<Animal> allAnimals = new ArrayList<>();

        // the times of asking are equal to the number of animals

        for (int i = 1; i <= askNumberAnimals; i++) {
            String animalName = askAnimalName(i); // ask name

            Animal animal = askAnimalSpecies(animalName); // ask species

            allAnimals.add(animal); // add animal to Array List

        }

        return allAnimals;
    }
    public static String askItem(Animal animal) {
        String itemName;
        boolean isValid = false;

        do {
            System.out.println("What item would you like to give to " + animal.getName() + "?");
            itemName = scan.nextLine().toLowerCase();

            if (itemName.equals("toy") || itemName.equals("water") || itemName.equals("food")) {
                if (animal.getLastItem() != null && animal.getLastItem().equalsIgnoreCase(itemName)) // If the item specified by the user is the same as the most recent (
                {
                    System.out.println("You cannot give the same item as yesterday");
                } else {
                    isValid = true;
                }
            } else {
                System.out.println("That is not a valid item");
            }
        }
        while (isValid == false);

        animal.setLastItem(itemName);

        // check the three valid items (Food, Water or Toy), already being converted to toLowerCase()

        if (itemName.equals("food")) {
            animal.giveFood();
        } else if (itemName.equals("water")) {
            animal.giveWater();
        } else {
            animal.giveToy();                              // can use switch as an alternative way.
        }

        if (animal.isDead()) // check dead
        {
            totalCost += 1000;
            System.out.println(animal.getName() + " has died");
        }
        return itemName;
    }

    public void weekCycle(ArrayList<Animal> zooAnimals) {
        String[] daysOfTheWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        for (String day : daysOfTheWeek) {
            System.out.println("\nThe current day is " + day);
            System.out.println();
            for (Animal animal : zooAnimals) {
                System.out.println(animal);
            }
            for (Animal animal : zooAnimals) {
                if (!animal.isDead()) {
                    askItem(animal);
                }
            }
        }
        System.out.println("\nTotal week cost = $" + getTotalCost());
    }

    public void beginSimulation()
    {
        displayWelcome();
        ArrayList<Animal> zooAnimals = animalSelection();
        weekCycle(zooAnimals);

    }

    //-------------------------operational methods------------------------------

    /**
     * Defines the Welcome Message text
     */
    public void displayWelcome() {
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("|                     Welcome to the Virtual Zoo!                      |");
        System.out.println("|     Use this application to simulate running a zoo over one week     |");
        System.out.println("|           This program is intended for zoo employees only!           |");
        System.out.println("+----------------------------------------------------------------------+");
    }

}