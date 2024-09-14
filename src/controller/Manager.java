/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import model.Brand;
import model.Category;
import model.Product;

/**
 *
 * @author trong
 */
public class Manager {
    //Manager quản lí CRUD : 1 cái Product
    List<Product> listProduct = new ArrayList();// <> có cũng được , ko cx đc
    // new : xin ram chỗ để chứa listProduct
    List<Brand> listBrand = new ArrayList();
    List<Category> listCategory = new ArrayList();
    
    public boolean checkIdFromList(String str, String id){
        switch(str){
            case "Category":{
                for(Category tay : listCategory){
                    if(tay.getCategoryId().equals(id)){
                        return true;
                    }
                }
                break;
            }
                
               
            case "Brand" :{
                for(Brand tay : listBrand){
                    if(tay.getBrandId().equals(id)){
                        return true;
                    }
                }
                break;
            }
        }
        return false;
    }
    
    
    public boolean checkIdExist(String id){ // kiểm tra Id tồn tại
        for(Product tay : listProduct){
            if(tay.getId().equals(id)){
                return true;
            }
        }
        return false;
    }// tồn tại true ; o tồn tại : false
    public void createProduct(){
        Scanner sc = new Scanner(System.in);
        String id,name,cateId,brandId;
        int modelYear;
        double listPrice;
        do{
            System.out.print("Enter Id");
            id= sc.nextLine();
        }while(checkIdExist(id) == true);// nếu id đã tồn tại => true => bắt nhập lại
        
        do{
            System.out.print("Enter name :");
            name =sc.nextLine();
        }while(name.isEmpty());
        
        do{
            System.out.print("Enter CategoryId:");
            cateId = sc.nextLine();
        }while(checkIdFromList("Category",cateId)==false);
        
        do{
            System.out.print("Enter BrandId:");
               brandId = sc.nextLine();
        }while(checkIdFromList("Brand", brandId)==false);
        
        do{
            System.out.print("Enter Model Year :");
            modelYear = Integer.parseInt(sc.nextLine());
        }while(modelYear <=1900 || modelYear > 2100);
        
        do{
            System.out.println("Enter List Price");
            listPrice = Double.parseDouble(sc.nextLine());
        }while(listPrice<0);
        Product p = new Product(id,name,brandId,cateId,modelYear,listPrice);
        listProduct.add(p);
    }
    public List<Product> searchProduct(String str){
        //return a list of Product
        // chưa yêu cầu user nhập bên main
        List<Product> result = new ArrayList();// ngôi nhà tình thương :>
        if(listProduct.size() == 0)
        {
            System.out.println("\"Have no any Product\"");
            return null;
        }
        for (Product   tay : result ) {
            if(tay.getName().contains(str))
            {
                result.add(tay);
            }
        }
        return result;
        
    }
    public boolean checkBlank(String check){
        if(!check.isEmpty()){
            return true;
        }else
            return false;
    }
    public void updateInformation(){
        Scanner sc = new Scanner(System.in);
        String id ;
        int flag = 0;
        boolean temp = true;
        System.out.print("Enter Id :");
        id = sc.nextLine();
        for(Product tay : listProduct){
            if(!tay.getId().equalsIgnoreCase(id)){
                System.out.println("\"Product does not exist\"");
                temp = false;
            }else{
                  if(checkBlank(tay.getName())){
                    System.out.print("Enter newName : ");
                    String newName = sc.nextLine();
                    tay.setName(newName);
                  }if(checkBlank(tay.getBrandId())){
                    System.out.print("Enter new Brand id : ");
                    String newBrandId= sc.nextLine();
                    tay.setBrandId(newBrandId);
                  }if(checkBlank(tay.getCategoryId())){
                    System.out.print("Enter Category id : ");
                    String newCategoryId= sc.nextLine();
                    tay.setCategoryId(newCategoryId);
                  }
                  do{
                      System.out.print("Enter new Model year : ");
                      int newModelYear = Integer.parseInt(sc.nextLine());
                      if(newModelYear>=1900 || newModelYear <2100){
                          flag = 1;
                          tay.setModelYear(newModelYear);
                      }else{ 
                          System.out.println("Ensure model year is a valid year.(1900 <= Model year < 2100)");
                      }
                  }while(flag==0);
                  do{
                      System.out.print("Enter new List price : ");
                      int newListPrice = Integer.parseInt(sc.nextLine());
                      if(newListPrice >0){
                          flag = 0;
                          tay.setListPrice(newListPrice);
                      }else{
                          System.out.println("Ensure Validate list price is a positive number.");
                      }
                  }while(flag==1);
                  
                  
            }
        }
        if(temp)
            System.out.println("Updating success");
        else
            System.out.println("Updating fail");
        
        //Ask to go back to the main menu 
    }
}
