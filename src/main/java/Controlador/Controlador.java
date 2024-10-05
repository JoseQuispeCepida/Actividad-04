package Controlador;

import Modelo.Estudiante;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Controlador {
    
    private DefaultTableModel modeloTabla;
    public ArrayList<Estudiante> listaEstudiantes;

    public Controlador(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
        this.listaEstudiantes = new ArrayList<>();
    }      
    
    public void agregarEstudiante(JTextField txtNombre, JTextField txtCodigo, JTextField txtDireccion, JTextField txtTelefono, JDateChooser FechaNacimiento) {
        String nombre = txtNombre.getText();
        String codigo = txtCodigo.getText();
        String direccion = txtDireccion.getText();
        int telefono = Integer.parseInt(txtTelefono.getText());
        Date fechaNacimiento = FechaNacimiento.getDate();

        // Crear una nueva instancia de Estudiante
        Estudiante estudiante = new Estudiante(codigo, nombre, fechaNacimiento, direccion, telefono);

        // Agregar el estudiante a la lista
        listaEstudiantes.add(estudiante);

        // Agregar los datos a la tabla
        modeloTabla.addRow(new Object[]{codigo, nombre, fechaNacimiento, direccion, telefono});
    }
    
    public void editarEstudiante(JTable tabla, JTextField txtNombre, JTextField txtCodigo, JTextField txtDireccion, JTextField txtTelefono, JDateChooser dateFechaNacimiento) {
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = tabla.getSelectedRow();

        // Verificar que se haya seleccionado una fila válida
        if (filaSeleccionada >= 0 && filaSeleccionada < listaEstudiantes.size()) {
            // Obtener los nuevos valores de los campos de texto
            String nuevoNombre = txtNombre.getText();
            String nuevoCodigo = txtCodigo.getText();
            String nuevaDireccion = txtDireccion.getText();
            int nuevoTelefono = Integer.parseInt(txtTelefono.getText());
            Date nuevaFechaNacimiento = dateFechaNacimiento.getDate();

            // Actualizar el estudiante en la lista
            Estudiante estudiante = listaEstudiantes.get(filaSeleccionada);
            estudiante.setNombre(nuevoNombre);
            estudiante.setCodigo(nuevoCodigo);
            estudiante.setDireccion(nuevaDireccion);
            estudiante.setTelefono(nuevoTelefono);
            estudiante.setFechaNacimiento(nuevaFechaNacimiento);

            // Actualizar la tabla
            Object[] nuevosDatos = {nuevoCodigo, nuevoNombre, nuevaFechaNacimiento, nuevaDireccion, nuevoTelefono};
            for (int i = 0; i < nuevosDatos.length; i++) {
                ((DefaultTableModel) tabla.getModel()).setValueAt(nuevosDatos[i], filaSeleccionada, i);
            }
        } else {
            // Mostrar un mensaje si no se selecciona ninguna fila
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para editar.");
        }
    }
    
    public void eliminarEstudiante(JTable tabla) {
        // Obtener la fila seleccionada
        int filaSeleccionada = tabla.getSelectedRow();

        // Verificar que se haya seleccionado una fila válida
        if (filaSeleccionada >= 0 && filaSeleccionada < listaEstudiantes.size()) {
            // Eliminar el estudiante del ArrayList
            listaEstudiantes.remove(filaSeleccionada);

            // Eliminar la fila de la tabla
            DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
            modeloTabla.removeRow(filaSeleccionada);

            // Mostrar mensaje de confirmación
            JOptionPane.showMessageDialog(null, "Estudiante eliminado correctamente.");
        } else {
            // Mostrar un mensaje si no se selecciona ninguna fila
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para eliminar.");
        }
    }
}
