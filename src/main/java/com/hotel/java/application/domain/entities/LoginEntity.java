package com.hotel.java.application.domain.entities;

import javax.persistence.*;

@Entity
@Table(name="login")
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String usuario;
    private String password;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_cliente")
    ClienteEntity cliente;

    public LoginEntity(String usuario, String password, ClienteEntity clienteEntity) {
        setUsuario (usuario);
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
                "usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", clienteEntity=" + cliente +
                '}';
    }
}
