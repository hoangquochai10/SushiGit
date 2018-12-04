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
public class ProductDTO {
    private String productID;
    private String productName;
    private float productPrice;
    private String productPicture;
    private String description;

    public ProductDTO(String productID, String productName, float productPrice, String productPicture, String description) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productPicture = productPicture;
        this.description = description;
    }

    public ProductDTO(String productName, float productPrice, String productPicture, String description) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productPicture = productPicture;
        this.description = description;
    }

    public ProductDTO(String productName, float productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductPicture() {
        return productPicture;
    }

    public void setProductPicture(String productPicture) {
        this.productPicture = productPicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
