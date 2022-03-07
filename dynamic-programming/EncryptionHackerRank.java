
public class EncryptionHackerRank {

	public static String encryption(String s) {
	 var encryptedMessage = "";
	 
	 var sqrt = Math.sqrt(s.length());
	 
	 var col = (int) Math.ceil(sqrt);
	 
	 var i = 0;
	 
	 while(i < col) {
		 var j = i;
		 while(j < s.length()) {
			 encryptedMessage += s.charAt(j);
			 j += col;
		 }
		 
		 encryptedMessage += " ";
		 i++;
	 }
	 
	 return encryptedMessage;

	}
	
	public static void main(String[] args) {
		System.out.println(EncryptionHackerRank.encryption("ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots"));
	}
	
	
}
