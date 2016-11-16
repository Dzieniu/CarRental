package carrental;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Konrad
 */
public class RentQuantity {
    
    private ArrayList<Rent> rents = new ArrayList<Rent>();
    private final String filename = "rents.txt";
  
    
    public void addRent(CarQuantity cars, ClientQuantity clients){
        clients.showClients();
        System.out.println("Enter client id: ");
        Scanner scan = new Scanner(System.in);
        int clientId = scan.nextInt();
        System.out.println("Enter car id: ");
        cars.showCars();
        int carId = scan.nextInt();
        System.out.println("Enter date (dd/mm/yyyy/)");
        scan = new Scanner(System.in);
        String date = scan.nextLine();
        if(cars.getCars().get(carId-1).getAvailableNumber()==0){
            System.out.println("There is no car, which you selected.");
        }
        else{
        rents.add(new Rent(clients.getClients().get(clientId-1).getName(), cars.getCars().get(carId-1).getModel(), date));
        System.out.println("You have added new rent.");
        cars.getCars().get(carId-1).incDownAvailableNumber();
        }
    }
    
    public void showRents(){
        for(Rent rent:rents){
            System.out.println("Rent: Client: "+ rent.getClient() + " Car:  " + rent.getCar() + " Date: " + rent.getDate());
        }
    }
    
    public void loadRents(){
        try{
                FileReader readerF = new FileReader(filename);
                BufferedReader reader = new BufferedReader(readerF);
                String line = null;

                while((line = reader.readLine()) !=null){
                    String r[] = line.split(" ");
                    rents.add(new Rent(r[0], r[1], r[2]));            
                }
            }
        catch(Exception e){
            System.out.println("Something goes wrong with file");
            }    
        }
    
    public void saveRents(){
        try{
            PrintWriter os = new PrintWriter(filename);
            for(Rent rent:rents){
                os.println(rent.getClient()+" " + rent.getCar()+ " " + rent.getDate());
            }
            os.close();
        }
        catch(IOException e){
            System.out.println("Something goes wrong with file");
        }
    }
    
}
