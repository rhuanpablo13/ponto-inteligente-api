package com.kazale.pontointeligente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestesJava8 {
	
	
	public static void main(String[] args) {
	
		List<String> lista = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
		
		lista.forEach(valor -> System.out.println(valor));
		
		lista.removeIf(valor -> valor == "A");
		
		System.out.println("Removendo valor A");
		
		lista.forEach(valor -> System.out.println(valor));
	}
	
	
}
