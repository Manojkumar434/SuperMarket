package market.supers.SuperMarkets;
import java.util.Scanner;

public class App implements pavithraaction
{
	pavithrahotel[] market=new pavithrahotel[12];
	Scanner scan=new Scanner(System.in);
	public App()
	{
		market[0] =new pavithrahotel("saravanaMasala","papper powder",36,"450G");
		market[1]=new pavithrahotel("aachiMasala","z powder",90,"200G");
		market[2]=new pavithrahotel("selvamMasala","karamasala",78,"100G");
		market[3]=new pavithrahotel("sakthiMasala","z powder",90,"200G");
		market[4]=new pavithrahotel("caseryMasala","orange casery",7800,"10KG");
		market[5]=new pavithrahotel("caseryMasala","  red with yellow combo powder",9,"20G");
		market[6]=new pavithrahotel("muttonMasala","gravy powder",780,"1KG");
		market[7]=new pavithrahotel("fishMasala","fry powder",900,"2KG");
		market[8]=new pavithrahotel("chickenMasala","chillypowder",780,"1KG");
		market[9]=new pavithrahotel("eggMasala","egg rice powder",100,"2KG");
	}
	public static void main(String[] args)
	{
		pavithrahotel f1=new pavithrahotel(); 
		f1.setProductname("nandhi product");
		f1.setTypeofitem("ulunthu");
		f1.setQuantity("1KG");
		f1.setItemrate(126);
		App store =new App();
		/*
		 * store.deleteproductname("aasai masala"); 
		 * store.listallproductname();
		 */
//		store.updateproductname("saravana masala");
		/* store.searchproductname("fish masala"); */
		/*
		 * store.deleteproductname("aasai masala");
		 *  store.sortproductname();
		 */do
		 {
			 System.out.println("MENU\nCHOOSE TO YOUR WISH\n1.new productname\n2.listall\n3.update\n4.sort\n5.delete\n6.search\n7.exit");
			 String MENU=store.scan.next();
			 switch(MENU)
			 {
			 case "1":
				 System.out.println("create a new productname with mandate detailks productname,typeofitem,itemrate,quantity");
				 pavithrahotel hotel=new pavithrahotel(store.scan.next(),store.scan.next(),store.scan.nextInt(),store.scan.next());
				 System.out.println(store.addnewproductname(hotel));
				 break;
			 case "2":
				 System.out.println("listing all productnames");
				 store.listallproductname();
				 break;
			 case "3":
				 System.out.println("update productname by productname");
				 String productname=store.scan.next(); 
				 store.updateproductname("chicken masala");
				 break;
			 case "4":
				 System.out.println("sortproductname");
				 store.sortproductname();
				 break;
			 case "5":
				 System.out.println("deleted this prouctname");
				 String typeofitem=store.scan.next();
				 store.deleteproductname(typeofitem);
				 break;
			 case "6":
				 System.out.println("search based on productname or typeofitem or itemrate or quantity");
				 String what=store.scan.next();
				 switch(what)
				 {
				 case "product":
					 System.out.println("tell us productname");
					 store.searchproductname(store.scan.next());
					 break;
				 case "itemrate":
					 System.out.println("tell us quantity and itemrate");
					 store.searchproductname(store.scan.next(),store.scan.nextInt());
					 break;
				 default:System.out.println("Nothing to search");
				 }
				 break;
				 default:return;
			 }
			 
		 }while(true);

		}
	

	@Override
	public String addnewproductname(pavithrahotel hotel) {
		// TODO Auto-generated method stub
		for(int index=0;index<market.length;index++)
		{
			if(market[index]==null)
			{
				market[index]=hotel;
				return hotel.getProductname()+" has added this product name";
			}
		}
		return hotel.getProductname()+" hasn't added";
		
	}

	@Override
	public void listallproductname() {
		// TODO Auto-generated method stub
		for(pavithrahotel temp:market)
		{
			if(temp!=null)
				System.out.println(temp);
		}
		
	}

	@Override
	public void deleteproductname(String typeofitem) {
		// TODO Auto-generated method stub
		
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
		System.out.println(typeofitem+ "hasn't found anywhere");
		
	}
	@Override
	public void updateproductname(String productname) {
		// TODO Auto-generated method stub
		for(int index=0;index<market.length;index++)
		{
			if(market[index]==null)
				continue;
			if(market[index].getProductname().equalsIgnoreCase(productname)) 
			{
				System.out.println(market[index]);
				System.out.println("tell us your update name");
				String seal= scan.next();
				switch(seal)
				{
				case "productname":
					System.out.println("Tell us product  name: ");
					String xhat=scan.next();
					market[index].setProductname(productname);
					break;
				case "typeofitem":
					System.out.println("tell us new item name");
					String zhat= scan.next();
					market[index].setTypeofitem(zhat);
					break;
				case "quantity":
					System.out.println("tell us exchange quantity");
					String ahat=scan.next();
					market[index].setQuantity(ahat);
					break;
				case "itemrate":
					System.out.println("tell us item rate yearly once changed the all item rate");
					int bhat=scan.nextInt();
					market[index].setItemrate(bhat);
					break;
				}
			System.out.println(" has updated in "+productname);
			return;
			}
		}
		System.out.println(productname +"hasn't updated");
	}
	@Override
	public void sortproductname() {
		// TODO Auto-generated method stub
		pavithrahotel pavi=null;
		System.out.println("Based on what you wish to sort");
		String what=scan.next();
		
		for(int hold=0;hold<=market.length;hold++)
		{
			for(int com=hold+1;com<market.length;com++)
			{
				if(what.equalsIgnoreCase("productname"))
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
				else if(what.equalsIgnoreCase("typeofitem"))
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
				else if(what.equalsIgnoreCase("quantity"))
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
				else if(what.equalsIgnoreCase("itemrate"))
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
	@Override
	public void searchproductname(String productname )
	{
		// TODO Auto-generated method stub
		System.out.println(" Matching the Productname "+productname);
		for(int index=0;index<market.length;index++)
		{
			if(market[index]==null)
				continue;
			if(market[index].getProductname().equalsIgnoreCase(productname))
			{
				System.out.println(market[index]);
				return;
			}
		}
		System.out.println(productname+" This productname hasn't found anyhwere");
	}
	@Override
	public void searchproductname(String quantity, int itemrate) {
		// TODO Auto-generated method stub
		System.out.println(" Matching the Quantity "+quantity+" or  Itemrate "+itemrate);
		// TODO Auto-generated method stub
		for(int index=0;index<market.length;index++)
		{
			if(market[index]==null)
				continue;
			if(market[index].getQuantity().equalsIgnoreCase(quantity) || market[index].getItemrate()<=itemrate)
			{
				System.out.println(market[index]);
				return;
			}
		}
		System.out.println(quantity+"hasn't matching anywhere"+itemrate);
	
	}
}