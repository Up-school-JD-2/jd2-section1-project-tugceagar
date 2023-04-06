
public class FilmManager {

	private Film[] films = new Film[0];
	private int counter = 0;

	public void addFilm(Film film) {
		reInitializeArray();
		films[counter] = film;
		counter++;
		System.out.println("Film eklendi");
	}

	public Film searchFilm(String id) {
		for (int i = 0; i < counter; i++) {
			if (films[i].getId().equals(id)) {
				return films[i];
			}
		}
		return null;
	}

	public void removeFilm(String id) {
		for (int i = 0; i < counter; i++) {
			if (films[i].getId().equals(id)) {

				Film[] newFilms = new Film[films.length - 1];
				System.arraycopy(films, 0, newFilms, 0, i);
				System.arraycopy(films, i + 1, newFilms, i, films.length - i - 1);
				counter--;
				System.out.println("Film silindi.");
				films = newFilms;

			} else
				System.out.println("Film bulunamadı.");
			break;
		}
	}

	private void reInitializeArray() {
		Film[] newFilm = new Film[films.length + 1];
		System.arraycopy(films, 0, newFilm, 0, films.length);
		films = newFilm;
	}

	public void listFilms() {
		for (int i = 0; i < counter; i++) {
			System.out.println(films[i].toString());
		}
	}

}
