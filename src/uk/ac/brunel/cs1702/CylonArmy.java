package uk.ac.brunel.cs1702;

import java.util.ArrayList;

import uk.ac.brunel.cs1702.Cylons.*;

public class CylonArmy {
	
	ArrayList<Cylon[][]> theArmy = new ArrayList<Cylon[][]>();
	int cylonPerShip = Constants.NUMBER_OF_CYLON_MODELS / Constants.MAX_NUMBER_OF_SHIPS;
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	public CylonArmy(int[] modelNoCount) throws CylonException {
		//ResurrectionShipFactory.getInstance().resurrectionShips.clear();
		if (ResurrectionShipFactory.getInstance() != null && modelNoCount.length == Constants.NUMBER_OF_CYLON_MODELS) {
			for (int i = 0; i < Constants.MAX_NUMBER_OF_SHIPS; i++) {
				ResurrectionShip myShip = ResurrectionShipFactory.getInstance().getNewShip(i + 1);
				Cylon[][] subArmy = myShip.getCylonArmy(modelNoCount);
				theArmy.add(subArmy);
			}
		} else {
			throw new CylonException();
		}
	}
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	public Cylon[][] getArmy() {
		Cylon[][] newArmyArray = new Cylon[Constants.NUMBER_OF_CYLON_MODELS][];
		
		for (int i = 0; i < theArmy.size(); i++) {
			for (int x = 0; x < theArmy.get(i).length; x++) {
				if ((x < ((i + 1) * cylonPerShip) && x >= i * cylonPerShip)) {
					newArmyArray[x] = new Cylon[theArmy.get(i)[x].length];
					for (int y = 0; y < theArmy.get(i)[x].length; y++) {
						newArmyArray[x][y] = theArmy.get(i)[x][y];
					}
				}
			}
		}
		
		return newArmyArray;
	}
}
