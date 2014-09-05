package com.senac.estrutura;


public class ListaEncadeadaOrdenada<T> {
	private Nodo<T> head = null;
	private Nodo<T> tail = null;   
	private int size = 0;

	public ListaEncadeadaOrdenada() {
		this.head = new Nodo<T>(null);
	}

	@SuppressWarnings("unchecked")
	public void insert(Object element) {
		if (this.size == 0) {
			this.insertOnHead(element);
		} else {
			Nodo<T> actual = this.head;
			int diff;

			for (int i = 0; i <= this.size - 1; i++) {
				diff = ((Comparable<T>) element).compareTo((T) actual.getElement());
				System.out.println(element + " <> " + actual.getElement() + " = " + diff);
				if(diff <= 0) {
					this.insert(i,element);
					return;
				} else {
					if(i == this.size - 1) {
						this.insertOnTail(element);
						return;
					}
					actual = actual.getNext();
			     }
			}
		}
	}

	private void insertOnTail(Object element) {
		if (this.size == 0) {
			this.insertOnHead(element);
		} else {
			Nodo<T> newNodo = new Nodo<T>(element);
			this.tail.setNext(newNodo);
			newNodo.setPrevious(this.tail);
			this.tail = newNodo;
			this.size++;
		}
	}

	private void insertOnHead(Object element) {
		Nodo<T> newNodo = new Nodo<T>(element);

		if(this.size == 0){
	    	this.tail = newNodo;
	    } else {
	    	newNodo.setNext(this.head);
	        this.head.setPrevious(newNodo);
	    }

		this.head = newNodo;
	    this.size++;
	}

	private void insert(int position, Object element) {
		if(position == 0) {
			this.insertOnHead(element);
		} else if(position == this.size) {
			this.insertOnTail(element);
		} else {
			Nodo<T> previous = this.getNodo(position - 1);
			Nodo<T> newNodo = new Nodo<T>(previous.getNext(), element);
			newNodo.setPrevious(previous);
			previous.getNext().setPrevious(newNodo);
			previous.setNext(newNodo);

			this.size++;
		}
	}

	public Nodo<T> getHead() {
		if (this.size > 0) {
			return this.head;
		}
		return null;
	}

	public Object getElement(Object element) {
		int position = this.getPosition(element);
		if (position >= 0) {
			return this.getElement(position);
		}

		return null;
	}

	public Object getElement(int position) {
		return this.getNodo(position).getElement();
	}

	public void removeHead() {
		if (!this.positionExists(0)) {
			throw new IllegalArgumentException("Posição não existe");
		}

		this.head = this.head.getNext();
		this.head.setPrevious(null);
		this.size--;
		  
		if (this.size == 0) {
			this.tail = null;
		}
	}

	public void removeTail() {
		if (!this.positionExists(this.size - 1)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		if (this.size == 1) {
			this.removeHead();
		} else {
			Nodo<T> newTail = this.tail.getPrevious();
			newTail.setNext(null);
			this.tail = newTail;
			this.size--;
		}
	}

	public void remove(Object element) {
		int position = this.getPosition(element);
		if (position >= 0) {
			this.remove(position);
		}
	}

	public void remove(int position) {
		if (!this.positionExists(position)) {
			throw new IllegalArgumentException("Posição não existe");
		}

		if (position == 0) {
			this.removeHead();
		} else if (position == this.size - 1) {
			this.removeTail();
		} else {
			Nodo<T> previous = this.getNodo(position - 1);
			Nodo<T> actual = previous.getNext();
			Nodo<T> next = actual.getNext();

			previous.setNext(next);
			next.setPrevious(previous);

			this.size--;
		}
	}

	public boolean exists(Object element) {
		Nodo<T> actual = this.head;

		while (actual != null) {
			if (actual.getElement().equals(element)) {
				return true;
			}
			actual = actual.getNext();
		}
		return false;
	}


	public int getPosition(Object element) {
		Nodo<T> actual = this.head;
		int position = 0;

		while (actual != null) {
			if (actual.getElement().equals(element)) {
				return position;
			}
			actual = actual.getNext();
			position++;
		}
		return -1;
	}

	public int size() {
		return this.size;
	}

	private boolean positionExists(int posicao){
		return posicao >= 0 && posicao < this.size;
	}

	private Nodo<T> getNodo(int position) {
		if(!this.positionExists(position)) {
			throw new IllegalArgumentException("Posição não existe");
		}

		Nodo<T> nodo = this.head;
		for (int i = 0; i < position; i++) {
			nodo = nodo.getNext();
		}
		return nodo;
	}

	public String toString() {
		if(this.size == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");
		Nodo<T> nodo = head;

		for (int i = 0; i < this.size - 1; i++) {
			builder.append(nodo.getElement());
			builder.append(", ");
			nodo = nodo.getNext();
		}

		builder.append(nodo.getElement());
		builder.append("]");

		return builder.toString();
	}
}