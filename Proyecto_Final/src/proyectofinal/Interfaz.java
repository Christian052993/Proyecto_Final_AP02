/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author Chistian Alexis Lombana Ospina
 * @author Maria Santos Mina Dorronsoro
 */
public class Interfaz extends javax.swing.JFrame {

    String nombre;
    int nHabitantes, indiceAire, nivelAuditiva;
    boolean basuras, texto;
    String datos[] = new String[5];
    
    File fichero;
    String ruta = "fichero.csv";
    
    public Interfaz() {
        initComponents();
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        setVisible(true);
        setSize(710, 580);
    }
        private boolean verificacion(String texto) {
        boolean opc = true;
        if(Pattern.matches("[a-zA-Z]+", texto)){
            opc = false;
        }
        return opc;
    }
    public void vaciar(JTextField uno){
        uno.setText("");
    }
    public void vaciarTodo() {
        jtComunidad.setText("");
        jtHabitante.setText("");
        jtAire.setText("");
        jtAuditiva.setText("");
    }
    public void guardar(String[] datos){
        fichero = new File(ruta);//Creacion del Archivo
        BufferedWriter bw;
        try {
            if (fichero.createNewFile()) {
                System.out.println("El fichero se ha creado correctamente");
                bw = new BufferedWriter(new FileWriter(fichero, true));
                bw.write("Comuna " + datos[0] + ", " + datos[1] + ", " + datos[2] + ", "
                        + datos[3] + ", " + datos[4]);
            } else {
                System.out.println("El fichero ya existe");
                bw = new BufferedWriter(new FileWriter(fichero, true));
                bw.write("\r\n");
                bw.write("Comuna " + datos[0] + ", " + datos[1] + ", " + datos[2] + ", "
                        + datos[3] + ", " + datos[4]);
            }
            bw.close();

        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    public ArrayList aire(){
        ArrayList aire = new ArrayList();
        ArrayList comuna = new ArrayList();
        ArrayList datoFinal = new ArrayList();
        try {
            FileReader f = new FileReader(ruta);
            BufferedReader b = new BufferedReader(f);
            String cadena;
            while ((cadena = b.readLine()) != null) {
            String palabras[] = cadena.split(",");
                for (int i = 2; i < palabras.length; i+=5) {
                    aire.add(palabras[i]);
                }
                for (int i = 0; i < palabras.length; i+=5) {
                    comuna.add(palabras[i]);
                }
            }
            b.close();
            for (int i = 0; i < aire.size(); i++) {
                String nivel = (String) aire.get(i);
                nivel = nivel.replace(" ","");//Para quitar los espacios que hay en el String para poder convertirlo a entero
                
                if(Integer.parseInt(nivel) >= 151){
                    String condicion="";
                    if(Integer.parseInt(nivel) >= 151){
                        condicion = "Dañino para la mayoría de la poblacín";
                    }
                    if(Integer.parseInt(nivel) >= 201){
                        condicion = "Muy dañino";
                    }
                    if(Integer.parseInt(nivel) > 300){
                        condicion = "Peligroso";
                    }
                    datoFinal.add("Nivel del aire es" + aire.get(i) + " "+condicion +" => La " + comuna.get(i));
                    datoFinal.add("\n");
                    
                }
            }
        } catch (Exception e) {
            System.out.println("Error de analisis aire " + e);
        }
        return datoFinal;
    }
    public ArrayList audio(){
        ArrayList audicio = new ArrayList();
        ArrayList habitantes = new ArrayList();
        ArrayList datoFinal = new ArrayList();
        try {
            FileReader f = new FileReader(ruta);
            BufferedReader b = new BufferedReader(f);
            String cadena;
            while ((cadena = b.readLine()) != null) {
            String palabras[] = cadena.split(",");
                for (int i = 3; i < palabras.length; i+=5) {
                    audicio.add(palabras[i]);
                }
                for (int i = 1; i < palabras.length; i+=5) {
                    habitantes.add(palabras[i]);
                }
            }
            
            b.close();
            
            for (int i = 0; i < audicio.size(); i++) {
                String nivel = (String) audicio.get(i);
                nivel = nivel.replace(" ","");//Para quitar el espacio de un String para poder convertirlo a entero
                if(Integer.parseInt(nivel) >= 75){
                    String condicion="";
                    if(Integer.parseInt(nivel) >= 75){
                        condicion = "ruido alto";
                    }
                    if(Integer.parseInt(nivel) > 100){
                        condicion = "discotecas y concierto";
                    }
                    if(Integer.parseInt(nivel) >= 120){
                        condicion = "umbral de dolor, daño irrereversible";
                    }
                    datoFinal.add("Nivel del audicio es" + audicio.get(i) +"db "+condicion +" => Los habitantes son " + habitantes.get(i) );
                    datoFinal.add("\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Error de analisis audio " + e);
        }
        return datoFinal;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jbGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtComunidad = new javax.swing.JTextField();
        jtHabitante = new javax.swing.JTextField();
        jtAire = new javax.swing.JTextField();
        jtAuditiva = new javax.swing.JTextField();
        jrSI = new javax.swing.JRadioButton();
        jrNO = new javax.swing.JRadioButton();
        jbAnalisis = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jrAire = new javax.swing.JRadioButton();
        jrContaminacion = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" Monitor Ambiental");
        setPreferredSize(new java.awt.Dimension(765, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbGuardar.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jbGuardar.setText("GUARDAR");
        jbGuardar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbGuardar.setContentAreaFilled(false);
        jbGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jbGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 350, 70));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel1.setText("Nombre de la comuna");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 280, 40));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel2.setText("Numero de habitantes");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 280, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel3.setText("Indice de caldiad del aire");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 280, 40));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel4.setText("Contaminacion auditiva");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 280, 40));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel5.setText("Presencia de basuras");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 280, 40));

        jtComunidad.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jtComunidad.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.white));
        jtComunidad.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtComunidad.setOpaque(false);
        jPanel1.add(jtComunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 240, 50));

        jtHabitante.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jtHabitante.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.white));
        jtHabitante.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtHabitante.setOpaque(false);
        jPanel1.add(jtHabitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 240, 50));

        jtAire.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jtAire.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.white));
        jtAire.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtAire.setOpaque(false);
        jPanel1.add(jtAire, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 240, 50));

        jtAuditiva.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jtAuditiva.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.white));
        jtAuditiva.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtAuditiva.setOpaque(false);
        jPanel1.add(jtAuditiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 240, 50));

        buttonGroup1.add(jrSI);
        jrSI.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jrSI.setText("SI");
        jrSI.setBorder(null);
        jrSI.setBorderPainted(true);
        jrSI.setContentAreaFilled(false);
        jrSI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jrSI, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 70, 40));

        buttonGroup1.add(jrNO);
        jrNO.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jrNO.setText("NO");
        jrNO.setBorder(null);
        jrNO.setBorderPainted(true);
        jrNO.setContentAreaFilled(false);
        jrNO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jrNO, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 80, 40));

        jbAnalisis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbAnalisis.setText("ANALISIS");
        jbAnalisis.setBorderPainted(false);
        jbAnalisis.setContentAreaFilled(false);
        jbAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnalisisActionPerformed(evt);
            }
        });
        jPanel1.add(jbAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, 150, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 550));

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray), "ANALISIS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 2, 18))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup2.add(jrAire);
        jrAire.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jrAire.setText("CALIDAD DEL AIRE");
        jrAire.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jrAire.setOpaque(false);
        jrAire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrAireActionPerformed(evt);
            }
        });
        jPanel3.add(jrAire, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 410, -1));

        buttonGroup2.add(jrContaminacion);
        jrContaminacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jrContaminacion.setText("CONTAMINACION AUDITIVA");
        jrContaminacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jrContaminacion.setOpaque(false);
        jrContaminacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrContaminacionActionPerformed(evt);
            }
        });
        jPanel3.add(jrContaminacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 410, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 570, 170));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jtArea.setColumns(20);
        jtArea.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        jtArea.setRows(5);
        jScrollPane1.setViewportView(jtArea);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 569, 280));

        jButton1.setText("Volver");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolver(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 490, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
            
     if (verificacion(jtHabitante.getText())) {//verificaion de JTextfield
            if(verificacion(jtAire.getText())) {
                if(verificacion(jtAuditiva.getText())) {
                    if(verificacion(jtComunidad.getText())) {
                        if (jrSI.isSelected()) {
                            basuras = true;
                        } else {
                            basuras = false;
                        }
                        String bas = String.valueOf(basuras);
                        System.out.println("basura " + bas);
                        nombre = jtComunidad.getText();
                        nHabitantes = Integer.parseInt(jtHabitante.getText());
                        indiceAire = Integer.parseInt(jtAire.getText());
                        nivelAuditiva = Integer.parseInt(jtAuditiva.getText());

                        datos[0]= nombre;
                        datos[1]= Integer.toString(nHabitantes);
                        datos[2]= Integer.toString(indiceAire);
                        datos[3]= Integer.toString(nivelAuditiva);
                        datos[4]= bas;

                        guardar(datos);
                        vaciarTodo();

                    }else{
                        vaciar(jtComunidad);
                    }
                }else{
                    vaciar(jtAuditiva);
                }
            }else{
                vaciar(jtAire);
            }
        }else{
            vaciar(jtHabitante);
        }
                      
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnalisisActionPerformed
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
        jPanel3.setVisible(true);
        
    }//GEN-LAST:event_jbAnalisisActionPerformed

    private void jbVolver(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolver
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jtArea.setText("");
        vaciarTodo();
    }//GEN-LAST:event_jbVolver

    private void jrAireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrAireActionPerformed
        jtArea.setText("");
        ArrayList datoAire = new ArrayList();
        datoAire =aire();
        for (int i = 0; i < datoAire.size(); i++) {
            jtArea.append((String) datoAire.get(i));

        }
    }//GEN-LAST:event_jrAireActionPerformed

    private void jrContaminacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrContaminacionActionPerformed
        jtArea.setText("");
        ArrayList datoAudio = new ArrayList();
        datoAudio =audio();
        for (int i = 0; i < datoAudio.size(); i++) {
            jtArea.append((String) datoAudio.get(i));

        }
    }//GEN-LAST:event_jrContaminacionActionPerformed

    public static void main(String args[]) {
        new Interfaz();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAnalisis;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JRadioButton jrAire;
    private javax.swing.JRadioButton jrContaminacion;
    private javax.swing.JRadioButton jrNO;
    private javax.swing.JRadioButton jrSI;
    private javax.swing.JTextField jtAire;
    private javax.swing.JTextArea jtArea;
    private javax.swing.JTextField jtAuditiva;
    private javax.swing.JTextField jtComunidad;
    private javax.swing.JTextField jtHabitante;
    // End of variables declaration//GEN-END:variables
}
