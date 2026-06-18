package actividadd_4_2;

public class EquipoMaratonProgramacion {

    private String nombreEquipo;
    private String universidad;
    private String lenguajeProgramacion;
    private Programador[] programadores;
    private int cantidadProgramadores;

    public EquipoMaratonProgramacion(String nombreEquipo, String universidad,
            String lenguajeProgramacion) throws CampoInvalidoException {

        validarDatoGeneral(nombreEquipo, "El nombre del equipo");
        validarDatoGeneral(universidad, "La universidad");
        validarDatoGeneral(lenguajeProgramacion, "El lenguaje de programacion");

        this.nombreEquipo = nombreEquipo.trim();
        this.universidad = universidad.trim();
        this.lenguajeProgramacion = lenguajeProgramacion.trim();
        programadores = new Programador[3];
        cantidadProgramadores = 0;
    }

    public boolean estaLleno() {
        return cantidadProgramadores == programadores.length;
    }

    public void anadirProgramador(Programador programador) throws EquipoCompletoException {
        if (estaLleno()) {
            throw new EquipoCompletoException("El equipo ya esta completo.");
        }

        programadores[cantidadProgramadores] = programador;
        cantidadProgramadores++;
    }

    public static void validarCampo(String campo, String nombreCampo)
            throws CampoInvalidoException {

        if (campo == null || campo.trim().isEmpty()) {
            throw new CampoInvalidoException(nombreCampo + " es obligatorio.");
        }

        String texto = campo.trim();
        if (texto.length() >= 20) {
            throw new CampoInvalidoException(
                    nombreCampo + " debe tener menos de 20 caracteres.");
        }

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (!Character.isLetter(caracter) && caracter != ' ' && caracter != '-') {
                throw new CampoInvalidoException(
                        nombreCampo + " solo puede contener letras, espacios o guiones.");
            }
        }
    }

    private static void validarDatoGeneral(String dato, String nombreDato)
            throws CampoInvalidoException {
        if (dato == null || dato.trim().isEmpty()) {
            throw new CampoInvalidoException(nombreDato + " es obligatorio.");
        }
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public String getUniversidad() {
        return universidad;
    }

    public String getLenguajeProgramacion() {
        return lenguajeProgramacion;
    }

    public Programador[] getProgramadores() {
        return programadores.clone();
    }
}
