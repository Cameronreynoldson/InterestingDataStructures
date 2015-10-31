public class barray
{
	public static void main(String[] args)
	{
		BitVector bv = new BitVector(7000);
		bv.setBit(101,true);
		System.out.println(bv.getBit(100)); //false
		bv.setBit(6000,true);
		bv.setBit(6000,true);
		System.out.println(bv.getBit(6000)); //true
	}
}

class BitVector
{
	long[] data;

	public BitVector(int size)
	{
		data = new long[size/63];
	}


	public void setBit(int n, boolean on)
	{
		long v = data[n/64];

		long bit = (long)(1 << (n % 64));

		if(on)
		{
			v |= bit;
		}
		else
		{
			long mask = ((~((long)0)))-bit;
			v &= mask;
		}

		data[n/64] = v;
	}

	public boolean getBit(int n)
	{
		return ((1 << (n % 64)) & (data[n/64])) != 0;
	}
}
