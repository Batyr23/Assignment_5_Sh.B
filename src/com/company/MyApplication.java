package com.company;

import com.company.Controllers.NecklaceController;
import com.company.Controllers.StoneController;
import java.util.Scanner;

public class MyApplication {
    private final StoneController controller;
    private final NecklaceController controller2;


    public MyApplication(StoneController controller, NecklaceController controller2) {
        this.controller = controller;
        this.controller2 = controller2;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("3. Create Stone");
            System.out.println("4. Create Necklace");
            System.out.println("5. Calculate total cost for one necklace");
            System.out.println("6. Calculate total weight for one necklace");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (0-6): ");
                int option = scanner.nextInt();
                if (option == 3) {
                    createStoneMenu();
                } else if(option == 4) {
                    createNecklaceMenu();
                } else if(option == 5){
                    UpdateOverAllCostMenu();
                } else if(option == 6){
                    UpdateOverAllWeight();
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

    public void createStoneMenu() {
        System.out.println("Please enter stone id");
        int stone_id = scanner.nextInt();

        System.out.println("Please enter stone name");
        String stone_name = scanner.next();
        scanner.nextLine();

        System.out.println("Please enter stone weight");
        double stone_weight = scanner.nextDouble();

        System.out.println("Please enter stone cost");
        double stone_cost = scanner.nextDouble();

        String response = controller.createStone(stone_id, stone_name, stone_weight,stone_cost);
        System.out.println(response);
    }

    public void createNecklaceMenu(){
        System.out.println("Please enter necklace id");
        int necklace_id = scanner.nextInt();

        System.out.println("Please enter necklace name");
        String necklace_name = scanner.next();
        scanner.nextLine();

        System.out.println("Please enter necklace weight");
        double necklace_weight = scanner.nextDouble();

        System.out.println("Please enter necklace cost");
        double necklace_cost = scanner.nextDouble();

        System.out.println("Please enter necessary number of stones for this necklace");
        int num_stones = scanner.nextInt();

        String response = controller2.createNecklace(necklace_id, necklace_name, necklace_weight,necklace_cost,num_stones);
        System.out.println(response);
    }

    public void UpdateOverAllCostMenu(){
        System.out.println("Please enter the necklace id");
        int necklace_id = scanner.nextInt();
        System.out.println("Please enter the stone id");
        int stone_id = scanner.nextInt();
        System.out.println("Please enter the number of stones");
        int num_stones = scanner.nextInt();

        controller2.UpdateOverAllCost(necklace_id,stone_id,num_stones);

    }

    public void UpdateOverAllWeight() {
        System.out.println("Please enter the necklace id");
        int necklace_id = scanner.nextInt();
        System.out.println("Please enter the stone id");
        int stone_id = scanner.nextInt();
        System.out.println("Please enter the number of stones");
        int num_stones = scanner.nextInt();

        controller2.UpdateOverAllWeight(necklace_id,stone_id,num_stones);
    }

    // I added here generics but do not know what I need to do with this in my project
    public <T> void UserMenu(T param1) {
        param1 = (T) scanner.next();
        System.out.println(param1);
    }

}   