import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

/*
//PROCESSO PARA CRIAÇÃO DO USUÁRIO
        UsuarioDAO dao = new UsuarioDAO();
        Usuario novo = new Usuario("Rodrigo", "rodrigo@email.com");
        dao.criar(novo);
//PROCESSO PARA CRIAÇÃO DO USUARIO


//PROCESSO PARA LISTAGEM DE USUARIOS
        List<Usuario> lista = dao.listar();
        lista.forEach(System.out::println);
//PROCESSO PARA LISTAGEM DE USUARIOS




        if (!lista.isEmpty()) {
            Usuario u = lista.get(0);
            u.setNome("Ana Maria Silva");
            dao.atualizar(u);
        }

        if (!lista.isEmpty()) {
            dao.excluir(lista.get(0).getId());
        }

*/
        Scanner sc = new Scanner(System.in);

        boolean condicional = true;

        while (condicional) {
            System.out.println("\n======================");
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Adicionar um usuário");
            System.out.println("2. Listar os usuários");
            System.out.println("3. Remover um usuário");
            System.out.println("4. Atualizar os usuários");
            System.out.println("0. Fechar o programa");

            try {
                int numeroEscolha = sc.nextInt();
                sc.nextLine();

                switch (numeroEscolha) {
                    case 1:
                        System.out.println("Digite o nome");
                        String nome = sc.nextLine();
                        System.out.println("Digite o email");
                        String email = sc.nextLine();
                        UsuarioDAO daoNome = new UsuarioDAO();

                        Usuario novoNome = new Usuario(nome, email);


                        daoNome.criar(novoNome);
                        System.out.println("Obrigado! Usuário " + nome + " foi cadastrado em nosso sistema.");
                    break;

                    case 2:
                        UsuarioDAO daoList = new UsuarioDAO();
                        List<Usuario> listagemUsuario = daoList.listar();
                        System.out.println("Usuários listados: ");
                        listagemUsuario.forEach(System.out::println);
                    break;

                    case 3:
                        System.out.println("Digite o ID do usuário que você quer excluir");
                        int idExclusao = sc.nextInt();
                        UsuarioDAO daoExcluir = new UsuarioDAO();
                        daoExcluir.excluir(idExclusao);
                    break;

                    case 4:
                        System.out.println("Digite o ID do usuário que você quer atualizar");
                        int idAtualizar = sc.nextInt();
                        sc.nextLine();
                        UsuarioDAO daoAtualizar = new UsuarioDAO();
                        List<Usuario> atualizarUsuario = daoAtualizar.listar();

                        boolean encontrado = false;

                        for (Usuario usuario : atualizarUsuario) {
                            if (usuario.getId() == idAtualizar) {

                                System.out.println("Digite o novo nome");
                                String nomeAlterado = sc.nextLine();
                                System.out.println("Digite o novo email");
                                String novoEmail = sc.nextLine();

                                usuario.setNome(nomeAlterado);
                                usuario.setEmail(novoEmail);

                                daoAtualizar.atualizar(usuario);
                                encontrado = true;
                                break;
                            }

                        }

                        if (!encontrado) {
                            System.out.println("Usuário não encontrado");
                        }
                    break;

                    case 0:
                        System.out.println("\n Sessão terminada!");
                        condicional = false;
                    break;

                    default: System.out.println("Opçao inválida. Tente novamente.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nEntrada inválida. Tente novamente.");
                sc.nextLine();
            }


        }


    }
}