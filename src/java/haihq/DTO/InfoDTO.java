/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haihq.DTO;

/**
 *
 * @author haihq
 */
public class InfoDTO {
    private int infoID;
    private String name;
    private String address;
    private String tel;
    private String email;
    private String dateOpen;
    private int numberViewer;

    public InfoDTO(int infoID, String name, String address, String tel, String email, String dateOpen, int numberViewer) {
        this.infoID = infoID;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.dateOpen = dateOpen;
        this.numberViewer = numberViewer;
    }

    public int getNumberViewer() {
        return numberViewer;
    }

    public void setNumberViewer(int numberViewer) {
        this.numberViewer = numberViewer;
    }

    public InfoDTO() {
    }

    public int getInfoID() {
        return infoID;
    }

    public void setInfoID(int infoID) {
        this.infoID = infoID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(String dateOpen) {
        this.dateOpen = dateOpen;
    }
    
}
