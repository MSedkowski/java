
package ludo.client;
import ludo.common.Request;
//import common.Space;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import javafx.scene.control.Button;
import ludo.client.view.GeneralViewController;
import ludo.common.Board;
import ludo.common.PlayerList;
/**
 *
 * @author Mateusz
 */
public class Client {
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket socket;
    private int myId;
    private PlayerColor color;
    private String name;

    private String hostName;   
    private int port;

    private Queue<Request> listRequest;
    private boolean myTurn = false;
    public Client( InetAddress inetAddress, int port ) {
	this.hostName = inetAddress.getHostName();
	this.port = port;
	this.listRequest = new ArrayDeque<Request>();

	try {
            this.socket = new Socket(this.hostName, this.port);
            this.out = new ObjectOutputStream(this.socket.getOutputStream());
            this.in = new ObjectInputStream( this.socket.getInputStream());
            
	} catch (IOException e) {
            e.printStackTrace();
	}
    }

    private synchronized Request getrequest(){
        return listRequest.poll();
    }    
    
    @SuppressWarnings("unchecked")
    private void handleTheRequest(Request request){
        switch (request.getCodeRequest()){
            case 500: //Ustawienie graczy i wyświetlenie gry
                ScreenController.getScreenController().getEnterStage().close();
                ScreenController.getScreenController().getGeneralStage().setTitle(name);
                ScreenController.getScreenController().showGame();
                ScreenController.getScreenController().getGeneralViewController().createListOfButtons();
                ScreenController.getScreenController().getGeneralViewController().initializeListOfPlayers((PlayerList) request.getData());
                ScreenController.getScreenController().getGeneralViewController().initializeListOfFields();
                if(color == null) {
                    color = PlayerColor.valueOf(((PlayerList) request.getData()).getPlayerList().size()-1);
                    System.out.print(color);
                }
                break;
            case 501: //Ustawienie żetonów na planszy
                ScreenController.getScreenController().getGeneralViewController().setTokens();
                break;
            case 503: //Ustawienie identyfikatora
                this.myId = (int) request.getData();
                break;
            case 504: //Ustawienie aktywnego gracza
                if(this.color.toString().equalsIgnoreCase((String) request.getData())) {
                    ScreenController.getScreenController().getGeneralViewController().setActivePlayer(this.color.toString());
                    this.myTurn = true;
                }
                else {
                    ScreenController.getScreenController().getGeneralViewController().setActivePlayer((String) request.getData());
                    this.myTurn = false;
                }
                System.out.println(myTurn);
                break;
            case 505:
                ScreenController.getScreenController().getGeneralViewController().setBoard((Board) request.getData());
                break;
            case 507:
                ScreenController.getScreenController().getWinningStage().setTitle(name);
                ScreenController.getScreenController().getGeneralStage().close();
                if(this.myId == (int) request.getData()){
                    ScreenController.getScreenController().showResultScreen();
                    ScreenController.getScreenController().getWinningStageController().setWinner("Zwycięstwo!", this.color.toString());
                }
                else {
                    ScreenController.getScreenController().showResultScreen();
                    ScreenController.getScreenController().getWinningStageController().setWinner("Porażka!", this.color.toString());
                }
                break;
        }
    }
    
    public synchronized void addRequest(Request request){
	listRequest.add(request);
    }
    
    private void readRequest() throws ClassNotFoundException, IOException{
		if (this.socket.getInputStream().available() > 0) {
			Request request = (Request) this.in.readObject();
			//System.out.println("Client get code: " + request.getCodeRequest() );
			addRequest(request);
		}
	}

	public void closeConnection(){
		this.sendRequest(new Request(600, null));
		this.close();
	}

	public void sendRequest(Request request){
		//System.out.println("Send request. Code: " + request.getCodeRequest());
		try {
			this.out.reset();
			this.out.writeObject(request);
			this.out.flush();
		} catch (IOException e) {
			this.addRequest(request);
			e.printStackTrace();
		}
	}

	public void run(){
		try {
			readRequest();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		if ( !this.listRequest.isEmpty() ){
			this.handleTheRequest(this.getrequest());
		}
	}

	private void close(){
		try {
			this.in.close();
			this.out.close();
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PlayerColor getColor() {
		return color;
	}

	public int getMyId(){
		return this.myId;
	}

    public void setName(String text) {
        this.name = text;
    }
    

}
