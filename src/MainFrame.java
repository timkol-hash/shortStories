import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;

public class MainFrame extends JFrame {
    private JTabbedPane shortPeresTb;
    private JTabbedPane tbb;
    private JTabbedPane MainTb;
    private JLabel lb;
    private JLabel lb1;
    private JPanel pnl;
    private JPanel pnl1;
    private Font font = new Font("Times New Roman", Font.PLAIN, 24);
    private JComboBox<String> jcb1 = new JComboBox();
    private JComboBox<String> jcb2 = new JComboBox();
    private ImageIcon icon = new ImageIcon("src\\DATA\\_MAIN_FILES_\\icon.png");
    private JComboBox<String> jcb3 = new JComboBox();

    public MainFrame(String title) {
        super(title);
        MainTb = new JTabbedPane();
        shortPeresTb = new JTabbedPane();
        MainTb.addTab("Краткие пересказы", shortPeresTb);
        createMainTab(2);
        createInfo();
        createMainTab(1);
        setSize(1000, 1000);
        setIconImage(icon.getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }


    private void createTab(String name, String[] items, JComboBox<String> comp) {
        JPanel pnl = new JPanel();
        JPanel pnl1 = new JPanel();
        ScrollPane Spnl2 = new ScrollPane();
        for (int i = 0; i < items.length; i++) {
            comp.addItem(items[i]);
        }
        JTextArea txt = new JTextArea();
        txt.setFont(font);
        txt.setEditable(false);
        shortPeresTb.addTab(name, pnl);
        pnl1.add(comp);
        Spnl2.add(txt);
        comp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch ((String) comp.getSelectedItem()) {
                    case "'Игрок' Федор Достоевский":
                        try {
                            File files = new File("src\\DATA\\NOVELS\\'Игрок' Федор Достоевский.txt");
                            String lines = Files.readString(Paths.get(files.getPath()));
                            txt.setText("");
                            txt.setText(lines);
                            break;
                        } catch (Exception err) {
                            JOptionPane.showMessageDialog(null, "Файл с расположением \n" + err.getMessage() + "\nне найден", "Краткие пересказы", JOptionPane.ERROR_MESSAGE);

                        }
                    case "'Ася' Иван Тургенев":
                        try {
                            File files = new File("src\\DATA\\NOVELS\\'Ася' Иван Тургенев.txt");
                            String lines = Files.readString(Paths.get(files.getPath()));
                            txt.setText("");
                            txt.setText(lines);
                            break;
                        } catch (Exception err) {
                            JOptionPane.showMessageDialog(null, "Файл с расположением \n" + err.getMessage() + "\nне найден", "Краткие пересказы", JOptionPane.ERROR_MESSAGE);

                        }
                    case "'Старик и море' Эрнест Хемингуэй":
                        try {
                            File files = new File("src\\DATA\\NOVELS\\'Старик и море' Эрнест Хемингуэй.txt");
                            String lines = Files.readString(Paths.get(files.getPath()));
                            txt.setText("");
                            txt.setText(lines);
                            break;
                        } catch (Exception err) {
                            JOptionPane.showMessageDialog(null, "Файл с расположением \n" + err.getMessage() + "\nне найден", "Краткие пересказы", JOptionPane.ERROR_MESSAGE);

                        }
                }

            }
        });
        pnl.add(pnl1);
        pnl.add(Spnl2);
        pnl.setLayout(new GridLayout(2, 1));
        Spnl2.add(BorderLayout.NORTH, txt);
        pnl.add(BorderLayout.NORTH, pnl1);
        pnl.add(BorderLayout.CENTER, Spnl2);
        pnl1.setSize(getWidth(), 100);
    }

    private void createMainTab(int num) {
        if (num == 1) {
            createTab(
                    "Романы",
                    new String[]{"Пока к сожалению нет"},
                    jcb1);
            createTab(
                    "Повести",
                    new String[]{"'Шинель' Н.В. Гоголь",
                            "'Белые ночи' Ф.М. Достоевский",
                            "'Олеся' А.И. Куприн",},
                    jcb2);
            createTab(
                    "Стихотворения",
                    new String[]{"'Я помню чудное мгновение' А.С. Пушкин",
                            "'Зимнее утро' А.С. Пушкин",
                            "'' "},
                    jcb3);
            add(MainTb);
        } else if (num == 2){
            pnl1 = new JPanel();
            lb1 = new JLabel();
            pnl1.add(lb1);
            Font font1 = new Font("Times New Roman", Font.PLAIN,50);
            String txt = "              Ведутся работы{{{(>_<)}}}";
            lb1.setText(txt);
            lb1.setFont(font1);
            MainTb.addTab("Биографии", lb1);
        }
    }

    private void createInfo() {
        pnl = new JPanel();
        lb = new JLabel();
        pnl.add(lb);
        Font font1 = new Font("Times New Roman", Font.PLAIN, 15);
        String txt = "Привет! Это литературная утилита, в которой есть... (пока реализован далеко не весь функционал) Автор программы - Колесник Тимофей Витальевич";
        lb.setText(txt);
        lb.setFont(font1);
        MainTb.addTab("О программе", lb);
    }

}
