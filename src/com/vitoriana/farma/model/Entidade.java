package com.vitoriana.farma.model;

import java.util.Random;

public abstract class Entidade {

	private int id;

	public Entidade(int id) {
		this.id = id;
	}

	public int getId() {
		if (id == 0) {
			Random random = new Random();
			return (random.nextInt(999));
		} else {
			return id;
		}
	}
	
	@Override
	public String toString() {
		return "<" + this.getClass().getSimpleName() + ":" + id + ">";
	}
}
