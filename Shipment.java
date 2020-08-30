package DeliverrSolution;

import java.util.HashMap;

/*
 * This class implements a function that produces the cheapest shipment by 
 * looking for the items being ordered in the first warehouse first since it
 * is the least expensive to order from.
 * 
 * I implement this function with the use of HashMaps because it is the most
 * straightforward and simple method to map the items to order to the number
 * each item to order. I also use HashMap to map the warehouses to the inventory
 * in each of the warehouses.
 */
public class Shipment {

	public static HashMap<String, HashMap<String, Integer>> solution(HashMap<String, Integer> order,
			HashMap<String, HashMap<String, Integer>> inventory) {

		// finalShipment holds the final order of what and where to order
		HashMap<String, HashMap<String, Integer>> finalShipment = new HashMap<>();
		// finalOrders holds the finalOrders from each of the warehouses
		HashMap<String, Integer> finalOrders = new HashMap<>();
		/*
		 * These nested loops first loop through the items to be ordered (the
		 * first input). Then, I loop through the warehouses to see if the current
		 * item is present and available. If it is available, I put the order
		 * in finalOrders and update the inventory for future orders. After I
		 * find the item in the warehouse, I break out of the loop and go to
		 * the next item.
		 */
		for (String key : order.keySet()) {
			Integer toOrder = order.get(key);
			for (String warehouse : inventory.keySet()) {
				for (String avail : inventory.get(warehouse).keySet()) {
					if (key.equals(avail)) {
						Integer total = inventory.get(warehouse).get(avail);
						finalOrders.put(key, total);
						finalShipment.put(warehouse, finalOrders);
						if (toOrder <= total) {
							total -= toOrder;
						} else {
							total = 0;
						}
						inventory.get(warehouse).put(avail, total);
						break;
					}
				}
			}
		}
		
		/*
		 * If I don't need to order an item (the mapped number is 0), I remove
		 * it from the finalOrder
		 */
		for (String key : finalOrders.keySet()) {
			if (finalOrders.get(key) == 0) {
				finalOrders.remove(key);
			}
		}
		
		/*
		 * If I don't need to order from a specific warehouse, I remove that
		 * warehouse from finalShipment
		 */
		for (String warehouse: finalShipment.keySet()) {
			if (finalShipment.get(warehouse).isEmpty()) {
				finalShipment.remove(warehouse);
			}
		}
		return finalShipment;
	}
}
