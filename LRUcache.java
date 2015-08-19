import java.util.*;


public class LRUcache<K,V> extends LinkedHashMap<K,V>
{
	private int limit; 

	public LRUcache(int s)]
	{
		super(16,0.75f,true);
		limit = s; 
	}

	protected boolean removeEldestEntry(Map.Entry<K,V> eldest)
	{
		return size() >= limit;
	}
}
