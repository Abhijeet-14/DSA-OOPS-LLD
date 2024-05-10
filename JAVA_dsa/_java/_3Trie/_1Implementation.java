package _dsa._java._3Trie;

public class _1Implementation {

	static final int CHAR = 26;
	
	static TrieNode root;
	
	static void insert(String word) {
		if(word.length() == 0)
			return;
		
		TrieNode current = root;
		
		for(int i=0; i<word.length(); i++) {
			int index = word.charAt(i)-'a';
			if(current.child[index] == null) {
				current.child[index] = new TrieNode();
			}
			
			current = current.child[index];
		}	
		
		current.isEnd = true;
		System.out.println("Congo, Inserted!");
	}

	
	
	
	static boolean search(String word) {
		
		if(word.length() == 0){
			return false;
		}
		
		TrieNode current = root;
		for(int i=0; i<word.length();i++) {
			int index = word.charAt(i) - 'a';
						
			if(current.child[index] == null) {
				return false;
			}
			
			current = current.child[index];
		}
			
		return (current.isEnd);
	}
	
	public static void main(String[] args) {
			root = new TrieNode();
			insert("geeks");
			insert("bad");
			
			System.out.println(search("geeks") ? "TRUE" : "FALSE");
	}
	
	
	
	public static class TrieNode{
		TrieNode child[] = new TrieNode[CHAR];
		boolean isEnd;
		
	}

}
