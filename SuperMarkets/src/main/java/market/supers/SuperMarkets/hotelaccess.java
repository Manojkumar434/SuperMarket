package market.supers.SuperMarkets;

import java.util.InputMismatchException;
import java.util.Scanner;

public class hotelaccess implements Runnable, pavithraaction
{
	pavithrahotel[] market=new pavithrahotel[10];
	Scanner scan=new Scanner(System.in);
	public hotelaccess()
	{
		market[0] =new pavithrahotel("SaravanaMasala","PapperPowder",36,"450G");
		market[1]=new pavithrahotel("AachiMasala","FandaPowder",90,"200G");
		market[2]=new pavithrahotel("SelvamMasala","karamasala",78,"100G");
		market[3]=new pavithrahotel("SakthiMasala","BovantoPowder",90,"200G");
		market[4]=new pavithrahotel("CaseryMasala","OrangeCasery",7800,"10KG");
		market[5]=new pavithrahotel("CaseryMasala","Red With yellow Combo Powder",9,"20G");
		market[6]=new pavithrahotel("MuttonMasala","GravyPowder",780,"1KG");
		market[7]=new pavithrahotel("FishMasala","FryPowder",900,"2KG");
		market[8]=new pavithrahotel("ChickenMasala","ChillyPowder",170,"1KG");
		market[9]=new pavithrahotel("EggMasala","Egg Rice Powder",100,"2KG");
	}
	@Override
	synchronized public void run() {
		// TODO Auto-generated method stub
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
		try
		{
		for(int index=0;index<market.length;index++)
		{
			if(market[index]==null)
			{
				market[index]=hotel;
				return hotel.getProductname()+" has added this ProductName";
			}
		}
		throw new HotelNotFoundException();
	}
		catch( HotelNotFoundException hot)
		{
			System.out.println(hot+"\n Deleted Somthing inorder to Add: ");
			for(pavithrahotel pavi:market)
			{
				System.out.println(pavi.getProductname());
			}
			deleteproductname(scan.next());
			return addnewproductname(hotel);
		}
	}

	@Override
	public void listallproductname() {
		// TODO Auto-generated method stub
		for(pavithrahotel temp:market)
		{
				try
			{
				System.out.println(temp.toString());
			}
			catch(NullPointerException np)
			{
				System.out.println(np);
				continue;
			}
		}
		
	}

