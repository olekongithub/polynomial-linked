

public class LinkedList {
	public Node head;
	public Node curr;

	public LinkedList(int[] intList){
		head = new Node(intList[intList.length -1], intList.length-1);
		curr = head;
		for (int x = intList.length - 2 ; x >= 0 ; x--){
			if (intList[x] == 0){
				continue;
			}
			curr = curr.next(new Node(intList[x], x));
		}
	}
	
	public LinkedList(int coef, int deg){
		head = new Node(coef, deg);
		curr = head;
	}
	
	public void add(int coef, int deg){
		if (coef == 0){return;}
		curr = curr.next(new Node (coef, deg));
	}
	
	public void print(){
		curr = head;
		boolean first = true;
		while (curr != null){
			if (curr.coefficient == 0){
				curr = curr.next; continue;
			}
			else if(curr.coefficient == 1 && !first && curr.degree != 0){
				System.out.print("+" + "x^" + curr.degree + " ");
				curr = curr.next;
				continue;
			}
			else if (curr.coefficient == 1 && curr.degree != 0){
				System.out.print("x^" + curr.degree + " ");
				curr = curr.next;
				first = false;
				continue;				
			}
			else if (curr.degree == 0 && curr.coefficient>0 && !first){
				System.out.print("+" + curr.coefficient);
				curr = curr.next;
				continue;
			}
			else if (curr.degree == 0){
				System.out.print(curr.coefficient);
				curr = curr.next;
				continue;
			}
			else if (curr.degree == 1){
				if (curr.coefficient > 0){
					System.out.print("+" + curr.coefficient + "x ");
				}
				else {
					System.out.print(curr.coefficient + "x ");
				}
				curr = curr.next;
				continue;
			}
			else if(curr.coefficient > 0 && !first){
				System.out.print("+");
			}
			System.out.print(curr.coefficient + "x^" + curr.degree + " ");
			curr = curr.next;
			first = false;
		}
		System.out.println();
	}
	
	public void searchAndAdd(int coef, int deg){
		curr = head;
		Node prev = curr;
		if (coef == 0){
			return;
		}
		while (curr != null){
			if (curr.degree == deg){
				curr.coefficient += coef;
				return;
			}
			if (curr.degree < deg){
				prev.next(new Node(coef, deg, curr));
				return;
			}
			prev = curr;
			curr = curr.next;
		}
		prev.next(new Node(coef, deg));
	}
}
