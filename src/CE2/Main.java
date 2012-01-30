package CE2;


import java.util.LinkedList;
import java.util.List;
import java.util.Collections;


public class Main {
	public List<Gadget> slst;
	public int budget;
	public String[] Algo1Res;
	public String[] Algo2Res;
	public String[] Algo3Res;
        public boolean Algo1Done=false;
        public boolean Algo2Done=false;
        public boolean Algo3Done=false;
	public String Algo1Time; 
	public String Algo2Time;
	public String Algo3Time;
	
	
		
	public void run(String[] items, double budgt, String selection){
		//Main pba = new Main();
		this.slst = new LinkedList<Gadget>();
		budgt *= 100;
		this.budget = (int) budgt;
		this.takeFromGUI(items);
		this.selector(selection);
	}
	
	
	/*Pre-Processing methods*/
	public void takeFromGUI(String[] items){
                CharSequence dot = ".";
                int xprice;	
			
		for(int i = 0 ; i<items.length ; i++){
                    String[] args = items[i].split("\\s");
                        if(args[1].contains(dot)){
                            String[] price = args[1].split("\\.");
                             xprice = 100 * toInt(price[0]) + toInt(price[1]);
                        }
                        else
                        {
                             xprice = 100*toInt(args[1]);
                        }


			String xname = args[0];
			
			int xsat = toInt(args[2]);
			String xprc = args[1];
			
			Gadget g = new Gadget(xname, xprice,xsat,xprc);
			
			this.addd(g);
			this.extirpate();
		}
	}

	public void addd(Gadget x){
		int i = 0;
		if(this.slst.isEmpty()){
			this.slst.add(x);
		}else{
			while(x.sat < this.slst.get(i).sat){
				if(i + 1 == this.slst.size()){
					break;
				}else{
					i++;
				}
			}

			while(x.sat == this.slst.get(i).sat		&&		x.price > this.slst.get(i).price){
				if(i + 1 == this.slst.size()){
					break;
				}else{
					i++;
				}
			}

			if(i >=  this.slst.size()){
				System.out.println("ERROR");
			}else{
				this.slst.add(i+1,x);
			}

		}
	}

	private void printslist(){
		for(int i = 0 ; i < this.slst.size() ; i++){
			System.out.print(this.slst.get(i).itmname + " ");
			System.out.print(this.slst.get(i).price + "  ");
			System.out.print(this.slst.get(i).prc + "  ");
			System.out.println(this.slst.get(i).sat + " ");
		}
	}

	public void extirpate(){
		for(int i=0 ; i<this.slst.size() ; i++){
			if(this.slst.get(i).price > this.budget){
				this.slst.remove(i);
				i--;
			}
		}
	}
	/*Pre-Processing methods*/
	
	
	/*DP methods*/
	private String[] dptables(){
		int budget = this.budget;
		int[][] memo = new int[this.slst.size() + 1][budget+1];
		String[][] items = new String[this.slst.size() + 1][budget+1];

		for(int i = 0 ; i<=this.slst.size() ; i++){
			for(int j = 0 ; j<=budget ; j++){
				items[i][j] = "";
			}
		}

		for(int i = 1 ; i<=this.slst.size() ; i++){
			for(int j = 1 ; j<=budget ; j++){
				this.compute(i, j, memo, items);
			}
		}

		String[] answer = new String[2];
		answer[0] = memo[this.slst.size()][budget] + "";
		answer[1] = items[this.slst.size()][budget];
		this.Algo1Res = answer;
                Algo1Done=true;
		return answer;
	}
	
	private void compute(int nth, int weight, int[][] sat, String[][] items){
		int nprice = this.slst.get(nth-1).price;
		int nsat = this.slst.get(nth-1).sat;


		if(nprice > weight){ //don't take the nth item
			items[nth][weight] = items[nth-1][weight];
			sat[nth][weight] = sat[nth-1][weight];
		}


		else if(sat[nth-1][weight - nprice] + nsat > sat[nth-1][weight]){ //take the nth item

			if(items[nth-1][weight - nprice].contains("+")){
				items[nth][weight] = appendAll(items[nth-1][weight - nprice], toString(nth-1));
			}else{
				items[nth][weight] = items[nth-1][weight - nprice] + "," + toString(nth-1);
			}

			sat[nth][weight] = sat[nth-1][weight - nprice] + nsat;
		}

		else if(sat[nth-1][weight - nprice] + nsat == sat[nth-1][weight]){ //take both items

			String temp;
			if(items[nth-1][weight - nprice].contains("+")){
				temp = appendAll(items[nth-1][weight - nprice], toString(nth-1));
			}else{
				temp = items[nth-1][weight - nprice] + "," + toString(nth-1);
			}
			items[nth][weight] = items[nth-1][weight] + "+" + temp;



			sat[nth][weight] = sat[nth-1][weight - nprice] + nsat;
		}

		else{// don't take the nth item
			items[nth][weight] = items[nth-1][weight];
			sat[nth][weight] = sat[nth-1][weight];
		}


	}
	/*DP methods*/
	
	
	/*Pure Recursion*/
	private String[] precursion(){
		int i = this.slst.size() + 1;
		int weight = this.budget + 1;
		String[] ans = this.recursion(i-1, weight-1);
		this.Algo3Res = ans;
                Algo3Done= true;
		return ans;
	}
	