	@Override
	public void deleteproductname(String typeofitem) {
		// TODO Auto-generated method stub
		try
		{
		for(int index=0;index<market.length;index++)
		{
			if(market[index]==null)
				continue;
			if(market[index].getProductname().equalsIgnoreCase(typeofitem))
			{
				market[index]=null;
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
		for(int index=0;index<market.length;index++)
			
		{
			if(market[index]==null)
				continue;
			if(market[index].getProductname().equalsIgnoreCase(productname)) 
			{
				System.out.println(market[index]);
				try
				{
				System.out.println("Tell us your Update property Name");
				String seal= scan.next();
				switch(seal)
				{
				case "productname":
					System.out.println("Tell us ProductName: ");
					String xhat=scan.next();
					market[index].setProductname(productname);
					break;
				case "typeofitem":
					System.out.println("Tell us new TypeofItem");
					String zhat= scan.next();
					market[index].setTypeofitem(zhat);
					break;
				case "quantity":
					System.out.println("Tell us new Quantity");
					String ahat=scan.next();
					market[index].setQuantity(ahat);
					break;
				case "itemrate":
					System.out.println("Tell us new ItemRate");
					int bhat=scan.nextInt();
					market[index].setItemrate(bhat);
					break;
					default:throw new HotelNotFoundException();
				}
			System.out.println(" has updated in "+productname);
			return;
				}
				catch(HotelNotFoundException | InputMismatchException forr)
				{
					Scanner scans =new Scanner(System.in);
					System.out.println(forr+" enter exact name to update details: productname,typeofitem,itemname,quantity");
					System.out.println("Tell us your UpdateName");
					String seal= scans.next();
					switch(seal)
					{
					case "productname":
						System.out.println("Tell us ProductName: ");
						String xhat=scans.next();
						market[index].setProductname(productname);
						break;
					case "typeofitem":
						System.out.println("Tell us new TypeofItem");
						String zhat= scans.next();
						market[index].setTypeofitem(zhat);
						break;
					case "quantity":
						System.out.println("Tell us new Quantity");
						String ahat=scans.next();
						market[index].setQuantity(ahat);
						break;
					case "itemrate":
						System.out.println("Tell us new ItemRate");
						int bhat=scans.nextInt();
						market[index].setItemrate(bhat);
						break;
						default:System.out.println("Maximum chance is over");
					}
				System.out.println(" has updated in "+productname);
				return;
				}
			}
		}
		throw new HotelNotFoundException();
		}
		catch(HotelNotFoundException hote)
		{
			System.out.println(hote+"\nInvalid Productname name, enter correctly");
			for(pavithrahotel h1:market)
			{
				System.out.println(h1.getProductname());
			}
			updateproductname(scan.next());
		}
		//System.out.println(name+" hasn't updated");
	}
	@Override
	public void sortproductname() 
	{
		pavithrahotel pavi=null;
		System.out.println("Based on what you wish to sort");
		String what=scan.next();
		
		for(int hold=0;hold<=market.length;hold++)
		{
			for(int com=hold+1;com<market.length;com++)
			{
				if(what.equalsIgnoreCase("Productname"))
				{
					if(market[com]==null)
						continue;
					if(market[hold].getProductname().compareTo(market[com].getProductname())>0)
					{
						pavi=market[hold];
						market[hold]=market[com];
						market[com]=pavi;					
					}
				}
				else if(what.equalsIgnoreCase("TypeofItem"))
				{
					if(market[com]==null)
						continue;
					if(market[hold].getTypeofitem().compareTo(market[com].getTypeofitem())>0)
					{
						pavi=market[hold];
						market[hold]=market[com];
						market[com]=pavi;
					}
				}
				else if(what.equalsIgnoreCase("Quantity"))
				{
					if(market[com]==null)
						continue;
					if(market[hold].getQuantity().compareToIgnoreCase(market[com].getQuantity())>=0)
					{
						pavi=market[hold];
						market[hold]=market[com];
						market[com]=pavi;
					}
				}
				else if(what.equalsIgnoreCase("ItemRate"))
				{
					if(market[com]==null)
						continue;
					if(market[hold].getItemrate()>=market[com].getItemrate())
					{
						pavi=market[hold];
						market[hold]=market[com];
						market[com]=pavi;
					}		
				}
			}
		}

	}
				
public void searchproductname(String productname,String typeofitem)
	{
	try
	{
		System.out.println("  Trying to fetch pavithrahotel matching the productname "+productname+"or typeofitem"+typeofitem);
		for(int index=0;index<market.length;index++)
		{
			if(market[index]==null)
				continue;
			if(market[index].getProductname().equalsIgnoreCase(productname)|| market[index].getTypeofitem().equalsIgnoreCase(typeofitem))
			{
				System.out.println(market[index]);
				return;
			}
		}
		throw new InputMismatchException();
	}
	catch(InputMismatchException inp)
	{

		System.out.println(inp+"\n Invaild Something ,Plese Exactly Correct productName |typeofitem");
		for(int index=0;index<market.length;index++)
		{
			if(market[index]==null)
				continue;
			if(market[index].getProductname().equalsIgnoreCase(productname)|| market[index].getTypeofitem().equalsIgnoreCase(typeofitem))
			{
				System.out.println(market[index]);
				return;
			}
		}
		searchproductname(scan.next(),scan.next());
	}
	}
	@Override
	public void searchproductname(String quantity, int itemrate) {
		// TODO Auto-generated method stub
		boolean hai=false;
		try
		{
		System.out.println(" Trying to fetch pavithrahotel matching the Quantity "+quantity+" or  Itemrate "+itemrate);
		for(int index=0;index<market.length;index++)
		{
			if(market[index]==null)
				continue;
			if(market[index].getQuantity().equalsIgnoreCase(quantity) || market[index].getItemrate()>=itemrate)
			{
				System.out.println(market[index]);
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
		searchproductname(scan.next(),scan.nextInt());
	}
	}
	
}
