package timemanagment;

import java.io.*;
import java.net.*;

public class TimeManagement {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println(
                    "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
                Socket echoSocket = new Socket(hostName, portNumber);
                DataOutputStream out = new DataOutputStream(echoSocket.getOutputStream());
                DataInputStream in = new DataInputStream(echoSocket.getInputStream());) {
            BufferedReader stdIn
                    = new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;
            while(true) {
                    readFromServer(in);
                    
                    fromUser = stdIn.readLine();
                    if (fromUser != null) {
                        System.out.println("Client: " + fromUser);
                        out.writeUTF(fromUser);
                    }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to "
                    + hostName);
            System.exit(1);
        }
    }

    private static void readFromServer(DataInputStream in) throws IOException {
        String fromServer;
        fromServer = in.readUTF();
        System.out.println("Server: " + fromServer);
        if (fromServer.equals("Bye.")) {
            System.out.println("Client: " + fromServer);
            System.exit(1);
        }
    }
}

