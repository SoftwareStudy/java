/*
 �ڲ���ķ��ʹ���
 1���ڲ������ֱ�ӷ����ⲿ���еĳ�Ա������˽�г�Ա
 	֮���Կ���ֱ�ӷ����ⲿ��ĳ�Ա������Ϊ�ڲ����г�����һ���ⲿ������ã�
	��ʽ���ⲿ����.this
 2���ⲿ��Ҫ�����ڲ��࣬���뽨���ڲ������

 ���ʸ�ʽ��
1, ���ڲ��ඨ�����ⲿ��ĳ�Աλ���ϣ����ҷ�˽�У��������ⲿ�������С�
 ֱ�ӽ����ⲿ�����
 ��ʽ
 	�ⲿ����.�ڲ����� ������ = �ⲿ�����.�ڲ������
	Outer.Inner in = new Outer.new Inner();
2�����ڲ����ڳ�Աλ���ϣ��Ϳ��Ա���Ա���η������Ρ�
	���磬private�����ڲ������ⲿ���н��з�װ��
	static���ڲ���;߱��˾�̬������
	���ڲ��౻static���κ�ֻ��ֱ�ӷ����ⲿ���е�static��Ա�������˷��ʾ���
	
	���ⲿ�������У����ֱ�ӷ��ʾ�̬�ڲ���ķǾ�̬��Ա�أ�
	new Outer.Inner().function();

	���ⲿ�������У����ֱ�ӷ���static�ڲ���ľ�̬��Ա�أ�
	Outer.Inner.function();

	ע�⣺���ڲ����ж����˾�̬��Ա�����ڲ�������Ǿ�̬�ġ�
		���ⲿ���еľ�̬���������ڲ���ʱ���ڲ���Ҳ�����Ǿ�̬�ġ�

�ڲ��ඨ��ԭ��
	����������ʱ��������ڲ�����������������ڲ�����������
	��Ϊ�ڲ�������ʹ���ⲿ��������ݡ�

class Body{
	//���಻����ֱ�ӱ�¶
	private class XinZang{

	}	
	//�ṩ������¶���࣬���磬ҽ������
	public void show(){
		new XinZang();
	}

}


 * */

class Outer{
	int x = 3;
	
	/*�����ڲ���*/
	class Inner{
		int x = 4;
		void function(){
			int x = 6;
			System.out.println("inner:"+Outer.this.x); //�ڲ�������ⲿ��Ա
		}
	}
	void method(){
		System.out.println(x);
		//�����ڲ����Ա
		Inner in new Inner();
		in.function();
	}
}
public class Main{
	public static void main(String[] args){
		Outer out = new Outer();
		out.method();
		//ֱ�ӷ����ڲ����еĳ�Ա
		Outer.Inner in = new Outer.new Inner();
		in.function();
	}
}

/*���ڲ����Ǿ�̬��ʱ��*/
class Outer{
	static int x = 3;
	
	/*�����ڲ���*/
	static class Inner{
		int x = 4;
		void function(){
			int x = 6;
			System.out.println("inner:"+Outer.this.x); //�ڲ�������ⲿ��Ա
		}
	}
	void method(){
		System.out.println(x);
		//�����ڲ����Ա
		Inner in new Inner();
		in.function();
	}
}
public class Main{
	public static void main(String[] args){
		Outer out = new Outer();
		out.method();
		new Outer.Inner().function();
		//ֱ�ӷ����ڲ����еĳ�Ա
		//Outer.Inner in = new Outer.new Inner();
		//in.function();
	}
}



�����ڲ���

/*
 �ڲ��ඨ���ھֲ�ʱ��
 1�������Ա���Ա���η�����
 2������ֱ�ӷ����ⲿ���еĳ�Ա����Ϊ�������ⲿ���е����á�
 	���ǲ����Է��������ڵľֲ��еı�����ֻ�ܷ��ʱ�final���εľֲ�������

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
 1�������ڲ�������ڲ���ļ�д��ʽ��
 2�������ڲ����ǰ�᣺
 	�ڲ�������Ǽ̳�һ�������ʵ�ֽӿ�

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
