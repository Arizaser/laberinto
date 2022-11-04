/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberinto;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author marizase
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File fr = new File("laberinto.txt");
        Laberinto lab = new Laberinto();
        lab.loadMap(fr);
        
        Jugador player = new Jugador(lab);
        
//        System.out.println(lab.getMatriz()[1][72]);
        
//        for (int i = 0; i < lab.getMatriz().length; i++) {
//            for (int j = 0; j < lab.getMatriz()[i].length; j++) {
//                System.out.println(i+"," + j + ": "+lab.getMatriz()[i][j]);
//            }
//        }
//        
//        System.out.println(lab.getLimitDown());
//        for (Character[] arg : lab.getMatriz()) {
//            for (Character character : arg) {
//                System.out.println(character);
//            }
//        }

          
        
//        for (Posicion pos : player.solve()) {
//            System.out.println("\n"+pos.getFila() + "," + pos.getColumna());
//        }

        player.solve();
        
    }
}
