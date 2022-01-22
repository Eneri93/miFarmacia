package com.example.mifarmacia.clases;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = "Farmacos")
public class Farmacos implements Serializable {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "codigo")
    private String codigo;
    @NonNull
    @ColumnInfo(name = "nombre")
    private String nombre;

    @NonNull
    @ColumnInfo(name = "marca", index = true)
    private String marca;
    @NonNull
    @ColumnInfo(name = "principio activo")
    private String principio;
    @NonNull
    @ColumnInfo(name = "precio")
    private String precio;

    public Farmacos(@NonNull String codigo, @NonNull String nombre, @NonNull String marca, @NonNull String principio, @NonNull String precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.principio = principio;
        this.precio = precio;
    }

    @NonNull
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(@NonNull String codigo) {
        this.codigo = codigo;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getMarca() {
        return marca;
    }

    public void setMarca(@NonNull String marca) {
        this.marca = marca;
    }

    @NonNull
    public String getPrincipio() {
        return principio;
    }

    public void setPrincipio(@NonNull String principio) {
        this.principio = principio;
    }

    @NonNull
    public String getPrecio() {
        return precio;
    }

    public void setPrecio(@NonNull String precio) {
        this.precio = precio;
    }
}

