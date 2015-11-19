/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reportes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franciscojavier
 */
public class BDControl {
    
    private Connection c;
    private Statement st;
    
    public BDControl(Connection c) {
        this.c = c;
        try {
            st = c.createStatement();
        } catch (SQLException ex) {
            
        }
        
    }
    
    
    
    public ResultSet query(String query){
        ResultSet result = null;
        try {
            result = st.executeQuery(query);
        } catch (SQLException ex) {
            
        }
        
        return result;
    };
    
    
    
}
