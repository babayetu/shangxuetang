package com.yinnut.generic;

public abstract class Father<T,T1> {
	T name;
	public abstract void test(T t);
}

//子类申明时指定具体类型
class Child1 extends Father<String,Integer> {
	Integer t2;
	@Override
	public void test(String t) {
		// TODO Auto-generated method stub
		
	}
	
}

//子类为泛型类,类型在使用时确定
class Child2<T,T1> extends Father<T,T1> {
	T t2;
	@Override
	public void test(T t) {
		// TODO Auto-generated method stub
		
	}
	
}

//子类为泛型类，父类不指定类型,泛型的擦除,统一使用Object替换
class Child3<T1,T2> extends Father {
	T1 name;
	
	@Override
	public void test(Object t) {
		// TODO Auto-generated method stub
		
	}
	
}

//子类和父类同时擦除
class Child4 extends Father {
	Object name;
	
	@Override
	public void test(Object t) {
		// TODO Auto-generated method stub
		
	}	
}

/* 错误：子类类型擦除，父类使用泛型
 * 

class Child5 extends Father<T,T1> {
	Object name;

	@Override
	public void test(T t) {
		// TODO Auto-generated method stub
	}	
}
 */