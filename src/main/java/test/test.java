/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import db.AccountDB;

/**
 *
 * @author datld7
 */
public class test {
    public static void main(String[] args) {
        AccountDB accountDB = new AccountDB();
        
        System.out.println(accountDB.checkLogin("admin", "123456"));
    }
}
