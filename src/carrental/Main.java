package carrental;

import java.util.Scanner;

/**
 * @author Konrad
 */
public class Main {
    
    public static void main(String[] args) {
        
        boolean isFinish = false;
        CarQuantity cars = new CarQuantity();
        cars.loadCars();
        ClientQuantity clients = new ClientQuantity();
        clients.loadClients();
        RentQuantity rents = new RentQuantity();
        rents.loadRents();
        System.out.println("Car Rental. What would u do now?");
        while(isFinish==false){
        System.out.println("\n1. Show Cars");
        System.out.println("2. Add new Car");
        System.out.println("3. Show Clients");
        System.out.println("4. Add new Client");
        System.out.println("5. Show Rents");
        System.out.println("6. Add Rent");
        System.out.println("7. Exit");
        
        System.out.println("Your Choice");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        
        switch(choice){
            case 1:
                cars.showCars();
                break;
            case 2:
                cars.addCar();
                break;
            case 3:
                clients.showClients();
                break;
            case 4:
                clients.addClient();
                break;
            case 5:
                rents.showRents();
                break;
            case 6:
                rents.addRent(cars, clients);
                break;
            case 7:
                cars.saveCars();
                clients.saveClients();
                rents.saveRents();
                isFinish=true;
                break;
            default:
                System.out.println("Not correct choice, try again.");
                break;
        }
    }
    }
}
