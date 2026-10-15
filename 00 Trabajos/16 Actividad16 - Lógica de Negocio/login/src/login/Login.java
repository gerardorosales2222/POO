package login;
/**
 * @author Profe
 */
public class Login {

    public static UsuarioDTO convertirADTO(Usuario user) {
        return new UsuarioDTO(user.getNombre(), user.getEmail());
    }
    
    public static void main(String[] args) {
        
        Usuario user = new Usuario(1L,"Roman","rom67@gmail.com","123");
        UsuarioDTO userDTO = convertirADTO(user);
        boolean login = user.logearse("123");
        if(login){
            RespuestaDTO<UsuarioDTO> ok = new RespuestaDTO(login,"Permitido", userDTO);
            System.out.println("Acceso permitido..."+ok);
        }else{
            RespuestaDTO<UsuarioDTO> mal = new RespuestaDTO(login,"Denegado", null);
            System.out.println("Acceso denegado!");
        }
        
    }
    
}
