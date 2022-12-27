package cs.vsu.ru.skogorev_m_a.gr12;

import java.util.Locale;

//вывод окна
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DrawForm().setVisible(true);
            }
        });
    }
}