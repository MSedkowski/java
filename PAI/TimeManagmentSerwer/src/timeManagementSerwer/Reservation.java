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
    private String activity;
    private Integer clientID, startHour, endHour;

    public Reservation(Integer clientID, Integer startHour, Integer endHour, String activity) {
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

    public Integer getStartHour() {
        return startHour;
    }

    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
    
    
}
