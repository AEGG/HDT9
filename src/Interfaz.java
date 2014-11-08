
/*
 * Universidad del Valle de Guatemala
 * Hoja de Trabajo #9 Aloritmo de Floyd
 * Max de Le�n - 13012
 * Aar�n Gir�n - 13042
 * Ricardo Franco - 13261
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interfaz {
	private JFrame ventana;
	private JPanel panel;
	private JLabel lBienvenida, lRuta, lRpta, lCentro, lImagen, lGrafo;
	private JButton bBuscar, bCentro, bSalir, bNuevo;
	private String ciudad1, ciudad2, centro, distancia, grafo;
	private JTextField xDistancia, xCiudad1, xCiudad2;
	private ImageIcon imagen;
	private JTextArea tGrafo;
	Grafo matriz = new Grafo();
	//matriz.caminoCorto();
	public Interfaz(){
		matriz.caminoCorto();
		ventana = new JFrame();
		panel = new JPanel();
		ventana.setPreferredSize(new Dimension(325,350));
		ventana.setTitle("Centro de viajes Guatemala");
		panel.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setContentPane(panel);
// Area donde se inician los botones que se utilizan
		bBuscar = new JButton("Calcular ciudad");
		bBuscar.setBounds(10,270,125,20);
		bBuscar.addActionListener(new ButtonListener());
		bCentro = new JButton("Encontrar el centro");
		bCentro.setBounds(160,270,150,20);
		bCentro.addActionListener(new ButtonListener());
		bNuevo = new JButton("Cambio de ruta");
		bNuevo.setBounds(10,295,150,20);
		bNuevo.addActionListener(new ButtonListener());
		bSalir = new JButton("Salir");
		bSalir.setBounds(210,295,100,20);
		bSalir.addActionListener(new ButtonListener());
// Area donde se encuentran los label's del programa
		lBienvenida = new JLabel("Bienvenidos al centro de viajes Guatemala");
		lBienvenida.setBounds(40,10,250,15);
		lRuta = new JLabel("Rutas de Guatemala");
		lRuta.setBounds(10,150,250,15);
		lGrafo = new JLabel("Grafo de rutas:");
		lGrafo.setBounds(190,150,200,15);
		lRpta = new JLabel("");
		lRpta.setBounds(10,225,250,15);
		lCentro = new JLabel("");
		lCentro.setBounds(10,240,250,15);
		lImagen = new JLabel("");
		lImagen.setBounds(70,15,340,150);
// Area para el ingreso de valores 
		xDistancia = new JTextField("Distancia",30);
		xDistancia.setVisible(true);
		xDistancia.setEnabled(true);
		xDistancia.setBounds(10,205,150,20);
		xCiudad1 = new JTextField("Ciudad de origen",30);
		xCiudad1.setVisible(true);
		xCiudad1.setEnabled(true);
		xCiudad1.setBounds(10,165,150,20);
		xCiudad2 = new JTextField("Ciudad de destino",30);
		xCiudad2.setVisible(true);
		xCiudad2.setEnabled(true);
		xCiudad2.setBounds(10,185,150,20);
/*
 * Aqui se carga el valor de la imagen que vamos a colocar en nuestro label
 * para que apareza en la interfaz gr�fica 
 */
		imagen = new ImageIcon("guatemala 2.gif");
		lImagen.setIcon(imagen);
// Area para agregar al text area el grafo que tenemos 
		tGrafo = new JTextArea(10,5);
		tGrafo.setLineWrap(true);
		tGrafo.setWrapStyleWord(true);
		tGrafo.setBounds(190,170,120,80);
		tGrafo.setEditable(false);
		tGrafo.setVisible(true);
// Se agrega todo al panel 
		panel.add(bBuscar);
		panel.add(bCentro);
		panel.add(bNuevo);
		panel.add(bSalir);
		panel.add(lBienvenida);
		panel.add(lGrafo);
		panel.add(lRuta);
		panel.add(lRpta);
		panel.add(lCentro);
		panel.add(lImagen);
		panel.add(xDistancia);
		panel.add(xCiudad1);
		panel.add(xCiudad2);
		panel.add(tGrafo);
	}
	public void mostrar(){
		ventana.pack();
		ventana.setVisible(true);
	}
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent mouse){
			if(mouse.getSource()==bBuscar){
				matriz.caminoCorto();
				ciudad1 = xCiudad1.getText();
				ciudad2 = xCiudad2.getText();
				if(matriz.D.contains(ciudad1)&&matriz.D.contains(ciudad2)){
                    //System.out.println("\nLa ruta mas corta es: "+matriz.D.getEdge(ciudad1, ciudad2));
                    lRpta.setText("La ruta m�s corta es: "+matriz.D.getEdge(ciudad1, ciudad2));
				}
				xCiudad1.requestFocus();
			}
			if(mouse.getSource()==bCentro){
				centro = matriz.centroGrafo();
				lCentro.setText(centro);
			}
			if(mouse.getSource()==bNuevo){
				grafo = matriz.D.show();
				ciudad1 = xCiudad1.getText();
				ciudad2 = xCiudad2.getText();
				distancia = xDistancia.getText();
                if(matriz.D.contains(ciudad1)&&matriz.D.contains(ciudad2)){
                    matriz.D.addEdge(ciudad1, ciudad2, distancia);
                    tGrafo.append(grafo);
                }
                else{
                    matriz.D.add(ciudad1);
                    matriz.D.add(ciudad2);
                    matriz.D.addEdge(ciudad1, ciudad2, distancia);
                    tGrafo.append(grafo);
                }
                JOptionPane.showMessageDialog(null, "Nueva ruta ingresada correctamente");
			}
			if(mouse.getSource()==bSalir){
				ventana.setVisible(false);
			}
		}
	}
}
