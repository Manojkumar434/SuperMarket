package market.supers.SuperMarkets;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

public class hotelaccess implements Runnable, pavithraaction
{
	ArrayList<pavithrahotel>market=new ArrayList<pavithrahotel>();
	Scanner scan=new Scanner(System.in);
	public hotelaccess()
	{
		market.add(new pavithrahotel("SaravanaMasala","PapperPowder",36,"450G"));
		market.add(new pavithrahotel("AachiMasala","FandaPowder",90,"200G"));
		market.add(new pavithrahotel("SelvamMasala","karamasala",78,"100G"));
		market.add(new pavithrahotel("SakthiMasala","BovantoPowder",90,"200G"));
		market.add(new pavithrahotel("CaseryMasala","OrangeCasery",7800,"10KG"));
		market.add(new pavithrahotel("CaseryMasala","Red With yellow Combo Powder",9,"20G"));
		market.add(new pavithrahotel("MuttonMasala","GravyPowder",780,"1KG"));
		market.add(new pavithrahotel("FishMasala","FryPowder",900,"2KG"));
		market.add(new pavithrahotel("ChickenMasala","ChillyPowder",170,"1KG"));
		market.add(new pavithrahotel("EggMasala","Egg Rice Powder",100,"2KG"));
	}
	@Override
	synchronized public void run() {
		System.out.println("Welcome "+Thread.currentThread().getName()+" to hotelaccess Control");
		do
		 {
			 System.out.println("MENU \nCHOOSE TO YOUR WISH\n 1.AddProductname\n 2.ListAll\n 3.Update\n 4.Sort\n 5.Delete\n 6.Search\n 7.Exit");
			 String MENU=scan.next();
			 switch(MENU)
			 {
			 case "1":
				 try 
				 {
				 System.out.println("Create a NewProductname with mandate details ProductName,TypeOfItem,ItemRate,Quantity");
				 pavithrahotel hotel=new pavithrahotel(scan.next(),scan.next(),scan.nextInt(),scan.next());
				 System.out.print(addnewproductname(hotel));
				 break;
				 }
				 catch(InputMismatchException exe)
				 {
					 System.out.println(exe+"plese exactly correct details is productname,typeofitem,itemrate,quantity");
					 pavithrahotel hotel=new pavithrahotel(scan.next(),scan.next(),scan.nextInt(),scan.next());
					 System.out.print(addnewproductname(hotel));
				 }
			 case "2":
				 System.out.println("Listing All ProductNames");
				 listallproductname();
				 break;
			 case "3":
				 System.out.println("Update ProductName:");
				 String productname=scan.next(); 
				 updateproductname(productname);
				 break;
			 case "4":
				 System.out.println("SORTING based on Productname or typeofitem & itemrate or quantity ");
				 sortproductname();
				 listallproductname();
				 break;
			 case "5":
				 try
				 {
				 System.out.println("Deleted This typeofitem");
				 String typeofitem=scan.next();
				 deleteproductname(typeofitem);
				 break;
				 }
				 catch(NullPointerException nul)
				 {
					 System.out.println("This name is wrong,plese Exactly correct productname");
					 String typeofitem=scan.next();
					 deleteproductname(typeofitem);
				 }
			 case "6":
				 System.out.println("Search based on Productname or TypeofItem & Quantity or ItemRate");
				 String what=scan.next();
				 switch(what)
				 {
				 case "productname":
					 System.out.println("Tell us ProductName and Typeofitem");
					 //String productname1=store.scan.next();
					 searchproductname(scan.next(),scan.next());
					 break;
				 case "quantity":
					 try
					 {
					 System.out.println("Tell us Quantity and ItemRate");
					 searchproductname(scan.next(),scan.nextInt());
					 }
					 catch(InputMismatchException miss)
					 {
						 System.out.println(miss+" Invaild Something,Exactly Correct Name of Quantity and Itemrate");
						 searchproductname(scan.next(),scan.nextInt());
						 searchproductname(scan.next(),scan.nextInt());
						 break;
					 }
			 }
				 break;
			 default:return;
			 }
		 }while(true);
}
	
	@Override
	public String addnewproductname(pavithrahotel hotel) 
	{
		// TODO Auto-generated method stub
		market.add(hotel);
		return hotel.getProductname()+"Has Added";
	}

	@Override
	public void listallproductname() {
		// TODO Auto-generated method stub
		Iterator<pavithrahotel>user=market.iterator();
		while(user.hasNext())
		{
			System.out.println(user.next());
		}
	}

