package com.senac.estrutura;

public class Nodo<T> {
	private Nodo<T> next = null, previous = null;
	private Object element;

	public Nodo(Object element) {
		this.element = element;
	}

	public Nodo(Nodo<T> next, Object element) {
		this.next = next;
		this.element = element;
	}

	public Nodo<T> getNext() {
		return next;
	}
	
	public Nodo<T> getPrevious() {
		return this.previous;
	}

	public Object getElement() {
		return element;
	}

	public void setNext(Nodo<T> nodo) {
		this.next = nodo;
	}

	public void setPrevious(Nodo<T> nodo) {
		this.previous = nodo;
	}
}