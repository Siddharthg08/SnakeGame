import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Main {

	public static boolean checkWall(GameScreen screen, Snake snake){
		if(snake.getX()==0 || snake.getY()==0 || snake.getY()== screen.getScreenHeight()-1 ||snake.getX()== screen.getScreenWidth()-1){
			System.out.println("Game over!!!");
			return true;
		}
		return false;

	}

	public static void main(String[] args) {

		// Constants
		final int SCREEN_WIDTH = 30; // Columns
		final int SCREEN_HEIGHT = 10; // Rows
		final int SNAKE_STARTING_X = SCREEN_WIDTH / 2;
		final int SNAKE_STARTING_Y = SCREEN_HEIGHT / 2;

		// Init screen
		GameScreen screen = new GameScreen(SCREEN_WIDTH, SCREEN_HEIGHT);
		screen.InitScreen();

		// Init walls
		Wall wall = new Wall('|');
		wall.addWallsRow(screen, wall, 0); // First row
		wall.addWallsRow(screen, wall, screen.getScreenHeight() - 1); // Last
																		// row
		wall.addWallsColumn(screen, wall, 0); // First column
		wall.addWallsColumn(screen, wall, screen.getScreenWidth() - 1); // Last
																		// column

		// Init player
		Snake snake = new Snake('S', SNAKE_STARTING_X, SNAKE_STARTING_Y);
		screen.setObjectOnLocation(snake, snake.getX(), snake.getY());

		// Init food
		Food food = new Food('F');
		food.addRandomFood(screen, food);
		
		// Input from player
		Scanner scanner = new Scanner(System.in);
		char input;

		// The game logic starts here
		boolean isRunning = true;

		while (isRunning) {

			screen.PrintScreen();

			if(food.getPosX() == snake.getX() && food.getPosY() == snake.getY()){
				System.out.println("You Won");
				isRunning = false;
				return;
			}
			if(checkWall(screen,snake)){
				return;
			}
			// Get input from player and do something
			switch (input = scanner.nextLine().charAt(0)) {
			case 'a':
				snake.moveLeft(screen, snake);
				break;
			case 'd':
				snake.moveRight(screen, snake);
				break;
			case 'w':
				snake.moveUp(screen, snake);
				break;
			case 's':
				snake.moveDown(screen, snake);
				break;
			}
		}
	}

//	private static boolean checkWall(GameScreen screen, Snake snake) {
//	}

}
