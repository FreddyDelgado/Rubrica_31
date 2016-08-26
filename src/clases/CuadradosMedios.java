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
public class CuadradosMedios {
    double semilla, cantidad;
    int digitos;
    private boolean repetir;
    private ArrayList<double[]> lista;

    public CuadradosMedios(int semilla, int digitos, int cantidad) {
        this.lista = new ArrayList();
        this.semilla = semilla;
        this.digitos = digitos;
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
                fila[1] = semilla;
                fila[2] = semilla * semilla;
                fila[3] = obtenerSemilla((int) fila[2], this.digitos);
                fila[4] = obtenerPorcentaje(fila[3]);                
                semilla = fila[3];
                lista.add(fila);
            }
        }else{
            for (int i = 1; i <= cantidad; i++) {
                double[] fila = new double[5];
                fila[0] = i;
                fila[1] = semilla;
                fila[2] = semilla * semilla;
                fila[3] = obtenerSemilla((int) fila[2], this.digitos);
                fila[4] = obtenerPorcentaje(fila[3]);               
                semilla = fila[3];
                lista.add(fila);
            }
        }
        return lista;
    }
    
    private int obtenerSemilla(int valor, int digitos){
        String resultado =  String.valueOf(valor);
        int largo = (resultado.length() - digitos);
        String semi = resultado;
        if(largo % 2 == 0){
            if(largo > 0){
                largo = largo/2;
                semi = resultado.substring(largo, resultado.length() - largo);
            }
        }else{            
            if(largo > 1){
                largo = (largo/2)+1;
                semi = resultado.substring(resultado.length() - (digitos + largo), resultado.length() - largo);
            }else{
                if(largo == 1 ){
                   semi = resultado.substring(0, resultado.length() - 1); 
                }
            }
        }
        return Integer.parseInt(semi);
    }
    
    private double obtenerPorcentaje(double valor){
        double potencia = Math.pow(10, this.digitos);        
        return valor/potencia;
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
