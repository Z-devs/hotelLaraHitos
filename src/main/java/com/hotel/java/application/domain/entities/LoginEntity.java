package com.hotel.java.application.domain.entities;

import javax.persistence.*;

@Entity
@Table(name="login")
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_cliente")
    ClienteEntity cliente;

    public LoginEntity(String username, String password, ClienteEntity clienteEntity) {
        setUsername (username);
        setPassword (password);
        setClienteEntity (clienteEntity);
    }

    public LoginEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String usuario) {
        this.username = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ClienteEntity getClienteEntity() {
        return cliente;
    }

    public void setClienteEntity(ClienteEntity clienteEntity) {
        this.cliente = clienteEntity;
    }

    @Override
    public String toString() {
        return "LoginEntity{" +
                "usuario='" + username + '\'' +
                ", password='" + password + '\'' +
                ", clienteEntity=" + cliente +
                '}';
    }
}
