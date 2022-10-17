package com.vitoriana.farma.model;

import java.io.Serializable;

public abstract class Entidade implements Serializable {

    private static final long serialVersionUID = 1L;

    public static int NEXT_ID = 0;

    private int id;

    public Entidade() {
        this.id = ++NEXT_ID;
    }

    public Entidade(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "<" + this.getClass().getSimpleName() + ":" + id + ">";
    }
}
