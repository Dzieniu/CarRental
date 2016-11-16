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
public class CarQuantity {
    
    private ArrayList<Car> cars = new ArrayList<>();
    private final String fileName = "cars.txt";
    
    public void loadCars(){
        
        try{
                FileReader readerF = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(readerF);
                String line = null;

                while((line = reader.readLine()) !=null){
                    String r[] = line.split(" ");
                    cars.add(new Car(Integer.parseInt(r[0]), r[1], Integer.parseInt(r[2])));            
                }
            }
        catch(Exception e){
            System.out.println("Something goes wrong with file");
            }    
        }
    
    public void saveCars(){
        try{
            PrintWriter os = new PrintWriter(fileName);
            for(Car car:cars){
                os.println(car.getId()+" " + car.getModel()+ " " + car.getAvailableNumber());
            }
            os.close();
        }
        catch(IOException e){
            System.out.println("Something goes wrong with file");
        }
        
        
    }
    
    public void addCar(){
        System.out.println("Enter car model: ");
        Scanner scan = new Scanner(System.in);
        String carName = scan.nextLine();
        System.out.println("Enter available number of this car: ");
        int availavleValue = scan.nextInt();
        cars.add(new Car(cars.size()+1, carName, availavleValue));
        System.out.println("You have added new car ");
    }
    
    public void showCars(){
        for(Car car:cars){
            System.out.println("Id: "+ car.getId() +" Car: " + car.getModel() + " Available Number: " + car.getAvailableNumber());
        }
    }
    public ArrayList<Car> getCars(){
        return cars;
    }
}
