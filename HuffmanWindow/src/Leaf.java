
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ahmed Fekry
 */
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
