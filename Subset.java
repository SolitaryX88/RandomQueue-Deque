public class Subset {
   public static void main(String[] args){
	   		
	   RandomizedQueue<String> randqueue = new RandomizedQueue<String>();
       int k = Integer.parseInt(args[0]);
       while (!StdIn.isEmpty()) {
           String item = StdIn.readString();
           randqueue.enqueue(item);
       }
       for (int i = 0; i < k; i++) {
           System.out.println(randqueue.dequeue());
       }
		}
}