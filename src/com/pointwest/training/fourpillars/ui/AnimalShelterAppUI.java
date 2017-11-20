package com.pointwest.training.fourpillars.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pointwest.training.fourpillars.bean.AnimalBean;
import com.pointwest.training.fourpillars.bean.CatBean;
import com.pointwest.training.fourpillars.bean.DogBean;
import com.pointwest.training.fourpillars.bean.ParrotBean;
import com.pointwest.training.fourpillars.manager.AnimalShelterAppManager;

public class AnimalShelterAppUI {

	public List<AnimalBean> maintainAnimalShelter(List<AnimalBean> listOfAnimals, AnimalShelterAppUI animalShelterUi) {
		String mainMenuInput;
		int listOfAnimalSize = listOfAnimals.size();
		if (listOfAnimalSize == 0) {
			mainMenuInput = animalShelterUi.displayMainMenuForEmpty();
		} else if (listOfAnimalSize < 10) {
			mainMenuInput = animalShelterUi.displayMainMenu();
		} else {
			mainMenuInput = animalShelterUi.displayMainMenuForFull();
		}
		List<AnimalBean> latestListOfAnimals = new ArrayList<AnimalBean>();
		switch (mainMenuInput) {
		case "1":

			String addSubMenuInput = animalShelterUi.displayAddSubMenu();
			AnimalShelterAppManager addAnimalShelterAppManager = new AnimalShelterAppManager();
			List<AnimalBean> addUpdListOfAnimals = new ArrayList<AnimalBean>();
			switch (addSubMenuInput) {
			case "1":
				String dogName = animalShelterUi.getDogName();
				int dogAge = animalShelterUi.getDogAge();
				String dogGender = animalShelterUi.getDogGender();
				String dogAnimalType = "Dog";
				DogBean newDog = addAnimalShelterAppManager.setDogDetails(dogName, dogAge, dogGender, dogAnimalType);
				latestListOfAnimals = addAnimalShelterAppManager.addDogToListOfAnimals(listOfAnimals, newDog);
				break;
			case "2":
				String catName = animalShelterUi.getCatName();
				int catAge = animalShelterUi.getCatAge();
				String catGender = animalShelterUi.getCatGender();
				String catAnimalType = "Cat";
				CatBean newCat = addAnimalShelterAppManager.setCatDetails(catName, catAge, catGender, catAnimalType);
				latestListOfAnimals = addAnimalShelterAppManager.addCatToListOfAnimals(listOfAnimals, newCat);
				break;
			case "3":
				String parrotName = animalShelterUi.getParrotName();
				int parrotAge = animalShelterUi.getParrotAge();
				String parrotGender = animalShelterUi.getParrotGender();
				String parrotAnimalType = "Parrot";
				ParrotBean newParrot = addAnimalShelterAppManager.setParrotDetails(parrotName, parrotAge, parrotGender,
						parrotAnimalType);
				latestListOfAnimals = addAnimalShelterAppManager.addParrotToListOfAnimals(listOfAnimals, newParrot);
				break;
			}

			break;
		case "2":
			String remAnimalRefIdInput = animalShelterUi.displayRemPage();
			AnimalShelterAppManager remAnimalShelterAppManager = new AnimalShelterAppManager();
			boolean animalRefIdExists = remAnimalShelterAppManager.verifyRefIdExists(listOfAnimals,
					remAnimalRefIdInput);
			if (animalRefIdExists == true) {
				latestListOfAnimals = remAnimalShelterAppManager.remAnimalFromListOfAnimals(listOfAnimals,
						remAnimalRefIdInput);
				System.out
						.println("Animal with Reference ID " + remAnimalRefIdInput + " HAS BEEN successfully removed");

			} else {
				System.out.println(
						"Animal with Reference ID " + remAnimalRefIdInput + " HAS NOT BEEN successfully removed");
			}
			break;
		case "3":
			latestListOfAnimals = animalShelterUi.displayViewPage(listOfAnimals, animalShelterUi);
			break;

		}
		return latestListOfAnimals;
	}

