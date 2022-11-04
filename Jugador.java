/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberinto;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author marizase
 */
public class Jugador {

    private Laberinto laberinto;
    private Posicion currentPosition;
    private ArrayDeque<Posicion> road;

    public Jugador(Laberinto laberinto) {
        this.laberinto = laberinto;
        this.currentPosition = this.laberinto.getStartPosition();
        this.road = new ArrayDeque();
        road.push(new Posicion(this.currentPosition));
    }

    public Posicion getCurrentPosition() {
        return currentPosition;
    }

    public Laberinto getLaberinto() {
        return laberinto;
    }

    public void updatePosition(Posicion position) {
        this.road.add(position);
        this.currentPosition = position;
    }

    public void solve() {
        Character[][] matriz = this.laberinto.getMatriz();

        while (matriz[this.currentPosition.getFila()][this.currentPosition.getColumna()] != 'S') {
//            System.out.println(this.currentPosition);
            try {
                matriz[this.currentPosition.getFila()][this.currentPosition.getColumna()] = 'V';

                if (matriz[this.currentPosition.getFila() + 1][this.currentPosition.getColumna()] == ' ' || matriz[this.currentPosition.getFila() + 1][this.currentPosition.getColumna()] == 'S') {
                    this.currentPosition.stepDown();
                    this.road.push(new Posicion(this.currentPosition.getFila()+1, this.currentPosition.getColumna()));
                } else if (matriz[this.currentPosition.getFila()][this.currentPosition.getColumna() + 1] == ' ' || matriz[this.currentPosition.getFila()][this.currentPosition.getColumna() + 1] == 'S') {
                    this.currentPosition.stepRight();
                    this.road.push(new Posicion(this.currentPosition.getFila(), this.currentPosition.getColumna()+1));
                } else if (matriz[this.currentPosition.getFila() - 1][this.currentPosition.getColumna()] == ' ' || matriz[this.currentPosition.getFila() - 1][this.currentPosition.getColumna()] == 'S') {
                    this.currentPosition.stepUp();                    
                    this.road.push(new Posicion(this.currentPosition.getFila()-1, this.currentPosition.getColumna()));
                } else if (matriz[this.currentPosition.getFila()][this.currentPosition.getColumna() - 1] == ' ' || matriz[this.currentPosition.getFila()][this.currentPosition.getColumna() - 1] == 'S') {
                    this.currentPosition.stepLeft(); 
                    this.road.push(new Posicion(this.currentPosition.getFila(), this.currentPosition.getColumna()-1));
                } else {
                    this.road.pop();
                    this.currentPosition.setFila(this.road.peek().getFila());
                    this.currentPosition.setColumna(this.road.peek().getColumna());
                }
            } catch (Exception e) {
            }
        }
        System.out.println("SE HA COMPLETADO EL LABERINTO! ENHORABUENA!!\nCAMINO:");
        for (Posicion posicion : this.road) {
            System.out.println(posicion.getFila()+","+posicion.getColumna());
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (j==0) {
                    System.out.print("\n");
                }
                System.out.print(matriz[i][j]);
                
            }
        }
    }
}