	private String[] recursion(int i, int weight){
		if(i==0 || weight==0){
			String[] args = new String[2];
			args[0] = toString(0);
			args[1] = "";
			return args;
		}



		else if(this.slst.get(i-1).price > weight){
			String[] args = new String[2];
			String[] holding = new String[2];
			holding = this.recursion(i-1, weight);
			args[0] = holding[0];
			args[1] = holding[1];
			return args;
		}



		else if(toInt(this.recursion(i-1, weight)[0]) > toInt(this.recursion(i-1, weight-this.slst.get(i-1).price)[0]) + this.slst.get(i-1).sat){
			String[] args = new String[2];
			String[] holding = new String[2];
			holding = this.recursion(i-1, weight);
			args[0] = holding[0];
			args[1] = holding[1];
			return args;
		}


		else if(toInt(this.recursion(i-1, weight)[0]) == toInt(this.recursion(i-1, weight-this.slst.get(i-1).price)[0]) + this.slst.get(i-1).sat){
			String[] args = new String[2];
			String[] holding = new String[2];
			holding = this.recursion(i-1, weight-this.slst.get(i-1).price);
			args[0] = toString(toInt(holding[0]) +  this.slst.get(i-1).sat);
			String temp = "";
			if(holding[1].contains("+")){
				temp = appendAll(holding[1], toString(i-1)); 
			}else{
				temp = holding[1] + "," + toString(i-1);
			}
			args[1] = this.recursion(i-1, weight)[1] + "+" + temp;
			return args;			
		}



		else{
			String[] args = new String[2];
			String[] holding = new String[2];
			holding = this.recursion(i-1, weight-this.slst.get(i-1).price);
			args[0] = toString(toInt(holding[0]) + this.slst.get(i-1).sat);
			if (holding[1].contains("+")){
				args[1] = appendAll(holding[1], toString(i-1));
			}else{
				args[1] = holding[1] + "," + toString(i-1);
			}

			return args;
		}



	}
	/*Pure Recursion*/
	
	
	/*bruteforce methods*/
	private static int[] toBit(int x, int y){
		int[] bitVector = new int[y];
		if(x==0){
			return bitVector;
		}else{

			Double doub;
			Integer xx = new Integer(x);
			doub = Math.log(xx) / Math.log(2);
			doub = Math.floor(doub);
			int i = bitVector.length-1;

			while(x >= 2){			
				bitVector[i] = (x % 2);
				x = x/2;
				i--;
			}
			bitVector[i] = x;
			return bitVector;
		}

	}

	private String[] powerset(){
		int budget = this.budget;
		int noOfItems = this.slst.size();
		Double doub = Math.pow(2,noOfItems);
		int maxsat = 0;
		List<int[]> subsets = new LinkedList<int[]>();


		for(int i=0 ; i< doub.intValue(); i++){
			int[] selection = toBit(i,noOfItems);

			if(this.calcprice(selection) <= budget){
				int[] x = new int[2];
				x[0] = i;
				x[1] = this.calcsat(selection);
				if(x[1] >= maxsat){
					subsets.add(x);
					maxsat = x[1];
				}
			}
		}

		for(int i=0 ; i<subsets.size(); i++){
			if(subsets.get(i)[1] < maxsat){
				subsets.remove(i);
				i--;
			}
		}


		String temp = "";
		for(int i=0 ; i<subsets.size()-1; i++){
			for(int j=0 ; j<noOfItems ; j++){
				if(toBit(subsets.get(i)[0], noOfItems)[j] == 1){
					temp += "," + toString(j);
				}
			}
			temp += "+";
		}
		for(int j=0 ; j<noOfItems ; j++){
			if(toBit(subsets.get(subsets.size()-1)[0], noOfItems)[j] == 1){
				temp += "," + toString(j);
			}
		}


		String[] answer = new String[2];
		answer[0] = toString(maxsat);
		answer[1] = temp;
		
		this.Algo2Res = answer;
                Algo2Done=true;
		return answer;

	}