	@Override
	public void deleteproductname(String typeofitem) {
		// TODO Auto-generated method stub
		List<pavithrahotel>tmp=new Vector<pavithrahotel>();
		tmp.addAll(market);
		try
		{
		for(int index=0;index<market.size();index++)
		{
			if(tmp.get(index).getProductname().equalsIgnoreCase(typeofitem))
			{
				market.remove(tmp.get(index));
				System.out.println(typeofitem+"is deleted successfully");
				return;
			}
		}
		throw new HotelNotFoundException();
	}
		catch(HotelNotFoundException hn)
		{
			System.out.println(hn+"\n Invaild ProductName ,Plese Exactly Correct productName");
			for(pavithrahotel pavit:market)
			{
				System.out.println(pavit.getProductname());
			}
		}
		deleteproductname(scan.next());
		}

	@Override
	public void updateproductname(String productname) 
	{
		try
		{
		for(int index=0;index<market.size();index++)
		{
			if(market.get(index).getProductname().equalsIgnoreCase(productname));
			{
				System.out.println("Tell us what to update: ");
				String what=scan.next();
				switch(what)
				{
				case "productname":
					System.out.println("Tell us whats new Product name for "+productname);
					market.get(index).setProductname(scan.next());
					System.out.println(productname+" Product name has updated as "+market.get(index).getProductname());
					return;
				case "Typeofitem":
					System.out.println("Tell us whats new typeofitem name for"+productname);
					market.get(index).setTypeofitem(scan.next());
					System.out.println((productname+"Type of item has updates as"+market.get(index).getTypeofitem()));
					return;
				case "Itemrate":
					System.out.println("Tell us whats new itemrate for"+productname);
					market.get(index).setItemrate(scan.nextInt());
					System.out.println(productname+"Itemrate has updates as"+market.get(index).getItemrate());
					return;
				case "quantity":
					System.out.println("Tell us whats new quantity for" +productname);
					market.get(index).setQuantity(scan.next());
					System.out.println(productname+"Quantity has updated as"+market.get(index).getQuantity());
					return;
					default:throw new HotelNotFoundException();
					}
			}
		}
	}
		catch(HotelNotFoundException exe)
		{
			System.out.println(exe+"\n keyword to update not matched select any below:");
			for(pavithrahotel f:market)
			{
			System.out.println(f.getProductname ());
			}
			updateproductname(productname);
		}
	}
public void searchproductname(String productname,String typeofitem)
	{
	try
	{
		System.out.println("  Trying to fetch pavithrahotel matching the productname "+productname+"or typeofitem"+typeofitem);
		for(int index=0;index<market.size();index++)
		{

			if(market.get(index).getProductname().equalsIgnoreCase(productname)|| market.get(index).getTypeofitem().equalsIgnoreCase(typeofitem))
			{
				System.out.println(market.get(index));
				return;
			}
		}
		throw new InputMismatchException();
	}
	catch(InputMismatchException inp)
	{

		System.out.println(inp+"\n Invaild Something ,Plese Exactly Correct productName |typeofitem");
		listallproductname();
		for(int index=0;index<market.size();index++)
		{
			if(market.get(index).getProductname().equalsIgnoreCase(productname)|| market.get(index).getTypeofitem().equalsIgnoreCase(typeofitem))
			{
				System.out.println(market.get(index));
				return;
			}
		}
		searchproductname(scan.next(),scan.next());
	}
	}
	@Override
	public void searchproductname(String quantity, int itemrate) 
	{
		boolean hai=false;
		try
		{
		System.out.println(" Trying to fetch pavithrahotel matching the Quantity "+quantity+" or  Itemrate "+itemrate);
		for(int index=0;index<market.size();index++)
		{
			if(market.get(index).getQuantity().equalsIgnoreCase(quantity) || market.get(index).getItemrate()>=itemrate)
			{
				System.out.println(market.get(index));
				//return;
				hai=true;
			}
		}
		if(hai==false)
			throw new HotelNotFoundException(); 
	}
	catch(HotelNotFoundException inpu)
	{
		System.out.println(inpu+" Invaild Something ,Plese Exactly Correct quantity |itemrate");
		listallproductname();
		searchproductname(scan.next(),scan.nextInt());
	}
	}
	@Override
	public void sortproductname() 
	{  	

		Collections.sort(market);
		
	}
	
}
