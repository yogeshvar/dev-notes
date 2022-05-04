 package org.tektutor.menuwebservice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
	
	
	@GetMapping("/welcome")
	@ResponseBody
	public String sayWelcome(@RequestParam String firstName,@RequestParam String secondName) {
		return "Welcome to Vikas Maggi Plaza, " + firstName + " " + secondName;
	}

	@GetMapping("/starter")
	@ResponseBody
	public HashMap<Integer,String> getStarter(){
		HashMap<Integer,String> starterList=new HashMap<Integer,String>();
		starterList.put(101, "Garlic Paneer");
		starterList.put(102, "Paneer 65");
		starterList.put(103, "Paneer Cutlet");
		starterList.put(104, "Bharwan Paneer");
		starterList.put(105, "Paneer Tikka");
		return starterList;
	}
  
	@GetMapping("/combos")
	@ResponseBody
	public HashMap<Integer,String> getCombos(){
		HashMap<Integer,String> combosList=new HashMap<Integer,String>();
		combosList.put(101, "Jumbo Thali");
		combosList.put(102, "Normal Thali");
		combosList.put(103, "Mini Meal");
		combosList.put(104, "Deluxe Thali");
		combosList.put(105, "Bahubali Thali");
		return combosList;
  }

	@GetMapping("/getDrinks")
	@ResponseBody
	public HashMap<Integer,String> getDrinks(){
		HashMap<Integer,String> drinkList=new HashMap<Integer,String>();
		drinkList.put(200, "BIRA Strong");
		drinkList.put(160, "Carlsberg Strong");
		drinkList.put(120, "Kingfisher Strong");
		drinkList.put(140, "Tuborg Strong");
		drinkList.put(30, "Water");
		return drinkList;
	}
	
	@GetMapping("/getMenus")
	@ResponseBody
	public HashMap<Integer,String> getMenus() {
		HashMap<Integer,String> foodList = new HashMap<Integer,String>();
		foodList.put(1,"Butter Chicken");
		foodList.put(2,"Kadai Chicken");
		foodList.put(3,"Do Pyaaza chicken");
		foodList.put(4,"Afghani Chicken");
		foodList.put(5,"Tandoori Chicken");
		foodList.put(6,"Mushroom chicken");
		foodList.put(7,"Butter Roti");
		foodList.put(8,"Twa Roti");
		foodList.put(9,"Tandoori Roti");
		foodList.put(10,"Aaloo Naan");
		foodList.put(18, "Gobhi Naan");	
		foodList.put(11,"Spicy Panner Maggi");
		foodList.put(12,"Spicy Maggi");
		foodList.put(13,"Masala Maggi");
		foodList.put(14,"Egg Maggi");
		foodList.put(15,"Atta Maggi");
		foodList.put(16,"Vegetable Maggi");
		foodList.put(17,"Corn Maggi");
		foodList.put(18,"Mushroom Maggi");
		foodList.put(19,"Plain Maggi");
		foodList.put(110,"Spicy Masala Maggi");
		foodList.put(118, "Ice cream");	
		foodList.put(119, "pizza maggi");
		foodList.put(183, "choco cream");	
    return foodList;
	}
	

	@GetMapping("/getIceCream")
	@ResponseBody
	public HashMap<Integer,String> getIceCream() {
		HashMap<Integer,String> iceCreamList = new HashMap<Integer,String>();
		iceCreamList.put(1,"Vanilla");
		iceCreamList.put(1,"Butter Scotch");
		iceCreamList.put(1,"Chocolate");	
		return iceCreamList;
	}
	
	@GetMapping("/getDesserts")
	@ResponseBody
	public HashMap<Integer, String> getDesserts(){
		HashMap<Integer, String> dessertList = new HashMap<Integer, String>();
		dessertList.put(1, "Raspberry Bars");
		dessertList.put(2, "Mint Oreo Cake");
		dessertList.put(3, "Gooey Brownies");
		dessertList.put(4, "Kulfi");
		dessertList.put(5, "Coco Cake");
		dessertList.put(6, "Gulab Jamun");
		dessertList.put(7, "Pomegranate Cake");
		dessertList.put(8, "Nutellan chips");
		dessertList.put(9, "Shahi Tukda");
		dessertList.put(10, "Kaju ki Barfi");
		dessertList.put(11, "Banana Pudding");
		dessertList.put(12, "Gajar Ka Halwa");
		dessertList.put(13, "Aam Shrikhand");
		dessertList.put(15, "Nutella Brownies");
		dessertList.put(16, "Modak");
		
		return dessertList;
	}
	
	@GetMapping("/getMenusWithPrice")
	@ResponseBody
	public HashMap<Integer,HashMap<String, Integer>> getMenus1() {
		HashMap<Integer,HashMap<String, Integer>> foodList = new HashMap<>();
		HashMap<String, Integer> spicyPanner = new HashMap<>();
		spicyPanner.put("Spicy Paneer", 190);
		foodList.put(1,spicyPanner);
		HashMap<String, Integer> spicyMaggi = new HashMap<>();
		spicyMaggi.put("Spicy Maggi", 100);
		foodList.put(2,spicyMaggi);
		HashMap<String, Integer> masalaMaggi = new HashMap<>();
		masalaMaggi.put("Masala Maggi", 120);
		foodList.put(3,masalaMaggi);
		HashMap<String, Integer> eggMaggi = new HashMap<>();
		eggMaggi.put("Egg Maggi", 180);
		foodList.put(4,eggMaggi);
		HashMap<String, Integer> attaMaggi = new HashMap<>();
		attaMaggi.put("Atta Maggi", 140);
		foodList.put(5,attaMaggi);
		HashMap<String, Integer> vegetableMaggi = new HashMap<>();
		vegetableMaggi.put("Vegitable Maggi", 150);
		foodList.put(6,vegetableMaggi);
		HashMap<String, Integer> cornMaggi = new HashMap<>();
		cornMaggi.put("Corn Maggi", 160);
		spicyPanner.put("Corn Maggi", 160);
		foodList.put(7,cornMaggi);
		HashMap<String, Integer> mushroomMaggi = new HashMap<>();
		mushroomMaggi.put("Mushroom Maggi", 190);
		foodList.put(8,mushroomMaggi);
		HashMap<String, Integer> plainMaggi = new HashMap<>();
		plainMaggi.put("Plain Maggi", 80);
		foodList.put(9,plainMaggi);
		HashMap<String, Integer> spicyMasalaMaggi = new HashMap<>();
		spicyMasalaMaggi.put("Spicy Masala Maggi", 90);
		foodList.put(10,spicyMasalaMaggi);
		return foodList;
	}
	@GetMapping("/burger")
	@ResponseBody
	public HashMap<Integer,String> getBurger(){
		HashMap<Integer,String> burgerList=new HashMap<Integer,String>();
		burgerList.put(50, "Paneer Burger");
		burgerList.put(51, "Aloo Tikki Burger");
		burgerList.put(52, "Veg Burger");
		burgerList.put(53, "Corn Burger");
		burgerList.put(54, "Maharaja Burger");
		return burgerList;
	}
	
	@GetMapping("/getDetailedMenu")
	@ResponseBody
	public HashMap<Integer, String[]> getDetailedMenu(){
		
		HashMap<Integer, String[]> foodItemData = new HashMap<Integer,String[]>();
		
		try {
			BufferedReader inputReader = new BufferedReader(new FileReader("src/main/resources/food_item.txt"));
			String input_string = "";
			
			while((input_string = inputReader.readLine())!= null) {
				String[] foodData = input_string.split(" ");
				foodItemData.put(Integer.parseInt(foodData[0]), Arrays.copyOfRange(foodData, 1, foodData.length));
				
			}
			inputReader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foodItemData;
		
	}
	
	@GetMapping("/getFoodItemsWithIngredient")
	@ResponseBody
	public HashMap<Integer, String[]> getFoodItemsWithIngredient(String stringKey){
		
		HashMap<Integer, String[]> foodData = getDetailedMenu();
		HashMap<Integer,String[]> filteredData = new HashMap<Integer,String[]>();
		
		for(int key:foodData.keySet()) {
			
			if (foodData.get(key)[0].contains(stringKey)) {
				filteredData.put(key, foodData.get(key));
			}
		}
		
		return filteredData;
		
	}
	
	
	
	@GetMapping("/getChickenMainCourse")
	@ResponseBody
	public HashMap<Integer,HashMap<String, Integer>> getMenus2() {
		HashMap<Integer,HashMap<String, Integer>> foodList = new HashMap<>();
		HashMap<String, Integer> chickenHandi = new HashMap<>();
		chickenHandi.put("Chicken Handi", 190);
		foodList.put(1,chickenHandi);
		HashMap<String, Integer> chickenKadhai = new HashMap<>();
		chickenKadhai.put("Chicken Kadhai", 100);
		foodList.put(2,chickenKadhai);
		HashMap<String, Integer> chickenLassoni = new HashMap<>();
		chickenLassoni.put("Chicken Lassoni", 120);
		foodList.put(3,chickenLassoni);
		HashMap<String, Integer> chickenMalabar = new HashMap<>();
		chickenMalabar.put("Chicken Malabar", 180);
		foodList.put(4,chickenMalabar);
		HashMap<String, Integer> chickenMasala = new HashMap<>();
		chickenMasala.put("Chicken Masala", 140);
		foodList.put(5,chickenMasala);
		HashMap<String, Integer> chickenCurry = new HashMap<>();
		chickenCurry.put("Chicken Curry", 150);
		foodList.put(6,chickenCurry);
		return foodList;
	}
	
}
