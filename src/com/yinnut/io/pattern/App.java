package com.yinnut.io.pattern;

/**
 * 扩音器
 * 玩的是类和类之间的关系
 * 
 * 1、依赖：形参局部变量
 * 2、关联：属性
 * 		聚合：属性 整体与部分 不一致的生命周期 人与手
 * 		组合：属性 整体与部分 一致的生命周期	 共存亡人与大脑
 * 		
 * 3、继承：父子类关系
 * 4、实现：接口抽象实现
 * 
 * @author liujingjing
 *
 */
public class App {

	public static void main(String[] args) {
		Amplifier amplifier = new Amplifier(new Voice());
		amplifier.say();
	}

}
