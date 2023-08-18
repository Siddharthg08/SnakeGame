public class GameScreen {

	private final int width;
    private final int height;
	private final char[][] screenMatrix;

	public GameScreen(int width, int height) {
		this.width = width;
		this.height = height;
		this.screenMatrix = new char[this.height][this.width];
	}

	// Fill array with dots
	public void InitScreen() {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				this.screenMatrix[i][j] = '_';
			}
		}
	}


	// Print the screen to console
	public void PrintScreen() {
//		clearConsole();
		System.out.print("\033\143");
//		System.out.print("\n \n");
//		System.out.print('\u000C');
		for (int i = 0; i < this.height; i++) {
//			System.out.print("\t\t\t");
			for (int j = 0; j < this.width; j++) {
				System.out.print(this.screenMatrix[i][j]);
			}
			System.out.println();
		}
	}

	//Screen clear location
	public void ClearScreenLocation(int x, int y) {
		this.screenMatrix[y][x] = '_';
	}

	// Getters
	public int getScreenWidth() {
		return this.width;
	}

	public int getScreenHeight() {
		return this.height;
	}

	public char getObjectOnLocation(int x, int y) {
		return this.screenMatrix[y][x];
	}

	// Setters
	public void setObjectOnLocation(GameObject object, int x, int y) {
		this.screenMatrix[y][x] = object.getSymbol();
	}
}
