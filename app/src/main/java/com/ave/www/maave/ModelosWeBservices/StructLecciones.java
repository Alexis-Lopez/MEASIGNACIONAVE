package com.ave.www.maave.ModelosWeBservices;

import com.ave.www.maave.Model.Lecciones;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by trini on 22/05/18.
 */

public class StructLecciones {
    private Integer count;
    private Objects objects;
    private List<Lecciones> resultados = new ArrayList<Lecciones>();
    private String next;

    @SerializedName("id")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Objects getObjects() {
        return objects;
    }

    public void setObjects(Objects objects) {
        this.objects = objects;
    }

    public List<Lecciones> getResultados() {
        return resultados;
    }

    public void setResultados(List<Lecciones> resultados) {
        this.resultados = resultados;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}