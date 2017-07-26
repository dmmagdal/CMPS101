// ListTest.java
// Diego Magdaleno
// dmmagdal
// Tests the List ADT

public class ListTest{
	public static void main(String[] args){
		List l1 = new List();
		System.out.println("List size: "+l1.length());	// returns correct output

		/* Notes:
			+ all append() and prepend() operations work as they should
			+ length operation works as it should
			+ both back() and front() operations work as they should
			+ toString() operation works as it should
		 
		*/

		// test append(), prepend(), front(), back(), and length()

		/*		// works completely
		l1.append(4);
		l1.prepend(1);
		l1.prepend(8);
		System.out.println("Front: "+l1.front());	// back and front give correct outputs	
		System.out.println("Back: "+l1.back());
		/*
		l1.moveFront();
		for (int i = 0; i < 3; i++){
			System.out.print(l1.get()+" ");
			l1.moveNext();
		}
		System.out.println("List size: "+l1.length());
		//*/

		/*		// works completely
		l1.prepend(4);
		l1.append(1);
		l1.append(8);
		System.out.println("Front: "+l1.front());		// back and front give correct outputs
		System.out.println("Back: "+l1.back());
		System.out.println("List size: "+l1.length());	// length gives correct output
		//*/

		/*		// works completely
		l1.prepend(4);
		l1.append(1);
		l1.prepend(8);
		System.out.println("Front: "+l1.front());		// back and front give correct outputs
		System.out.println("Back: "+l1.back());
		System.out.println("List size: "+l1.length());	// length gives correct output
		//*/

		/*		// works completely
		l1.append(4);
		l1.prepend(1);
		l1.append(8);
		System.out.println("Front: "+l1.front());		// back and front give correct outputs
		System.out.println("Back: "+l1.back());
		System.out.println("List size: "+l1.length());	// length gives correct output
		//*/

		/*		// works completely
		l1.prepend(4);
		l1.prepend(1);
		l1.prepend(8);
		System.out.println("Front: "+l1.front());		// back and front give correct outputs
		System.out.println("Back: "+l1.back());
		System.out.println("List size: "+l1.length());	// length gives correct output
		//*/

		/*		// works completely
		l1.append(4);
		l1.append(1);
		l1.append(8);
		System.out.println("Front: "+l1.front());		// back and front give correct outputs
		System.out.println("Back: "+l1.back());
		System.out.println("List size: "+l1.length());	// length gives correct output
		//*/

		// System.out.println(l1.toString());	// returns correct output


		// test moveFront(), get(), index(), moveBack(), moveNext(), and movePrev()

		l1.append(4);
		l1.append(1);
		l1.append(8);
		l1.moveFront();
		while (l1.index() != l1.length()){
			System.out.print(l1.get()+" ");
			l1.moveNext();
		}
		System.out.println("\n");
		while (l1.index() >= 0){
			System.out.print(l1.get()+" ");
			l1.movePrev();
		}


	}
}