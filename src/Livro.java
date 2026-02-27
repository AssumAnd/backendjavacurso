import java.util.*;

public class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel;
    private int codigoLivro;
    private List<String> listaEspera;

    public Livro(String titulo, String autor, boolean disponivel, int codigoLivro) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
        this.codigoLivro = codigoLivro;
        this.listaEspera = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
        if (disponivel && !listaEspera.isEmpty()) {
            System.out.println("\n ATENÇÃO: O livro \"" + titulo + "\" está disponível!");
            System.out.println("   Próximo na lista de espera: " + listaEspera.get(0));
        }
    }

    public int getCodigoLivro() {
        return codigoLivro;
    }

    public void adicionarListaEspera(String nomeUsuario) {
        listaEspera.add(nomeUsuario);
        System.out.println("\n" + nomeUsuario + " foi adicionado à lista de espera do livro \"" + titulo + "\"");
        System.out.println("   Sua posição na fila: " + listaEspera.size());
    }

    public void removerPrimeiroListaEspera() {
        if (!listaEspera.isEmpty()) {
            String usuarioRemovido = listaEspera.remove(0);
            System.out.println("\n" + usuarioRemovido + " foi removido da lista de espera (livro retirado)");
        }
    }

    public List<String> getListaEspera() {
        return listaEspera;
    }

    public void mostrarListaEspera() {
        if (listaEspera.isEmpty()) {
            System.out.println("   Nenhuma pessoa na lista de espera.");
        } else {
            System.out.println("   Lista de espera (" + listaEspera.size() + " pessoa(s)):");
            for (int i = 0; i < listaEspera.size(); i++) {
                System.out.println("   " + (i + 1) + ". " + listaEspera.get(i));
            }
        }
    }

    public static void main(String[] args) {
        List<Livro> estante = new ArrayList<>();

        estante.add(new Livro("Amor, teoricamente", "Ali Hazelwood", false, 1));
        estante.add(new Livro("A razão do amor", "Ali Hazelwood", true, 2));
        estante.add(new Livro("Hipótese do amor", "Ali Hazelwood", false, 3));
        estante.add(new Livro("Jantar secreto", "Raphael Montes", true, 4));
        estante.add(new Livro("Impostora", "R. F. Kuang", true, 5));
        estante.add(new Livro("MAUS", "Art Spiegelman", false, 6));
        estante.add(new Livro("Tartarugas Ninjas", "IDW", true, 7));
        estante.add(new Livro("Homem-Aranha: De volta ao lar", "John Romita Sr.", false, 8));
        estante.add(new Livro("Dragon Ball - Edição definitiva", "Akira Toriyama", true, 9));
        estante.add(new Livro("O jogador número um", "Ernest Cline", true, 10));

        Scanner sc = new Scanner(System.in);

        boolean continuar = true;
        int ultimoCodigo = 10;

        while (continuar) {
            System.out.println("\n=========================================");
            System.out.println("BIBLIOTECA VIRTUAL");
            System.out.println("=========================================");

            System.out.println("\nNOSSOS LIVROS DISPONÍVEIS:");
            System.out.println("-----------------------------");

            // Mostrar todos os livros
            for (Livro livro : estante) {
                if (!livro.getDisponivel()) {
                    System.out.print(
                            "\n" + livro.getCodigoLivro() + ". " + livro.getTitulo() + " - " + livro.getAutor() + " (INDISPONÍVEL)");
                    livro.mostrarListaEspera();
                } else {
                    System.out.print("\n" + livro.getCodigoLivro() + ". " + livro.getTitulo() +
                            " - " + livro.getAutor() + " (DISPONÍVEL)");
                }
            }

            System.out.println("\n\n=======================");
            System.out.println("MENU PRINCIPAL:");
            System.out.println("1. Retirar livro");
            System.out.println("2. Devolver livro");
            System.out.println("3. Adicionar livro à biblioteca");
            System.out.println("4. Entrar na lista de espera");
            System.out.println("5. Sair");
            System.out.print("\nEscolha uma opção: ");

            try {
                int numeroEscolha = sc.nextInt();
                sc.nextLine();

                switch (numeroEscolha) {
                    case 1:
                        System.out.print("\nQual livro você gostaria de retirar? Insira o código: ");
                        int codigoRetirar = sc.nextInt();
                        sc.nextLine();

                        Livro livroRetirar = null;
                        for (Livro livro : estante) {
                            if (livro.getCodigoLivro() == codigoRetirar) {
                                livroRetirar = livro;
                                break;
                            }
                        }

                        if (livroRetirar != null) {
                            if (livroRetirar.getDisponivel()) {
                                System.out.print("Digite seu nome: ");
                                String nomeUsuario = sc.nextLine();

                                livroRetirar.setDisponivel(false);
                                livroRetirar.removerPrimeiroListaEspera();
                                System.out.println("\nLIVRO RETIRADO COM SUCESSO!");
                                System.out.println("   Livro: \"" + livroRetirar.getTitulo() + "\"");
                                System.out.println("   Retirado por: " + nomeUsuario);
                            } else {
                                System.out.println("\nEste livro está INDISPONÍVEL!");
                                System.out.println("   Deseja entrar na lista de espera? (S/N)");
                                String resposta = sc.nextLine();

                                if (resposta.equalsIgnoreCase("S")) {
                                    System.out.print("Digite seu nome: ");
                                    String nomeUsuario = sc.nextLine();
                                    livroRetirar.adicionarListaEspera(nomeUsuario);
                                }
                            }
                        } else {
                            System.out.println("\nLivro não encontrado!");
                        }
                        break;

                    case 2:
                        System.out.print("\n Qual livro você gostaria de devolver? Insira o código: ");
                        int codigoDevolver = sc.nextInt();
                        sc.nextLine();

                        Livro livroDevolver = null;
                        for (Livro livro : estante) {
                            if (livro.getCodigoLivro() == codigoDevolver) {
                                livroDevolver = livro;
                                break;
                            }
                        }

                        if (livroDevolver != null) {
                            if (!livroDevolver.getDisponivel()) {
                                livroDevolver.setDisponivel(true);
                                System.out.println("\n LIVRO DEVOLVIDO COM SUCESSO!");
                                System.out.println("   Livro: \"" + livroDevolver.getTitulo() + "\"");
                            } else {
                                System.out.println("\nEste livro já está disponível!");
                            }
                        } else {
                            System.out.println("\n Livro não encontrado!");
                        }
                        break;

                    case 3:
                        System.out.println("\n ADICIONAR NOVO LIVRO");
                        System.out.println("---------------------");
                        System.out.print("Título do livro: ");
                        String novoTitulo = sc.nextLine();
                        System.out.print("Autor do livro: ");
                        String novoAutor = sc.nextLine();

                        ultimoCodigo++;
                        estante.add(new Livro(novoTitulo, novoAutor, true, ultimoCodigo));

                        System.out.println("\n LIVRO ADICIONADO COM SUCESSO!");
                        System.out.println("   Título: \"" + novoTitulo + "\"");
                        System.out.println("   Autor: " + novoAutor);
                        System.out.println("   Código: " + ultimoCodigo);
                        break;

                    case 4:
                        System.out.print("\n Qual livro deseja entrar na lista de espera? Insira o código: ");
                        int codigoEspera = sc.nextInt();
                        sc.nextLine();

                        Livro livroEspera = null;
                        for (Livro livro : estante) {
                            if (livro.getCodigoLivro() == codigoEspera) {
                                livroEspera = livro;
                                break;
                            }
                        }

                        if (livroEspera != null) {
                            if (!livroEspera.getDisponivel()) {
                                System.out.print("Digite seu nome: ");
                                String nomeUsuario = sc.nextLine();
                                livroEspera.adicionarListaEspera(nomeUsuario);
                            } else {
                                System.out.println("\n Este livro já está disponível! Você pode retirá-lo agora.");
                            }
                        } else {
                            System.out.println("\nLivro não encontrado!");
                        }
                        break;

                    case 5:
                        System.out.println("\nObrigado por usar nossa biblioteca!");
                        continuar = false;
                        break;

                    default:                        System.out.println("\nOpção inválida! Escolha uma opção de 1 a 5.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nEntrada inválida! Digite um número.");
                sc.nextLine();
            }

            if (continuar) {
                System.out.println("\nPressione Enter para continuar...");
                sc.nextLine();
            }
        }

        sc.close();
    }
}