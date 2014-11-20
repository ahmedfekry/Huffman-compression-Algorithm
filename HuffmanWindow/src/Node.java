
public class Node extends Tree{

	public Tree Left;
	public Tree Right;
	
	public Node(Tree l, Tree r,int rel) {
			Left = l;
			Right = r;
			setFreq(rel);
	}

	public void printnode() {
		
		System.out.println(Left.getFreq());
		System.out.println(Right.getFreq());
	}
}
