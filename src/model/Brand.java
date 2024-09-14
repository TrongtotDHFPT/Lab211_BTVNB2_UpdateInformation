/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author trong
 */
public class Brand {
    private String brandId,nameBrand;

    public Brand(String brandId, String nameBrand) {
        this.brandId = brandId;
        this.nameBrand = nameBrand;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return nameBrand;
    }

    public void setName(String nameBrand) {
        this.nameBrand = nameBrand;
    }
    
}
