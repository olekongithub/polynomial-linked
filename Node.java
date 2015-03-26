
public class Node {
	public int coefficient;
	public int degree;
	public Node next;
	
	public Node(int coef, int deg){
		this.coefficient = coef;
		this.degree = deg;
	}
	
	public Node(int coef, int deg, Node next){
		this.coefficient = coef;
		this.degree = deg;
		this.next = next;
	}
	public Node next(Node n){
		this.next = n;
		return next;
	}


}
