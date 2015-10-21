import java.util.*; 

public class Trie
{
	Trie[] children; 
	boolean isWord;  
	int count; 
	
	public Trie()
	{
		children = new char[26];
		isWord = false; 
		usedMoreThanOnce = false; 
	}


	public void add(String str)
	{
		if(str.length() == 0)
		{
			this.isWord = true;
			return; 
		}

		char c = str.charAt(0);
		int index = c - 'a';
		if(this.children[index] == null)
		{
			this.children[c-96] = new Trie();
		}

		this.count++;

		this.children[c-96].add(str.substring(1));
	}


	public boolean search(String s)
	{
		if(s.length() == 0)
		{
			return this.isWord();
		}

		char c = str.charAt(0);
		int index = c - 'a';
		if(this.children[index] == null)
		{
			return false; 
		}

		return this.children[index].search(s.substring(1));
	}

	public boolean remove(String s)
	{
		if(!search(s))
			return false;

		Trie current = this; 
		for(char c : s.toCharArray())
		{
			Trie child = current.children[c-'a'];
			if(child.count == 1)
			{
				this.children[c-'a'] = null;
				return true; 
			}

			child.count--;
			current = child;
		}
	}

	public List<String> getWords()
	{
		List<String> words = new ArrayList<String>();

		collectWords(words, new StringBuilder());

		return words;
	}

	private void collectWords(List<String> words, StringBuilder sb)
	{
		if (this.word)
		{
			words.add(sb.toString());
		}

		for (int i = 0; i < 26; ++i)
		{
			if (this.children[i] != null)
			{
				this.children[i].collectWords(words, sb.append((char)('a' + i)));
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}
