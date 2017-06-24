/*
 *����
 *��������ʵ����
 *�������л�������
 *
 * */
//�����������ϵ�PCI�ӿ�
interface PCI{
	public void open();
	public void close();
}
class MainBoard{
	public void run(){
		System.out.println("mainboard run");//��������
	}
	public void usePCI(PCI p){//ʹ�ýӿ��ϵĶ���
		//PCI p = new NetCard() //�ӿ�������ָ���Լ����������
		if(p != null){
			p.open();
			p.close();
		}	
	}
}
//����������Ҫ����PCI�Ĺ���
class NetCard implements PCI{
	//��������
	public void open(){
		System.out.println("netcard open");
	}
	//�ر�����
	public void close(){
		System.out.println("nercard close");
	}
}
//����������Ҫ����PCI�Ĺ���
class SoundCard implements PCI{
	//��������
	public void open(){
		System.out.println("sondcard open");
	}
	//�ر�����
	public void close(){
		Sysetm.out.println("soundcard close");
	}
}
public class Main{
	public static void main(String[] args){
		MainBoard mb = new MainBoard();
		mb.run();			//��������
		mb.usePCI(null);		//�ӿڴ�û�ж���
		mb.usePCI(new NetCard());	//�ڽӿڴ���������
		mb.usePCI(new SoundCard());	//�ڽӿڴ���������
	}
}
