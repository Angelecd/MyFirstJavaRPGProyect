import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Torneo{
	int noPartida = 5;

	//Getters
	public int getnoPartida(){
		return noPartida;
	}

	//Setters
	public void setSiguientePartida(){
		noPartida--;
	}

	//Funciones
	public void seleccionarEnemigo(Character enemy){
		//Seleccion de enemigos 
		switch(getnoPartida()){
		case 1: 
			enemy.setRestoreStats("Cthulhu", 500, 50, 75, 10, 0, 0, 10);
			break;
		case 2: 
			enemy.setRestoreStats("Caballero", 200, 30, 60, 4, 0, 0, 5);
			break;
		case 3: 
			enemy.setRestoreStats("Ogro", 150, 25, 40, 5, 3, 3, 3);
			break;
		case 4: 
			enemy.setRestoreStats("Serpiente", 100, 15, 50, 6, 5, 5, 5);
			break;
		case 5: 
			enemy.setRestoreStats("Rana", 100, 10, 30, 3, 3, 3, 3);
			break;
		}
	}
}