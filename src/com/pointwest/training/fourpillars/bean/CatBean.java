package com.pointwest.training.fourpillars.bean;

public class CatBean extends AnimalBean {
	// inherited from AnimalBean

	private String animalType = "Cat";
	

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String makeCatSound() {
		String catSound = "meow meow meow";
		return catSound;
	}

	
}
