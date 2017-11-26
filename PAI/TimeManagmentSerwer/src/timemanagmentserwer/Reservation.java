/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timemanagmentserwer;

/**
 *
 * @author Mateusz
 */
public class Reservation {
    private String clientName, startHour, endHour, activity;

    public Reservation(String clientName, String startHour, String endHour, String activity) {
        this.clientName = clientName;
        this.startHour = startHour;
        this.endHour = endHour;
        this.activity = activity;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
    
    
}
