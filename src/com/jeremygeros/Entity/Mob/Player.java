package com.jeremygeros.Entity.Mob;

import com.jeremygeros.Keyboard;
import com.jeremygeros.graphics.Screen;
import com.jeremygeros.graphics.Sprite;

public class Player extends Mob {
	
	private Keyboard input;
	private Sprite sprite;
	
	public Player(Keyboard input) {
		this.input = input;
		sprite = sprite.player_forward;
	}
	
	public Player(Keyboard input, int x, int y) {
		this.input = input;
		this.x = x;
		this.y = y;
		sprite = sprite.player_forward;
	}
	
	public void update() {
		int xa = 0, ya = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		
		if (xa != 0 || ya != 0) move(xa, ya);
	}
	
	public void render(Screen screen) {
		if (dir == 0) sprite = Sprite.player_forward;
		if (dir == 1) sprite = Sprite.player_right;
		if (dir == 2) sprite = Sprite.player_back;
		if (dir == 3) sprite = Sprite.player_left;
		
		screen.renderPlayer(x - 16, y - 16, sprite);
	}
}
