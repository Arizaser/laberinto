/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberinto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author marizase
 */
public class Laberinto {
    private Character[][] matriz;
    private Posicion startPosition;
    private Posicion finishPosition;
    private int limitUp;
    private int limitDown;
    private int limitRight;
    private int limitLeft;

    public Laberinto() {
        this.limitUp = 0;
        this.limitLeft = 0;
    }

    public Posicion getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Posicion startPosition) {
        this.startPosition = startPosition;
    }

    public Posicion getFinishPosition() {
        return finishPosition;
    }

    public void setFinishPosition(Posicion finishPosition) {
        this.finishPosition = finishPosition;
    }
    
    public void getSizeMatriz(File file) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(file);
        int caract = 0;
        int fila = 0;
        int columna = 0;
        int limiteColumnas = 0;

        while (caract != -1) {
            caract = fr.read();
            char c = (char) caract;
            
            if (c == '\n') {
                fila++;
                limiteColumnas = columna;
                columna = 0;
            }

            if (c == 'E') {
                this.startPosition = new Posicion(fila, columna);
            }
            if (c == 'S') {
                this.finishPosition = new Posicion(fila, columna);
            }
            if (c != '\n') {
                columna++;
            }
        }
        this.limitDown = fila;
        this.limitRight = limiteColumnas;
    }

    public Character[][] getMatriz() {
        return matriz;
    }

    public void loadMap(File file) throws FileNotFoundException, IOException {
        this.getSizeMatriz(file);
        this.matriz = new Character[this.limitDown+1][this.limitRight];
        FileReader fr = new FileReader(file);
        int caract = 0;
        int fila = 0;
        int columna = 0;

        while (caract != -1) {
            caract = fr.read();
            char c = (char) caract;
            
            if (c == '\n') {
                fila++;
                columna = 0;
            }
            try {
                if (c != '\n') {
                    this.matriz[fila][columna] = c;
                }
            } catch (Exception e) {
                System.out.println(("Error de muro"));
            }
            if (c != '\n') {
                columna++;
            }
        }
    }

    public int getLimitUp() {
        return limitUp;
    }

    public int getLimitDown() {
        return limitDown;
    }

    public int getLimitRight() {
        return limitRight;
    }

    public int getLimitLeft() {
        return limitLeft;
    }
    
}
