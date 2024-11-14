package Consola;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pokedex extends javax.swing.JFrame {

    private int currentPokemonIndex = 0;

    // Nombres y tipos de los nuevos Pokémon
    private final String[] pokemons = {
        "Growlithe", "Psyduck", "Bellsprout", "Voltorb", 
        "Exeggcute", "Onix", "Zubat", "Farfetch'd", 
        "Hitmonlee", "Tentacool"
    };
    
    private final String[] types = {
        "Fuego", "Agua", "Planta", "Eléctrico", 
        "Planta/Psíquico", "Roca", "Veneno", "Normal/Volador", 
        "Lucha", "Agua/Veneno"
    };

    public Pokedex() {
        initComponents();
        pnlImagen.setBackground(new Color(0, 143, 57)); // Fondo verde como la Pokedex
        cargarImagen();
        actualizarInformacionPokemon();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlImagen = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        lblNombrePokemon = new javax.swing.JLabel();
        lblTipoPokemon = new javax.swing.JLabel();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokedex");

        jPanel1.setBackground(new java.awt.Color(255, 102, 102)); // Fondo de la ventana

        pnlImagen.setPreferredSize(new java.awt.Dimension(350, 450));

        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setPreferredSize(new java.awt.Dimension(300, 400));

        javax.swing.GroupLayout pnlImagenLayout = new javax.swing.GroupLayout(pnlImagen);
        pnlImagen.setLayout(pnlImagenLayout);
        pnlImagenLayout.setHorizontalGroup(
            pnlImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImagenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlImagenLayout.setVerticalGroup(
            pnlImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImagenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblNombrePokemon.setFont(new Font("Arial", Font.BOLD, 24));
        lblNombrePokemon.setForeground(Color.WHITE);
        lblNombrePokemon.setHorizontalAlignment(JLabel.CENTER);
        lblNombrePokemon.setText("Growlithe");

        lblTipoPokemon.setFont(new Font("Arial", Font.PLAIN, 18));
        lblTipoPokemon.setForeground(Color.WHITE);
        lblTipoPokemon.setHorizontalAlignment(JLabel.CENTER);
        lblTipoPokemon.setText("Fuego");

        btnAnterior.setText("< Anterior");
        btnAnterior.addActionListener(evt -> mostrarPokemonAnterior());

        btnSiguiente.setText("Siguiente >");
        btnSiguiente.addActionListener(evt -> mostrarPokemonSiguiente());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(pnlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblNombrePokemon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTipoPokemon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(btnAnterior)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSiguiente)))
            .addContainerGap()
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createSequentialGroup()
            .addContainerGap(20, Short.MAX_VALUE)
            .addComponent(pnlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblNombrePokemon)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblTipoPokemon)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnAnterior)
                .addComponent(btnSiguiente))
            .addGap(20, 20, 20)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void cargarImagen() {
        String nombrePokemon = pokemons[currentPokemonIndex];
        String ruta = "gifs/" + nombrePokemon + ".gif";
        File archivo = new File(ruta);
        if (archivo.exists()) {
            ImageIcon icono = new ImageIcon(ruta);
            lblImagen.setIcon(icono);
        }
    }

    private void actualizarInformacionPokemon() {
        lblNombrePokemon.setText(pokemons[currentPokemonIndex]);
        lblTipoPokemon.setText(types[currentPokemonIndex]);
        cargarImagen();
    }

    private void mostrarPokemonAnterior() {
        if (currentPokemonIndex > 0) {
            currentPokemonIndex--;
            actualizarInformacionPokemon();
        }
    }

    private void mostrarPokemonSiguiente() {
        if (currentPokemonIndex < pokemons.length - 1) {
            currentPokemonIndex++;
            actualizarInformacionPokemon();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Pokedex().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombrePokemon;
    private javax.swing.JLabel lblTipoPokemon;
    private javax.swing.JPanel pnlImagen;
    // End of variables declaration
}

