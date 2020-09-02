package com.eomcs.util;

import java.util.EmptyStackException;

// 테스트2: MyStackTest2 
// 6) Object.clone() 을 오버라이딩 : deep copy

public class Stack<E> extends LinkedList<E> implements Cloneable {

	public E push(E item) {
		add(item);
		return item;
	}

	public E pop() {
		if (size() == 0) {
			throw new EmptyStackException();
		}
		return remove(size() - 1);
	}

	public E peek() {
		if (size() == 0) {
			throw new EmptyStackException();
		}
		return get(size() - 1);
	}

	public boolean empty() {
		return this.size() == 0;
	}

	@Override
	public Stack<E> clone() throws CloneNotSupportedException {
		// 새 스택을 만든다
		Stack<E> newStack = new Stack<>();

		// 기존 스택의 값을 가져온다
		Object[] values = this.toArray();

		// 기존 스택의 값을 새 스택에 넣는다
		for (Object value : values) {
			newStack.push((E) value);
		}
		return newStack;
	}
}



















