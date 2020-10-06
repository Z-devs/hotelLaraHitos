package com.hotel.java.application.dto;

import com.hotel.java.application.services.DateDiffService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class ReservaDtoModel {

    @NotNull
    @NotEmpty
    Date checkIn;

    @NotNull
    @NotEmpty
    Date checkOut;

    @NotNull
    @NotEmpty
    float precioHab;


    @NotNull
    @NotEmpty
    long habId;

    @NotNull
    @NotEmpty
    String clienteUsername;


    public String getClienteUsername() {
        return clienteUsername;
    }

    public void setClienteUsername(String clienteUsername) {
        this.clienteUsername = clienteUsername;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public float getPrecioHab() {
        return precioHab;
    }

    public void setPrecioHab(float precioHab) {
        this.precioHab = precioHab;
    }

    public long getHabId() {
        return habId;
    }

    public void setHabId(long habId) {
        this.habId = habId;
    }

}
