/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package t4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class T4 {
    static final String url = "jdbc:postgresql://localhost:5432/Tugas";
    static final String user = "postgres";
    static final String pass = "bajumuslim";
    static final Scanner sc = new Scanner (System.in);
    
    public static void main(String[] args) {
        boolean berhenti = true;
        do{
            Scanner sci = new Scanner(System.in);
            System.out.println("-|- Menu -|-");
            System.out.println(" |1| Select ");
            System.out.println(" |2| Insert ");
            System.out.println(" |3| Update ");
            System.out.println(" |4| Delete ");
            System.out.println("-|--------|-");
            System.out.print("Pilih");
            int pilih = sci.nextInt();
            System.out.println();
            
            switch (pilih) {
                case 1 : 
                    ambilData();
                    break;
                case 2 : 
                    tambahData();
                    break;
                case 3 : 
                    perbaruiData();
                    break;
                case 4 : 
                    hapusData();
                    break;
                default :
                    System.out.println(" Tidak ada");
            }
            
            System.out.println(" lanjut [Y/T]");
            String lanjut = sc.nextLine();
            
            if(lanjut.equalsIgnoreCase("Y"))
                berhenti = true;
            else
                berhenti = false;
        } while (berhenti);
    }
    //select
    static void ambilData(){
        String query = "select * from absen";
        try{
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement ();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
        System.out.println("nim\t:"+" "
            +String.valueOf(rs.getObject("nim")));
        System.out.println("nama\t:"+" "
            +String.valueOf(rs.getObject("nama")));
        System.out.println("domisili:"+" "
            +String.valueOf(rs.getObject("domisili")));
        System.out.println();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //insert
    static void tambahData(){
        System.out.println("INSERT");
        System.out.println("NIM\t: ");
        String nim = sc.nextLine();
        System.out.println("NAMA\t: ");
        String nama = sc.nextLine();
        System.out.println("DOMISILI: ");
        String domisili = sc.nextLine();
        
        String query ="insert into absen values ('"
            + nim + "','" + nama + "', '" + domisili + "')";
        
        try{
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement ();
            stmt.execute(query);
            System.out.println("Data Berhasil Dimasukkan\n");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Data Gagal Dimasukkan\n");
        }
    }
    //update
    static void perbaruiData(){
        System.out.println("Update");
        System.out.println("NIM\t: ");
        String nim = sc.nextLine();
        System.out.println("NAMA\t: ");
        String nama = sc.nextLine();
        System.out.println("DOMISILI: ");
        String domisili = sc.nextLine();
        
        String query ="update absen set nama = '"
            + nama + "', domisili = '" + domisili + "', nim = '" + nim + "'";
        
        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement ();
            stmt.execute(query);
            System.out.println("Data Berhasil Diperbarui\n");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Data Gagal Diperbarui\n");
        }
    }
    //delete
    static void hapusData(){
        System.out.println("Delete");
        System.out.println("NIM\t: ");
        String nim = sc.nextLine();
        
        String query ="delete from absen where nim = '" + nim + "'";
        
        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement ();
            stmt.execute(query);
            System.out.println("Data Berhasil Dihilangkan\n");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Data Gagal Dihilangkan\n");
        }
    }
}
