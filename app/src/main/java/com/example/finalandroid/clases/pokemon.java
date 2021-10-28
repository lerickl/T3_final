package com.example.finalandroid.clases;

public class pokemon {
    public int id;
    public String codigo;
    public String nombre;
    public String tipo;
    public String url_imagen;
    public int esta_atrapado;
    public float latitude;
    public float longitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

    public int getEsta_atrapado() {
        return esta_atrapado;
    }

    public void setEsta_atrapado(int esta_atrapado) {
        this.esta_atrapado = esta_atrapado;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public pokemon(){}

    public pokemon(int id, String codigo, String nombre, String tipo, String url_imagen, int esta_atrapado, float latitude, float longitude) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.url_imagen = url_imagen;
        this.esta_atrapado = esta_atrapado;
        this.latitude = latitude;
        this.longitude = longitude;
    }


}
