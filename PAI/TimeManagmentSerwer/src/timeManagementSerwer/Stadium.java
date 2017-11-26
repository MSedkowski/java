
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

    public Stadium(String stadiumName) {
        this.stadiumName = stadiumName;
        this.listOfReservation = new ArrayList();
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
                reservation.append("\t rezerwacja dla ID: ");
                reservation.append(reservationItem.getClientName());
                reservation.append("\n");
                i++;
            }
            return reservation.toString();
        }
    }
  
}
