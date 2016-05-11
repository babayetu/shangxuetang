package com.yinnut.generic;

/**
 * 泛型接口:与继承同理
 * @author liujingjing
 *
 * @param <T>
 */
public interface Comparable<T> {
	void compare(T t);
}

//声明子类指定具体类型
class Comp0 implements Comparable<String> {

	public void compare(String t) {

	}	
}
//父类擦除，子类擦除
class Comp1 implements Comparable {

	public void compare(Object t) {

	}	
}
//父类擦除，子类泛型
class Comp2<T> implements Comparable {

	public void compare(Object t) {

	}	
}
//子类泛型>=父类泛型
class Comp3<T> implements Comparable<T> {

	public void compare(T t) {

	}	
}

