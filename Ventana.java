import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Ventana extends Canvas{
	JFrame frame =  new JFrame("RPG Game");
	int personajeSeleccionado;
	Partida part = new Partida();
	Torneo torneo = new Torneo();

	//Funciones 
	public void crearVentana(){
		//Declaracion de la ventana 
		//Cofiguraciones de la ventana 
		frame.setSize(500, 510);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public void seleccionarPersonaje(Character player, Character enemy){

		Container c = frame.getContentPane();
		JLabel imgGuerrero = new JLabel();
		JLabel imgArquero = new JLabel();
		JLabel imgMago = new JLabel();

		imgGuerrero.setIcon(new ImageIcon("Guerrero.png"));
		imgArquero.setIcon(new ImageIcon("Arquero.png"));
		imgMago.setIcon(new ImageIcon("Mago.png"));

		Dimension sizeG = imgGuerrero.getPreferredSize();
		Dimension sizeA = imgArquero.getPreferredSize();
		Dimension sizeM = imgMago.getPreferredSize();
		
		imgGuerrero.setBounds(50,200,sizeG.width, sizeG.height);		
		imgArquero.setBounds(200,200,sizeA.width, sizeA.height);		
		imgMago.setBounds(350,200,sizeM.width, sizeM.height);		

		JButton guerrero = new JButton("Guerrero");
		JButton arquero = new JButton("Arquero");
		JButton mago = new JButton("Mago");

		guerrero.setBounds(50,400,100,30);
		arquero.setBounds(200,400,100,30);
		mago.setBounds(350,400,100,30);

		c.add(imgGuerrero);
		c.add(imgArquero);
		c.add(imgMago);

		frame.add(guerrero);
		frame.add(arquero);
		frame.add(mago);

		guerrero.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				player.setRestoreStats("Guerrero", 1000, 20, 30, 5, 3, 3, 3);
				guerrero.setVisible(false); arquero.setVisible(false); mago.setVisible(false);
				imgGuerrero.setVisible(false); imgArquero.setVisible(false); imgMago.setVisible(false);
				torneo.seleccionarEnemigo(enemy);
				pantallaDePartida(player,enemy);
			}
		});
		arquero.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				player.setRestoreStats("Arquero", 80, 15, 25, 8, 5, 5, 3);
				guerrero.setVisible(false); arquero.setVisible(false); mago.setVisible(false);
				imgGuerrero.setVisible(false); imgArquero.setVisible(false); imgMago.setVisible(false);
				torneo.seleccionarEnemigo(enemy);
				pantallaDePartida(player,enemy);			}
		});
		mago.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				player.setRestoreStats("Mago", 50, 10, 50, 7, 3, 3, 5);
				guerrero.setVisible(false); arquero.setVisible(false); mago.setVisible(false);
				imgGuerrero.setVisible(false); imgArquero.setVisible(false); imgMago.setVisible(false);
				torneo.seleccionarEnemigo(enemy);
				pantallaDePartida(player,enemy);
			}
		});
	}

	public void pantallaDePartida(Character p1, Character p2){
		// 
		Container c = frame.getContentPane();

		JLabel imgGuerrero = new JLabel();
		JLabel imgArquero = new JLabel();
		JLabel imgMago = new JLabel();

		JLabel imgRana = new JLabel();
		JLabel imgSerpiente = new JLabel();
		JLabel imgOgro = new JLabel();
		JLabel imgCaballero = new JLabel();
		JLabel imgCthulhu = new JLabel();
		
		imgGuerrero.setIcon(new ImageIcon("Guerrero.png"));
		imgArquero.setIcon(new ImageIcon("Arquero.png"));
		imgMago.setIcon(new ImageIcon("Mago.png"));

		imgRana.setIcon(new ImageIcon("Rana.png"));
		imgSerpiente.setIcon(new ImageIcon("Serpiente.png"));
		imgOgro.setIcon(new ImageIcon("ogro.png"));
		imgCaballero.setIcon(new ImageIcon("Caballero.png"));
		imgCthulhu.setIcon(new ImageIcon("cutulu.png"));

		Dimension sizeG = imgGuerrero.getPreferredSize();
		Dimension sizeA = imgArquero.getPreferredSize();
		Dimension sizeM = imgMago.getPreferredSize();

		Dimension sizeR = imgRana.getPreferredSize();
		Dimension sizeS = imgSerpiente.getPreferredSize();
		Dimension sizeO = imgOgro.getPreferredSize();
		Dimension sizeCa = imgCaballero.getPreferredSize();
		Dimension sizeCu = imgCthulhu.getPreferredSize();
		
		imgGuerrero.setBounds(20,150,sizeG.width, sizeG.height);		
		imgArquero.setBounds(20,150,sizeA.width, sizeA.height);		
		imgMago.setBounds(20,150,sizeM.width, sizeM.height);		

		imgRana.setBounds(300,150,sizeR.width, sizeR.height);		
		imgSerpiente.setBounds(300,150,sizeS.width, sizeS.height);	

		imgOgro.setBounds(300,150,sizeO.width, sizeO.height);		
		imgCaballero.setBounds(300,150,sizeCa.width, sizeCa.height);		
		imgCthulhu.setBounds(200,150,sizeCu.width, sizeCu.height);	

		if (p1.getVida() > 0 && p2.getVida() > 0) {
			
			if (p1.getNombre() == "Guerrero") {
				c.add(imgGuerrero);
			} else if (p1.getNombre() == "Arquero") {
				c.add(imgArquero);
			} else if (p1.getNombre() == "Mago") {
				c.add(imgMago);
			}		

			if (p2.getNombre() == "Rana") {
				c.add(imgRana);
			} else if (p2.getNombre() == "Serpiente") {
				c.add(imgSerpiente);
			} else if (p2.getNombre() == "Ogro") {
				c.add(imgOgro);
			} else if (p2.getNombre() == "Caballero") {
				c.add(imgCaballero);
			} else if (p2.getNombre() == "Cthulhu") {
				c.add(imgCthulhu);
			}			
			
			JLabel no = new JLabel(p1.getNombre());
			JLabel at = new JLabel("Ataque: " + p1.getAtaque());
			JLabel vi = new JLabel("Vida: " + p1.getVida());
			JLabel es = new JLabel("Especial " + p1.getAtqEsp()+" ATQ: " + p1.getCantAtqEsp());
			JLabel pv = new JLabel("Pocion Vida   +50: " + p1.getCantPosVid());
			JLabel pa = new JLabel("Pocion Ataque +15: " + p1.getCantPosAtq());

			JLabel noE = new JLabel(p2.getNombre());
			JLabel atE = new JLabel("Ataque: " + p2.getAtaque());
			JLabel viE = new JLabel("Vida: " + p2.getVida());
			JLabel esE = new JLabel("Especial " + p2.getAtqEsp()+" ATQ: " + p2.getCantAtqEsp());
			JLabel pvE = new JLabel("Pocion Vida   +50: " + p2.getCantPosVid());
			JLabel paE = new JLabel("Pocion Ataque +15: " + p2.getCantPosAtq());

			JButton uAt = new JButton("Atacar");
			JButton uAE = new JButton("Especial");
			JButton uPV = new JButton("P. Vida");
			JButton uPF = new JButton("P. Fuerza");
			
			no.setBounds( 20,   0,200,30); vi.setBounds(20,20,200,30); 
			at.setBounds( 20,  35,200,30); es.setBounds(20,50,200,30); 
			pv.setBounds( 20,  65,200,30); pa.setBounds(20,80,200,30);

			noE.setBounds(330,  0,200,30); viE.setBounds(330,20,200,30); 
			atE.setBounds(330, 35,200,30); esE.setBounds(330,50,200,30); 
			pvE.setBounds(330, 65,200,30); paE.setBounds(330,80,200,30);
			
			uAt.setBounds( 20,400,115,30); uAE.setBounds(140,400,115,30);
			uPV.setBounds(260,400,115,30); uPF.setBounds(380,400,115,30);

			uAt.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					part.primerTurno(p1, p2, 1);

					no.setVisible(false);   at.setVisible(false);  vi.setVisible(false); 
					es.setVisible(false);   pv.setVisible(false);  pa.setVisible(false);

					noE.setVisible(false); atE.setVisible(false); viE.setVisible(false);  
					esE.setVisible(false); pvE.setVisible(false); paE.setVisible(false);

					uAt.setVisible(false); uAE.setVisible(false); uPV.setVisible(false); uPF.setVisible(false);

					imgGuerrero.setVisible(false);imgArquero.setVisible(false);imgMago.setVisible(false); 
					imgRana.setVisible(false); imgSerpiente.setVisible(false); imgOgro.setVisible(false);imgCaballero.setVisible(false); imgCthulhu.setVisible(false); 

					pantallaDePartida(p1,p2);
				}
			});
			uAE.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					part.primerTurno(p1, p2, 2);

					no.setVisible(false);   at.setVisible(false);  vi.setVisible(false);  
					es.setVisible(false);   pv.setVisible(false);  pa.setVisible(false);

					noE.setVisible(false); atE.setVisible(false); viE.setVisible(false);  
					esE.setVisible(false); pvE.setVisible(false); paE.setVisible(false);	

					uAt.setVisible(false); uAE.setVisible(false); uPV.setVisible(false); uPF.setVisible(false);

					imgGuerrero.setVisible(false);imgArquero.setVisible(false);imgMago.setVisible(false); 
					imgRana.setVisible(false); imgSerpiente.setVisible(false); imgOgro.setVisible(false);imgCaballero.setVisible(false); imgCthulhu.setVisible(false); 

					pantallaDePartida(p1,p2);
				}
			});
			uPV.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					part.primerTurno(p1, p2, 3);

					no.setVisible(false);   at.setVisible(false);  vi.setVisible(false); 
					es.setVisible(false);   pv.setVisible(false);  pa.setVisible(false);

					noE.setVisible(false); atE.setVisible(false); viE.setVisible(false);  
					esE.setVisible(false); pvE.setVisible(false); paE.setVisible(false);

					uAt.setVisible(false); uAE.setVisible(false); uPV.setVisible(false); uPF.setVisible(false);

					imgGuerrero.setVisible(false);imgArquero.setVisible(false);imgMago.setVisible(false); 
					imgRana.setVisible(false); imgSerpiente.setVisible(false); imgOgro.setVisible(false);imgCaballero.setVisible(false); imgCthulhu.setVisible(false); 

					pantallaDePartida(p1,p2);
				}
			});
			uPF.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					part.primerTurno(p1, p2, 4);

					no.setVisible(false);   at.setVisible(false);  vi.setVisible(false); 
					es.setVisible(false);   pv.setVisible(false);  pa.setVisible(false);

					noE.setVisible(false); atE.setVisible(false); viE.setVisible(false);  
					esE.setVisible(false); pvE.setVisible(false); paE.setVisible(false);

					uAt.setVisible(false); uAE.setVisible(false); uPV.setVisible(false); uPF.setVisible(false);

					imgGuerrero.setVisible(false);imgArquero.setVisible(false);imgMago.setVisible(false); 
					imgRana.setVisible(false); imgSerpiente.setVisible(false); imgOgro.setVisible(false);imgCaballero.setVisible(false); imgCthulhu.setVisible(false); 

					pantallaDePartida(p1,p2);
				}
			});
			frame.add(no);  frame.add(at);  frame.add(vi);  frame.add(es);  frame.add(pv);  frame.add(pa);
			frame.add(noE); frame.add(atE); frame.add(viE); frame.add(esE); frame.add(pvE); frame.add(paE); 
			frame.add(uAt); frame.add(uAE); frame.add(uPV); frame.add(uPF); 
		}else{
			if (p1.getNombre() == "Guerrero") {
				p1.setRestoreStats("Guerrero", 1000, 20, 30, 5, 3, 3, 3);
			} else if (p1.getNombre() == "Arquero"){
				p1.setRestoreStats("Arquero", 1000, 20, 30, 5, 3, 3, 3);
			} else if (p1.getNombre() == "Mago"){
				p1.setRestoreStats("Mago", 1000, 20, 30, 5, 3, 3, 3);
			}
			torneo.setSiguientePartida();
			torneo.seleccionarEnemigo(p2);
			pantallaDeCambio(p1, p2);
		}
	}

	public void pantallaDeCambio(Character p1, Character p2){
		if (torneo.getnoPartida() > 0) {
			JButton next = new JButton("Siguiente nivel");
			next.setBounds(100,300,300,30);
			frame.add(next);

			next.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					pantallaDePartida(p1,p2);
					next.setVisible(false);
				}
			});

		} else {

			JLabel end  = new JLabel("                         Felicidades!!!");
			JLabel end2 = new JLabel("            Conseguiste pasar el juego!!");
			JButton close = new JButton("Cerrar");

			end.setBounds(100,250,300,30);
			end2.setBounds(100,300,300,30);
			close.setBounds(100,350,300,30);

			close.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					frame.setVisible(false);
				}
			});

			frame.add(end);
			frame.add(end2);
			frame.add(close);
		}
	}
}	