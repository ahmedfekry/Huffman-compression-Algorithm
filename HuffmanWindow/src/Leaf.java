
public class Leaf extends Tree{
	
	public char leaf;
	public Leaf() {
		
	}
	
	public Leaf(char l , int r) {
		setLeaf(l);
		setFreq(r);
	}
	
	public void setLeaf(char lea) {
		leaf = lea;
	}
	
	public char getLeaf() {
		return leaf;
	}

}
