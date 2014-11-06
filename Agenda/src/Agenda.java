import java.util.*;

/**
 * 
 */
public class Agenda {

    private ArrayList<Contacto> contactos;
    private ArrayList<Grupo> grupos;
    
    public Agenda() {
        this(null,null);
    }
    
    public Agenda(ArrayList<Contacto> contactos, ArrayList<Grupo> grupos) {
        if(contactos != null)        
            this.contactos = contactos;
        else
            this.contactos = new ArrayList<>();
    
        if(grupos != null)
            this.grupos = grupos;
        else
            this.grupos = new ArrayList<>();        
    }
    
    /**
     * 
     */
    public void iniciarAgenda() {
        cargarContactos();
    }
    
    
    
    public void cargarContactos(){
        if(archivo == null)
            archivo = "miAgenda.json";
        importarContactosDeUnArchivo(archivo);
    }

    /**
     * 
     */
    public void guardarCambios() {
        guardarCambios(null);
    }
    public void guardarCambios(String archivo){
        if(archivo == null)
            archivo = "miAgenda.json";
        exportarContactosAUnArchivo(archivo);
    }

    /**
     * 
     */
    private void importarContactosDeUnArchivo(String nombreDelArchivo) {
        Agenda importada = Importador.leer(nombreDelArchivo);
        this.contactos = importada.getContactos();
        this.grupos = importada.getGrupos();
    }

    /**
     * 
     * @param nombreDelArchivo
     */
    private void exportarContactosAUnArchivo(String nombreDelArchivo) {
        Exportador.escribir(nombreDelArchivo, this);
    }

    public void ingresarContacto(String nombre, String apellido, Telefono telefono){
        Contacto contacto = new Contacto (nombre, apellido, telefono);
        contactos.add (contacto);
                
    }
    
    public void ingresarContacto(String nombre, String apellido, Email email){
        Contacto contacto = new Contacto (nombre, apellido, email);
        contactos.add (contacto);
    }
    
    public void eliminarContacto(Contacto contacto){
        contactos.remove(contacto);
    }
    
    public ArrayList<Contacto> consultarContactoPorNombre(String nombre){
        ArrayList<Contacto> contactosConEseNombre = new ArrayList<> ();
        for (Contacto contacto : contactos) {
            if (contacto.getNombre() == nombre) {
                contactosConEseNombre.add(contacto);
            }
        }
        return contactosConEseNombre;     
    }
    
    public ArrayList<Contacto> consultarContactoPorApellido(String apellido){
        ArrayList<Contacto> contactosConEseApellido = new ArrayList<> ();
        for (Contacto contacto : contactos) {
            if (contacto.getApellido() == apellido) {
                contactosConEseApellido.add(contacto);
            }
        }
        return contactosConEseApellido;     
    }
        
    public ArrayList<Contacto> consultarContactoPorTelefono(String telefono){
        ArrayList<Contacto> contactosConEseTelefono= new ArrayList<> ();
        
        for (Contacto contacto : contactos) {
            for (Telefono telefono: contacto.getTelefonos() ) {
                if (telefono == telefono) {
                    contactosConEseTelefono.add(contacto);
                }
            }
        }
        return contactosConEseTelefono;     
    }
    
    public ArrayList<Contacto> consultarContactoPorEmail(String correo){
        ArrayList<Contacto> contactosConEseEmail= new ArrayList<Contacto> ();
        
        for( int i = 0; i< contactos.size(); i++) {
            for (int j =0; j< contactos.get(i).getEmails().size(); j++){
                if(contactos.get(i).getEmails().get(j).getCorreo() == correo)
                    contactosConEseEmail.add(contactos.get(i));
            }
        }
        return contactosConEseEmail;     
    }
    
    public ArrayList<Contacto> consultarContactoPorGrupo(String grupo){
        
        
        return 
    }
   
    
    public Grupo crearGrupo(String nombre) {
        return crearGrupo(nombre,null);
    }
    
    public Grupo crearGrupo(String nombre, ArrayList<Contacto> contactos){
        Grupo grupoNuevo = new Grupo(nombre, contactos);
        grupos.add(grupoNuevo);
        return grupoNuevo;       
    }


    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }
    
}
