��̬���������Ϊ������ڵĶ���������̬��(��java����Ҫ�����ڶ�����)
	ѧ���̬����ǰ����ָ��һ�����������飬���ڿ���ָ��һ�Ѷ��������顣
������
	�ˣ����ˣ�Ů��
	���è����

è   x = new è();
���� x = new è();
/*
��Ҫ��������⣺
	1����̬�ı�����ʽ��
		���������ָ�����Լ����������
		���������Ҳ���Խ����Լ����������
	2����̬��ǰ�ᡣ
		������������֮���й�ϵ��Ҫô�̳У�Ҫôʵ�֡�
		ͨ������һ��ǰ�᣺���ں�������
	3����̬������ʲô�ô���
		��̬�ĳ��ִ�������˳������չ�ԡ�
	4����̬�ı׶ˣ�
		�������չ�ԣ�����ֻ��ʹ�ø�������÷��ʸ����еĳ�Ա��
	5����̬���Ӧ�ã�
		
	6����̬�ĳ��ִ����е��ص�(��̬ʹ�õ�ע������)
		�ڶ�̬�г�Ա�������ص㣻(�Ǿ�̬)
			�ڱ���ʱ�ڣ����������ͱ��������������Ƿ��е��õķ�����
			����У�����ͨ�������û�б���ʧ�ܡ�
			������ʱ�ڣ����Ķ��������������Ƿ��е��õķ�����
		���ܽ���ǣ���Ա�����ڶ�̬����ʱ�����뿴��ߣ����п��ұߡ�
		�ڶ�̬�г�Ա�������ص㣺
			���۱�������У����ο����(�����ͱ�����������)
		�ڶ�̬�У���̬�������ص㣺
			���۱�������У����ο����
	
*/
/*
 *������
 * 
 *���
 *è������ 
 * */
abstract class Animal{
	abstract void eat();//���ڶ���ԵĶ�����ȷ�������Զ���Ϊ���󷽷�
}

class Cat extends Animal{
	public void eat(){
		System.out.println("����");
	}
	public void catchMouse(){
		System.out.println("ץ����");
	}
}
class Dog extends Animal{
	public void eat(){
		System.out.println("�Թ�ͷ");
	}
	public void kanJia(){
		System.out.println("����");
	}
}
class Pig extends Animal{
	public void eat(){
		System.out.println("����");
	}
	public void gongDi(){
		System.out.println("����");
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
		
		Animal a = new Cat();//��������������ת��
				     //byte b =2; int x = b;(b������Ϊinteger����)
		a.eat();
		//�����Ҫ����è�����з���ʱ����β�����
		//ǿ�ƽ���������á�ת���������͡�����ת��
		Cat c = (Cat)a;//(���ǽ����������ת��������������)
		c.catchMouse();
		//ǧ��Ҫ���������Ĳ��������������ת���������͡�
		//������ת�����Ǹ���Ӧ��ָ�����Լ����������ʱ����Ӧ�ÿ��Ա�������
		//Ҳ���Ա�ǿ��ת����
		//��̬��ʼ���ն���������������ű仯��
	}
	/*��̬��Ӧ��ʵ��*/
	public static void function(Animal c){
		c.eat();
	}
}

instanceof �ؼ��֣������ж϶���������Ƿ���ھ���Ķ�������,����ֵΪ��������

���� Cat a = new Cat();
     if(a instanceof Cat){
     	System.out.println("a��Cat����");
     }

/*
 *��̬��Ӧ��ʵ��
 * */

/*
 * ������ѧ����
 * 	ѧϰ��˯����
 * �߼���ѧ��
 *      ѧϰ��˯����
 *
 *  ���Խ�������������г�ȡ��
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
		System.out.println("����˯");
	}
}
class AdvStudent extends Student{
	public void study(){
		System.out.println("adv study");
	}
}
public class Main{
	public static void main(String[] args){
		/*����û�ж�̬ʱ�ĵ�����ʽ*/
		BaseStudent bs = new BaseStudent();
		bs.study();
		bs.sleep();
		AdvStudent as = new AdvStudent();
		as.study();
		as.sleep();		
		/*�����ж�̬�Ժ�ĵ�����ʽ*/
		Dostudent ds = new Dostudent();
		ds.doSome(new BaseStudent());
		ds.doSome(new AdvStudent());
	}
	/*ָ�ӻ�����͸߼����ѧ��ȥ������,��Ȼ��װ��������
	 * ��������û�ж�̬��˼�룬���Դ����ظ���
	 * ������������˺ܴ�Ĺ�����������Ч�ʻ����ߡ� 
	 * */
	public void doSome(BaseStudent bs){
		bs.study();
		bs.sleep();		
	}
	public void doSome(AdvStudent bs){
		bs.study();
		bs.sleep();	
	}
	/*���ö�̬����ʽ�������������������ͬʱָ�ӣ�
	 * �����Ĵ��븴���ʺܸߣ����ļ����˿����ߵ�ѹ����
	 * ��Ϊһ������ĳ���Ա�����Ǳر����ܡ�
	 * */
	public void doSome(Student stu){
		stu.study();
		stu.sleep();
	}
}
/*��Ȼ����ָ��һ��ѧ�������飬��ô�β������ǵ�����װ������Ϊһ����*/
class Dostudent{
	public void doSome(Student stu){
		stu.study();
		stu.sleep();
	}	
}

/*�ܽ᣺�Զ������ͽ��г�ȡ��ͬ�Ĳ�������˶�̬�Ĳ�����
 *	����һ�������������в����������õ����࣬�Ӷ�
 *	���Ϳ����ߵ�ѹ��������Ƕ�̬��˼�롣
 * 
 * */
