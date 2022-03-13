/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poly.manager_product.dao;

import edu.poly.manager_product.helper.databasehelperSP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import edu.poly.manager_product.model.product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import edu.poly.manager_product.view.login;
/**
 *
 * @author LÊNA
 */
public class productdao {
    
    
    
     public boolean insertProduct (product pro) throws Exception{
        String sql ="insert into Product (idName,idProduct,tenSP,soLuong,giatien) values(?,?,?,?,?)";
        try(
            Connection con =databasehelperSP.opConnection();
            PreparedStatement pstmt= con.prepareStatement(sql);
            ){
        pstmt.setString(1,pro.getIdName());
        pstmt.setString(2,pro.getIdProduct());
        pstmt.setString(3,pro.getTenSP() );
        pstmt.setInt(4,pro.getSoLuong() );
        pstmt.setDouble(5,pro.getGiatien() );
        return pstmt.executeUpdate()>0;
        }

    }   
     
     
     public boolean insertaccount (product pro) throws Exception{
        String sql ="insert into Account (idName,pass,hoTen,sDT) values(?,?,?,?)";
        try(
            Connection con =databasehelperSP.opConnection();
            PreparedStatement pstmt= con.prepareStatement(sql);
            ){
        pstmt.setString(1,pro.getIdName());
        pstmt.setString(2,pro.getPass() );
        pstmt.setString(3,pro.getHoTen() );
        pstmt.setString(4,pro.getsDT() );
        return pstmt.executeUpdate()>0;
        }

    }   
    
     public boolean delete (String idproduct) throws Exception{
        String sql ="delete from Product where idProduct = ? ";
        try(
            Connection con =databasehelperSP.opConnection();
            PreparedStatement pstmt= con.prepareStatement(sql);
            ){
            pstmt.setString(1, idproduct );
        
    
         return pstmt.executeUpdate()>0;
        }
    }       
     
     public boolean update(product pro )throws Exception{
        String sql ="update Product set tenSP = ?,soLuong = ?,giatien = ? where idProduct = ?  ";
        try(
            Connection con1 =databasehelperSP.opConnection();
            PreparedStatement pstmt1= con1.prepareStatement(sql);
            ){
                pstmt1.setString(4, pro.getIdProduct());
                pstmt1.setString(1, pro.getTenSP());
                pstmt1.setInt(2, pro.getSoLuong());
                pstmt1.setDouble(3, pro.getGiatien() );
                return pstmt1.executeUpdate()>0;
        }
    }
     
    public product findbyid (String idname) throws Exception{
        String sql ="SELECT * FROM QLDocument where maTL = ? ";
        try(
            Connection con =databasehelperSP.opConnection();
            PreparedStatement pstmt= con.prepareStatement(sql);
             ){
            pstmt.setString(1, idname);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                product pro = new product();
                pro.setIdProduct(rs.getString("idProduct"));
                pro.setTenSP(rs.getString("tenSP"));
                pro.setSoLuong(rs.getInt("soLuong"));
                pro.setGiatien(rs.getDouble("giatien"));
                return pro;
            }
        return null;
        }
    }
}

