package com.hotel.java.application.domain.entitiesHB;

import javax.persistence.*;

@Entity
@Table(name = "habitacion", schema = "hotel", catalog = "")
public class HabitacionEntity {
    private long id;
    private String codigo;
    private String descripcion;
    private Integer precio;
    private ReservaEntity reservaByReservaId;
    private TipoEntity tipoByTipoId;

    public HabitacionEntity(long id, String codigo, String descripcion, Integer precio, TipoEntity tipoByTipoId) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipoByTipoId = tipoByTipoId;
    }

    public HabitacionEntity(String codigo, String descripcion, Integer precio, TipoEntity tipoByTipoId) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipoByTipoId = tipoByTipoId;
    }

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "codigo", nullable = true, length = 45)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "descripcion", nullable = true, length = 45)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "precio", nullable = true, precision = 0)
    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @ManyToOne
    @JoinColumn(name = "reserva_id", referencedColumnName = "id", nullable = false)
    public ReservaEntity getReservaByReservaId() {
        return reservaByReservaId;
    }

    public void setReservaByReservaId(ReservaEntity reservaByReservaId) {
        this.reservaByReservaId = reservaByReservaId;
    }

    @ManyToOne
    @JoinColumn(name = "tipo_id", referencedColumnName = "id", nullable = false)
    public TipoEntity getTipoByTipoId() {
        return tipoByTipoId;
    }

    public void setTipoByTipoId(TipoEntity tipoByTipoId) {
        this.tipoByTipoId = tipoByTipoId;
    }
}
