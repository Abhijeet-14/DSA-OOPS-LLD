package _dsa._java._LEETCODE.Strings;

// Question: https://leetcode.com/problems/defanging-an-ip-address/

// Response: SOLVED

public class E2_Defanging_an_IP_Address {

	public static void main(String[] args) {

		String address = "1.1.1.1";
		System.out.println(defangIPaddr(address));
	}

	public static String defangIPaddr(String address) {
		String defanged = "";
		for (int index = 0; index < address.length(); index++) {
			if (address.charAt(index) == '.')
				defanged += "[.]";
			else
				defanged += address.charAt(index);
		}

		return defanged;
	}

}
