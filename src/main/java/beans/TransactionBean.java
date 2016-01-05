package beans;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.Size;

public class TransactionBean
{
		@Size(min=1, max=30)
		private String name;
		@Size(min=1, max=30)
		private String transaction;
		@Size(min=1, max=30)
		private String amount;
		private Map<String,String> transactionTypes; 
		
		private void populateTransactions(){
			transactionTypes = new LinkedHashMap<String,String>();
			transactionTypes.put("IN", "Sätt in");
			transactionTypes.put("TA", "Ta ut");
		}

		public TransactionBean() {
			this.name = "";
			this.transaction = "";
			this.amount = "";
			populateTransactions();
		}
		
		public TransactionBean(String name, String transaction, String amount) {
			this.name = name;
			this.transaction = transaction;
			this.amount = amount;
			populateTransactions();

		}

		public String getName()
		{
				return this.name;
		}

		public String getTransaction()
		{
				return this.transaction;
		}

		public String getAmount()
		{
				return this.amount;
		}
		
		public void setName(String name)
		{
				this.name = name;
		}

		public void setTransaction(String transaction)
		{
				this.transaction = transaction;
		}
		
		public void setAmount(String amount)
		{
				this.amount = amount;
		}
		
		public Map<String,String> getTransactionTypes(){
			return transactionTypes;
		}


}

