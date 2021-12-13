package market.supers.SuperMarkets;
public class App 
{
	public static void main(String[] args) 
	{
		hotelaccess access =new hotelaccess();
		Thread t1=new Thread(access,"Manojkumar");
		Thread t2=new Thread(access,"Manikandan");
		Thread t3=new Thread(access,"Vijayasarathy");
		Thread t4=new Thread(access,"Nandhakumar");
		Thread t5=new Thread(access,"pavithra");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
	