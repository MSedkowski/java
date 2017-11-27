
package timeManagementSerwer;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateusz
 */
public class Stadium {
  private String stadiumName;
  private List<Reservation> listOfReservation;
  private List<Reservation> listOfCanceledReservation;

    public Stadium(String stadiumName) {
        this.stadiumName = stadiumName;
        this.listOfReservation = new ArrayList();
        this.listOfCanceledReservation = new ArrayList();
    }

    public List<Reservation> getListOfCanceledReservation() {
        return listOfCanceledReservation;
    }

    public void setListOfCanceledReservation(List<Reservation> listOfCanceledReservation) {
        this.listOfCanceledReservation = listOfCanceledReservation;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public List<Reservation> getListOfReservation() {
        return listOfReservation;
    }

    public void setListOfReservation(List<Reservation> listOfReservation) {
        this.listOfReservation = listOfReservation;
    }
    
    public String showStadiumReservation() {
        int i = 1;
        StringBuilder reservation = new StringBuilder();
        reservation.append("Obecne rezerwacje obiektu " + this.getStadiumName() + "\n");
        if (this.getListOfReservation().isEmpty()) {
            reservation.append("Brak rezerwacji\n");
            return reservation.toString();
        }
        else {
            for (Reservation reservationItem : listOfReservation) {
                reservation.append(i + " ");
                reservation.append("Od: ");
                reservation.append(reservationItem.getStartHour());
                reservation.append("\t do: ");
                reservation.append(reservationItem.getEndHour());
                reservation.append("\t usługa: ");
                reservation.append(reservationItem.getActivity());
                reservation.append("\t zarezerwowane przez ID: ");
                reservation.append(reservationItem.getClientID());
                reservation.append("\n");
                i++;
            }
            return reservation.toString();
        }
    }
    
    public String showCanceledStadiumReservation() {
        int i = 1;
        StringBuilder reservation = new StringBuilder();
        reservation.append("Wycofane rezerwacje obiektu " + this.getStadiumName() + "\n");
        if (this.getListOfCanceledReservation().isEmpty()) {
            reservation.append("Brak wycofanych rezerwacji\n");
            return reservation.toString();
        }
        else {
            for (Reservation reservationItem : listOfCanceledReservation) {
                reservation.append(i + " ");
                reservation.append("Od: ");
                reservation.append(reservationItem.getStartHour());
                reservation.append("\t do: ");
                reservation.append(reservationItem.getEndHour());
                reservation.append("\t usługa: ");
                reservation.append(reservationItem.getActivity());
                reservation.append("\t zarezerwowane przez ID: ");
                reservation.append(reservationItem.getClientID());
                reservation.append("\n");
                i++;
            }
            return reservation.toString();
        }
    }
  
}
