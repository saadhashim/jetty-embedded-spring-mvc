package beans;

public class CustomerBean
{
		private String name;

		private String balance;

		public CustomerBean() {
			this.name = "";
			this.balance = "";
		}
		
		public CustomerBean(String name, String balance) {
			this.name = name;
			this.balance = balance;
		}

		public String getName()
		{
				return this.name;
		}

		public String getBalance()
		{
				return this.balance;
		}

		public void setName(String name)
		{
				this.name = name;
		}

		public void setBalance(String balance)
		{
				this.balance = balance;
		}


}