	private int calcsat(int[] selection){
		int sat=0;
		for(int i=0 ; i<selection.length ; i++){
			if(selection[i] == 1){
				sat += this.slst.get(i).sat;
			}
		}
		return sat;
	}

	private int calcprice(int[] selection){
		int price=0;
		for(int i=0 ; i<selection.length ; i++){
			if(selection[i] == 1){
				price += this.slst.get(i).price;
			}
		}
		return price;
	}
	/*bruteforce methods*/
	
	
	/*Timing methods*/
	public long time(int algo){
		long start = 0;
		long end = 0;

		
		switch(algo){
		case 1: {start = System.nanoTime(); this.dptables(); end = System.nanoTime(); break;}
		case 2: {start = System.nanoTime(); this.powerset(); end = System.nanoTime(); break;}
		case 3: {start = System.nanoTime(); this.precursion(); end = System.nanoTime(); break;}
		default: System.out.println("ERROR");		
		}
		final long duration = end-start;
		switch(algo){
		case 1: {this.Algo1Time = formatime(duration); break;}
		case 2: {this.Algo2Time = formatime(duration); break;}
		case 3: {this.Algo3Time = formatime(duration); break;}
		}
		return duration;
	}
	/*Timing methods*/
	
	
	
	
	
	
	/*Misc methods*/
	private static int toInt(String x){
		return Integer.parseInt(x);
	}

	private static String toString(int x){
		return Integer.toString(x);
	}

	private static String toString(long x){
		Long l = x;
		return l.toString();
	}

	private static String appendAll(String x, String y){
		String result = "";
		String[] options = x.split("\\+");
		for(int i=0 ; i<options.length-1 ; i++){
			result += options[i] + "," + y + "+";
		}
		result += options[options.length-1];
		return result;
	}

	private String answerToGUI(String s, String sat){
		int spent = 0;
		String[] itemlist = s.split(",");

		String result = "";
		
		
		
		result += "Buy:";
		result += "\n";
		for(int i=1 ; i<itemlist.length ; i++){
			result += this.slst.get(toInt(itemlist[i])).itmname;
			result += " for ";
			result += this.slst.get(toInt(itemlist[i])).prc;
			result += "\n";
		}


		result += "Satisfaction:";
		result += "\n";
		result += sat;
		result += "\n";


		result += "Spent:";
		result += "\n";
		for(int i=1 ; i<itemlist.length ; i++){
			spent += this.slst.get(toInt(itemlist[i])).price;
		}

		int spent1 = spent / 100;
		int spent2 = spent % 100;

		if(spent2 >= 10){
			result += spent1 + "." + spent2;
		}else if(spent2 == 0){
			result += spent1 + ".00";
		}else{
			result += spent1 + ".0" + spent2;
		}
		result += "\n";
		return result;

	}
	
	public static int option(String s){
		if(s.equals("111")){
			return 7;
		}else if(s.equals("110")){
			return 6;
		}else if(s.equals("101")){
			return 5;
		}else if(s.equals("100")){
			return 4;
		}else if(s.equals("011")){
			return 3;
		}else if(s.equals("010")){
			return 2;
		}else if(s.equals("001")){
			return 1;
		}else{
			return -99;
		}
	}
	
	public void selector(String s){
		int n = option(s);
		
		switch (n) {
			case 1: {this.time(3); break;}
			case 2: {this.time(2); break;}
			case 3: {this.time(2); this.time(3); break;}
			case 4: {this.time(1); break;}
			case 5: {this.time(1); this.time(3); break;}
			case 6: {this.time(1); this.time(2); break;}
			case 7: {this.time(1); this.time(2); this.time(3); break;}
			default: {break;}
		}
			
		
	}
	
	public static boolean listequal(String s1, String s2){
		String[] place1 = s1.split("+");
		String[] place2 = s2.split("+");
		return place1 == place2;
		
	}

