/*
 内部类的访问规则：
 1，内部类可以直接访问外部类中的成员，包括私有成员
 	之所以可以直接访问外部类的成员，是因为内部类中持有了一个外部类的引用，
	格式：外部类名.this
 2，外部类要访问内部类，必须建立内部类对象

 访问格式：
1, 当内部类定义在外部类的成员位置上，而且非私有，可以在外部其他类中。
 直接建立外部类对象。
 格式
 	外部类名.内部类名 变量名 = 外部类对象.内部类对象
	Outer.Inner in = new Outer.new Inner();
2，当内部类在成员位置上，就可以被成员修饰符所修饰。
	比如，private，将内部类在外部类中进行封装。
	static：内部类就具备了静态的特性
	当内部类被static修饰后，只能直接访问外部类中的static成员，出现了访问局限
	
	在外部其他类中，如何直接访问静态内部类的非静态成员呢？
	new Outer.Inner().function();

	在外部其他类中，如何直接访问static内部类的静态成员呢？
	Outer.Inner.function();

	注意：当内部类中定义了静态成员，该内部类必须是静态的。
		当外部类中的静态方法访问内部类时，内部类也必须是静态的。

内部类定义原则：
	当描述事物时，事物的内部还有事物，该事物用内部类来描述。
	因为内部事务在使用外部事物的内容。

class Body{
	//心脏不对外直接暴露
	private class XinZang{

	}	
	//提供方法暴露心脏，例如，医生访问
	public void show(){
		new XinZang();
	}

}


 * */

class Outer{
	int x = 3;
	
	/*定义内部类*/
	class Inner{
		int x = 4;
		void function(){
			int x = 6;
			System.out.println("inner:"+Outer.this.x); //内部类访问外部成员
		}
	}
	void method(){
		System.out.println(x);
		//访问内部类成员
		Inner in new Inner();
		in.function();
	}
}
public class Main{
	public static void main(String[] args){
		Outer out = new Outer();
		out.method();
		//直接访问内部类中的成员
		Outer.Inner in = new Outer.new Inner();
		in.function();
	}
}

/*当内部类是静态的时候*/
class Outer{
	static int x = 3;
	
	/*定义内部类*/
	static class Inner{
		int x = 4;
		void function(){
			int x = 6;
			System.out.println("inner:"+Outer.this.x); //内部类访问外部成员
		}
	}
	void method(){
		System.out.println(x);
		//访问内部类成员
		Inner in new Inner();
		in.function();
	}
}
public class Main{
	public static void main(String[] args){
		Outer out = new Outer();
		out.method();
		new Outer.Inner().function();
		//直接访问内部类中的成员
		//Outer.Inner in = new Outer.new Inner();
		//in.function();
	}
}



匿名内部类

/*
 内部类定义在局部时，
 1，不可以被成员修饰符修饰
 2，可以直接访问外部类中的成员，因为还持有外部类中的引用。
 	但是不可以访问它所在的局部中的变量，只能访问被final修饰的局部变量。

 * */
class Outer{
	void method(){
		final int y = 4;
		class Inner{
			void function(){
				System.out.println(Outer.this.y);
			}
			new Inner().function();
		}
	}
}
public class Main{
	public static void main(String[] args){
		new Outer().method();
	}
}
/*
 1，匿名内部类就是内部类的简写格式。
 2，定义内部类的前提：
 	内部类必须是继承一个类或者实现接口

 * */
abstract class AbsDemo{
	abstract void show();
}
class Outer{
	int x =3;
/*	class Inner extends AbsDemo{
		System.out.println("method:"+x);
	}
*/
	public void function(){
//		new Inner().method();
		
		new AbsDemo(){
			void show(){
				System.out.println("x==="+x);
			}
		}.show();
	}
}
