
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinearProbingHashST<Integer, String> linearHT=new LinearProbingHashST<Integer, String>(10);
		
		linearHT.insert(4514,"alfalfa sprouts");
		linearHT.insert(4131,"apple fuji");
		linearHT.insert(4133,"apple gala");
		linearHT.insert(4017,"apple granny smith");
		linearHT.printTable();
		linearHT.insert(4218,"apricots");
		linearHT.printTable();
		linearHT.delete(4218);
		linearHT.printTable();
		
	}

}
