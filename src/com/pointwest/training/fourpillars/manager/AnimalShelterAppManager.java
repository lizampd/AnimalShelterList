package com.pointwest.training.fourpillars.manager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.pointwest.training.fourpillars.bean.AnimalBean;
import com.pointwest.training.fourpillars.bean.CatBean;
import com.pointwest.training.fourpillars.bean.DogBean;
import com.pointwest.training.fourpillars.bean.ParrotBean;

public class AnimalShelterAppManager {

	

	public DogBean setDogDetails(String name, int age, String gender, String type) {
		DogBean newDog = new DogBean();
		newDog.setAnimalName(name);
		newDog.setAnimalAge(age);
		newDog.setAnimalGender(gender);
		newDog.setAnimalType(type);
	
		SimpleDateFormat f = new SimpleDateFormat("yyMMddHHmmss");
		String refID = f.format(new Date());
		newDog.setAnimalRefID(refID);
		return newDog;
	}

	public List<AnimalBean> addDogToListOfAnimals(List<AnimalBean> listAnimals, DogBean dog) {
		listAnimals.add(dog);
		return listAnimals;
	}

	
	public CatBean setCatDetails(String name, int age, String gender, String type) {
		CatBean newCat = new CatBean();
		newCat.setAnimalName(name);
		newCat.setAnimalAge(age);
		newCat.setAnimalGender(gender);
		newCat.setAnimalType(type);
	
		SimpleDateFormat f = new SimpleDateFormat("yyMMddHHmmss");
		String refID = f.format(new Date());
		newCat.setAnimalRefID(refID);
		return newCat;
	}

	public List<AnimalBean> addCatToListOfAnimals(List<AnimalBean> listAnimals, CatBean cat) {
		listAnimals.add(cat);
		return listAnimals;
	}
	
	public ParrotBean setParrotDetails(String name, int age, String gender, String type) {
		ParrotBean newParrot = new ParrotBean();
		newParrot.setAnimalName(name);
		newParrot.setAnimalAge(age);
		newParrot.setAnimalGender(gender);
		newParrot.setAnimalType(type);
	
		SimpleDateFormat f = new SimpleDateFormat("yyMMddHHmmss");
		String refID = f.format(new Date());
		newParrot.setAnimalRefID(refID);
		return newParrot;
	}

	public List<AnimalBean> addParrotToListOfAnimals(List<AnimalBean> listAnimals, ParrotBean parrot) {
		listAnimals.add(parrot);
		return listAnimals;
	}
	
	
	public boolean verifyRefIdExists(List<AnimalBean> listAnimals, String remAnimalRefId) {
		boolean animalRefIdExists = false;
		for (AnimalBean remAnimal : listAnimals) {
			if (remAnimal.getAnimalRefID().equalsIgnoreCase(remAnimalRefId)) {
				animalRefIdExists = true;
				break;
			}
		}
		return animalRefIdExists;
	}

	public List<AnimalBean> remAnimalFromListOfAnimals(List<AnimalBean> listAnimals, String remAnimalRefId) {
		for (AnimalBean remAnimal : listAnimals) {
			if (remAnimal.getAnimalRefID().equalsIgnoreCase(remAnimalRefId)) {
				listAnimals.remove(remAnimal);
				break;
			}
		}
		return listAnimals;
	}
}