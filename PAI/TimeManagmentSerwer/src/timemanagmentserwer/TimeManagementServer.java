package timemanagmentserwer;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Connected extends Thread {

    private Socket clientSocket;
    private static List<Stadium> listOfStadiums;

    public Connected(Socket clientSocket, List<Stadium> listOfStadiums) {
        this.clientSocket = clientSocket;
        Connected.listOfStadiums = listOfStadiums;
    }

    public void run() {

        try {
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            String inputLine, outputLine;

            // Initiate conversation with client
            showMenu(out);
            while ((inputLine = in.readUTF()) != null) {
                if (inputLine.equals("Bye.")) {
                    break;
                }
                switch (inputLine) {
                    case "1": {
                        showReservation(out, in);
                        break;
                    }
                    case "2": {
                        createReservation(out, in);
                        break;
                    }
                    case "3": {
                        deleteReservation(out, in);
                        break;
                    }
                    default: {
                        while (true) {
                            out.writeUTF("Zły wybór!\n 'M' - Powrót do głównego menu\n 'Z' - Zakończ połączenie");
                            String option;
                            if ((option = in.readUTF()).equalsIgnoreCase("")) {
                                option = in.readUTF();
                            }
                            if (option.equalsIgnoreCase("M")) {
                                showMenu(out);
                                break;
                            }
                            if (option.equalsIgnoreCase("Z")) {
                                clientSocket.close();
                            }
                        }
                        break;
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showMenu(DataOutputStream out) throws IOException {
        StringBuilder menu = new StringBuilder();
        menu.append("Witamy na serwerze czasu\n");
        menu.append("Menu:\n");
        menu.append("1 - Wyświetl wszystkie rezerwacje\n");
        menu.append("2 - Stwórz nową rezerwację\n");
        menu.append("3 - Usuń rezerwację\n");
        out.writeUTF(menu.toString());
        out.flush();
    }

    private static void showReservationMenu(DataOutputStream out) throws IOException {
        StringBuilder reservationMenu = new StringBuilder();
        reservationMenu.append("Wybierz interesujący Cię obiekt:\n");
        reservationMenu.append("1 - Stadion Olimpia\n");
        reservationMenu.append("2 - Sadion Elana\n");
        reservationMenu.append("3 - Stadion Iskra\n");
        out.writeUTF(reservationMenu.toString());
        out.flush();
    }

    private static int showReservation(DataOutputStream out, DataInputStream in) throws IOException {
        while (true) {
            showReservationMenu(out);
            String choosenStadium;
            if(!(choosenStadium = in.readUTF()).equalsIgnoreCase("")) {
            }
            else {
                choosenStadium = in.readUTF();
            }
            if (choosenStadium.equals("1")) {
                out.writeUTF(listOfStadiums.get(0).showStadiumReservation());
                return 0;
            } else if (choosenStadium.equals("2")) {
                out.writeUTF(listOfStadiums.get(1).showStadiumReservation());
                return 1;
            } else if (choosenStadium.equals("3")) {
                out.writeUTF(listOfStadiums.get(2).showStadiumReservation());
                return 2;
            } else {
                out.writeUTF("Nie znaleziono obiektu, wybierz jeszcze raz.");
            }
        }
    }
    
    private static void createReservation(DataOutputStream out, DataInputStream in) throws IOException {
            Integer customerSelection = showReservation(out,in);
            String startTimeString, endTimeString, name; 
            out.writeUTF("Podaj godzinę rozpoczęcia: ");
            out.flush();
            if ((startTimeString = in.readUTF()).equalsIgnoreCase("")) {
                startTimeString = in.readUTF();
            } 
            out.writeUTF("Podaj godzinę zakończenia: ");
            out.flush();
            if ((endTimeString = in.readUTF()).equalsIgnoreCase("")) {
                endTimeString = in.readUTF();
            } 
            out.writeUTF("Podaj nazwę usługi");
            out.flush();
            if ((name = in.readUTF()).equalsIgnoreCase("")) {
                name = in.readUTF();
            } 
            listOfStadiums.get(customerSelection).getListOfReservation()
                    .add(new Reservation(name, startTimeString, endTimeString));
            out.writeUTF("Zapisano");
            out.flush();
    }
    
    public void deleteReservation(DataOutputStream out, DataInputStream in) throws IOException {
            Integer customerSelection = showReservation(out,in);
            String reservationNumber, confirmation;
            while(true) {
            out.writeUTF("Podaj numer rezerwacji do usunięcia: ");
            out.flush();
            if ((reservationNumber = in.readUTF()).equalsIgnoreCase("")) {
                reservationNumber = in.readUTF();
            } 
            int reservation = Integer.parseInt(reservationNumber);
            while (true) {
            out.writeUTF("Wybrana pozycja to: " + reservationNumber);
            out.writeUTF("Czy jesteś pewien?");
            if ((confirmation = in.readUTF()).equalsIgnoreCase("")) {
                confirmation = in.readUTF();
            } 
            if (confirmation.equalsIgnoreCase("T")) {
                listOfStadiums.get(customerSelection).getListOfReservation()
                        .remove(reservation-1);
                out.writeUTF("Rezerwacja usunięta!");
                break;
            }
            else if (confirmation.equalsIgnoreCase("N")) {
                out.writeUTF("Rezerwacja nieusunięta!");
                break;
            }
            else {
                out.writeUTF("Błędny wybór: ");
            }
            }
            out.writeUTF("Usuwamy jeszcze? N - Wyjście");
            if ((confirmation = in.readUTF()).equalsIgnoreCase("")) {
                confirmation = in.readUTF();
            } 
            if (confirmation.equalsIgnoreCase("N")) {
                out.writeUTF("Kończymy!");
                break;
            }
            else {
            }
            }
    }
}

public class TimeManagementServer {

    private static int portNumber;
    private List<Stadium> listofStadiums = new ArrayList();

    public void run() {
        listofStadiums.add(new Stadium("Olimpia"));
        listofStadiums.add(new Stadium("Elana"));
        listofStadiums.add(new Stadium("Iskra"));

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Connected(clientSocket, listofStadiums).start();
            }

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        portNumber = Integer.parseInt(args[0]);
        new TimeManagementServer().run();

        return;

    }

}
