import java.util.Arrays;

public class Film {

	private final String id;
	private final String name;
	private String director;
	private String[] actors = new String[0];
	private String date;
	private String info;
	private FilmTypes type; 
	private int counter = 0;

	public Film(String id, String name, String director, String[] actors, String date, String info, FilmTypes type) {
		this.id = id;
		this.name = name;
		this.director = director;
		this.date = date;
		this.info = info;
		this.type = type;
	}

	public void addActor(String name) {
		reInitializeArray();
		actors[counter] = name;
		counter++;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String[] getActors() {
		return actors;
	}

	public void setActors(String[] actors) {
		this.actors = actors;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	private void reInitializeArray() {
		String[] newActors = new String[actors.length + 1];
		System.arraycopy(actors, 0, newActors, 0, actors.length);
		actors = newActors;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", name=" + name + ", director=" + director + ", actors=" + Arrays.toString(actors)
				+ ", date=" + date + ", info=" + info + ", type=" + type + "]" + "\n";
	}

}
