import ui.AgendaUI;
import util.ConsoleUIHelper;

import java.io.IOException;


public class App {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        AgendaUI agenda = new AgendaUI();
        System.out.println();
        
        do  {
            agenda.importarArquivoTXT();
            ConsoleUIHelper.drawHeader("AGENDA", 80);
            agenda.menu();
        }
        while (true);

    }

}
