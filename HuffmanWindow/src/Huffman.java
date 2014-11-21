
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ahmed Fekry
 */
import java.util.*;
import java.util.Map.Entry;

import com.sun.org.apache.regexp.internal.REUtil;

public class Huffman {
	
	private ArrayList<Tree> List;
	private HashMap<Character, String> mp = new HashMap<Character,String>();

	public Huffman() {
		List = new ArrayList<Tree>();
	}
	
	public void add(char c) {
		boolean found = false;
		for (int i = 0; i < List.size(); i++) {
			if(((Leaf) List.get(i)).getLeaf() == c)
			{
				List.get(i).setFreq(List.get(i).getFreq()+1);
				found = true;
				System.out.println("char "+ c +"Exist. new relevance: " + List.get(i).getFreq());
				break;
			}
		}
		if(!found) {
			Leaf leaf = new Leaf(c,1);
			List.add(leaf);
			System.out.println("Added a new Leaf: " + c);
		}
	}
	public void sortList() {
		for (int i = 0; i < List.size(); i++) {
			int x = i;
			for (int j = i+1; j < List.size(); j++) {
				if(List.get(x).getFreq()  >= List.get(j).getFreq()) {
					x = j;
				}
			}
			int c = x;
			Tree tree = List.get(c);
			Tree tree2 = List.get(i);
			List.set(i, tree);
			List.set(c, tree2);
		}
	}
	public void printtreee() {
		System.out.println("Inintial" + List.size());
		for (int i = 0; i < List.size(); i++) {
			System.out.println(((Leaf) List.get(i)).getLeaf()+ ": " +List.get(i).getFreq());
		}
		System.out.println("-------------------------------");
	}
	
	private void printtree() {
		System.out.println("current tree size: " + List.size());
		for (int i = 0; i < List.size(); i++) {
			System.out.println(List.get(i).getFreq());
		}
		System.out.println("-------------------------------");
	}
	
	public Tree createTree() {
		sortList();
		System.out.println("------------");
		System.out.println("Old Tree");
		printtree();
		System.out.println("------------");
		
		if(List.size() < 1) {
			System.out.println("Tree is Empity");
			return null;
		}
		
		if(List.size() > 2) {
			int low1 = 0;
			int low2;
			for (int i = 0; i < List.size(); i++) {
				if(List.get(i).getFreq() < List.get(low1).getFreq()) low1 = i;
			}
			
			if(low1 == 0)
				low2 =1;
			else
				low2 = 0;
			
			for (int i = 0; i < List.size(); i++) {
				if ((List.get(i).getFreq() < List.get(low2).getFreq()) && i != low1) {
					low2 = i;
				}
			}
			
			if(low1 == low2) {
				System.out.println("Error");
				return null;
			}
			System.out.println("Two Lower Freq " + low1 + " and " + low2);
			
			int newfreq = List.get(low1).getFreq() + List.get(low2).getFreq();
			
			System.out.println( "new frq = " + newfreq);
			Node node;
//			if (List.get(low1).getRelevance() == List.get(low2).getRelevance() && low2 > low1) {
//				 node = new Node(List.get(low2),List.get(low1),newfreq);	
//			}
//			else
//			{
				node = new Node(List.get(low1),List.get(low2),newfreq);
//			}
			System.out.println("*************");
			node.printnode();
			System.out.println("*************");
			
//			List.set(low1, node);
			List.remove(low1);
			if(low2 >= 1 )
				List.remove(low2-1);
			else
				List.remove(low2);
				
			List.add(node);
			
			printtree();
			return createTree();
		}
		
		if (List.size() == 2){
			int low1 = 0;
			int low2 = 1;
			System.out.println("Two Lower Freq" + low1 + " and " + low2);
			
			int newfreq = List.get(low1).getFreq() + List.get(low2).getFreq();
			Node node;
			if(List.get(low1).getFreq() > List.get(low2).getFreq() ) {
				node = new Node(List.get(low2),List.get(low1),newfreq);
			}
			else {
				node = new Node(List.get(low1),List.get(low2),newfreq);
			}
			System.out.println("*************");
			node.printnode();
			System.out.println("*************");
			List.remove(0);
			List.remove(0);
			List.add(node);
			printtree();
			return createTree();
		}
		printtree();
		System.out.println("Tree Created");
		return List.get(0);
	}
	
	public Tree getPos(Tree tree, String path) {
		Tree res = tree;
		for (int i = 0; i < path.length(); i++) {
			if(path.charAt(i)!='1' || path.charAt(i)!='0') {
				System.out.println("Invalid path");
				return null;
			}
			if(path.charAt(i) == '0')
				res = ((Node) res).Left;
			else if (path.charAt(i) == '1')
				res = ((Node) res).Right;
		}
		return res;
	}
	
	public void comhufm() {
		for(Map.Entry<Character, String> e : mp.entrySet()) {
				System.out.println("----");
				System.out.println(e.getKey() +" = " + e.getValue());
			}
	}
	public String comhufm1() {
		String out = "";
			for(Map.Entry<Character, String> e : mp.entrySet()) {
				out += e.getValue();
			}
			IO ins = new IO();
			ins.writeBinary("C:\\Users\\lenovo\\Documents\\NetBeansProjects\\HuffmanWindow\\src\\out.txt", out, out.length());
			String aaas = ins.readBinary("C:\\Users\\lenovo\\Documents\\NetBeansProjects\\HuffmanWindow\\src\\out.txt");
			
                        return aaas ;
	}
	
	public void getComressedCode(Tree tree,String input) {
		if( (tree instanceof Leaf))
		{
			mp.put( ((Leaf) tree).getLeaf() ,input );
			return;
		}
		
		getComressedCode(((Node) tree).Left, input+'0');
		getComressedCode(((Node) tree).Right, input+'1');
	}
        
        
        
       public  String Decomress(Tree node, int i, String s, Tree head) {
        if(i==s.length())
        {
        return "";
        }
        if (node instanceof Leaf) {
            return ((Leaf)node).leaf + Decomress(head, i, s, head);
        }
        if (s.charAt(i) == '0') {
            return Decomress(((Node) node).Left, i + 1, s, head);
        } else {
            return Decomress(((Node) node).Right, i + 1, s, head);
        }
    }
        
	public void clear() {
		List.clear();
		System.out.println("Cleared List");
	}
}





