package com.hamit.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hamit.dao.IDaoImplements;
import com.hamit.dao.RegisterDao;
import com.hamit.dto.RegisterDto;

public class RegisterController implements IDaoImplements<RegisterDto> {
	private static final long serialVersionUID = 4810538115518987291L;
	// değişkenler
	private RegisterDao registerDao;
	private RegisterDto registerDto;
	private List<RegisterDto> registerDtoList;

	// parametresiz constructor
	public RegisterController() {
		registerDao = new RegisterDao();
		registerDto = new RegisterDto();
		list();
	}

	// Interface metotları
	@Override
	public void create(RegisterDto t) {
		System.out.println("controller create");
		this.getRegisterDao().create(t);

	}

	@Override
	public void update(RegisterDto t) {
		System.out.println("controller update");
		this.getRegisterDao().update(t);

	}

	@Override
	public void delete(long id) {
		System.out.println("controller delete");
		this.getRegisterDao().delete(id);

	}

	@Override
	public ArrayList<RegisterDto> list() {
		System.out.println("controller list");
		registerDtoList = registerDao.list();
		return (ArrayList<RegisterDto>) registerDtoList;
	}

	// sorgulama
	public boolean searchRegisterDatabase() {
		// databasesten gelen veriler
		String dbEmail = "root", dbPassword = "root";
		String email, password;
		Scanner klavye = new Scanner(System.in);
		// System.out.println("Bir tuşa basınız");
		// klavye.hasNext();

		while (3 > 1) {
			System.out.println("Lütfen email adresinizi giriniz");
			email = klavye.nextLine();
			System.out.println("Lütfen şifreniz adresinizi giriniz");
			password = klavye.nextLine();
			if ((email.equalsIgnoreCase(dbEmail)) && (password.equalsIgnoreCase(dbPassword))) {
				System.out.println("Admin panele yönlendiriliyorsunuz.");
				return true;
			} else {
				System.out.println("Şifreniz yanlış");
				return false;
			}

		}

	}

	// getter setter
	public RegisterDao getRegisterDao() {
		if (this.registerDao == null)
			this.registerDao = new RegisterDao();
		return registerDao;
	}

	public void setRegisterDao(RegisterDao registerDao) {
		this.registerDao = registerDao;
	}

	public RegisterDto getRegisterDto() {
		if (this.registerDto == null)
			this.registerDto = new RegisterDto();
		return registerDto;
	}

	public void setRegisterDto(RegisterDto registerDto) {
		this.registerDto = registerDto;
	}

	public List<RegisterDto> getRegisterDtoList() {
		return registerDtoList;
	}

	public void setRegisterDtoList(List<RegisterDto> registerDtoList) {
		this.registerDtoList = registerDtoList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
