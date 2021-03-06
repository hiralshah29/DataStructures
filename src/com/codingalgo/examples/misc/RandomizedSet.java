package com.codingalgo.examples.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Design a data structure that supports insert, delete, search and getRandom in
 * constant time.
 * 
 * The best way to solve it is by using HashMap and ArrayList together. The
 * value field of the HashMap should be the corresponding position in ArrayList.
 * Every time an elements is deleted, the arraylist should update the
 * corresponding position with its tail element and reduce the total length by
 * 1. (Or simply reduce length by 1 if the position is at the tail). The time
 * complexity of any operation will be O(1).
 * 
 */

public class RandomizedSet<T> {

	private Map<T, Integer> valueIndexes;
	private List<T> values;
	private Random rand;

	public RandomizedSet() {
		valueIndexes = new HashMap<>();
		values = new ArrayList<>();
		rand = new Random();
	}

	public void add(T value) {
		if (!contains(value)) {
			int lastIndex = values.size();
			valueIndexes.put(value, lastIndex);
			values.add(value);
		}
	}

	public boolean contains(T value) {
		if (value == null) {
			throw new NullPointerException();
		}
		return valueIndexes.containsKey(value);
	}

	public T getRandom() {
		if (valueIndexes.isEmpty()) {
			throw new NoSuchElementException();
		}
		int randomIndex = rand.nextInt(values.size());
		return values.get(randomIndex);
	}

	public T deleteRandom() {
		if (valueIndexes.isEmpty()) {
			throw new NoSuchElementException();
		}
		int randomIndex = rand.nextInt(values.size());
		return deleteValue(randomIndex);
	}

	public T delete(T value) {
		if (!contains(value)) {
			throw new NoSuchElementException();
		}
		int index = valueIndexes.get(value);
		return deleteValue(index);
	}

	private T deleteValue(int currentIndex) {
		// remove the current element in the array, swap with the last,
		// and update the new index value in the map.
		T currentValue = values.get(currentIndex);
		int lastIndex = values.size() - 1;
		T lastVal = values.get(lastIndex);
		Collections.swap(values, currentIndex, lastIndex);
		// removing the last element is constant
		values.remove(lastIndex);
		valueIndexes.put(lastVal, currentIndex);
		valueIndexes.remove(currentValue);
		return currentValue;
	}

	public int size() {
		if (values.size() != valueIndexes.size()) {
			// should never happen.
			throw new IllegalStateException();
		}
		return values.size();
	}
}