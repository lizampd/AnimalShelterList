package com.pointwest.training.fourpillars.bean;

public class ParrotBean extends AnimalBean {
	private String animalType = "Parrot";
	

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	
	public String makeParrotSound() {
		String parrotSound = "squawk squawk squawk";
		return parrotSound;
	}
}
