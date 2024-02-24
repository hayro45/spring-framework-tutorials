package springIntro;

public class CustomerManager implements ICustomerService{
	
	private ICustomerDal customerDal;
	/* Constructor injection 
	public CustomerManager(ICustomerDal customerDal) {
		this.customerDal = customerDal;
	}*/
	
	//settr injeciton
	public void setCustomerDal(ICustomerDal customerDal) {
		this.customerDal = customerDal;
	}
	
	public void add() {
		//iş kuralları
		customerDal.add();
	}
}
