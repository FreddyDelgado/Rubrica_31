/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Freddy
 */
public class RandomicoMixto {
    double xn, a, c, m, cantidad;
    private boolean repetir;
    private ArrayList<double[]> lista;
    private int nRepetido;

    public RandomicoMixto(double xn, double a, double c, double m, double cantidad) {
        this.lista = new ArrayList();
        this.xn = xn;
        this.a = a;
        this.c = c;
        this.m = m;
        setCantidad(cantidad);
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
        if(cantidad == -1){
            repetir = true;
        }else{
            repetir = false;
        }
    }
    
    public ArrayList<double[]> generar(){
        
        if(repetir){
            for (int i = 1; !comprobarRepetido(); i++) {
                double[] fila = new double[5];
                fila[0] = i;
                fila[1] = xn;
                fila[2] = ((a*xn)+c);
                fila[3] = fila[2]%m;
                fila[4] = fila[3]/m;                
                xn = fila[3];
                lista.add(fila);
                fila = null;
            }
        }else{
            for (int i = 1; i <= cantidad; i++) {
                double[] fila = new double[5];
                fila[0] = i;
                fila[1] = xn;
                fila[2] = ((a*xn)+c);
                fila[3] = fila[2]%m;
                fila[4] = fila[3]/m;                
                xn = fila[3];
                lista.add(fila);
                fila = null;
            }
        }
        return lista;
    }

    private boolean comprobarRepetido() {
        boolean encontrado = false;
        for (double[] list : lista) {
            for (double[] n : lista) {
                if(list[4] == n[4]){
                    
                    return true;
                }
            }
        }
        return encontrado;
    }
    
    
}
