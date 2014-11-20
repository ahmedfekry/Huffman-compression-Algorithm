import java.util.Arrays;


public class Main {

	public static void main(String[] args) {
		Huffman hfmn = new Huffman();
		IO ins = new IO();
		
		String x = ins.getI("/home/ahmed/FCI/java/HuffmanWindow/src/file.txt");//"aaaaaaaaaaaaaaaaaaaab";
		System.out.println(x.length());
		char[] chars = x.toCharArray();
		Arrays.sort(chars);
		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i]);
		}
		System.out.println();
		for(int i=0; i < chars.length; ++i) {
			hfmn.add(chars[i]);
		}
		hfmn.sortList();
		hfmn.printtreee();
		System.out.println("-------------------");
		Node node = (Node) hfmn.createTree();
		System.out.println(node.getFreq());
		String in = "";
		hfmn.getComressedCode(node, in);
		hfmn.comhufm();
		String res = hfmn.comhufm1();
//		String f = hfmn.
		System.out.println(res);
		
	}

}
