import javax.swing.*; 
import java.awt.*;
import java.util.*;

public class Character{
	
	String nombre; 
	int vida;
	int ataque;
	int atqEsp;
	int velocidad;
	int cantPosVid;
	int cantPosAtq;
	int cantAtqEsp;

	//Getters
	public String getNombre(){
		return nombre;
	}
	public int getVida(){
		return vida;
	}
	public int getAtaque(){
		return ataque;
	}
	public int getAtqEsp(){
		return atqEsp;
	}
	public int getVelocidad(){
		return velocidad;
	}
	public int getCantPosVid(){
		return cantPosVid;
	}
	public int getCantPosAtq(){
		return cantPosAtq;
	}
	public int getCantAtqEsp(){
		return cantAtqEsp;
	}
	
	//Setters
	public void setRestoreStats(String nom, int vid, int atq, int atqE, int vel, int posV, int posA, int canAtq){
		System.out.println(nom+".setRestoreStats");
		nombre = nom; 
		vida = vid;
		ataque = atq;
		atqEsp = atqE;
		velocidad = vel;
		cantPosVid = posV;
		cantPosAtq = posA; 
		cantAtqEsp = canAtq;
	}
	public void setVida(int danio){
		System.out.println(getNombre()+"Character.setVida");
		vida -= danio;
	}
	public void setUsoPosiVid(){
		System.out.println(getNombre()+"Character.setUsoPosiVid");
		cantPosVid--;
		vida += 50;
	}
	public void setUsoPosAtq(){
		System.out.println(getNombre()+"Character.setUsoPosAtq");
		cantPosAtq--;
		ataque += 15;
		atqEsp += 15;
	}
	public void setMenosAtqEsp(){
		System.out.println(getNombre()+"Character.setMenosAtqEsp");
		cantAtqEsp--;
	}

	//Funciones
	public void ataque(Character p1, Character p2){
		System.out.println("Character.ataque");
		p2.setVida(p1.getAtaque());
	}
	public void ataqueEspecial(Character p1, Character p2){
		System.out.println("Character.ataqueEspecial");
		p2.setVida(p1.getAtqEsp());
		p1.setMenosAtqEsp();
	} 

	public void usarPocionVida(Character p){
		System.out.println("Character.usarPocionVida");
		p.setUsoPosiVid();

	}
	public void usarPocionAtaque (Character p){
		System.out.println("Character.usarPocionAtaque");
		p.setUsoPosAtq();
	}
}