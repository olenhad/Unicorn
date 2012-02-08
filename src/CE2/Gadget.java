package CE2;

//U087074M
//Chris Chak
//CS2103 Sem2 Ay11/12


public class Gadget {
	
	public String itmname;
	public int price;
	public int sat;
	public String prc;
	
	Gadget(String x, int y, int z, String w){
		this.itmname = x;
		this.price = y;
		this.sat = z;
		this.prc = w;
	}
	
	public static void gprint(Gadget g){
		System.out.print(g.itmname);
		System.out.print(" " + g.prc);
		System.out.println(" " + g.sat);
	}

}
