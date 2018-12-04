/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haihq.DAO;

import haihq.DTO.InfoDTO;
import haihq.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author haihq
 */
public class InfoDAO implements Serializable{
    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;
    
    private void closeConnection() throws SQLException
    {
        if(rs!=null)
        {
            rs.close();
        }
        if(stm!=null)
        {
            stm.close();
        }
    }
    
    public InfoDTO getInfo()
    {
        try
        {
            con=MyConnection.getConnection();
            String sql = "SELECT TOP 1 InfoID, Name, Address, Tel, Email, Open_hours, Number_Viewer FROM Info ORDER BY InfoID DESC";
            stm=con.prepareStatement(sql);
            rs=stm.executeQuery();
            if(rs.next())
            {
                int id = rs.getInt("InfoID");
                String name = rs.getString("Name");
                String address = rs.getString("Address");
                String tel = rs.getString("Tel");
                String email = rs.getString("Email");
                String dateOpen = rs.getString("Open_hours");
                int numberViewer = rs.getInt("Number_Viewer");
                InfoDTO dto = new InfoDTO(id, name, address, tel, email, dateOpen, numberViewer);
                return dto;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public void updateViewer(int id, int viewer) throws SQLException
    {
        try
        {
            con = MyConnection.getConnection();
            String sql = "UPDATE Info SET Number_Viewer = '"+viewer+"' WHERE InfoID='"+id+"'";
            stm = con.prepareStatement(sql);
            stm.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
    }
}
