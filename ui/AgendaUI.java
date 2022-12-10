package ui;

import enums.TipoContato;
import enums.TipoEndereco;
import enums.TipoTelefone;
import model.Contato;
import model.Telefone;
import util.ConsoleUIHelper;


import java.util.ArrayList;
import java.util.List;

public class AgendaUI {
   static List<Contato> agenda = new ArrayList<>();
   static Contato contato = new Contato();
    public static void menu () {
        int opcao = ConsoleUIHelper.askChooseOption("Digite a opção desejada:",
                "Adicionar um novo contato", "Editar um contato", "Listar contatos",
                "Buscar contato", "Remover contato", "Sair da agenda");

        switch (opcao) {
            case 0 -> {
                adicionarContato(contato);
                if (ConsoleUIHelper.askConfirm("Você deseja adicionar um telefone?", "sim", "não")) {

                    adicionarTelefone(contato);
                }


                if (ConsoleUIHelper.askConfirm("Você deseja adicionar um endereço?", "sim", "não")) {
                    adicionarEndereco();
                }

                System.out.println("Contato adicionado");
//                exibircontato():

            }
            case 1 -> System.out.println("editar");
            case 2 -> {
                listarContato();
            }
            case 3 -> System.out.println("Número 3");
            case 4 -> System.out.println("Número 4");
            case 5 -> System.exit(0);
        }

    }

    public static void adicionarContato(Contato contato) {
        String nome = ConsoleUIHelper.askNoEmptyInput("Digite o nome do seu contato.", 3);
        String sobrenome = ConsoleUIHelper.askNoEmptyInput("Digite o sobrenome do seu contato.", 3);
        int tipo = ConsoleUIHelper.askChooseOption("Digite o tipo do seu contato", "Pessoal", "Profissional");
        TipoContato tipoContato;
        if (tipo == 0) {
            tipoContato = TipoContato.PESSOAL;
        }
        else {
            tipoContato = TipoContato.PROFISSIONAL;
        }

        contato.setNome(nome);
        contato.setSobreNome(sobrenome);
        contato.setTipoContato(tipoContato);
        agenda.add(contato);
    }
//    public static void gravarContato(Contato contato, List<Contato> agenda) {
//        agenda.add(contato);
//    }

    public static void adicionarTelefone(Contato contato) {
        TipoTelefone tipoTelefone = TipoTelefone.CELULAR;
        String ddd = ConsoleUIHelper.askSimpleInput("Digite o DDD");
        String numero = ConsoleUIHelper.askNoEmptyInput("Digite o número.", 3);
        int tipo = ConsoleUIHelper.askChooseOption("Digite o tipo do número", "Celular", "Residencial", "Comercial");
        switch (tipo) {
            case 0 -> {
                tipoTelefone = TipoTelefone.CELULAR;
            }
            case 1 -> {
                tipoTelefone = TipoTelefone.RESIDENCIAL;
            }
            case 2 -> {
                tipoTelefone = TipoTelefone.COMERCIAL;
            }
        }
        Telefone telefone = new Telefone(ddd, numero, tipoTelefone);

    // Checar duplicidade do telefone neste contato
        contato.addTelefone(telefone);
    }

    public static void adicionarEndereco() {
        String logradouro = ConsoleUIHelper.askSimpleInput("Digite o logradouro");
        String numero = ConsoleUIHelper.askSimpleInput("Digite o número da casa");
        String cidade = ConsoleUIHelper.askSimpleInput("Digite a cidade");
        String estado = ConsoleUIHelper.askSimpleInput("Digite o estado");
        String cep = ConsoleUIHelper.askSimpleInput("Digite o CEP");
        int tipo = ConsoleUIHelper.askChooseOption("Digite o tipo do endereço", "Residencial","Comercial","Deixar em branco");
        TipoEndereco tipoEndereco;
        switch (tipo) {
            case 0 -> {
                tipoEndereco = TipoEndereco.RESIDENCIAL;
            }
            case 1 -> {
                tipoEndereco = TipoEndereco.COMERCIAL;
            }
            case 2 -> System.out.println("endereço em branco");
        }
    }

    public static void listarContato() {
        for (int i = 0; i < agenda.size(); i++) {
            System.out.println(i+1 + " - " + agenda.get(i).getNomeCompleto().trim());
        }

    }
//    public static void exibirContato(List<Contato> agenda) {
//
//        String contatoDetalhado = agenda.get().getDetalhado();
//        ConsoleUIHelper.drawWithPadding(contatoDetalhado, 80);
//    }
}
