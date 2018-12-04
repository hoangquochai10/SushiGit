/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haihq.DAO;

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
public class ProductDAO implements Serializable{
    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;
    
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
    
    public List<ProductDTO> getAllProducts() throws SQLException
    {
        try
        {
            List<ProductDTO> listProducts = new ArrayList<>();
            con = MyConnection.getConnection();
            String sql = "SELECT ProductName, ProductPrice, ProductDes, ProductPicture FROM Product";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next())
            {
                String productName = rs.getString("ProductName");
                float productPrice = rs.getFloat("ProductPrice");
                String productDes = rs.getString("ProductDes");
                String productPicture = rs.getString("ProductPicture");
                ProductDTO dto = new ProductDTO(productName, productPrice, productPicture, productDes);
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
