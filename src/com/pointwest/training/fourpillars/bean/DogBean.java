package com.pointwest.training.fourpillars.bean;

public class DogBean extends AnimalBean {
	private String animalType = "Dog";

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String makeDogSound() {
		String dogSound = "arf arf arf";
		return dogSound;

	}

}