package bancomacro;
/**
 * @author Profe
 */
public class BancoMacro {
    
    public static ClienteDTO convertirADTO(Cliente cli){
        return new ClienteDTO(cli.getNombre(),
                cli.getApellido(), 
                cli.getDni());
    }
    
    public static void main(String[] args) {
        Cliente cli = new Cliente(661L, "Rogelio", "Rojas", "22876543", "1234");
        ClienteDTO cliDTO = convertirADTO(cli);
        
        RespuestaDTO<ClienteDTO> respuesta = new RespuestaDTO<>(true,"Encontrado",cliDTO);
        System.out.println(respuesta.getMensaje() + "\n" + respuesta.getDatos());
    }
    
}
