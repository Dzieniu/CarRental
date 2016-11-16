package carrental;
/**
 * @author Konrad
 */
public class Rent {
    
    private String client;
    private String car;
    private String date;
    
    public Rent(String client, String car, String date){
        this.client = client;
        this.car = car;
        this.date=date;
    }
    
    public String getClient(){
        return client;
    }
    
    public String getCar(){
        return car;
    }
    
    public String getDate(){
        return date;
    }
    
}
