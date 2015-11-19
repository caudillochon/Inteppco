/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLC;

import java.io.IOException;

/**
 *
 * @author Caudillo
 */
public class outpot {

   

    public static void encender() {
        try {
            Process p = Runtime.getRuntime().exec("C:\\encender\\Client.exe");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void apagar() {
        try {
            Process process = new ProcessBuilder(
                    "C:\\apagar\\Client.exe").start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
