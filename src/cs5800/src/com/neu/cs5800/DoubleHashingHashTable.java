package com.neu.cs5800;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Class HashTable */
public class DoubleHashingHashTable
{
    private int TABLE_SIZE;
    private int size;
    public HashEntry[] table;
    private int primeSize;
    private Map<Integer, List<Integer>> map;

    /* Constructor */
    public DoubleHashingHashTable(int ts)
    {
        size = 0;
        TABLE_SIZE = ts;
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
        primeSize = getPrime();
        map = new HashMap<>();
    }
    /* Function to get prime number less than table size for myhash2 function */
    public int getPrime()
    {
        for (int i = TABLE_SIZE - 1; i >= 1; i--)
        {
            int fact = 0;
            for (int j = 2; j <= (int) Math.sqrt(i); j++)
                if (i % j == 0)
                    fact++;
            if (fact == 0)
                return i;
        }
        /* Return a prime number */
        return 3;
    }
    /* Function to get number of key-value pairs */
    public int getSize()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    /* Function to clear hash table */
    public void makeEmpty()
    {
        size = 0;
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }
    /* Function to get value of a key */
    public int get(String key)
    {
        int hash1 = myhash1( key );
        int hash2 = myhash2( key );
        int comparison = 1;

        while (table[hash1] != null && !table[hash1].key.equals(key))
        {
            hash1 += hash2;
            hash1 %= TABLE_SIZE;
            comparison++;
            System.out.println("当前comparison：" + comparison);
        }
        map.putIfAbsent(comparison, new ArrayList<>());
        map.get(comparison).add(size);
        System.out.println("当前comparison：" + comparison);

        return table[hash1].value;
    }
    /* Function to insert a key value pair */
    public void insert(String key, int value)
    {
        if (size == TABLE_SIZE)
        {
            System.out.println("Table full");
            throw new IllegalStateException();
        }
        int hash1 = myhash1( key );
        int hash2 = myhash2( key );
        while (table[hash1] != null)
        {
            hash1 += hash2;
            hash1 %= TABLE_SIZE;
        }
        table[hash1] = new HashEntry(key, value);
        size++;
    }
    /* Function to remove a key */
    public void remove(String key)
    {
        int hash1 = myhash1( key );
        int hash2 = myhash2( key );
        while (table[hash1] != null && !table[hash1].key.equals(key))
        {
            hash1 += hash2;
            hash1 %= TABLE_SIZE;
        }
        table[hash1] = null;
        size--;
    }
    /* Function myhash which gives a hash value for a given string */
    private int myhash1(String x )
    {
        int hashVal = x.hashCode( );
        hashVal %= TABLE_SIZE;
        if (hashVal < 0)
            hashVal += TABLE_SIZE;
        return hashVal;
    }
    /* Function myhash function for double hashing */
    private int myhash2(String x )
    {
        int hashVal = x.hashCode( );
        hashVal %= TABLE_SIZE;
        if (hashVal < 0)
            hashVal += TABLE_SIZE;
        return primeSize - hashVal % primeSize;
    }
    /* Function to print hash table */
    public void printHashTable()
    {
        System.out.println("\nHash Table");
        for (int i = 0; i < TABLE_SIZE; i++)
            if (table[i] != null)
                System.out.println(table[i].key +" "+table[i].value);
    }

    public Map<Integer, List<Integer>> getMap() {
        return map;
    }

    public HashEntry[] getTable () {
        return table;
    }

    public static class HashEntry
    {
        String key;
        int value;

        /* Constructor */
        HashEntry(String key, int value)
        {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }
}
