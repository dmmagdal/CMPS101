// ListTest.java
// Diego Magdaleno
// dmmagdal
// pa1: Tests the List ADT

public class ListTest{
	public static void main(String[] args){
		List l1 = new List();
		// System.out.println("List size: "+l1.length());	// returns correct output

		/* Notes:
			+ all append() and prepend() operations work as they should
			+ length operation works as it should
			+ both back() and front() operations work as they should
			+ toString() operation works as it should
			+ moveNext() movePrev() moveFront() moveBack() and get() all work as they should
		 	+ copy() deleteFront() deleteBack() clear() and equals work as they should
			+ concat() works as it should
			+ insertBefore() insertAfter() and delete()  work as they should
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
		/*
		l1.moveFront();	// prints list in order
		while (l1.index() != l1.length()){
			int x = l1.get();
			System.out.print(x+" ");
			if (l1.index() == l1.length()-1){
				break;
			}
			else {
				l1.moveNext();
			}
		}	// gives correct output, all aspects work
		System.out.println("\n");
		*/
		/*
		l1.moveBack();
		while (l1.index() >= 0){	// prints list in reverse order
			int x = l1.get();
			System.out.print(x+" ");
			l1.movePrev();
		}	// gives correct output, all aspects work
		*/


		// test copy() equals() and clear() as well as deleteFront() and deleteBack() indrectly back calling clear()

		List l2 = new List();	// copy of the l1 list

		/*
		l2.append(4);
		l2.append(1);
		l2.append(8);

		System.out.println("Are the two lists equal: "+l1.equals(l2));	// gives correct output

		l2.clear();

		System.out.println("Are the two lists equal: "+l1.equals(l2));	// gives correct output

		l2 = l1.copy();

		System.out.println("Are the two lists equal: "+l1.equals(l2));	// gives correct output

		*/


		// test concat() 

		///*
		l2.append(5);
		l2.append(3);
		l2.append(7);
		l2.append(9);
		l2.append(6);
		l2.prepend(0);

		l1 = l1.concat(l2);
		System.out.println(l1.toString());	// gives correct output

		//*/

		l1.moveFront();
		l1.insertAfter(3);	// works
		l1.moveBack();
		l1.insertBefore(1);	// works
		l1.movePrev();
		l1.movePrev();
		l1.delete();		// works 
		System.out.println(l1.toString());	// gives correct output


	}
}