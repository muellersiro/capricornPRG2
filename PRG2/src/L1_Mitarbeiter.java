
public class L1_Mitarbeiter {

	private int pnr;
	private String name;
	private char gender;

	public L1_Mitarbeiter(int pnr, String name, char gender) {
		this.pnr = pnr;
		this.name = name;
		this.gender = gender;
	}

	public String toString() {
		return ("Pernumber: " + this.pnr + ", Name: " + this.name + ", Gender: " + this.gender);
	}

	public static void main(String[] args) {

		L1_Mitarbeiter[] mA = null;
		mA[1] = new L1_Mitarbeiter(01, "Siro", 'm');
		
	}

	public static int getByPnr(L1_Mitarbeiter[] mA, int pnr) {
		for (int i = 0; i <= mA.length; i++) {
			L1_Mitarbeiter m1 = mA[i];
			if (m1 != null && m1.pnr == m1.pnr) {
				return m1.pnr;
			}
		}
		return -1;
	}

	public static int countM(L1_Mitarbeiter[] mA) {
		return count(mA, 'm');

	}

	public static int countF(L1_Mitarbeiter[] mA) {
		return count(mA, 'f');
	}

	public static int count(L1_Mitarbeiter[] mA, char gender) {
		int count = 0;
		for (int i = 0; i <= mA.length; i++) {
			L1_Mitarbeiter m1 = mA[i];
			if (m1 != null && m1.gender == gender) {
				count++;
			}
		}
		return count;
	}
	
	public static L1_Mitarbeiter[] getAllById(L1_Mitarbeiter[] mA, int pnr) {
		
		L1_Mitarbeiter[] mASelected = null;
		for (int i = 0; i <= mA.length; i++) {
			L1_Mitarbeiter m1 = mA[i];
			if (m1 != null && m1.pnr == m1.pnr) {
				mASelected[1] = m1;
			}
		}
		return mASelected;
	}
	
}
