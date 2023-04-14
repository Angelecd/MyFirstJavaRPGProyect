import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;

public class Partida{

	//Funciones
	public void primerTurno(Character p1, Character p2, int mov){
		if (p1.getVelocidad() > p2.getVelocidad()) {
			turno(p1, p2, false, mov);
			turno(p2, p1, true, mov);
			//pantallaDePartida(p1,p2);
		} else {
			turno(p2, p1, true, mov);
			turno(p1, p2, false, mov);
		}
	}	
	
	public void turno(Character p1, Character p2, boolean npc, int mov){
		boolean movimientoValido = true;		
		do{
			int ran = (int)(Math.random()*((4-1)+1))+1;
			//Ingresa dato para escojer movimiento
			if (npc == false) {
				System.out.println(p1.getAtqEsp());
				System.out.println("Ingresa un  movimiento: 1. Ataque 2. Ataque especial 3. Pos vida 3. Pos ataque");
			}else {
				mov = ran;
			}

			switch (mov){
			case 1:
				p1.ataque(p1, p2);
				movimientoValido = true;
				break;
			case 2: 
				if (p1.getCantAtqEsp() > 0){
					p1.ataqueEspecial(p1, p2);
					movimientoValido = true;
				}else{
					if(npc==false)
						System.out.println("Ya no tienes ataques especiales");
					movimientoValido = false;
				}
				break;
			case 3: 
				if (p1.getCantPosVid() > 0){
					p1.usarPocionVida(p1);
					movimientoValido = true;
				}else{
					if(npc==false)
						System.out.println("Ya no tienes pociones de vida");
					movimientoValido = false;
				}
				break;
			case 4: 
				if (p1.getCantPosAtq() > 0){
					p1.usarPocionAtaque(p1);
					movimientoValido = true;
				}else{
					if(npc==false)
						System.out.println("Ya no tienes pociones de ataque");
					movimientoValido = false;
				}
				break;
			}
		}while(movimientoValido == false);
	}
}