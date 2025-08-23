package com.examples.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class CollectionsFrameworkExample {

	// List Interface
	List<String> arrayListObj = new ArrayList<>();
	List<String> linkedListObj = new LinkedList<>();
	List<String> vectorListObj = new Vector<>();
	List<String> stackListObj = new Stack<>();
	List<String> copyOnWriteArrayListtObj = new CopyOnWriteArrayList<>();

	// Queue Interface
	Queue<String> arrayDequeObj = new ArrayDeque<>();
	Queue<String> priorityQueueObj = new PriorityQueue<>();

	Deque<String> deQueueObj = new ArrayDeque<>();

	BlockingQueue<String> arrayBlockingQueueObj = new ArrayBlockingQueue<>(10);
	BlockingQueue<String> linkedBlockingQueueObj = new LinkedBlockingQueue<String>();

	// Set Interface
	Set<String> hastSetObj = new HashSet<>();
	Set<String> linkedHashSetObj = new LinkedHashSet<>();
	Set<String> treeSetObj = new TreeSet<>();
	Set<String> concurrentSkipListSetObj = new ConcurrentSkipListSet<>();

	// Map Interface
	Map<String, String> hashMapObj = new HashMap<>();
	Map<String, String> treeMapObj = new TreeMap<>();
	Map<String, String> linkedHashMapObj = new LinkedHashMap<>();
	Map<String, String> hashtableObj = new Hashtable<>();

	// 1. Insertion Operations
	void addElements() {
		try {
			arrayListObj.add("Apple");
			linkedListObj.add("Banana");
			vectorListObj.add("Cherry");
			stackListObj.add("Date");
			copyOnWriteArrayListtObj.add("Date");

			arrayDequeObj.offer("Elderberry");
			priorityQueueObj.offer("Fig");

			deQueueObj.add("Grape");

			arrayBlockingQueueObj.put("Honeydew");
			linkedBlockingQueueObj.add("Iced Tea");

			hastSetObj.add("Jackfruit");
			linkedHashSetObj.add("Kiwi");
			treeSetObj.add("Lemon");

			hashMapObj.put("Mango", "Sweet");
			treeMapObj.put("Nectarine", "Tart");
			linkedHashMapObj.put("Orange", "Citrus");
			hashtableObj.put("Apple", "Fruit");

			// Add All
			arrayListObj.addAll(Arrays.asList("Apple", "Banana"));
			linkedListObj.addAll(Arrays.asList("Cherry", "Date"));

			arrayDequeObj.addAll(Arrays.asList("Elderberry", "Fig"));
			priorityQueueObj.addAll(Arrays.asList("Grape", "Honeydew"));

			deQueueObj.addAll(Arrays.asList("Iced Tea", "Jackfruit"));

			hastSetObj.addAll(Arrays.asList("Kiwi", "Lemon"));
			linkedHashSetObj.addAll(Arrays.asList("Mango", "Nectarine"));
			treeSetObj.addAll(Arrays.asList("Orange", "Papaya"));

			hashMapObj.putAll(Map.of("Peach", "Sweet", "Plum", "Sour"));
			treeMapObj.putAll(Map.of("Quince", "Tart"));
			linkedHashMapObj.putAll(Map.of("Raspberry", "Sweet"));
			hashtableObj.putAll(Map.of("Raspberry", "Sweet"));
		} catch (Exception e) {
		}
	}

	// 2. Removal Operations
	void removeElements() {
		try {
			arrayListObj.remove("Apple"); // Removes by object
			linkedListObj.remove(0); // Removes by index
			vectorListObj.remove(0); // Removes by index
			stackListObj.remove(0); // Removes by index
			copyOnWriteArrayListtObj.remove(0); // Removes by index

			arrayDequeObj.poll(); // Removes and returns the first element
			priorityQueueObj.poll(); // Removes and returns the lowest priority element

			deQueueObj.removeFirst(); // Removes the first element
			deQueueObj.removeLast(); // Removes the last element

			arrayBlockingQueueObj.take(); // Blocks until an element is available
			linkedBlockingQueueObj.remove("Iced Tea"); // Removes by object

			hastSetObj.remove("Jackfruit");
			linkedHashSetObj.remove("Kiwi");
			treeSetObj.remove("Lemon");

			hashMapObj.remove("Mango");
			treeMapObj.remove("Nectarine");
			linkedHashMapObj.remove("Orange");
			hashtableObj.remove("Carrot"); // Removes the entry for key "Carrot"

			// Remove Multiple Elements
			arrayListObj.removeAll(Arrays.asList("Apple", "Banana"));
			linkedListObj.removeAll(Arrays.asList("Cherry", "Date"));
			copyOnWriteArrayListtObj.removeAll(Arrays.asList("Cherry", "Date"));

			arrayDequeObj.removeAll(Arrays.asList("Elderberry", "Fig"));
			priorityQueueObj.removeAll(Arrays.asList("Grape", "Honeydew"));

			deQueueObj.removeAll(Arrays.asList("Iced Tea", "Jackfruit"));

			hastSetObj.removeAll(Arrays.asList("Kiwi", "Lemon"));
			linkedHashSetObj.removeAll(Arrays.asList("Mango", "Nectarine"));
			treeSetObj.removeAll(Arrays.asList("Orange", "Papaya"));
		} catch (Exception e) {
		}
	}

	// 3. Lookup Operations
	void searchForElements() {
		try {
			arrayListObj.contains("Apple"); // Checks if "Apple" exists
			linkedListObj.contains("Banana");
			vectorListObj.contains("Cherry");
			stackListObj.contains("Date");
			copyOnWriteArrayListtObj.contains("Date");

			arrayDequeObj.contains("Elderberry");
			priorityQueueObj.contains("Fig");

			deQueueObj.contains("Grape");

			arrayBlockingQueueObj.contains("Honeydew");
			linkedBlockingQueueObj.contains("Iced Tea");

			hastSetObj.contains("Jackfruit");
			linkedHashSetObj.contains("Kiwi");
			treeSetObj.contains("Lemon");

			hashMapObj.containsKey("Mango"); // Checks if key "Mango" exists
			treeMapObj.containsValue("Tart"); // Checks if value "Tart" exists
			linkedHashMapObj.containsKey("Orange");
			hashtableObj.containsKey("Apple");
		} catch (Exception e) {
		}
	}

	// 4. Traversal Operations
	void iteratingOverElements() {
		try {
			arrayListObj.forEach(System.out::println);
			linkedListObj.forEach(System.out::println);
			vectorListObj.forEach(System.out::println);
			stackListObj.forEach(System.out::println);
			copyOnWriteArrayListtObj.forEach(System.out::println);

			arrayDequeObj.forEach(System.out::println);
			priorityQueueObj.forEach(System.out::println);

			deQueueObj.forEach(System.out::println);

			arrayBlockingQueueObj.forEach(System.out::println);
			linkedBlockingQueueObj.forEach(System.out::println);

			hastSetObj.forEach(System.out::println);
			linkedHashSetObj.forEach(System.out::println);
			treeSetObj.forEach(System.out::println);

			hashMapObj.forEach((k, v) -> System.out.println(k + ": " + v));
			treeMapObj.forEach((k, v) -> System.out.println(k + ": " + v));
			linkedHashMapObj.forEach((k, v) -> System.out.println(k + ": " + v));
			hashtableObj.forEach((k, v) -> System.out.println(k + ": " + v));
		} catch (Exception e) {
		}
	}

	// 5. Query Operations
	void sizeAndEmptiness() {
		try {
			arrayListObj.size();
			linkedListObj.isEmpty();
			vectorListObj.size();
			stackListObj.isEmpty();
			copyOnWriteArrayListtObj.size();

			arrayDequeObj.size();
			priorityQueueObj.isEmpty();

			deQueueObj.size();

			arrayBlockingQueueObj.size();
			linkedBlockingQueueObj.isEmpty();

			hastSetObj.size();
			linkedHashSetObj.isEmpty();
			treeSetObj.size();

			hashMapObj.size();
			treeMapObj.isEmpty();
			linkedHashMapObj.size();
			hashtableObj.isEmpty();
		} catch (Exception e) {
		}
	}

	// 6. Modification Operations
	void updateElements() {
		try {
			arrayListObj.set(0, "Apricot"); // Sets element at index 0
			linkedListObj.set(1, "Blueberry");
			copyOnWriteArrayListtObj.set(1, "Blueberry");

			hashMapObj.put("Mango", "Sour"); // Updates the value for key "Mango"
			linkedHashMapObj.put("Orange", "Tart"); // Updates the value for key "Orange"
			hashtableObj.put("Apple", "Green Fruit"); // Updates the value for key "Apple"

			// Update All
			hashtableObj.putAll(Map.of("Banana", "Yellow Fruit", "Cucumber", "Green Vegetable"));
		} catch (Exception e) {
		}
	}

	// 7. Sorting Operations
	void sortElements() {
		try {
			Collections.sort(arrayListObj); // Sorts in ascending order
			Collections.sort(linkedListObj);

			arrayListObj.sort(Comparator.reverseOrder()); // Sort in descending order
			linkedListObj.sort(Comparator.naturalOrder());
		} catch (Exception e) {
		}
	}

	// 8. Conversion Operations
	void convertCollection() {
		try {
			Set<String> listToSet = new HashSet<>(arrayListObj);
			List<String> setToList = new ArrayList<>(hastSetObj);

			Set<String> keysSet = hashtableObj.keySet(); // Get all keys
			Collection<String> values = hashtableObj.values(); // Get all values
		} catch (Exception e) {
		}
	}

	// 9. Utility Operations
	void clearAllElements() {
		try {
			arrayListObj.clear();
			linkedListObj.clear();
			vectorListObj.clear();
			stackListObj.clear();
			copyOnWriteArrayListtObj.clear();

			arrayDequeObj.clear();
			priorityQueueObj.clear();

			deQueueObj.clear();

			arrayBlockingQueueObj.clear();
			linkedBlockingQueueObj.clear();

			hastSetObj.clear();
			linkedHashSetObj.clear();
			treeSetObj.clear();

			hashMapObj.clear();
			treeMapObj.clear();
			linkedHashMapObj.clear();
			hashtableObj.clear(); // Removes all entries
		} catch (Exception e) {
		}
	}

	// 10. Blocking Operations (for thread-safe collections)
	void blockingQueueOperations() {
		try {
			arrayBlockingQueueObj.put("Item"); // Blocks if full
			String item = arrayBlockingQueueObj.take(); // Blocks if empty

			linkedBlockingQueueObj.put("Item");
			String item2 = linkedBlockingQueueObj.take();
		} catch (Exception e) {
		}
	}

	// 11. Transformation Operations (Streams)
	void transformingWithStreams() {
		try {
			List<String> upperCaseList = arrayListObj.stream().map(String::toUpperCase).toList();

			List<String> filteredList = linkedListObj.stream().filter(s -> s.startsWith("B")).toList();
		} catch (Exception e) {
		}
	}
}