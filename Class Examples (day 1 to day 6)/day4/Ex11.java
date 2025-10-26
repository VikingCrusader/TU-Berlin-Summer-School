package day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex11 {
	public static void main(String[] args) {
		List <String> type = new ArrayList();
		List <String> number = new ArrayList();
		type.add("Spade");
		type.add("Diamond");
		type.add("Heard");
		type.add("club");
		
		number.add("A");
		number.add("2");
		number.add("3");
		number.add("4");
		number.add("5");
		number.add("6");
		number.add("7");
		number.add("8");
		number.add("9");
		number.add("10");
		number.add("J");
		number.add("Q");
		number.add("K");
		
		List <String> Deck = new ArrayList();
		for (String t : type) {
			for (String n : number) {
				Deck.add(t + " " + n);
			}
		}
		
		String temp;
		int n = Deck.size();
		for (int i = 0; i < Deck.size(); i++) {
			// random number algorithm
			int j = i + (int)(Math.random() * (n - i));
			// 交换 Deck[i] 和 Deck[j] 
            temp = Deck.get(i);
            Deck.set(i, Deck.get(j));
            Deck.set(j, temp);
		}
		
		System.out.println(Deck);

	}
}

