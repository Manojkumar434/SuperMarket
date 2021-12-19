package market.supers.SuperMarkets;

import java.util.InputMismatchException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class hotelaccess implements Runnable, pavithraaction
{
	File file=new File("D:\\Education Content-2\\Career Guidance\\Files\\My first console application.doc");
	FileOutputStream fos=null;   	ObjectOutputStream oos=null;
	FileInputStream fis=null;  		ObjectInputStream ois=null;
	ArrayList<pavithrahotel>market=null;
	Scanner scan=new Scanner(System.in);
	
	public void affection() throws IOException
	{
		fos=new FileOutputStream(file); 
		oos=new ObjectOutputStream(fos); 
		oos.writeObject(market); // current list updated
		oos.close();
		fos.close();
	}

	public void fetch() throws IOException, ClassNotFoundException
	{
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		market = (ArrayList<pavithrahotel>)ois.readObject();// read existing list from file
		ois.close();
		fis.close();
	}
	public hotelaccess()
	{
		/*
		 * market.add(new pavithrahotel("SaravanaMasala","PapperPowder",36,"450G"));
		 * market.add(new pavithrahotel("AachiMasala","FandaPowder",90,"200G"));
		 * market.add(new pavithrahotel("SelvamMasala","karamasala",78,"100G"));
		 * market.add(new pavithrahotel("SakthiMasala","BovantoPowder",90,"200G"));
		 * market.add(new pavithrahotel("CaseryMasala","OrangeCasery",7800,"10KG"));
		 * market.add(new
		 * pavithrahotel("CaseryMasala","Red With yellow Combo Powder",9,"20G"));
		 * market.add(new pavithrahotel("MuttonMasala","GravyPowder",780,"1KG"));
		 * market.add(new pavithrahotel("FishMasala","FryPowder",900,"2KG"));
		 * market.add(new pavithrahotel("ChickenMasala","ChillyPowder",170,"1KG"));
		 * market.add(new pavithrahotel("EggMasala","Egg Rice Powder",100,"2KG")); try {
		 * fos=new FileOutputStream(file); oos=new ObjectOutputStream(fos);
		 * oos.writeObject(market); oos.close(); fos.close(); } catch(IOException io) {
		 * 
		 * }
		 */
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
				 System.out.println("Create a NewProductname with mandate details ProductName,Typeofitem,Itemrate,Quantity");
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
				 System.out.println("Search based on productname or typeofitem & quantity or itemrate");
				 String what=scan.next();
				 switch(what)
				 {
				 case "productname": case "typeofitem":
					 System.out.println("Tell us productname and typeofitem");
					 //String productname1=store.scan.next();
					 searchproductname(scan.next(),scan.next());
					 break;
				 case "quantity": case "itemrate":
					 try
					 {
					 System.out.println("Tell us quantity and itemRate");
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
		try
		{
			fetch();
			market.add(hotel);
			affection();
		}
		catch(IOException e) {} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotel.getProductname()+" has added";
	}

	@Override
	public void listallproductname() {
		try
		{
			fetch();
			Iterator<pavithrahotel> it=market.iterator();
			while(it.hasNext())
			{
				System.out.println(it.next());
			}
		}
		catch(IOException | ClassNotFoundException e) {}
	}

	@Override
	public void deleteproductname(String productname) {
		try
		{		
			fetch();
			for(int index=0;index<market.size();index++)
			{
				if(market.get(index).getProductname ().equalsIgnoreCase(productname))
				{
					market.remove(market.get(index));
					System.out.println(productname+("This is deleted successfully"));
					affection();
					
					return;
				}
			}
			throw new HotelNotFoundException();
		}
		catch (HotelNotFoundException hotty)
		{
			{
				System.out.println(hotty+"\nInvalid Pavithrahotel name, Enter exact name to delete");
				for(pavithrahotel h:market)
				{
					System.out.println(h.getProductname());
				}
				deleteproductname(scan.next());
			}
		}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	@Override
	public void updateproductname(String productname) 
	{
		try
		{
			fetch();
			for(int index=0;index<market.size();index++)
			{
				if(market.get(index).getProductname().equalsIgnoreCase(productname))
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
					case "typeofitem":
						System.out.println("Tell us whats new typeofitem name for"+productname);
						market.get(index).setTypeofitem(scan.next());
						System.out.println((productname+"Type of item has updates as")+market.get(index).getTypeofitem());
						return;
					case "itemrate":
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
			System.out.println(exe+"\n keyword to update not matched select any below: \n productname,typeofitem,itemrate,quantity");
			System.out.println("keyword/ refernce to update should be  productname,typeofite,m,itemrate,quantity" );
			for(pavithrahotel f:market)
			{
			System.out.println(f.getProductname());
			}
			updateproductname(scan.next());
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public void searchproductname(String productname,String typeofitem)
	{
	boolean hai=false;
	try
	{
		System.out.println("  Matching the productname "+productname+" or typeofitem"+typeofitem);
		fetch();
		for(pavithrahotel cute:market)
		{
			if(cute.getProductname().equalsIgnoreCase(productname)|| cute.getTypeofitem().equalsIgnoreCase(typeofitem))
			{
				System.out.println(cute); 
				return;
			}
		}
		if(hai!=true)
		throw new HotelNotFoundException();
	}
	catch(HotelNotFoundException inp)
	{

		System.out.println(inp+"\n Invaild Something ,Plese Exactly Correct productName |typeofitem");
		listallproductname();
		searchproductname(scan.next(),scan.next());
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	@Override
	public void searchproductname(String quantity, int itemrate) 
	{
		boolean hai=false;
		try
		{
		System.out.println("searching based on quantity or itemrate: "+quantity+"  and "+itemrate);
		fetch();
		for(pavithrahotel sweet:market)
		{
			if(sweet.getQuantity().equalsIgnoreCase(quantity) || sweet.getItemrate()>=itemrate)
			{
				System.out.println(sweet);
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
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void sortproductname() 
	{
		try 
	{
		fetch();
		Collections.sort(market);
		affection();
	}
	catch(IOException | ClassNotFoundException io)
	{
		
	}
		
	}
	
}
