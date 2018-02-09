package ludo.server;

/**
 *
 * @author Mateusz
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import ludo.Player;
import ludo.PlayerList;

/**
 *
 * @author Mateusz
 */

class Connected extends Thread {

    private Socket clientSocket;
    //private static ListOfRooms listOfRooms;
    private static PlayerList listOfPlayers;
    private static int playerId;
    private static String[] colorList = {"blue", "green", "yellow", "red"};
    private static int actualPlayer = 0;

    public Connected(Socket clientSocket, PlayerList listOfPlayers, int playerId) {
        this.clientSocket = clientSocket;
//        Connected.listOfRooms = listOfRooms;
        Connected.listOfPlayers = listOfPlayers;
        Connected.playerId = playerId;
    }
    
     public void run() {
         
        try {
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            String inputLine;
            while ((inputLine = in.readUTF()) != null) {
                String[] request = inputLine.split(":");
                int selection = Integer.parseInt(request[0]);
                switch(selection) {
                    case 101: { //create new player
                        int size = 0;
                        if (!listOfPlayers.getPlayerList().isEmpty()) 
                            size = listOfPlayers.getPlayerList().size();
                        if (listOfPlayers.getPlayerList().isEmpty() || size != 4) {
                            listOfPlayers.addPlayer(new Player(request[1], colorList[size]));
                        }
                        break;
                    }
                    case 102: { //get player color
                        Player player = listOfPlayers.searchPlayerByName(request[1]);
                        sendResponse("102:" + player.getName() + ":" + player.getColor());
                        break;
                    }
                    
                    case 103: { //change player
                        if(actualPlayer != 3) actualPlayer++;
                        else actualPlayer = 0;
                        sendResponse("103:" + actualPlayer);
                        break;
                    }
                    
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Connected.class.getName()).log(Level.SEVERE, null, ex);
        }    
     }
     
     public PlayerList getListOfPlayers() {
         return this.listOfPlayers;
     }
     
     public void sendResponse(String request) throws IOException {
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
        out.writeUTF(request);
     }
}

public class Server {
    private static int portNumber = 4444;
    private int playerId = 0;
    private String playerName;
    
    public void run() {
//        Room first = new Room("Łatwy");
//        Room second = new Room("Średni");
//        Room third = new Room("Trudny");
//        ListOfRooms list = new ListOfRooms();
//        list.addRoom(first);
//        list.addRoom(second);
//        list.addRoom(third);
        PlayerList listOfPlayers = new PlayerList();
        
         try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Connected(clientSocket, listOfPlayers, playerId).start();
                playerId++;
            }

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {

        new Server().run();
        
    }
    
}