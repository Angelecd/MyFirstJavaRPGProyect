import javax.swing.*; 
import java.awt.*;
import java.util.*;

public class RPG{
	public static void main(String[] args) {

		Ventana ven =  new Ventana();
		
		Character player = new Character();
		Character enemy = new Character();
		
		ven.crearVentana();
		ven.seleccionarPersonaje(player, enemy);

	}
}