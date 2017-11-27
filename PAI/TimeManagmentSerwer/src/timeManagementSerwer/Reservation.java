/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeManagementSerwer;

/**
 *
 * @author Mateusz
 */
public class Reservation {
    private String startHour, endHour, activity;
    private Integer clientID;

    public Reservation(Integer clientID, String startHour, String endHour, String activity) {
        this.clientID = clientID;
        this.startHour = startHour;
        this.endHour = endHour;
        this.activity = activity;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
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
