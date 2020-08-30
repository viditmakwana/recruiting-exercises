package DeliverrSolution;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class Tests {

	/*
	 * Basic test to see of I can order an apple from a warehouse that has an 
	 * apple
	 */
	@Test
	public void test1() {
		HashMap<String, Integer> order = new HashMap<>();
		order.put("apple", 1);
		HashMap<String, Integer> inv1 = new HashMap<>();
		inv1.put("apple", 1);
		HashMap<String, HashMap<String, Integer>> inventory = new HashMap<>();
		inventory.put("owd", inv1);
		HashMap<String, Integer> ans1 = new HashMap<>();
		ans1.put("apple", 1);
		HashMap<String, HashMap<String, Integer>> answer = new HashMap<>();
		answer.put("owd", ans1);
		HashMap<String, HashMap<String, Integer>> testSub = new HashMap<>();
		testSub = Shipment.solution(order, inventory);
		assertTrue(answer.equals(testSub));
	}
	
	/*
	 * This tests whether I can order from two different warehouses if necessary
	 */
	@Test
	public void test2() {
		HashMap<String, Integer> order = new HashMap<>();
		order.put("apple", 10);
		HashMap<String, Integer> inv1 = new HashMap<>();
		inv1.put("apple", 5);
		HashMap<String, HashMap<String, Integer>> inventory = new HashMap<>();
		inventory.put("owd", inv1);
		HashMap<String, Integer> inv2 = new HashMap<>();
		inv2.put("apple", 5);
		inventory.put("dm", inv2);
		HashMap<String, HashMap<String, Integer>> testSub = new HashMap<>();
		testSub = Shipment.solution(order, inventory);
		HashMap<String, HashMap<String, Integer>> answer = new HashMap<>();
		HashMap<String, Integer> ans1 = new HashMap<>();
		ans1.put("apple", 5);
		HashMap<String, Integer> ans2 = new HashMap<>();
		ans2.put("apple", 5);
		answer.put("owd", ans1);
		answer.put("dm", ans2);
		assertTrue(answer.equals(testSub));
	}
	
	/*
	 * This tests if I am able to order from the warehouses in the first place
	 */
	@Test
	public void test3() {
		HashMap<String, Integer> order = new HashMap<>();
		order.put("apple", 1);
		HashMap<String, Integer> inv1 = new HashMap<>();
		inv1.put("apple", 0);
		HashMap<String, HashMap<String, Integer>> inventory = new HashMap<>();
		inventory.put("owd", inv1);
		HashMap<String, HashMap<String, Integer>> answer = new HashMap<>();
		HashMap<String, HashMap<String, Integer>> testSub = new HashMap<>();
		testSub = Shipment.solution(order, inventory);
		assertTrue(answer.equals(testSub));
	}

}