	public String displayMainMenuForEmpty() {
		Scanner scanner = new Scanner(System.in);
		boolean validInput = false;
		String mainInput = " ";
		while (validInput == false) {
			System.out.println("Welcome to JC's Animal Shelter!");
			System.out.println("The shelter is currently empty");
			System.out.println("Please select an option: ");
			System.out.println("[1] Add Animal");
			mainInput = scanner.nextLine();
			if (("1").equals(mainInput)) {
				validInput = true;
				break;
			}
		}
		return mainInput;
	}

	public String displayMainMenu() {
		List<String> menuList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		menuList.add("1");
		menuList.add("2");
		menuList.add("3");
		boolean validInput = false;
		String mainInput = " ";
		while (validInput == false) {
			System.out.println("Welcome to JC's Animal Shelter!");
			System.out.println("Please select an option: ");
			System.out.println("[1] Add Animal");
			System.out.println("[2] Remove an Animal");
			System.out.println("[3] View all Animals");
			mainInput = scanner.nextLine();
			for (String menu : menuList) {
				if (menu.equals(mainInput)) {
					validInput = true;
					break;
				}
			}
		}

		return mainInput;
	}

	public String displayMainMenuForFull() {
		Scanner scanner = new Scanner(System.in);
		boolean validInput = false;
		String mainInput = " ";
		while (validInput == false) {
			System.out.println("Welcome to JC's Animal Shelter!");
			System.out.println("The shelter is currently full");
			System.out.println("Please select an option: ");
			System.out.println("[1] Remove Animal");
			System.out.println("[2] View all Animals");
			mainInput = scanner.nextLine();
			if (("1").equals(mainInput) || ("2").equals(mainInput)) {
				validInput = true;
				break;
			}
		}
		if (("1").equals(mainInput)) {
			mainInput = "2";
		} else {
			mainInput = "3";
		}

		return mainInput;
	}

	public String displayAddSubMenu() {
		List<String> subMenuList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		subMenuList.add("1");
		subMenuList.add("2");
		subMenuList.add("3");
		boolean validInput = false;
		String subInput = " ";
		while (validInput == false) {
			System.out.println("Add Animal Page");
			System.out.println("What animal are you trying to add? ");
			System.out.println("Please select an option:");
			System.out.println("[1] A Dog");
			System.out.println("[2] A Cat");
			System.out.println("[3] A Parrot");
			subInput = scanner.nextLine();
			for (String subMenu : subMenuList) {
				if (subMenu.equals(subInput)) {
					validInput = true;
					break;
				}
			}
		}
		return subInput;
	}

