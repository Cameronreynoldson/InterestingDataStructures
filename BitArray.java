public class BitArray
{
	public static void main(String[] args)
	{
		BitVector bv = new BitVector(5000);
		bv.setBit(101,true);
		System.out.println(bv.getBit(100)); //false
		bv.setBit(5000,true);
		System.out.println(bv.getBit(5000)); //true
	}
}

class BitVector
{
	long[] data;

	public BitVector(int size)
	{
		data = new long[size/63]; 
	}

	public boolean getBit(int p)
	{
		return (data[p/64] & (1 << (p % 64))) != 0;
	}

	public void setBit(int p, boolean b)
	{
		long v = data[p / 64];

		long mask = (long) (1 << (p%64));

		if(b)
		{
			v |= mask;
		}
		else
		{
			v &= (255-mask);
		}

		data[p/64] = v;
	}
}
