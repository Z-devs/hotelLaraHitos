package com.hotel.java.application.domain.entitiesHB;

import javax.persistence.*;

@Entity
@Table(name = "login", schema = "hotel", catalog = "")
public class LoginEntity {
    private long id;
    private String nombre;
    private String password;
    private ClienteEntity clienteByClienteId;


    public LoginEntity(long id, String nombre, String password, ClienteEntity clienteByClienteId) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.clienteByClienteId = clienteByClienteId;
    }

    public LoginEntity(String nombre, String password, ClienteEntity clienteByClienteId) {
        this.nombre = nombre;
        this.password = password;
        this.clienteByClienteId = clienteByClienteId;
    }

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 45)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false)
    public ClienteEntity getClienteByClienteId() {
        return clienteByClienteId;
    }

    public void setClienteByClienteId(ClienteEntity clienteByClienteId) {
        this.clienteByClienteId = clienteByClienteId;
    }
}
