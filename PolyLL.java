

public class PolyLL {
	private LinkedList p;
	private LinkedList q;
	private LinkedList sum;
	private LinkedList difference;
	private LinkedList product;
	
	public PolyLL(int[] a, int[] b){
		p = new LinkedList(a);
		q = new LinkedList(b);
	}
	
	public LinkedList add(){
		Node pcurrent = p.head;
		Node qcurrent = q.head;
		if (pcurrent.degree == qcurrent.degree){
			sum = new LinkedList(pcurrent.coefficient + qcurrent.coefficient, pcurrent.degree);
			qcurrent = qcurrent.next;
			pcurrent = pcurrent.next;
		}
		else if (pcurrent.degree < qcurrent.degree){
			sum = new LinkedList(qcurrent.coefficient, qcurrent.degree);
			qcurrent = qcurrent.next;
		}
		else{
			sum = new LinkedList(pcurrent.coefficient, pcurrent.degree);
			pcurrent = pcurrent.next;
		}
		while ( qcurrent != null || pcurrent != null ){
			if (qcurrent==null){
				sum.add(pcurrent.coefficient, pcurrent.degree);
				pcurrent = pcurrent.next;
			}
			else if (pcurrent==null){
				sum.add(qcurrent.coefficient, qcurrent.degree);
				qcurrent = qcurrent.next;
			}
			else if (pcurrent.degree == qcurrent.degree){
				sum.add(pcurrent.coefficient + qcurrent.coefficient, pcurrent.degree);
				qcurrent = qcurrent.next;
				pcurrent = pcurrent.next;
			}
			else if (pcurrent.degree < qcurrent.degree){
				sum.add(qcurrent.coefficient, qcurrent.degree);
				qcurrent = qcurrent.next;
			}
			else {
				sum.add(pcurrent.coefficient, pcurrent.degree);
				pcurrent = pcurrent.next;
			}
		}
		p.print();
		System.out.println("Plus");
		q.print();
		System.out.println("Equals");
		sum.print();
		return sum;
	}
	
	public LinkedList subtract(){
		Node pcurrent = p.head;
		Node qcurrent = q.head;
		if (pcurrent.degree == qcurrent.degree){
			difference = new LinkedList(pcurrent.coefficient - qcurrent.coefficient, pcurrent.degree);
			qcurrent = qcurrent.next;
			pcurrent = pcurrent.next;
		}
		else if (pcurrent.degree < qcurrent.degree){
			difference = new LinkedList(-qcurrent.coefficient, qcurrent.degree);
			qcurrent = qcurrent.next;
		}
		else{
			difference = new LinkedList(pcurrent.coefficient, pcurrent.degree);
			pcurrent = pcurrent.next;
		}
		while ( qcurrent != null || pcurrent != null ){
			if (qcurrent==null){
				difference.add(pcurrent.coefficient, pcurrent.degree);
				pcurrent = pcurrent.next;
			}
			else if (pcurrent==null){
				difference.add(-1*qcurrent.coefficient, qcurrent.degree);
				qcurrent = qcurrent.next;
			}
			else if (pcurrent.degree == qcurrent.degree){
				difference.add(pcurrent.coefficient - qcurrent.coefficient, pcurrent.degree);
				qcurrent = qcurrent.next;
				pcurrent = pcurrent.next;
			}
			else if (pcurrent.degree < qcurrent.degree){
				difference.add(-1*qcurrent.coefficient, qcurrent.degree);
				qcurrent = qcurrent.next;
			}
			else {
				difference.add(pcurrent.coefficient, pcurrent.degree);
				pcurrent = pcurrent.next;
			}
		}
		p.print();
		System.out.println("Minus");
		q.print();
		System.out.println("Equals");
		difference.print();
		return difference;
	}
	
	public LinkedList multiply(){
		Node pcurrent = p.head;
		Node qcurrent = q.head;
		product = new LinkedList(0, pcurrent.degree+qcurrent.degree);
		while (pcurrent != null){
			while (qcurrent != null){
				product.searchAndAdd(pcurrent.coefficient*qcurrent.coefficient, pcurrent.degree+qcurrent.degree);
				qcurrent = qcurrent.next;
			}
			qcurrent = q.head;
			pcurrent = pcurrent.next;
		}
		p.print();
		System.out.println("Times");
		q.print();
		System.out.println("Equals");
		product.print();
		return product;
	}
	
	public void evaluate(int value){
		int total = 0;
		Node current = p.head;
		while (current != null){
			total += total + current.coefficient * Math.pow(value, current.degree);
			current = current.next;
		}
		System.out.println("First polynomial evaluates to " + total);
		total = 0;
		current = q.head;
		while (current != null){
			total += total + current.coefficient * Math.pow(value, current.degree);
			current = current.next;
		}
		System.out.println("Second polynomial evaluates to " + total);
		total = 0;
		current = sum.head;
		while (current != null){
			total += total + current.coefficient * Math.pow(value, current.degree);
			current = current.next;
		}
		System.out.println("The sum evaluates to " + total);
		total = 0;
		current = difference.head;
		while (current != null){
			total += total + current.coefficient * Math.pow(value, current.degree);
			current = current.next;
		}
		System.out.println("The difference evaluates to " + total);
		total = 0;
		current = product.head;
		while (current != null){
			total += total + current.coefficient * Math.pow(value, current.degree);
			current = current.next;
		}
		System.out.println("The product evaluates to " + total);
	}
	
	public static void main(String[] args){
		int[] first = {1,0,2};
		int[] second = {1,2,3};
		PolyLL myPoly = new PolyLL(first, second);
		myPoly.add();
		myPoly.subtract();
		myPoly.multiply();
		myPoly.evaluate(3);
		int[] a = {1,0,2,-3,4};
		int[] b = {1,-2,3,0,6,7};
		PolyLL yourPoly = new PolyLL(a,b);
		yourPoly.add();
		yourPoly.subtract();
		yourPoly.multiply();
		yourPoly.evaluate(2);
	}

}
