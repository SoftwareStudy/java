多态：可以理解为事物存在的多种体现形态。(在java中主要体现在对象上)
	学完多态后，以前可以指挥一个对象做事情，现在可以指挥一堆对象做事情。
举例：
	人：男人，女人
	动物：猫，狗

猫   x = new 猫();
动物 x = new 猫();
/*
需要解决的问题：
	1，多态的表现形式。
		父类的引用指向了自己的子类对象。
		父类的引用也可以接收自己的子类对象。
	2，多态的前提。
		必须是类与类之间有关系，要么继承，要么实现。
		通常还有一个前提：存在函数覆盖
	3，多态到底有什么好处？
		多态的出现大大的提高了程序的扩展性。
	4，多态的弊端：
		提高了扩展性，但是只能使用父类的引用访问父类中的成员。
	5，多态如何应用？
		
	6，多态的出现代码中的特点(多态使用的注意事项)
		在多态中成员函数的特点；(非静态)
			在编译时期：参阅引用型变量所属的类中是否有调用的方法，
			如果有，编译通过，如果没有编译失败。
			在运行时期：参阅对象所属的类中是否有调用的方法。
		简单总结就是：成员函数在多态调用时，编译看左边，运行看右边。
		在多态中成员变量的特点：
			无论编译和运行，都参考左边(引用型变量所属的类)
		在多态中，静态函数的特点：
			无论编译和运行，都参考左边
	
*/
/*
 *举例：
 * 
 *动物，
 *猫，狗。 
 * */
abstract class Animal{
	abstract void eat();//由于动物吃的东西不确定，所以定义为抽象方法
}

class Cat extends Animal{
	public void eat(){
		System.out.println("吃鱼");
	}
	public void catchMouse(){
		System.out.println("抓老鼠");
	}
}
class Dog extends Animal{
	public void eat(){
		System.out.println("吃骨头");
	}
	public void kanJia(){
		System.out.println("看家");
	}
}
class Pig extends Animal{
	public void eat(){
		System.out.println("饲料");
	}
	public void gongDi(){
		System.out.println("供地");
	}
}
public class Main{
	public static void main(String[] args){
		Cat c  = new Cat();
		Dog c1 = new Dog();
		Pig c2 = new Pig();
		function(c);
		function(c1);
		function(c2);	
		
		Animal a = new Cat();//类型提升。向上转型
				     //byte b =2; int x = b;(b被提升为integer类型)
		a.eat();
		//如果想要调用猫的特有方法时，如何操作？
		//强制将父类的引用。转成子类类型。向下转型
		Cat c = (Cat)a;//(这是将父类的引用转换成了子类类型)
		c.catchMouse();
		//千万不要出现这样的操作，将父类对象转成子类类型。
		//我们能转换的是父类应用指向了自己的子类对象时，该应用可以被提升，
		//也可以被强制转换。
		//多态自始至终都是子类对象在做着变化。
	}
	/*多态的应用实例*/
	public static void function(Animal c){
		c.eat();
	}
}

instanceof 关键字，用于判断对象的引用是否等于具体的对象类型,返回值为布尔类型

例如 Cat a = new Cat();
     if(a instanceof Cat){
     	System.out.println("a是Cat类型");
     }

/*
 *多态的应用实例
 * */

/*
 * 基础班学生：
 * 	学习，睡觉。
 * 高级班学生
 *      学习，睡觉。
 *
 *  可以将这两类事物进行抽取。
 *
 * */
class Student{
	public abstract void study();
	public void sleep();
}

class BaseStudent extends Student{
	public void study(){
		System.out.println("base study");
	}
	public void sleep(){
		System.out.println("坐着睡");
	}
}
class AdvStudent extends Student{
	public void study(){
		System.out.println("adv study");
	}
}
public class Main{
	public static void main(String[] args){
		/*这是没有多态时的调用形式*/
		BaseStudent bs = new BaseStudent();
		bs.study();
		bs.sleep();
		AdvStudent as = new AdvStudent();
		as.study();
		as.sleep();		
		/*这是有多态以后的调用形式*/
		Dostudent ds = new Dostudent();
		ds.doSome(new BaseStudent());
		ds.doSome(new AdvStudent());
	}
	/*指挥基础班和高级班的学生去做事情,虽然封装了起来，
	 * 但是由于没有多态的思想，所以代码重复大，
	 * 给开发者造成了很大的工作量，而且效率还不高。 
	 * */
	public void doSome(BaseStudent bs){
		bs.study();
		bs.sleep();		
	}
	public void doSome(AdvStudent bs){
		bs.study();
		bs.sleep();	
	}
	/*利用多态的形式建立父类的引用来进行同时指挥，
	 * 这样的代码复用率很高，大大的减轻了开发者的压力，
	 * 作为一名优秀的程序员，这是必备技能。
	 * */
	public void doSome(Student stu){
		stu.study();
		stu.sleep();
	}
}
/*既然可以指挥一批学生做事情，那么何不将它们单独封装起来做为一个类*/
class Dostudent{
	public void doSome(Student stu){
		stu.study();
		stu.sleep();
	}	
}

/*总结：对对象类型进行抽取共同的部分造成了多态的产生，
 *	建立一个工具类来进行操作父类引用的子类，从而
 *	降低开发者的压力，这就是多态的思想。
 * 
 * */
