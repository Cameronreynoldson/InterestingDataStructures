import java.util.*; 

public class DisjointSet
{
	//value,parent
	Map<Integer,Integer> map; 

	public DisjointSet(List<Integer> values)
	{
		map = new HashMap<Integer,Integer>();

		//iterate through all elements 
		for(int i = 0; i < values.size(); ++i)
		{
			int val = values.get(i);
			map.put(val,val); //set every element to be the parent of itself
		}
	}

	public int find(int elementToFind)
	{
		//recursive version, should be optimized for large disjoint sets, couldn't help myself because of the elegance
		//performs path compression simultaneously 
		if(map.get(elementToFind) == elementToFind)
			return elementToFind; 
		else
			map.put(elementToFind,find(elementToFind));
	}


	public void union(int v1, int v2)
	{
		//union the two sets that hold these values
		int p1 = find(v1);
		int p2 = find(v2);

		map.put(p1,Math.max(p1,p2));
		map.put(p2,Math.max(p1,p2));
	}


}
