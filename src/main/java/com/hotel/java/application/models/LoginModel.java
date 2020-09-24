package com.hotel.java.application.models;

import java.util.List;

public class LoginModel {
    private long id;
    private String username;
    private String password;
    List<ClienteModel> clienteModelList;

    public LoginModel(String username, String password, List<ClienteModel> clienteModelList) {
        setUsername (username);
        setPassword (password);
        setClienteModelList (clienteModelList);
    }

    public LoginModel(long id, String username, String password, List<ClienteModel> clienteModelList) {
        setId(id);
        setUsername (username);
        setPassword (password);
        setClienteModelList (clienteModelList);
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

    public void setUsername(String username) {
        this.username = username;
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
                "usuario='" + username + '\'' +
                ", password='" + password + '\'' +
                ", clienteModelList=" + clienteModelList +
                '}';
    }
}
