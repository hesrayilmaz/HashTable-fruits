
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinearProbingHashST<Integer, String> linearHT = new LinearProbingHashST<Integer, String>(10);

		linearHT.insert(4239, "black berries");
		linearHT.insert(4045, "cherries red");
		linearHT.insert(4048, "limes");
		linearHT.insert(4051, "mango");
		linearHT.insert(4032, "watermelon seedless");
		linearHT.printTable();

		linearHT.insert(4131, "apple fuji");
		linearHT.insert(4227, "avocado small");
		linearHT.insert(4232, "banana baby");
		linearHT.insert(4260, "coconut white");
		linearHT.insert(4022, "grapes green");
		linearHT.insert(4053, "lemons yellow");
		linearHT.insert(4050, "melon cantaloupe");
		linearHT.insert(4036, "nectarines");
		linearHT.insert(4931, "nuts peanuts");
		linearHT.insert(4012, "orange navel");
		linearHT.insert(4395, "papaya");
		linearHT.insert(4038, "peaches yellow");
		linearHT.insert(4430, "pineapple");
		linearHT.insert(4028, "strawberry basket");
		linearHT.insert(3146, "tomatoes cherry");

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

		DoubleHashingHashST<Integer, String> doubleHT = new DoubleHashingHashST<Integer, String>(10);

		doubleHT.insert(4239, "black berries");
		doubleHT.insert(4045, "cherries red");
		doubleHT.insert(4048, "limes");
		doubleHT.insert(4051, "mango");
		doubleHT.insert(4032, "watermelon seedless");
		doubleHT.printTable();

		doubleHT.insert(4131, "apple fuji");
		doubleHT.insert(4227, "avocado small");
		doubleHT.insert(4232, "banana baby");
		doubleHT.insert(4260, "coconut white");
		doubleHT.insert(4022, "grapes green");
		doubleHT.insert(4053, "lemons yellow");
		doubleHT.insert(4050, "melon cantaloupe");
		doubleHT.insert(4036, "nectarines");
		doubleHT.insert(4931, "nuts peanuts");
		doubleHT.insert(4012, "orange navel");
		doubleHT.insert(4395, "papaya");
		doubleHT.insert(4038, "peaches yellow");
		doubleHT.insert(4430, "pineapple");
		doubleHT.insert(4028, "strawberry basket");
		doubleHT.insert(3146, "tomatoes cherry");

		doubleHT.find(4032);
		doubleHT.find(4430);
		doubleHT.find(4028);

		doubleHT.delete(4227);
		doubleHT.delete(4931);
		doubleHT.delete(4395);

		doubleHT.find(4227);
		doubleHT.find(4931);
		doubleHT.find(4395);
		doubleHT.printTable();

	}

}
