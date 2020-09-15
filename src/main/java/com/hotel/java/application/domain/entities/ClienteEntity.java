package com.hotel.java.application.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="cliente")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido;
    private String email;

    @OneToMany(mappedBy="reserva")
    List<ReservaEntity> reservaEntities;

    @OneToOne (mappedBy = "cliente")
    LoginEntity loginEntity;

    public ClienteEntity(String nombre, String apellido, String email) {
        setNombre (nombre);
        setApellido (apellido);
        setEmail (email);
    }

    public ClienteEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ReservaEntity> getReservaEntities() {
        return reservaEntities;
    }

    public void setReservaEntities(List<ReservaEntity> reservaEntities) {
        this.reservaEntities = reservaEntities;
    }

    public LoginEntity getLoginEntity() {
        return loginEntity;
    }

    public void setLoginEntity(LoginEntity loginEntity) {
        this.loginEntity = loginEntity;
    }

    @Override
    public String toString() {
        return "ClienteEntity{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", reservaEntities=" + reservaEntities +
                '}';
    }
}
