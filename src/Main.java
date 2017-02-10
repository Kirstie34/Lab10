import java.util.ArrayList;
import java.util.Scanner;

//This program allows a user to view new and used cars and select if they would like to purchase one.

public class Main {

    public static void main(String[] args) {

        Scanner scan1 = new Scanner(System.in);

        int count = 1; //numbers car list
        int count2 = 7; //numbers quit option


        //list of all inventory (new and used)
        ArrayList<Car> carList = new ArrayList<Car>();

        carList.add(new Car("Nikolai", "Model S", 2017, 54999.90));
        carList.add(new Car("Fourd", "Escapade", 2017, 31999.90));
        carList.add(new Car("Chewie", "Vette", 2017, 44989.95));
        carList.add(new UsedCar("Hyonda", "Prior", 2015, 14795.50, 35987.6));
        carList.add(new UsedCar("GC", "Chirpus", 2013, 8500.00, 12345.0));
        carList.add(new UsedCar("GC", "Witherell", 2016, 14450.00, 3500.3));


        for (Car c : carList) { //prints out complete numbered car list
            System.out.println(count++ + ". " + c.toString());

        }
        System.out.println(count2-- + ". " + "Quit"); //adds quit option to list

        boolean carPurchase = true;

        int count4 = 8; //decreases bounds for if statement with every car purchase

        while (carPurchase) { //repeats the following until user selects quit option

            count4--;

            System.out.println();
            System.out.print("Which car would you like? ");
            int carChoice = scan1.nextInt();

            if (carChoice > 0 && carChoice < count4) {
                System.out.println(carList.get(carChoice - 1));
            } else {
                System.out.println("Have a great day!");
                System.exit(0);
            }

            System.out.print("Would you like to buy this car? ");
            char purchaseCar = scan1.next().charAt(0);

            if (purchaseCar == 'y' || purchaseCar == 'Y') {
                System.out.println("Excellent! Our finance department will be in touch shortly.");
                System.out.println();                                  // if user selects number of car, removes car and
                carList.remove(carChoice - 1);                  // reprints car list

                int count3 = 1;
                for (Car c : carList) {
                    System.out.println(count3++ + ". " + c.toString());

                }

                System.out.println(count2-- + ". " + "Quit");

            } else {

                System.out.println("Have a great day!");                //if user selects number of quit, exits program
                System.exit(0);


            }
        }
    }
}
