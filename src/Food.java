public class Food extends GameObject {

	public Food(char symbol) {
		setSymbol(symbol);
	}
		private int posX;
		private int posY;

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}


	// Add food to random location inside the matrix limits
	public void addRandomFood(GameScreen screen, Food food) {
		posX=(int)(Math.random() * (screen.getScreenWidth() - 2))+1;
		posY=(int) (Math.random() * (screen.getScreenHeight() - 2))+1;
		screen.setObjectOnLocation(food, posX, posY);
	}
}
