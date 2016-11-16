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
public class ClientQuantity {
    private ArrayList<Client> clients = new ArrayList<Client>();
    private final String fileName = "clients.txt";
    
    public void loadClients(){
        try{
                FileReader readerF = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(readerF);
                String line = null;

                while((line = reader.readLine()) !=null){
                    String r[] = line.split(" ");
                    clients.add(new Client(Integer.parseInt(r[0]),r[1]));            
                }
            }
        catch(Exception e){
            System.out.println("Something goes wrong with file");
            }    
       }
    
    public void saveClients(){
        try{
            PrintWriter os = new PrintWriter(fileName);
            for(Client client:clients){
                os.println(client.getId()+ " " + client.getName());
            }
            os.close();
        }
        catch(IOException e){
            System.out.println("Something goes wrong with file");
        }
    }
    
    public void addClient(){
        System.out.println("Enter client name: ");
        Scanner scan = new Scanner(System.in);
        String clientName = scan.nextLine();
        clients.add(new Client(clients.size()+1, clientName));
        System.out.println("You have added new client");
    }
    
    public void showClients(){
        for(Client client:clients){
            System.out.println("Id: "+client.getId() + " Client: " + client.getName());
        }
    }
    public ArrayList<Client> getClients(){
        return clients;
    }
    
    
}
