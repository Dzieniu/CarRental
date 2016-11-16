package carrental;
/**
 * @author Konrad
 */
public class Car {
    private int id;
    private String model;
    private int availableNumber;
    
    public Car(int id, String model, int availableNumber){
        this.id=id;
        this.model = model;
        this.availableNumber=availableNumber;
    }
    
    public int getId(){
        return id;
    }
    
    public String getModel(){
        return model;
    }
    
    public int getAvailableNumber(){
        return availableNumber;
    }
    
    public void incDownAvailableNumber(){
        availableNumber = availableNumber-1;
    }
}
