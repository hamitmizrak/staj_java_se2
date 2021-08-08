package com.hamit.main;

import java.util.Scanner;

import com.hamit.controller.RegisterController;
import com.hamit.dto.RegisterDto;

public class BankMain {

	// controler
 
	RegisterController controller = new RegisterController();

	// create
	// RegisterDto dto = new RegisterDto("adi", "soyadi", "email3@gmail.com", "root", "admin");
	// controller.create(dto);

	// delete
	// controller.delete(9);

	// update
	// RegisterDto dto = new RegisterDto(4, "adi44", "soyadi44", "email44@gmail.com", "root44", "admin");
	// controller.update(dto);

	// select
	// for (RegisterDto registerDto : controller.list()) {
	// System.out.println(registerDto);
	// }

	public static void main(String[] args) {

		RegisterController controller = new RegisterController();
		boolean result = controller.searchRegisterDatabase();
		// boolean result = true;

		// user
		// 1-) Para ekle
		// 2-) Hesaptan para Çek
		// 3-) Hesabımı sil
		// 4-) Para listeleme (para çekmek) , Loglama
		// 5-) Email gönder
		//

		while (true) {
			if (result) {
				System.out.println("Lütfen bir seçim yapınız");
				System.out.println("1-) Create  \n2-) Delete \n3-) update \n4-) Listeleme \n5- Çıkış");
				Scanner klavye = new Scanner(System.in);
				String chooise = klavye.nextLine();

				switch (chooise) {
					case "1":
						String adi, soyadi, email, sifre, role;
						System.out.println("lütfen adınızı giriniz");
						adi = klavye.nextLine();
						System.out.println("lütfen soyadınızı giriniz");
						soyadi = klavye.nextLine();
						System.out.println("lütfen emailiniz giriniz");
						email = klavye.nextLine();
						System.out.println("lütfen şifrenizi giriniz");
						sifre = klavye.nextLine();
						System.out.println("lütfen role");
						role = klavye.nextLine();
						RegisterDto dto = new RegisterDto(adi, soyadi, email, sifre, role);
						controller.create(dto);
						break;

					case "2":
						for (RegisterDto registerDto : controller.list()) {
							System.out.println(registerDto);
						}
						System.out.println("silmek istediğiniz id'yi giriniz");
						int id = klavye.nextInt();
						controller.delete(id);
						break;

					case "3":
						for (RegisterDto registerDto : controller.list()) {
							System.out.println(registerDto);
						}
						String uadi, usoyadi, uemail, usifre, urole;
						int uid;
						System.out.println("lütfen güncelenecek id giriniz");
						uid = klavye.nextInt();
						System.out.println("lütfen güncelenecek adınızı giriniz");
						uadi = klavye.nextLine();
						System.out.println("lütfen güncelenecek soyadınızı giriniz");
						usoyadi = klavye.nextLine();
						System.out.println("lütfen güncelenecek emailiniz giriniz");
						uemail = klavye.nextLine();
						System.out.println("lütfen güncelenecek şifrenizi giriniz");
						usifre = klavye.nextLine();
						System.out.println("lütfen güncelenecek role");
						urole = klavye.nextLine();

						RegisterDto update = new RegisterDto(uid, uadi, usoyadi, uemail, usifre, urole);
						controller.update(update);
						break;

					case "4":
						for (RegisterDto registerDto : controller.list()) {
							System.out.println(registerDto);
						}
						break;

					case "5":
						System.out.println("Çıkış yapılıyor");
						System.exit(0);
						break;

					default:
						System.out.println("Lütfen belirtilen aralıkta giriş yapınız");
						break;
				}
			} else {
				System.out.println("Username veya parolanız yanlıştır.");
			}
		}
	}

}
