package com.senac.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.senac.estrutura.ListaEncadeadaOrdenada;

public class ListaEncadeadaOrdenadaTest {

	@Test
	public void testAdciona() {
	    ListaEncadeadaOrdenada<String> lista = new ListaEncadeadaOrdenada<String>();
	    lista.insert("x");
	    lista.insert("a");
	    lista.insert("b");
	    lista.insert("1");
	    lista.insert("c");
	    assertEquals(null, "[1, a, b, c, x]", lista.toString());
	}

	@Test
	public void testPegaPorPosicao() {
	    ListaEncadeadaOrdenada<String> lista = new ListaEncadeadaOrdenada<String>();
	    lista.insert("Nome A");
	    lista.insert("Nome C");
	    lista.insert("Nome B");
	    lista.insert("Nome E");
	    lista.insert("Nome D");
	    assertEquals(null, "[Nome A, Nome B, Nome C, Nome D, Nome E]", lista.toString());
	    assertEquals(null, "Nome A", lista.getElement(0));
	    assertEquals(null, "Nome C", lista.getElement(2));
	}

	@Test
	public void testRemoveDoComeco() {
		ListaEncadeadaOrdenada<String> lista = new ListaEncadeadaOrdenada<String>();

		lista.insert("Nome 1");
		lista.insert("Nome 2");

		lista.removeHead();

		assertEquals(null, "Nome 2", lista.getElement(0));
	}

	@Test
	public void testRemoveDoFim() {
		ListaEncadeadaOrdenada<String> lista = new ListaEncadeadaOrdenada<String>();

		lista.insert("Nome 3");
		lista.insert("Nome 1");
		lista.insert("Nome 2");

		lista.removeTail();

		assertEquals(null, "Nome 1", lista.getElement(0));
	}

	@Test
	public void testRemovePorPosicao() {
	    ListaEncadeadaOrdenada<String> lista = new ListaEncadeadaOrdenada<String>();
	    lista.insert("Nome 1");
	    lista.insert("Nome 2");
	    lista.insert("Nome 3");

	    lista.remove(1);
	    assertEquals(null, "[Nome 1, Nome 3]", lista.toString());
	}

	@Test
	public void testTamanho() {
		ListaEncadeadaOrdenada<String> lista = new ListaEncadeadaOrdenada<String>();

		lista.insert("Nome 1");
		lista.insert("Nome 2");

		assertEquals(null, 2, lista.size());

		lista.insert("Nome 3");

		assertEquals(null, 3, lista.size());
	}

	@Test
	public void testContemElemento() {
		ListaEncadeadaOrdenada<String> lista = new ListaEncadeadaOrdenada<String>();

		lista.insert("Nome 1");
		lista.insert("Nome 2");

		assertTrue(lista.getPosition("Nome 1") >= 0);
		assertTrue(lista.getPosition("Nome 3") < 0);
	}
}