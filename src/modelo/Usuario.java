/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author sartre
 */
public class Usuario {
    private String user;
    private String pass;
    private String nombre;
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Usuario(String user, String pass, String nombre) {
        this.user = user;
        this.pass = pass;
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return this.nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }
    
}
