package hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value="ctx")
//@Table(name="checktxper")

public class CheckTx extends Tx {
	
	private int chequeNo;
	
	public CheckTx() {
		
	}
	
    public CheckTx(double amount, int chequeNo) {
		super(amount);
		this.chequeNo = chequeNo;
	}
    
    




	@Override
	public String toString() {
		return "CheckTx [chequeNo=" + chequeNo + ", getId()=" + getId() + ", getAmount()=" + getAmount() + "]";
	}

	public int getCheckNo() {
		return chequeNo;
	}

	public void setCheckNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}

}
