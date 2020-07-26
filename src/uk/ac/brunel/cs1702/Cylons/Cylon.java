package uk.ac.brunel.cs1702.Cylons;

public class Cylon {
	
	//YOU CAN ADD FIELDS HERE
	int modelNo, shipNo;
	boolean isInfected = false;
	boolean isDeadForever = false;
	int resurrectionCount = 0;
	int cylonPerShip = Constants.NUMBER_OF_CYLON_MODELS / Constants.MAX_NUMBER_OF_SHIPS;
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	protected Cylon(int modelNo) throws CylonException{
		if (modelNo >= 1 && modelNo <= Constants.NUMBER_OF_CYLON_MODELS) {
			this.modelNo = modelNo;
			this.shipNo = (int) (this.modelNo - 1) / cylonPerShip;
		} else {
			throw new CylonException();
		}
	}

	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	public int getModel() {
		return this.modelNo;
	}
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	public int getResurrectionCount() {
		return this.resurrectionCount;
	}
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	public boolean isDeadForever() {
		return this.isDeadForever;
	}
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	public void killed() throws CylonException {
		try {
			ResurrectionShipFactory.getInstance().findYourShip(this).resurrect(this);
		} catch (CylonException e) {
			this.isDeadForever = true;
			//throw new CylonException();
		}
	}
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	public void setInfected() {
		this.isInfected = true;
	}
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	public boolean isInfected(){
		return this.isInfected;	
	}	
}
