package org.jasonnet.bytes;

/**
 * A set of helper functions for working with byte arrays.
 * 
 * @author jasonnet (12/18/2014)
 */
public class ByteArrays {
	
	/**
	 * hiding default constructor by declaring it private.
	 * 
	 * @author jasonnet (12/19/2014)
	 */
	private ByteArrays() {
	}

	/**
	 * Find the location of the specified needle sequence in the
	 * specified range of the specified haystack sequence. 
	 *  
	 * This implementation differs from many other implementations 
	 * in that it allows the caller to specify a range of the 
	 * haystack array to consider.  This can be handy if the whole 
	 * array isn't populated or if one is incrementally parsing the 
	 * array. 
	 *  
	 * To-do: (2014-12-18) This implementation could be made faster 
	 * handling situations where the sequences are long and matches
	 * often don't occur early in the haystack subsequence.
	 * 
	 * @author jasonnet (12/18/2014)
	 * 
	 * @param haystack the array in which to find the needle 
	 *      	   sequence.
	 * @param idxStartHaystack the earliest index at which this 
	 *      		   routine should look for a match.
	 * @param idxEndHaystack the end (exclusive) of haystack 
	 *      		 sequence in question.  This value
	 *      		 should not be larger that the length of
	 *      		 the haystack array.  This function will
	 *      		 not possible consider matches that
	 *      		 begin after index (idxEndHaystack -
	 *      		 needle.length).
	 * @param needle the sequence to be found. 
	 *  
	 * @return int  -1 if a matching occurrance is not found. 
	 *         Otherwise, the index in to the haystack of the
	 *         beginning of the match.
	 */
	static public int indexOf( byte haystack[],  int idxStartHaystack, int idxEndHaystack, byte needle[]) {
		int needlelen = needle.length;
		int idxEndHaystack2 = idxEndHaystack - needlelen;
		outer:
		for (int i=idxStartHaystack; i<=idxEndHaystack2; i++) {
			for (int j=0; j<needlelen; j++) {
				if (haystack[i+j]!=needle[j]) {
					continue outer;
				}
			}
			return i;
		}
		return -1;
	}

	/**
	 * Indicates if the specified haystack byte array ends with the 
	 * specified needle byte array.
	 * 
	 * @author ccjason (1/22/2015)
	 * 
	 * @param haystack 
	 * @param needle 
	 * 
	 * @return boolean
	 */
	static public boolean endsWith( byte haystack[],  byte needle[]) {
		int idxNeedle = needle.length;
		int idxHaystack = haystack.length;
		if (idxNeedle>idxHaystack) return false;
		while (true) {
			idxNeedle--;  idxHaystack--;
			if (needle[idxNeedle]!=haystack[idxHaystack]) return false;
			if (idxNeedle==0) return true;
		}
	}

}