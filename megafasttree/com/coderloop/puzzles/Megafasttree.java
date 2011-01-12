/**
 *  Copyright 2010 Coderloop.com.
 *  Author: Diego, the architect
 **/
package com.coderloop.puzzles;

import java.util.LinkedList;
import java.util.Queue;

//! This class implements a Megafasttree
//! A mega-fast-tree is just a tree, but faster
//! Why am I not using the common libraries?
//! Because my tree implementation is faster!
public class Megafasttree {
	// ! The list containing the MegafasttreeTM
	private Node root;

	// ! This is a node of the MegafasttreeTM
	public static class Node {
		// ! This is the left child of a node of the MegafasttreeTM
		private Node left;
		// ! This is the right child of a node of the MegafasttreeTM
		private Node right;
		// ! The payload of this node
		private int payload;

		public Node(int payload) {
			this.payload = payload;
		}

		// ! Set the left child
		public Node setLeftChild(Node n) {
			this.left = n;
			return this;
		}

		// ! Set the right child
		public Node setRightChild(Node n) {
			this.right = n;
			return this;
		}

		// ! Return the left child
		public Node toLeft() {
			return this.left;
		}

		// ! Return the right child
		public Node toRight() {
			return this.right;
		}

		// ! Visit the current node
		public String visit() {
			return String.valueOf(payload);
		}
	}

	private String breadthFirst(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			if (curr.left != null) {
				queue.add(curr.left);
			}
			if (curr.right != null) {
				queue.add(curr.right);
			}
			sb.append(curr.visit());
		}
		
		return sb.toString();
	}

	// Public method, do not touch this signature...
	public void addRoot(Node n) {
		if (n != null) {
			this.root = n;
		}
	}

	// Public method, do not touch this signature...
	public String bfs() {
		return breadthFirst(root);
	}	
}