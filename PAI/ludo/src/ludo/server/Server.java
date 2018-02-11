package ludo.server;

/**
 *
 * @author Mateusz
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import ludo.common.Request;
//import ludo.common.Space;
import javafx.util.Pair;
import ludo.common.Player;
import ludo.common.PlayerList;
//import ludo.client.Color;

public class Server extends Receiver {
    private static final int RefreshPlayers = 0;
    private static final int SendMove = 1;
    private static final int SendResult = 2;
    
    private PlayerList listOfPlayers;
    private static String[] colorList = {"blue", "green", "yellow", "red"};
    //private Queue<Move> moveTosend;
    //private Color win;
    
    public Server(){
        super(null);
        listOfPlayers = new PlayerList();
    }
    
    @Override
    public boolean addClient(Client client){
        boolean res = super.addClient(client);
	if (res){
            client.addRequest(new Request(503, client.getMyId()));
	}
	return res;
    }
    
    @Override
    protected void sendRespond() {
    }

    @Override
    protected void loop() {
    }
    
    @Override
    protected void handleTheRequest(Pair<Request, Client> request) {
            Request req = request.getKey();
            Client client = request.getValue();

            switch (req.getCodeRequest()){
		case 100:	//create new player
                        System.out.println(req.getData());
			listOfPlayers.addPlayer(new Player((String)req.getData(), colorList[listOfPlayers.getPlayerList().size()]));
			this.addTask(RefreshPlayers);
			break;
		default:
			System.out.println("Server - Incoming request code: " + req.getCodeRequest());
			break;
            }
    }
    
    @Override
    protected void handleTheTask(Integer task) {
        if(task == RefreshPlayers) {
            Request request = new Request(500, this.listOfPlayers);
            sendToAll(request);
        }
        
    }
    
    private void sendToAll(Request request) {
        for(Client client : this.getClientList()){
                client.addRequest(request);
            }
    }
    

}

//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import ludo.common.Player;
//import ludo.common.PlayerList;
//
///**
// *
// * @author Mateusz
// */
//
//class Connected extends Thread {
//
//    private Socket clientSocket;
//    private static PlayerList listOfPlayers;
//    private static int playerId;
//    private static String[] colorList = {"blue", "green", "yellow", "red"};
//    private static int actualPlayer = 0;
//
//    public Connected(Socket clientSocket, PlayerList listOfPlayers, int playerId) {
//        this.clientSocket = clientSocket;
//        Connected.listOfPlayers = listOfPlayers;
//        Connected.playerId = playerId;
//    }
//    
//     public void run() {
//         
//        try {
//            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
//            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
//            String inputLine;
//            while ((inputLine = in.readUTF()) != null) {
//                String[] request = inputLine.split(":");
//                int selection = Integer.parseInt(request[0]);
//                switch(selection) {
//                    case 101: { //create new player
//                        int size = 0;
//                        String color = colorList[size];
//                        if (!listOfPlayers.getPlayerList().isEmpty() && size < 4) {
//                            size = listOfPlayers.getPlayerList().size();
//                            color = colorList[size];
//                        }
//                        listOfPlayers.addPlayer(new Player(request[1], color));
//                        switch(size) {
//                            case 0: {
//                                sendResponse("101:0");
//                                break;
//                            }
//                            case 1: {
//                                sendResponse("101:1:" + listOfPlayers.getPlayerList().get(0).getName() + ":" 
//                                        + listOfPlayers.getPlayerList().get(0).getColor());
//                                break;
//                            }
//                            case 2: {
//                                sendResponse("101:2:" + listOfPlayers.getPlayerList().get(0).getName() 
//                                        + ":" + listOfPlayers.getPlayerList().get(0).getColor() + ":" 
//                                        + listOfPlayers.getPlayerList().get(1).getName() + ":" 
//                                        + listOfPlayers.getPlayerList().get(1).getColor());
//                                break;
//                            }
//                            case 3: {
//                                sendResponse("101:3:" + listOfPlayers.getPlayerList().get(0).getName() 
//                                        + ":" + listOfPlayers.getPlayerList().get(0).getColor() + ":" 
//                                        + listOfPlayers.getPlayerList().get(1).getName() + ":" 
//                                        + listOfPlayers.getPlayerList().get(1).getColor() + ":" 
//                                        + listOfPlayers.getPlayerList().get(2).getName() + ":" 
//                                        + listOfPlayers.getPlayerList().get(2).getColor());
//                                break;
//                            }
//                        }
//                        break;
//                    }
//                    case 102: { //get player data
//                        Player player = listOfPlayers.searchPlayerByName(request[1]);
//                        sendResponse("102:" + player.getName() + ":" + player.getColor());
//                        break;
//                    }
//                    
//                    case 103: { //change player
//                        if(actualPlayer != 3) actualPlayer++;
//                        else actualPlayer = 0;
//                        sendResponse("103:" + actualPlayer);
//                        break;
//                    }
//                    
//                    case 104: {
//                        int sendSize = Integer.parseInt(request[1]);
//                        if(listOfPlayers.getPlayerList().size() > sendSize) {
//                            int index = listOfPlayers.getPlayerList().size() - sendSize;
//                            switch(index) {
//                                case 1:
//                                    sendResponse("104:" + listOfPlayers.getPlayer(3).getName() + ":" 
//                                    + listOfPlayers.getPlayer(3).getColor());
//                                    break;
//                                case 2: 
//                                    sendResponse("104:" + listOfPlayers.getPlayer(2).getName() + ":" 
//                                    + listOfPlayers.getPlayer(2).getColor() + ":" 
//                                    + listOfPlayers.getPlayer(3).getName() + ":"
//                                    + listOfPlayers.getPlayer(3).getColor());
//                                    break;
//                                case 3:
//                                    sendResponse("104:" + listOfPlayers.getPlayer(1).getName() + ":" 
//                                    + listOfPlayers.getPlayer(1).getColor() + ":"
//                                    + listOfPlayers.getPlayer(2).getName() + ":" 
//                                    + listOfPlayers.getPlayer(2).getColor() + ":" 
//                                    + listOfPlayers.getPlayer(3).getName() + ":"
//                                    + listOfPlayers.getPlayer(3).getColor());
//                                    break;
//                            }
//                        }
//                        break;
//                    }
//                    
//                }
//                
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(Connected.class.getName()).log(Level.SEVERE, null, ex);
//        }    
//     }
//     
//     public PlayerList getListOfPlayers() {
//         return this.listOfPlayers;
//     }
//     
//     public void sendResponse(String request) throws IOException {
//        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
//        out.writeUTF(request);
//        out.flush();
//     }
//}
//
//public class Server {
//    private static int portNumber = 4444;
//    private int playerId = 0;
//    private List<Connected> listOfClients = new ArrayList<>();
//    public void run() {
//        PlayerList listOfPlayers = new PlayerList();
//        
//         try {
//            ServerSocket serverSocket = new ServerSocket(portNumber);
//            while (true) {
//                Socket clientSocket = serverSocket.accept();
//                Connected newClient = new Connected(clientSocket, listOfPlayers, playerId);
//                newClient.start();
//                listOfClients.add(newClient);
//                playerId++;
//            }
//
//        } catch (IOException e) {
//            System.out.println("Exception caught when trying to listen on port "
//                    + portNumber + " or listening for a connection");
//            System.out.println(e.getMessage());
//        }
//    }
//    
//    public static void main(String[] args) {
//
//        Server serwer = new Server();
//        serwer.run();
//        
//    }
//    
//    private void sendToAll(String request) throws IOException {
//        for(Connected client : listOfClients) {
//            client.sendResponse(request);
//        }
//    }
//    
//}