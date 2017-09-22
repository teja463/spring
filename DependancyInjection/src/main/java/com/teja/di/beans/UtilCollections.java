package com.teja.di.beans;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;

public class UtilCollections {

	private Vector vector;
	private TreeSet treeSet;
	private Hashtable hashtable;
	public Vector getVector() {
		return vector;
	}
	public void setVector(Vector vector) {
		this.vector = vector;
	}
	public TreeSet getTreeSet() {
		return treeSet;
	}
	public void setTreeSet(TreeSet treeSet) {
		this.treeSet = treeSet;
	}
	public Hashtable getHashtable() {
		return hashtable;
	}
	public void setHashtable(Hashtable hashtable) {
		this.hashtable = hashtable;
		
	}
	

	public void printData(){
		Iterator vIterator = vector.iterator();
		while(vIterator.hasNext()){
			System.out.println(vIterator.next().toString());
		}
		
		Iterator tIterator = treeSet.iterator();
		while(tIterator.hasNext()){
			System.out.println(tIterator.next().toString());
		}
		
		Iterator hIterator = hashtable.keySet().iterator();
		while(hIterator.hasNext()){
			Object key = hIterator.next();
			
			System.out.println("Key : "+key.toString() +" Value: "+ hashtable.get(key));
		}
	}
}
