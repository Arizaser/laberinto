/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberinto;

/**
 *
 * @author marizase
 */
public class Posicion {
    private int fila;
    private int columna;
    private boolean visitado;

    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    
    public Posicion(Posicion posicion) {
        this.fila = posicion.getFila();
        this.columna = posicion.getColumna();
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    public void stepDown() {
        this.fila++;
    }
    
    public void stepUp() {
        this.fila--;
    }
    
    public void stepRight() {
        this.columna++;
    }
    
    public void stepLeft() {
        this.columna--;
    }

    public boolean isVisitado() {
        return visitado;
    }

    @Override
    public String toString() {
        return "Posicion{" + "fila=" + fila + ", columna=" + columna + '}';
    }
    
    
}
