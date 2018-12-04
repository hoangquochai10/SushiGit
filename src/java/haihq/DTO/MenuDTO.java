/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haihq.DTO;

import java.util.List;

/**
 *
 * @author haihq
 */
public class MenuDTO {
    private String menuID;
    private String menuName;
    private List<ProductDTO> listProduct;
    private String description;

    public MenuDTO(String menuID, String menuName, List<ProductDTO> listProduct, String description) {
        this.menuID = menuID;
        this.menuName = menuName;
        this.listProduct = listProduct;
        this.description = description;
    }

    public MenuDTO(String menuID, String menuName, String description) {
        this.menuID = menuID;
        this.menuName = menuName;
        this.description = description;
    }


    public String getMenuID() {
        return menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<ProductDTO> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ProductDTO> listProduct) {
        this.listProduct = listProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
