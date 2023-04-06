import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		int userCounter = 0;
		int filmCounter = 1;

		FilmManager filmManager = new FilmManager();
		UserManager userManager = new UserManager();
		String[] actors = new String[0];
		Film film;
		do {
			boolean userStatus = false;
			System.out.println("1. Giriş Yap");
			System.out.println("2. Hesap Ekle");
			System.out.println("3. Çıkış");
			int choice = sc.nextInt();

			switch (choice) {
			case 1 -> {
				sc.nextLine();
				System.out.println("Kullanıcı adı giriniz: ");
				String name = sc.nextLine();
				System.out.println("Şifre giriniz: ");
				String password = sc.nextLine();
				if (userManager.userLogin(name, password) == 0) {
					do {
						System.out.println("1. Hesapları görüntüle");
						System.out.println("2. Filmleri listele");
						System.out.println("3. Film ekle");
						System.out.println("4. Film ara");
						System.out.println("5. Film sil");
						System.out.println("6. Kullanıcı hesap ara");
						System.out.println("7. Kullanıcı hesap sil");
						System.out.println("8. Kullanıcı Çıkışı");
						System.out.println("9. Çıkış");
						int choice2 = sc.nextInt();

						switch (choice2) {

						case 1 -> {
							System.out.println("-----KULLANICILAR-----");
							userManager.listUsers();
						}
						case 2 -> {
							System.out.println("-----FİLMLER-----");
							filmManager.listFilms();
						}
						case 3 -> {
							sc.nextLine();
							System.out.println("Eklemek istediğiniz film adını giriniz: ");
							String filmName = sc.nextLine();
							System.out.println("Filmin yönetmenini giriniz: ");
							String director = sc.nextLine();
							System.out.println("Tarihini giriniz:");
							String date = sc.nextLine();
							System.out.println("Bilgilerini giriniz:");
							String info = sc.nextLine();
							System.out.println("Türünü seçiniz : FICTION, MYSTERY, ROMANCE, ACTION");
							var type = sc.next();
							var filmType = FilmTypes.getFilmType(type);
							if (filmType == null)
								System.out.println("Hatalı giriş yaptınız.");
							film = new Film(Integer.toString(filmCounter), filmName, director, actors, date, info,
									filmType);
							sc.nextLine();
							System.out.println("Filmin aktörlerini araya virgül koyarak giriniz: ");
							String actors1 = sc.nextLine();
							String[] array = actors1.split(",");
							for (String s : array)
								film.addActor(s);
							filmCounter++;
							filmManager.addFilm(film);
						}
						case 4 -> {
							sc.nextLine();
							System.out.println("Aranacak filmin id sini giriniz");
							String id = sc.nextLine();
							filmManager.searchFilm(id);
							if (filmManager.searchFilm(id) != null) {
								System.out.println("Film bulundu");
								System.out.println(filmManager.searchFilm(id).toString());
							} else
								System.out.println("Film bulunamadı");
						}
						case 5 -> {
							sc.nextLine();
							System.out.println("Silmek istediğiniz filmin id sini giriniz: ");
							String id = sc.nextLine();
							filmManager.removeFilm(id);

						}
						case 6 -> {
							sc.nextLine();
							System.out.println("Aranacak kullanıcının id sini giriniz: ");
							String id = sc.nextLine();
							userManager.searchUser(id);
							if (userManager.searchUser(id) != null) {
								System.out.println("Kullanıcı bulundu.");
								System.out.println(userManager.searchUser(id).toString());
							} else
								System.out.println("Kullanıcı bulunamadı.");
						}
						case 7 -> {
							sc.nextLine();
							System.out.println("Silmek istediğiniz kullanıcı id giriniz");
							String id = sc.nextLine();
							userManager.removeUser(id);
						}
						case 8 -> {
							userStatus = true;
						}
						case 9 -> {
							quit = true;
						}
						}
					} while (userStatus != true && quit != true);
				} else {
					System.out.println("Hatalı Giriş.");
					continue;
				}

			}
			case 2 -> {
				sc.nextLine();
				System.out.println("Kullanıcı adı giriniz: ");
				String name = sc.nextLine();
				System.out.println("E-mail giriniz: ");
				String email = sc.nextLine();
				System.out.println("Şifre oluşturunuz: ");
				String password = sc.nextLine();
				userCounter++;
				User user = new User(Integer.toString(userCounter), name, email, password);
				userManager.addUser(user);
			}
			case 3 -> {
				quit = true;
			}
			}

		} while (quit != true);

	}

}
