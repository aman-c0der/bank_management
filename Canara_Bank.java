package bank_management;

public class Canara_Bank extends Bank{

	public Canara_Bank(String bank_name, int holder_id, String ifsc_no, int acc_no, String branch_name, String acc_type,
			String p_password, int amount, User user) {
		super(bank_name, holder_id, ifsc_no, acc_no, branch_name, acc_type, p_password, amount, user);
	}
}
