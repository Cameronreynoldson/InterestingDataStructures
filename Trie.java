import java.util.*;

public class Trie
{
	char c;
	Trie[] children;
	boolean word;

	public Trie()
	{
		this.c = 0;
		this.children = new Trie[26];
		this.word = false;
	}

	public void add(String s)
	{
		if (s.isEmpty())
		{
			this.word = true;
			return;
		}

		char letter = s.charAt(0);
		
		int index = letter - 'a';

		if (this.children[index] == null)
		{
			this.children[index] = new Trie();
		}

		this.children[index].add(s.substring(1));
	}

	public boolean isWord(String s)
	{
		if (s.isEmpty())
		{
			return this.word;
		}

		int index = s.charAt(0) - 'a';

		if (this.children[index] == null)
		{
			return false;
		}

		return this.children[index].isWord(s.substring(1));
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
