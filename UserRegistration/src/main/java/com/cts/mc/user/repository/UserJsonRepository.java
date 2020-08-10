package com.cts.mc.user.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.cts.mc.user.vo.User;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserJsonRepository {
	ObjectMapper mapper = new ObjectMapper();

	// read json ---get UserDetail
	public void readJson(User user) {

		System.out.println(" readJson method start");

		ArrayList<User> existingUser = null;
		InputStream input;
		try {
			input = new FileInputStream("D:\\MC\\UserRegistration\\src\\main\\resources\\UserData.json");
			if (input.available() == 0) {
				System.out.println(" Json file is empty----writing first object");
				writeJson(Arrays.asList(user));
			} else {
				System.out.println("Json file is not empty ");
				List<User> usersList = Arrays.asList(mapper.readValue(input, User[].class));

				existingUser = new ArrayList<>(usersList);
				updateJson(existingUser, user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}

	// write json ---insert User

	public void writeJson(List<User> user)
			throws JsonGenerationException, JsonMappingException, FileNotFoundException, IOException {
		mapper.writeValue(new FileOutputStream("D:\\MC\\UserRegistration\\src\\main\\resources\\UserData.json"), user);
	}

	// write json ---update iser
	public void updateJson(ArrayList<User> existingUsers, User newUser) {
		System.out.println("UpdateJson method......");
		int initialSize = existingUsers.size();
		System.out.println(" Existing Json objects count " + initialSize);

		boolean[] flag = { true };
		flag[0] = false;

		if (existingUsers.size() == 0) {
			System.out.println("Json file is empty duplicate");
			existingUsers.add(newUser);
		} else {

			System.out.println(" update json method else block ");
			existingUsers.forEach(existingUser -> {
				if (existingUser.getUserId().equals(newUser.getUserId())) {
					System.out.println(" User already exists so updating it ");
					existingUser.setFirstName(newUser.getFirstName());
					existingUser.setLastName(newUser.getLastName());
					existingUser.setDob(newUser.getDob());
					existingUser.setEmail(newUser.getEmail());
//					existingUser.getProducts().addAll(newUser.getProducts());
					flag[0] = true;
				}

			});

			System.out.println(" flage is " + flag[0]);
			if (flag[0] == false) {
				System.out.println("object doesn't exists in json adding it to json ");
				existingUsers.addAll(Arrays.asList(newUser));
			}
		}

		try {
			mapper.writeValue(new FileOutputStream("D:\\MC\\UserRegistration\\src\\main\\resources\\UserData.json"),
					existingUsers);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
