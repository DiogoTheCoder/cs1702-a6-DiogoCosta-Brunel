package uk.ac.brunel.cs1702.Cylons;

import java.util.ArrayList;

//DO NOT MODIFY THIS LINE
public class ResurrectionShipFactory implements ShipFinder {
	
	//YOU CAN ADD FIELDS HERE
	public ArrayList<ResurrectionShip> resurrectionShips = new ArrayList<ResurrectionShip>();
	
	//DO NOT MODIFY THIS LINE
	private static ResurrectionShipFactory instance;

	//DO NOT MODIFY THIS CONSTRUCTOR
	private ResurrectionShipFactory(){}
	
	//DO NOT MODIFY THIS METHOD
	public static ResurrectionShipFactory getInstance(){
		if(instance == null)
			instance = new ResurrectionShipFactory();
		return instance;
	}

	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	public ResurrectionShip getNewShip(int shipID) throws CylonException {
		if (shipID > 0 && shipID <= Constants.MAX_NUMBER_OF_SHIPS) {
			for (ResurrectionShip ship : resurrectionShips) {
				// Check if shipId is not repeating
				if (shipID == ship.getShipID()) {
					throw new CylonException();
				}
			}
			// IF NONE OF THE IDS ALREADY EXIST
			ResurrectionShip newShip = new ResurrectionShip(shipID);
			resurrectionShips.add(newShip);
			
			return newShip;
		} else {
			throw new CylonException();
		}
	}
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	@Override
	public ResurrectionShip findYourShip(Cylon cylon) {
		ResurrectionShip myShip = resurrectionShips.get(cylon.shipNo);
		return myShip;
	}
}