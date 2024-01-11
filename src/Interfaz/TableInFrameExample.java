package Interfaz;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import Clases.PuntajesDAO;
import Clases.Puntajes;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TableInFrameExample extends JFrame {
    private JTable jTable1;
    public TableInFrameExample() {
        initComponents();
    }

    private void initComponents() {
        // Crear la tabla
        jTable1 = new JTable();
        jTable1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Usuario", "Puntaje"}) {
            Class[] types = new Class[]{String.class, Integer.class};
            boolean[] canEdit = new boolean[]{false, false};

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        // Configurar la ventana
        setTitle("Tabla de Puntajes");
        setSize(400, 300);

        // Agregar la tabla al contenido de la ventana
        cargarTop5Puntajes();
        getContentPane().add(new JScrollPane(jTable1));

        setLocationRelativeTo(null); // Centrar la ventana
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TableInFrameExample().setVisible(true);
        });
    }
    
    private void cargarTop5Puntajes() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0); // Limpiar la tabla
        PuntajesDAO punt = new PuntajesDAO();
        java.util.List<Puntajes> puntajes = punt.obtenerTodosLosPuntajes();
        for(Puntajes puntaje: puntajes){
            String usuario = puntaje.getName();
            int puntajei = puntaje.getPuntaje() ;
            modelo.addRow(new Object[]{usuario, puntajei});
        }
    }
}