	public String getDogName() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Dog Name: ");
		String dogName = scanner.nextLine();
		return dogName;
	}

	public int getDogAge() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Dog Age: ");
		int dogAge = Integer.parseInt(scanner.nextLine());
		return dogAge;
	}

	public String getDogGender() {
		Scanner scanner = new Scanner(System.in);
		boolean validInput = false;
		String genderInput = " ";
		String dogGender = " ";
		while (validInput == false) {
			System.out.println("Enter Dog Gender (M/F): ");
			genderInput = scanner.nextLine();
			if (("M").equalsIgnoreCase(genderInput) || ("F").equalsIgnoreCase(genderInput)) {
				validInput = true;
				break;

			}

		}
		if (("M").equalsIgnoreCase(genderInput)) {

			dogGender = "Male";
		} else {
			dogGender = "Female";
		}

		return dogGender;
	}

	public String getCatName() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Cat Name: ");
		String catName = scanner.nextLine();
		return catName;
	}

	public int getCatAge() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Cat Age: ");
		int catAge = Integer.parseInt(scanner.nextLine());
		return catAge;
	}

	public String getCatGender() {
		Scanner scanner = new Scanner(System.in);
		boolean validInput = false;
		String genderInput = " ";
		String catGender = " ";
		while (validInput == false) {
			System.out.println("Enter Cat Gender (M/F): ");
			genderInput = scanner.nextLine();
			if (("M").equalsIgnoreCase(genderInput) || ("F").equalsIgnoreCase(genderInput)) {
				validInput = true;
				break;

			}

		}
		if (("M").equalsIgnoreCase(genderInput)) {

			catGender = "Male";
		} else {
			catGender = "Female";
		}

		return catGender;
	}

	public String getParrotName() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Parrot Name: ");
		String parrotName = scanner.nextLine();
		return parrotName;
	}

	public int getParrotAge() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Parrot Age: ");
		int parrotAge = Integer.parseInt(scanner.nextLine());
		return parrotAge;
	}

	public String getParrotGender() {
		Scanner scanner = new Scanner(System.in);
		boolean validInput = false;
		String genderInput = " ";
		String parrotGender = " ";
		while (validInput == false) {
			System.out.println("Enter Parrot Gender (M/F): ");
			genderInput = scanner.nextLine();
			if (("M").equalsIgnoreCase(genderInput) || ("F").equalsIgnoreCase(genderInput)) {
				validInput = true;
				break;

			}

		}
		if (("M").equalsIgnoreCase(genderInput)) {

			parrotGender = "Male";
		} else {
			parrotGender = "Female";
		}

		return parrotGender;
	}

	public String displayRemPage() {
		String remAnimalRefIdInput;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Remove Animal Page");
		System.out.println("Please enter the reference ID of the animal to remove: ");
		remAnimalRefIdInput = scanner.nextLine();
		return remAnimalRefIdInput;
	}

	public List<AnimalBean> displayViewPage(List<AnimalBean> listAnimals, AnimalShelterAppUI animalShelterUi) {
		System.out.println("View Animals Page");
		System.out.println("Meet our lovely animal friends!");
		for (AnimalBean animal : listAnimals) {
			if (animal.getAnimalType() == "Dog") {
				animalShelterUi.displayDog(animal);
			} else if (animal.getAnimalType() == "Cat") {
				animalShelterUi.displayCat(animal);
			} else {
				animalShelterUi.displayParrot(animal);
			}
		}
		return listAnimals;
	}

	public void displayDog(AnimalBean animal) {
		DogBean dog = new DogBean();
		String dogSound = dog.makeDogSound();
		System.out.println(dogSound + " ... Hi I'm " + animal.getAnimalName() + " the " + animal.getAnimalType() + ", "
				+ animal.getAnimalAge() + " yrs old and my Reference ID is " + animal.getAnimalRefID());
	}

	public void displayCat(AnimalBean animal) {
		CatBean cat = new CatBean();
		String catSound = cat.makeCatSound();
		System.out.println(catSound + " ... Hi I'm " + animal.getAnimalName() + " the " + animal.getAnimalType() + ", "
				+ animal.getAnimalAge() + " yrs old and my Reference ID is " + animal.getAnimalRefID());
	}

	public void displayParrot(AnimalBean animal) {
		ParrotBean cat = new ParrotBean();
		String parrotSound = cat.makeParrotSound();
		System.out.println(parrotSound + " ... Hi I'm " + animal.getAnimalName() + " the " + animal.getAnimalType()
				+ ", " + animal.getAnimalAge() + " yrs old and my Reference ID is " + animal.getAnimalRefID());
	}

	public boolean displayTerminationPage() {
		Scanner scanner = new Scanner(System.in);
		boolean isDone;
		boolean validInput = false;
		String continueInput = " ";
		while (validInput == false) {
			System.out.println("Welcome to JC's Animal Shelter!");
			System.out.println("The shelter is currently full");
			System.out.println("Do you want to continue? [1] Yes [2] No");
			continueInput = scanner.nextLine();
			if (("1").equals(continueInput) || ("2").equals(continueInput)) {
				validInput = true;
				break;
			}
		}
		if (("1").equals(continueInput)) {
			isDone = false;
		} else {
			isDone = true;
		}
		return isDone;

	}
}
