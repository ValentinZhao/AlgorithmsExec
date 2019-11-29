package com.neu.cs5800;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinearProbingHashTable
{
    private int currentSize, maxSize;
    private String[] keys;
    private String[] vals;
    private Map<Integer, List<Integer>> map;

    /** Constructor **/
    public LinearProbingHashTable(int capacity)
    {
        currentSize = 0;
        maxSize = capacity;
        keys = new String[maxSize];
        vals = new String[maxSize];
        map = new HashMap<>();
    }

    /** Function to clear hash table **/
    public void makeEmpty()
    {
        currentSize = 0;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }

    /** Function to get size of hash table **/
    public int getSize()
    {
        return currentSize;
    }

    /** Function to check if hash table is full **/
    public boolean isFull()
    {
        return currentSize == maxSize;
    }

    /** Function to check if hash table is empty **/
    public boolean isEmpty()
    {
        return getSize() == 0;
    }

    /** Fucntion to check if hash table contains a key **/
    public boolean contains(String key)
    {
        return get(key) !=  null;
    }

    /** Functiont to get hash code of a given key **/
    private int hash(String key)
    {
        return Integer.valueOf(key) % maxSize;
    }

    /** Function to insert key-value pair **/
    public void insert(String key, String val)
    {
        int tmp = hash(key);
        int i = tmp;

        System.out.println("当前key：" + tmp);
        do
        {
//            if (isFull()) throw new IllegalStateException();
            if (keys[i] == null)
            {
                keys[i] = key;
                vals[i] = val;
                currentSize++;
                return;
            }
            if (keys[i].equals(key))
            {
                vals[i] = val;
                return;
            }
            i = (i + 1) % maxSize;
            if (tmp == i) throw new IllegalStateException();

        } while (i != tmp);
    }

    /** Function to get value for a given key **/
    public String get(String key)
    {
        int i = hash(key);
        int comparison = 1;

        while (keys[i] != null)
        {
            if (keys[i].equals(key)) {
                map.putIfAbsent(comparison, new ArrayList<>());
                map.get(comparison).add(currentSize);
                System.out.println("当前comparison：" + comparison);
                return vals[i];
            }
            comparison++;
            i = (i + 1) % maxSize;
        }
        return null;
    }

    public Map<Integer, List<Integer>> getMap() {
        return map;
    }
    /** Function to remove key and its value **/
    public void remove(String key)
    {
        if (!contains(key))
            return;

        /** find position key and delete **/
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % maxSize;
        keys[i] = vals[i] = null;

        /** rehash all keys **/
        for (i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize)
        {
            String tmp1 = keys[i], tmp2 = vals[i];
            keys[i] = vals[i] = null;
            currentSize--;
            insert(tmp1, tmp2);
        }
        currentSize--;
    }

    /** Function to print HashTable **/
    public void printHashTable()
    {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != null)
                System.out.println(keys[i] +" "+ vals[i]);
        System.out.println();
    }

    public String[] getKeys() {
        return keys;
    }

}
