package market.supers.SuperMarkets;

import java.io.IOException;

public interface pavithraaction {
	public String addnewproductname(pavithrahotel hotal);
	public void listallproductname();
	public void deleteproductname(String productname);
	public void updateproductname(String productname);
	public void searchproductname(String productname,String typeofitem) throws IOException;
	public void searchproductname(String quantity,int itemrate);
	public void sortproductname();
	
	

}
