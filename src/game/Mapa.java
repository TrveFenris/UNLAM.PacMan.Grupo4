package game;

import gameobject.Bolita;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JPanel;

import punto.Punto;
import rectas.Recta;
import rectas.Recta.RectaInvalidaException;
import rectas.Rectas;


public class Mapa implements Serializable {

	private static final long serialVersionUID = -1003977761766317877L;
	private ArrayList<Recta> rectas;
	private ArrayList<Bolita> bolitas;
	private ArrayList<Punto> puntos;
	private ArrayList<Punto> puntosExtremos;
	
	
	/**
	 * Genera un mapa por defecto.
	 */
	@Deprecated
	public Mapa() {
		rectas = new ArrayList<Recta>();
		bolitas = new ArrayList<Bolita>();
		agregarRecta(new Punto(30,50), new Punto(30,530));
		agregarRecta(new Punto(30,530), new Punto(730,530));
		agregarRecta(new Punto(730,50), new Punto(730,530));
		agregarRecta(new Punto(370,50), new Punto(370,530));
		agregarRecta(new Punto(30,290), new Punto(730,290));
		agregarRecta(new Punto(30,50), new Punto(730,50));
		agregarRecta(new Punto(250,30), new Punto(250,500));
		agregarRecta(new Punto(100,150), new Punto(600,150));
		agregarRecta(new Punto(550,34), new Punto(550,550));
		agregarRecta(new Punto(200,470), new Punto(500,470));
		agregarRecta(new Punto(200,450), new Punto(500,470)); //Recta de prueba, no se agrega porque es oblicua
	}
	
	/**
	 * Carga un mapa creado previamente.
	 * Los mapas deben estar guardados en la carpeta "maps/", el nombre debe ser ingresado sin extension.
	 * @param nombre -El nombre del mapa
	 */
	public Mapa(String nombre){
		puntos = new ArrayList<Punto>();
		puntosExtremos = new ArrayList<Punto>();
		rectas = new ArrayList<Recta>();
		bolitas = new ArrayList<Bolita>();
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    try {
	    	archivo = new File ("maps/"+nombre+".pacmap");
	    	fr = new FileReader (archivo);
	    	br = new BufferedReader(fr);
	    	String linea = br.readLine();
	    	String[] datos;
	    	int cantRectas = Integer.parseInt(linea);
	    	for(int i=0;i<cantRectas;i++){
	    		linea = br.readLine();
	    		datos = linea.split(" ");
	    		agregarRecta(new Punto(Integer.parseInt(datos[0]),Integer.parseInt(datos[1])), new Punto(Integer.parseInt(datos[2]),Integer.parseInt(datos[3])));
	    	}
	    	inicializarPuntos();
	    	inicializarPuntosExtremos();
	    }
	    catch(Exception e){
	    	System.out.println("Error al cargar el mapa");
	    }
	    finally{
	    	try{                    
	    		if( null != fr ){   
	    			fr.close();     
	    		}                  
	    	}
	    	catch (Exception e2){ 
	    		System.out.println("Error al cerrar el archivo");
	    	}
	    }
	}
	
	public ArrayList<Bolita> getArrayBolitas() {
		return bolitas;
	}
	
	public ArrayList<Recta> getArrayRectas() {
		return rectas;
	}
	
	public int getCantidadBolitasRestantes() {
		return bolitas.size();
	}
	
	private void agregarRecta(Punto p1, Punto p2) {
		try {
			rectas.add(new Recta(p1,p2));
		}
		catch(RectaInvalidaException ex) {
			System.out.println("No se pudo crear la recta: Parametros invalidos.");
		}
		
	}
	
	public void dibujar(JPanel area){
		for(Bolita b : bolitas) {
			b.dibujar(area);
		}
//		for(Recta rec : rectas) {
//			rec.dibujar(area);
//		}
	}
	
	public void generarBolitas(){
		for(Recta rec : rectas) {
			int cantBolitas = (rec.getLongitud())/20;
			for(int i=0;i<cantBolitas;i++){
				Punto pInicial = null;
				boolean especial = false;
				if(rec.getTipo()==Rectas.HORIZONTAL){
					pInicial = new Punto(rec.getPuntoInicialX() + i*20-5, rec.getPuntoInicialY()-5);
				}
				else if(rec.getTipo()==Rectas.VERTICAL){
					pInicial = new Punto(rec.getPuntoInicialX() - 5, rec.getPuntoInicialY() + i*20-5);
				}
				boolean colision = false;
				if( !bolitas.isEmpty() ) {
					Punto pAux = new Punto(pInicial.getX()+5, pInicial.getY()+5);
					for(Bolita bol : bolitas) {
						if( pAux.distanciaCon(bol.getCentroCoordenadas()) <= bol.getWidth() + 2) {
							colision = true;
							break;
						}
					}
				}
				if(!colision) {
					if(i%40==0) especial = true;
					Bolita b = new Bolita(pInicial, especial);
					bolitas.add(b);
				}
			}
		}
	}
	
	private void inicializarPuntos() {
		for(Recta r : rectas) {
			puntos.add(r.getPuntoInicial());
			puntos.add(r.getPuntoFinal());
		}
		//System.out.println("Puntos inicializados: TOTAL "+puntos.size());
	}
	private void inicializarPuntosExtremos() {
		Punto mayorXY = puntos.get(0);
		Punto menorXY = puntos.get(0);
		Punto mayorXmenorY = puntos.get(0);
		Punto menorXmayorY = puntos.get(0);
		for(Punto p : puntos) {
			if(p.getX()>=mayorXY.getX() && p.getY()>=mayorXY.getY()) {
				
				mayorXY = p;
			}
		}
		for(Punto p : puntos) {
			if(p.getX()<=menorXY.getX() && p.getY()<=menorXY.getY()) {
				menorXY = p;
			}
		}
		for(Punto p : puntos) {
			if(p.getX()>=mayorXmenorY.getX() && p.getY()<=mayorXmenorY.getY()) {
				mayorXmenorY = p;
			}
		}
		for(Punto p : puntos) {
			if(p.getX()<=menorXmayorY.getX() && p.getY()>=menorXmayorY.getY()) {
				menorXmayorY = p;
			}
		}
		puntosExtremos.add(mayorXY);
		puntosExtremos.add(menorXY);
		puntosExtremos.add(mayorXmenorY);
		puntosExtremos.add(menorXmayorY);
		/*
		System.out.print("Puntos extremos inicializados: ");
		for(Punto p : puntosExtremos) {
			System.out.print(puntosExtremos.get(puntosExtremos.indexOf(p)).toString());
		}
		*/
	}
	public ArrayList<Punto> getPuntos() {
		return puntos;
	}
	public ArrayList<Punto> getPuntosExtremos() {
		return puntosExtremos;
	}

	public void removerBolita(Bolita b) {
		b.setAliveState(false);
		b.borrarImagen();
		bolitas.remove(b);
	}
	public void removerBolita(int index) {
		Bolita b = bolitas.get(index);
		b.setAliveState(false);
		b.borrarImagen();
		bolitas.remove(b);
	}
}
