package src.hashmap;

public class CustomHashMap {
	final int size = 10;

	class Entry {
		String key;
		String value;

		Entry(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	Entry[] buckets = new Entry[size];

	boolean isEmpty() {
		int temp = 0;
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] == null)
				temp++;
		}
		if (temp == size)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomHashMap c = new CustomHashMap();
		c.push("ABC", "Nil");
		c.push("BCY", "Sach");
		c.push("ABC", "Nilesh");
		c.push("XYS", "Ashish");
	}

	public void push(String k, String v) {
		Entry entry = new Entry(k, v);
		int bucket = getHash(k) % size;
		if (isEmpty())
			buckets[bucket] = entry;
		else {
			int count = 0;
			Entry exist = buckets[getHash(k) % size];
			if (exist == null)
				buckets[bucket] = entry;
			else {
				while (count < size) {
					if (buckets[count] != null && buckets[count]!=exist) {
						buckets[count].value=null;
					}
					count++;
				}
				buckets[bucket]=entry;
				System.out.println(entry.value);
			}		
		}
	}

	public Entry getEntry(int hashCode) {

		return null;
	}

	public static int getHash(String key) {
		int hashCode = 0;
		for (int i = 0; i < key.length(); i++) {
			hashCode += key.charAt(i);
		}
		return hashCode;
	}
}
