package es.iescanarias.vm.model;

import java.nio.file.Path;
import java.util.ArrayList;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class AlmacenEmpleadoFileDAO {

    //Ejemplo de cualquier clase que sirva de serializador ( AlmacenEmpleadoFileDAO)


    private Path fichero;
    private JAXBContext contexto;


    public Path getRutaAlmacen() {
        Path absolutePath = null;
        if (fichero != null) {
            absolutePath = fichero.toAbsolutePath();
        }
        return absolutePath;
    }


    public AlmacenEmpleadoFileDAO() throws JAXBException {
         this("almacen.xml");
    }

    public AlmacenEmpleadoFileDAO(String nombreFichero) throws JAXBException {
        Path nombreComoPath = Path.of(nombreFichero);
        this.fichero = nombreComoPath;
        this.contexto = JAXBContext.newInstance(Empresa.class);
    }


    /*public String toXml(Empresa empresa) throws JAXBException {
        StringWriter writer = new StringWriter();

        Marshaller marshaller = crearMarshaller();
        marshaller.marshal(empresa, writer);

        return writer.toString();
    }*/

    /**
     *
     * @param empresa es la etiqueta raiz del XML
     * @throws JAXBException lanza una excepción si no puede convertir a xml
     * Este méodo sirve para guardar la empresa y lo único que hace es llamar a marshaller
     */

    public void guardar(Empresa empresa) throws JAXBException {
        Marshaller marshaller = crearMarshaller();
        //Marshaller marshaller = contexto.createMarshaller();
        marshaller.marshal(empresa, fichero.toFile());
    }


    /**
     *
     * @return el conjunto de elementos tomados del fichero como Empleados
     * @throws JAXBException
     */



    public ArrayList<Empleado> leerEmpleados() throws JAXBException {
        Unmarshaller unmarshaller = contexto.createUnmarshaller();

        Empresa empresaLeida = (Empresa) unmarshaller.unmarshal(fichero.toFile());

        if (empresaLeida.getEmpleados() == null){
            return new ArrayList<>();
        }

        return new ArrayList<>(empresaLeida.getEmpleados());
    }

   private Marshaller crearMarshaller() throws JAXBException {
        Marshaller marshaller = contexto.createMarshaller();

        marshaller.setProperty(
                Marshaller.JAXB_FORMATTED_OUTPUT,
                Boolean.TRUE
        );

        marshaller.setProperty(
                Marshaller.JAXB_ENCODING,
                "UTF-8"
        );
        return marshaller;
    }
}