	public static String formatime(long time){
		String returrn = "";
		
		if(toString(time).length() <= 9){
			returrn = "0." + toString(time);
		}else{
			char[] old = toString(time).toCharArray();
			char[] data = new char[old.length+1];
			int pointer = old.length;
			for(int i=0 ; i< pointer-9 ; i++){
				data[i]=old[i];
			}		
			data[pointer-9] = ".".charAt(0);
			for(int i = pointer-9 ; i<pointer ; i++){
				data[i+1] = old[i];
			}
			String s = new String(data);
			returrn = s;
		}
		return returrn;
	}

        private String printans(String s, String sat){
		
		int spent = 0;
		String[] itemlist = s.split(",");
		String reeturn = ""; 
		
		
		reeturn += "Buy:";
		reeturn += "\n";
		for(int i=1 ; i<itemlist.length ; i++){
			reeturn += (this.slst.get(toInt(itemlist[i])).itmname);
			reeturn += (" for ");
			reeturn += (this.slst.get(toInt(itemlist[i])).prc);
			reeturn += "\n"; 
		}


		reeturn += ("Satisfaction:");
		reeturn += "\n";
		reeturn += (sat);
		reeturn += "\n";


		reeturn += ("Spent:");
		reeturn += "\n";
		for(int i=1 ; i<itemlist.length ; i++){
			spent += this.slst.get(toInt(itemlist[i])).price;
		}

		int spent1 = spent / 100;
		int spent2 = spent % 100;

		if(spent2 >= 10){
			reeturn += (spent1 + "." + spent2);
			reeturn += "\n";
		}else if(spent2 == 0){
			reeturn += (spent1 + ".00");
			reeturn += "\n";
		}else{
			reeturn += (spent1 + ".0" + spent2);
			reeturn += "\n";
		}
                reeturn += "\n";
		return reeturn;

	}

	public String[] formatout(String[] res){
		String[] answers = res[1].split("\\+");
		
		String[] reeturn = new String[answers.length];
		
		for(int i=0 ; i<answers.length ; i++){
                        reeturn[i] = "Option ";
                        reeturn[i] += toString(i+1);
                        reeturn[i] += "\n"; 
			reeturn[i] += printans(answers[i], res[0]);
		}
                return reeturn;
	}

    public static boolean extensionality(String s1, String s2){
		List<String> solnset1 = new LinkedList<String>();
		List<String> solnset2 = new LinkedList<String>();

		String[] ss1 = s1.split("\\+");
		String[] ss2 = s2.split("\\+");

		if(ss1.length != ss2.length){ return false; }

		for(int i = 0 ; i<ss1.length ; i++){
			String[] temp1 = ss1[i].split(",");
			String[] temp2 = ss2[i].split(",");
			
			int[] num1 = new int[temp1.length-1];
			int[] num2 = new int[temp2.length-1];
			
			for(int x = 1 ; x<temp1.length ; x++){
				num1[x-1] = toInt(temp1[x]);
			}
			for(int y = 1 ; y<temp1.length ; y++){
				num2[y-1] = toInt(temp2[y]);
			}
						
			
			Arrays.sort(num1);
			Arrays.sort(num2);
			
			String tmp1 = "";
			String tmp2 = "";
			
			for(int j = 0 ; j<num1.length ; j++){
				tmp1 += "," + toString(num1[j]);
			}
			
			for(int k = 0 ; k<num2.length ; k++){
				tmp2 += "," + toString(num2[k]);
			}
			
			ss1[i] = tmp1;
			ss2[i] = tmp2;
			
			
			
			solnset1.add(ss1[i]);
			solnset2.add(ss2[i]);
		}

		Collections.sort(solnset1);
		Collections.sort(solnset2);

		return solnset1.equals(solnset2);
	}


	/*Comparing methods*/
	public int[] allEq(String[] arg1, String[] arg2, String[] arg3){
		int[] iar = new int[2];
            if(twoEq(arg1, arg2) && twoEq(arg2,arg3)){
                    iar[0] = 1;
                }else{
                iar[0]=0;

                if(twoEq(arg1, arg2)){
                    iar[1]=1;
                }else if(twoEq(arg2, arg3)){
                    iar[1]=2;
                }else if(twoEq(arg1, arg3)){
                    iar[3]=3;
                }else{
                    iar[3]=4;
                }
                }
            return iar;
	}

	public boolean twoEq(String[] arg1, String[] arg2){
		if(arg1 == arg2){
			return true;
		}else if(!arg1[0].equals(arg2[0])){
			return false;
		}else{
			return extensionality(arg1[1],arg2[1]);
		}
	}
	/*Comparing methods*/

	/*Misc methods*/
	
	/**/
	
}
