package beans;

import javax.validation.constraints.Size;

public class CustomerBean
{		
		@Size(min=1, max=30)
		private String name;

		@Size(min=1, max=30)
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

