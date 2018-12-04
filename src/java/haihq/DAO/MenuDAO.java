/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haihq.DAO;

import haihq.DTO.MenuDTO;
import haihq.DTO.ProductDTO;
import haihq.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haihq
 */
public class MenuDAO implements Serializable{
    private Connection con;
    private ResultSet rs;
    private PreparedStatement stm;
    
    public void closeConnection() throws SQLException
    {
        if(rs!=null)
        {
            rs.close();
        }
        if(stm!=null)
        {
            stm.close();
        }
        if(con!=null)
        {
            con.close();
        }
    }
    public List<MenuDTO> getAllMenus() throws SQLException
    {
        try
        {
            List<MenuDTO> listMenus = new ArrayList<>();
            con = MyConnection.getConnection();
            String sql = "SELECT MenuID, MenuName, MenuDes FROM Menu";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next())
            {
                String menuID = rs.getString("MenuID");
                String menuName = rs.getString("MenuName");
                String menuDes = rs.getString("MenuDes");
                MenuDTO dto = new MenuDTO(menuID, menuName, menuDes);
                listMenus.add(dto);
            }
            return listMenus;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return null;
    }
    
    public List<ProductDTO> getProductByMenuID(String menuID) throws SQLException
    {
        try
        {
            List<ProductDTO> listProducts = new ArrayList<>();
            con=MyConnection.getConnection();
//            String sql = "SELECT ProductName, ProductPrice FROM Menu m, Menu_Product mp, Product p"
//                    + " WHERE m.MenuID='"+menuID+"' AND m.MenuID=mp.MenuID AND mp.ProductID=p.ProductID";
            String sql = "SELECT ProductName, ProductPrice FROM Menu m, Menu_Product mp, Product p"
                    + " WHERE m.MenuID='"+menuID+"' AND m.MenuID=mp.MenuID AND mp.ProductID=o.ProductID";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next())
            {
                String productName = rs.getString("ProductName");
                float productPrice = rs.getFloat("ProductPrice");
                ProductDTO dto = new ProductDTO(productName, productPrice);
                listProducts.add(dto);
            }
            return listProducts;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return null;
    }
}
