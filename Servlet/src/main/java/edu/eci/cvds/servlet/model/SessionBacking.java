package edu.eci.cvds.servlet.model;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name= "guessBean")
//@ApplicationScoped
@SessionScoped
public class SessionBacking {

    private int numero;
    private int numeroDeIntentos;
    private int premioAcumulado;
    private String estado;
    private List<Integer> intentosFallidos;
    private  int intento;


    public SessionBacking(){
        numero = (int) (Math.random()*10) + 1;
        numeroDeIntentos = 0;
        premioAcumulado = 100000;
        estado = "Inicio";
        intentosFallidos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumeroDeIntentos() {
        return numeroDeIntentos;
    }

    public void setNumeroDeIntentos(int numeroDeIntentos) {
        this.numeroDeIntentos = numeroDeIntentos;
    }

    public int getPremioAcumulado() {
        return premioAcumulado;
    }

    public void setPremioAcumulado(int premioAcumulado) {
        this.premioAcumulado = premioAcumulado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Integer> getIntentosFallidos() {
        return intentosFallidos;
    }

    public List<Integer> getList(){
        return intentosFallidos;
    }

    public void setIntentosFallidos(ArrayList<Integer> intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }

    public int getIntento() {
        return intento;
    }

    public void setIntento(int intento) {
        this.intento = intento;
    }

    /**
     * Recibe un intento de juego y realiza la logica
     * @param intento intento de adivinanza
     */

    public void guess(int intento){
        numeroDeIntentos ++;
        if (intento == numero){
            estado = String.format("Ganaste !! tu premio es de %s", premioAcumulado);
        } else {
            estado = "Perdiste =( ";
            premioAcumulado -= 10000;
            intentosFallidos.add(intento);
        }
        System.out.println(intento);
    }

    /**
     * Reinicia el Juego
     */
    public void restart(){
        numero = (int) (Math.random()*10) + 1;
        numeroDeIntentos = 0;
        premioAcumulado = 100000;
        estado = "Inicio";
        intentosFallidos.clear();
    }
}
