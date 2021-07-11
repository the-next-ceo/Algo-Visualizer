import java.awt.Color;

public enum Colors {
	//grey						//green					//pink				//black			//blue			//red
	INACTIVE(191, 191, 191), SORTED(87, 232, 14), TARGET(255, 51, 204), ACTIVE(8,8,8), LOWER(12,94,245), UPPER(205,21,0);

	private final Color col;

	Colors(int r, int g, int b) {
		col = new Color(r, g, b);
	}

	public Color get() {
		return col;
	}
}
