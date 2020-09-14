package com.hotel.java.application.models;

import java.util.List;

public class LoginModel {
    private long id;
    private String usuario;
    private String password;
    List<ClienteModel> clienteModelList;

    public LoginModel(String usuario, String password, List<ClienteModel> clienteModelList) {
        setUsuario (usuario);
        setPassword (password);
        setClienteModelList (clienteModelList);
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

    public List<ClienteModel> getClienteModelList() {
        return clienteModelList;
    }

    public void setClienteModelList(List<ClienteModel> clienteModelList) {
        this.clienteModelList = clienteModelList;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", clienteModelList=" + clienteModelList +
                '}';
    }
}
