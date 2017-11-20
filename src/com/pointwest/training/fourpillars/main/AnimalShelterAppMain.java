package com.pointwest.training.fourpillars.main;

import java.util.ArrayList;
import java.util.List;

import com.pointwest.training.fourpillars.bean.AnimalBean;
import com.pointwest.training.fourpillars.ui.AnimalShelterAppUI;

public class AnimalShelterAppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<AnimalBean> listOfAnimals = new ArrayList<AnimalBean>();
		AnimalShelterAppUI animalShelterAppUi = new AnimalShelterAppUI();
		Boolean isMaxCapReached = false;
		Boolean isDone = false;
		do {
			listOfAnimals = animalShelterAppUi.maintainAnimalShelter(listOfAnimals, animalShelterAppUi);
			int listOfAnimalSize = listOfAnimals.size();

			if (listOfAnimalSize == 10) {			
				isDone = animalShelterAppUi.displayTerminationPage();
			}

		} while ((!isDone));

	}

}
