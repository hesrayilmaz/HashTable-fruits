
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinearProbingHashST<Integer, String> linearHT=new LinearProbingHashST<Integer, String>(10);
		
		linearHT.insert(4239,"black berries");
		linearHT.insert(4045,"cherries red");
		linearHT.insert(4048,"limes");
		linearHT.insert(4051,"mango");
		linearHT.insert(4032,"watermelon seedless");
		linearHT.printTable();
		
		linearHT.insert(4131,"apple fuji");
		linearHT.insert(4227,"avocado small");
		linearHT.insert(4232,"banana baby");
		linearHT.insert(4260,"coconut white");
		linearHT.insert(4022,"grapes green");
		linearHT.insert(4053,"lemons yellow");
		linearHT.insert(4050,"melon cantaloupe");
		linearHT.insert(4036,"nectarines");
		linearHT.insert(4931,"nuts peanuts");
		linearHT.insert(4012,"orange navel");
		linearHT.insert(4395,"papaya");
		linearHT.insert(4038,"peaches yellow");
		linearHT.insert(4430,"pineapple");
		linearHT.insert(4028,"strawberry basket");
		linearHT.insert(3146,"tomatoes cherry");
	
		linearHT.find(4032);
		linearHT.find(4430);
		linearHT.find(4028);
		
		linearHT.delete(4227);
		linearHT.delete(4931);
		linearHT.delete(4395);
		
		linearHT.find(4227);
		linearHT.find(4931);
		linearHT.find(4395);
		linearHT.printTable();
		
	}

}
