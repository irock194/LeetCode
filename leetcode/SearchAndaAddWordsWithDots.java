package leetcode;

//https://leetcode.com/problems/design-add-and-search-words-data-structure/

public class SearchAndaAddWordsWithDots {
	
	
	//Incredibly slow (n^3)
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        int level;
        int index;
        int length = word.length();
        
        TrieNode searchNode = root;
        for(level = 0; level < length; level++){
            index = word.charAt(level) - 'a';
            if(searchNode.children[index] == null){
                searchNode.children[index] = new TrieNode();
            }
            searchNode = searchNode.children[index];
        }
        searchNode.isEndOfWord = true;
        return;
    }
    
    public boolean search(String word) {
        int level;
        int index;
        int length = word.length();
        
        TrieNode searchNode = root;
        for(level = 0; level < length; level++){
            if(word.charAt(level) == '.'){
                return searchAll(word.substring(level), searchNode);
            }
            index = word.charAt(level) - 'a';
            if(searchNode.children[index] == null){
                return false;
            }
            searchNode = searchNode.children[index];
        }
        return searchNode.isEndOfWord;
    }
    
    public boolean searchAll(String word, TrieNode currentRoot){
        int level;
        int index;
        int length = word.length();
        
        //covers the case of "ba."
        if(length == 1){
            for(int i = 0; i < 26; i++){
                if(currentRoot.children[i] != null && currentRoot.children[i].isEndOfWord){
                    return true;
                }
            }
            return false;
        }
 
        
        TrieNode searchNode = currentRoot;
        for(int i = 0; i < 26; i++){
            if(searchNode.children[i] != null && searchDot(word.substring(1), searchNode.children[i])){
                return true;
            }
        }
        return false;
    }
    
    public boolean searchDot(String word, TrieNode currentNode){
        int level;
        int index;
        int length = word.length();
        
        TrieNode searchNode = currentNode;
        for(level = 0; level < length; level++){
            if(word.charAt(level) == '.'){
                return searchAll(word.substring(level), searchNode);
            }
            index = word.charAt(level) - 'a';
            if(searchNode.children[index] == null){
                return false;
            }
            searchNode = searchNode.children[index];
        }
        return searchNode.isEndOfWord;
    }
    
    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
        TrieNode(){
            isEndOfWord = false;
            for(int i = 0; i < children.length; i++){
                children[i] = null;
            }
        }
    }
}
