import java.util.EnumSet;

public enum FilmTypes {

	FICTION, MYSTERY, ROMANCE, ACTION;

	public static FilmTypes getFilmType(String type) {
		var filmTypes = EnumSet.allOf(FilmTypes.class);
		for (FilmTypes filmType : filmTypes) {
			if (filmType.name().equalsIgnoreCase(type)) {
				return filmType;
			}
		}
		return null;
	}

}
