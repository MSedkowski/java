package timeManagementSerwer;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Connected extends Thread {

    private Socket clientSocket;
    private static List<Stadium> listOfStadiums;
    private static int clientId;

    public Connected(Socket clientSocket, List<Stadium> listOfStadiums, int clientId) {
        this.clientSocket = clientSocket;
        Connected.listOfStadiums = listOfStadiums;
        Connected.clientId = clientId;
    }

    public void run() {

        try {
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            String inputLine;

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
                    case "4": {
                        showCanceledReservation(out, in);
                        break;
                    }
                    case "0": {
                        clientSocket.close();
                    }
                    default: {
                        out.writeUTF("Zły wybór");
                        break;
                    }
                }
                returnToMainMenu(out, in, clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void returnToMainMenu(DataOutputStream out, DataInputStream in,
            Socket clientSocket) throws IOException {
        while (true) {
            out.writeUTF("'M' - Powrót do głównego menu\n 'Z' - Zakończ połączenie");
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
    }

    private static void showMenu(DataOutputStream out) throws IOException {
        StringBuilder menu = new StringBuilder();
        menu.append("Witamy na serwerze czasu\n");
        menu.append("Menu:\n");
        menu.append("1 - Wyświetl wszystkie rezerwacje\n");
        menu.append("2 - Stwórz nową rezerwację\n");
        menu.append("3 - Usuń rezerwację\n");
        menu.append("4 - Wycofane rezerwacje\n");
        menu.append("0 - Zakończ połączenie\n");
        out.writeUTF(menu.toString());
        out.flush();
    }

    private static void showListOfStadiums(DataOutputStream out) throws IOException {
        StringBuilder reservationMenu = new StringBuilder();
        reservationMenu.append("Wybierz interesujący Cię obiekt:\n");
        reservationMenu.append("1 - Stadion Olimpia\n");
        reservationMenu.append("2 - Stadion Elana\n");
        reservationMenu.append("3 - Stadion Iskra\n");
        out.writeUTF(reservationMenu.toString());
        out.flush();
    }

    private static int showReservation(DataOutputStream out, DataInputStream in) throws IOException {
        while (true) {
            showListOfStadiums(out);
            String choosenStadium;
            if (!(choosenStadium = in.readUTF()).equalsIgnoreCase("")) {
            } else {
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

    private static int showCanceledReservation(DataOutputStream out, DataInputStream in) throws IOException {
        while (true) {
            showListOfStadiums(out);
            String choosenStadium;
            if (!(choosenStadium = in.readUTF()).equalsIgnoreCase("")) {
            } else {
                choosenStadium = in.readUTF();
            }
            if (choosenStadium.equals("1")) {
                out.writeUTF(listOfStadiums.get(0).showCanceledStadiumReservation());
                return 0;
            } else if (choosenStadium.equals("2")) {
                out.writeUTF(listOfStadiums.get(1).showCanceledStadiumReservation());
                return 1;
            } else if (choosenStadium.equals("3")) {
                out.writeUTF(listOfStadiums.get(2).showCanceledStadiumReservation());
                return 2;
            } else {
                out.writeUTF("Nie znaleziono obiektu, wybierz jeszcze raz.");
            }
        }
    }

    private static void createReservation(DataOutputStream out, DataInputStream in) throws IOException {
        Integer customerSelection = showReservation(out, in);
        String startTimeString, endTimeString, activityName;
        boolean reserved = false;
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
        if ((activityName = in.readUTF()).equalsIgnoreCase("")) {
            activityName = in.readUTF();
        }
        for (Stadium stadium : listOfStadiums) {
            for (Reservation reservation : stadium.getListOfReservation()) {
                if (reservation.getActivity().equalsIgnoreCase(activityName)
                        && !(startTimeString.compareTo(reservation.getStartHour()) != -1
                        && startTimeString.compareTo(reservation.getEndHour()) != 1
                        || endTimeString.compareTo(reservation.getEndHour()) != 1
                        && endTimeString.compareTo(reservation.getStartHour()) != -1)) {
                    out.writeUTF("Wybrana usługa jest już zarezerwowana");
                    reserved = true;
                }
            }
        }
        if (!reserved) {
            listOfStadiums.get(customerSelection).getListOfReservation()
                    .add(new Reservation(clientId, startTimeString, endTimeString, activityName));
            out.writeUTF("Zapisano");
            out.flush();
        }
    }

    public void deleteReservation(DataOutputStream out, DataInputStream in) throws IOException {
        Integer customerSelection = showReservation(out, in);
        String reservationNumber, confirmation;
        out.writeUTF("Podaj numer rezerwacji do usunięcia: ");
        out.flush();
        if ((reservationNumber = in.readUTF()).equalsIgnoreCase("")) {
            reservationNumber = in.readUTF();
        }
        int reservation = Integer.parseInt(reservationNumber);
        if (listOfStadiums.get(customerSelection).getListOfReservation()
                .get(reservation - 1).getClientID() == clientId) {
            out.writeUTF("Wybrana pozycja to: " + reservationNumber);
            out.writeUTF("Czy jesteś pewien? T - Tak");
            if ((confirmation = in.readUTF()).equalsIgnoreCase("")) {
                confirmation = in.readUTF();
            }
            if (confirmation.equalsIgnoreCase("T")) {
                listOfStadiums.get(customerSelection).getListOfCanceledReservation()
                        .add(listOfStadiums.get(customerSelection).getListOfReservation()
                                .get(reservation - 1));
                listOfStadiums.get(customerSelection).getListOfReservation()
                        .remove(reservation - 1);
                out.writeUTF("Rezerwacja usunięta!");
            } else {
                out.writeUTF("Rezerwacja nieusunięta!");
            }
        } else {
            out.writeUTF("To nie Twoja rezerwacja!");
        }

    }
}

public class TimeManagementServer {

    private static int portNumber;
    private List<Stadium> listofStadiums = new ArrayList();
    private int clientId = 0;

    public void run() {
        listofStadiums.add(new Stadium("Olimpia"));
        listofStadiums.add(new Stadium("Elana"));
        listofStadiums.add(new Stadium("Iskra"));

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Connected(clientSocket, listofStadiums, clientId).start();
                clientId++;
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
