package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Server {

    private ServerSocket servidor;
    private Socket cliente;
    private int cantActualClientes;
    private ArrayList<Socket> sockets;
    private int max_clientes;
    private int puerto;
    private String nombreHost;
    private String IPHost;
    private DataBase database;

    public String getNombreHost() {
        return nombreHost;
    }

    public String getIPHost() {
        return IPHost;
    }

    public int getMax_clientes() {
        return max_clientes;
    }

    public int getPuerto() {
        return puerto;
    }

    public Server(int port, int max_conexiones) {
        try {
            nombreHost = InetAddress.getLocalHost().getHostName().toString();
            IPHost = InetAddress.getLocalHost().getHostAddress().toString();
        }
        catch (UnknownHostException e1) {
            e1.printStackTrace();
        }

        puerto = port;
        max_clientes = max_conexiones;
        cantActualClientes = 0;
        sockets = new ArrayList<Socket>();
        database = new DataBase();

        try {
        	servidor = new ServerSocket(puerto);
        }
        catch (IOException e) {
            System.out.println("No se puede escuchar desde el puerto elegido, "
            					+ "cerrando Servidor...");
            System.exit(-1);
        }
    }

    /**
     * Devuelve la lista de sockets utilizados por el servidor
     */
    public ArrayList<Socket> getLista() {
        return sockets;
    }

    public Socket aceptarConexion() {
    	cliente=null;
        try {
        	servidor.setSoTimeout(1000);
            cliente = servidor.accept();
            cantActualClientes++;
            if (cantActualClientes > max_clientes) {
                DataOutputStream d = new DataOutputStream(cliente.getOutputStream());
                d.writeUTF("Servidor Lleno");
                cliente.close();
                cantActualClientes--;
                return null;
            }
            else{
            	sockets.add(cliente);
                System.out.println("La Conexion numero " + cantActualClientes 
                					+ " fue aceptada correctamente.");
            }
        } 
        catch(SocketTimeoutException e){
        	return null;
        }
        catch (IOException e) {
            System.out.println("Error al aceptar conexiones, Cerrando el Servidor...");
            e.printStackTrace();
            System.exit(-1);
        } 
        return cliente;
    }

    public void pararServidor() {
        try {
        	if(!servidor.isClosed())
        		servidor.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarCliente(){
    	cantActualClientes--;
    }
    
    /**
     * Devuelve el objeto DataBase utilizado por el servidor
     */
    public DataBase getDatabase(){
    	return database;
    }
}
