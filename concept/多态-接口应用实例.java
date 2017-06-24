/*
 *需求：
 *电脑运行实例，
 *电脑运行基于主板
 *
 * */
//存在于主板上的PCI接口
interface PCI{
	public void open();
	public void close();
}
class MainBoard{
	public void run(){
		System.out.println("mainboard run");//主板运行
	}
	public void usePCI(PCI p){//使用接口上的东西
		//PCI p = new NetCard() //接口型引用指向自己的子类对象
		if(p != null){
			p.open();
			p.close();
		}	
	}
}
//生产的网卡要符合PCI的规则
class NetCard implements PCI{
	//启动网卡
	public void open(){
		System.out.println("netcard open");
	}
	//关闭网卡
	public void close(){
		System.out.println("nercard close");
	}
}
//生产的声卡要符合PCI的规则
class SoundCard implements PCI{
	//启动声卡
	public void open(){
		System.out.println("sondcard open");
	}
	//关闭声卡
	public void close(){
		Sysetm.out.println("soundcard close");
	}
}
public class Main{
	public static void main(String[] args){
		MainBoard mb = new MainBoard();
		mb.run();			//启动主板
		mb.usePCI(null);		//接口处没有东西
		mb.usePCI(new NetCard());	//在接口处插入网卡
		mb.usePCI(new SoundCard());	//在接口处插入声卡
	}
}
