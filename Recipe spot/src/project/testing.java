/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Atif Jalal
 */
import java.sql.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class testing {

    public static void main(String[] args) {
        String databasepath = "Database.accdb";
        // Create a JFileChooser to select the image file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File selectedFile = fileChooser.getSelectedFile();
        int id = 2;
        // Create a connection to the Access database

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + databasepath);
            String query = "UPDATE recipes SET RecipeImage=? WHERE ID=?";
            pst = con.prepareStatement(query);
            InputStream is = new FileInputStream(selectedFile);
            pst.setBinaryStream(1, is);
            pst.setInt(2, id);
            pst.executeUpdate();

            // Execute the insert statement
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Image saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
