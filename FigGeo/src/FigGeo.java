import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FigGeo extends JFrame{
    private JRadioButton sześcianRadioButton;
    private JRadioButton prostopadłościanRadioButton;
    private JRadioButton walecRadioButton;
    private JRadioButton kulaRadioButton;
    private JRadioButton kwadratRadioButton;
    private JRadioButton prostokątRadioButton;
    private JRadioButton trójkątRadioButton;
    private JRadioButton trapezRadioButton;
    private JTextField textFBokA;
    private JTextField textFBokB;
    private JTextField textFWysokosc;
    private JTextField textFPromien;
    private JTextField textFiPole;
    private JTextField textFObwod;
    private JTextField textFObjetosc;
    private JButton obliczButton;
    private JButton wyczyśćButton;
    private JPanel JPanelMain;

    private int a;
    private int b;
    private int wysokosc;
    private int promien;
    private int pole;
    private double poleD;
    private int obw;
    private int obj;
    private double objD;

    public static void main(String[] args){
        FigGeo conFigGeo = new FigGeo();
        conFigGeo.setVisible(true);
    }

    public FigGeo(){
        super("Figury Geometryczne - kalkulator");
        this.setContentPane(this.JPanelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setLayout(null);
        obliczButton.addActionListener(listener);
        wyczyśćButton.addActionListener(listener);
        kwadratRadioButton.addActionListener(listener);
        prostokątRadioButton.addActionListener(listener);
        trójkątRadioButton.addActionListener(listener);
        trapezRadioButton.addActionListener(listener);
        sześcianRadioButton.addActionListener(listener);
        prostopadłościanRadioButton.addActionListener(listener);
        walecRadioButton.addActionListener(listener);
        kulaRadioButton.addActionListener(listener);
    }

    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object ob1 = e.getSource();
            if (ob1 == obliczButton && kwadratRadioButton.isSelected()) {
                a = Integer.parseInt(textFBokA.getText());
                pole = a * a;
                textFiPole.setText(String.valueOf(pole));
                obw = 4*a;
                textFObwod.setText(String.valueOf(obw));
                textFObjetosc.setText("");
            } else if (ob1 == obliczButton && prostokątRadioButton.isSelected()){
                a = Integer.parseInt(textFBokA.getText());
                b = Integer.parseInt(textFBokB.getText());
                pole = a * b;
                textFiPole.setText(String.valueOf(pole));
                obw = 2 * a + 2 * b;
                textFObwod.setText(String.valueOf(obw));
                textFObjetosc.setText("");
            }else if (ob1 == obliczButton && trójkątRadioButton.isSelected()){
                a = Integer.parseInt(textFBokA.getText());
                wysokosc = Integer.parseInt(textFWysokosc.getText());
                pole = (a * wysokosc)/2;
                textFiPole.setText(String.valueOf(pole));
                obw = 3 * a;
                textFObwod.setText(String.valueOf(obw));
                textFObjetosc.setText("");
            } else if (ob1 == obliczButton && trapezRadioButton.isSelected()){
                a = Integer.parseInt(textFBokA.getText());
                b = Integer.parseInt(textFBokB.getText());
                wysokosc = Integer.parseInt((textFWysokosc.getText()));
                pole = ((a + b) * wysokosc)/2;
                textFiPole.setText(String.valueOf(pole));
                textFObwod.setText("");
                textFObjetosc.setText("");
            } else if (ob1 == obliczButton && sześcianRadioButton.isSelected()){
                a = Integer.parseInt(textFBokA.getText());
                pole = (a * a) * 6;
                textFiPole.setText(String.valueOf(pole));
                textFObwod.setText("");
                obj = a * a * a;
                textFObjetosc.setText(String.valueOf(obj));
            } else if (ob1 == obliczButton && prostopadłościanRadioButton.isSelected()){
                a = Integer.parseInt(textFBokA.getText());
                b = Integer.parseInt(textFBokB.getText());
                wysokosc = Integer.parseInt(textFWysokosc.getText());
                pole = (a * b) * 2 + (a * wysokosc) * 2 + (b * wysokosc) * 2;
                textFiPole.setText(String.valueOf(pole));
                textFObwod.setText("");
                obj = a * b * wysokosc;
                textFObjetosc.setText(String.valueOf(obj));
            } else if (ob1 == obliczButton && walecRadioButton.isSelected()){
                promien = Integer.parseInt(textFPromien.getText());
                wysokosc = Integer.parseInt(textFWysokosc.getText());
                poleD = 2 * (Math.PI * Math.pow(promien, 2)) + 2 * Math.PI * promien * wysokosc;
                textFiPole.setText(String.valueOf(poleD));
                textFObwod.setText("");
                objD = Math.PI * Math.pow(promien, 2) * wysokosc;
                textFObjetosc.setText(String.valueOf(objD));
            } else if (ob1 == obliczButton && kulaRadioButton.isSelected()){
                promien = Integer.parseInt(textFPromien.getText());
                poleD= 4 * Math.PI * Math.pow(promien, 2);
                textFiPole.setText(String.valueOf(poleD));
                textFObwod.setText("");
                objD = (4/3) * Math.PI * Math.pow(promien,3);
                textFObjetosc.setText(String.valueOf(objD));
            }
            else if (ob1 == wyczyśćButton){
                textFBokA.setText("");
                textFBokB.setText("");
                textFWysokosc.setText("");
                textFPromien.setText("");
                textFiPole.setText("");
                textFObwod.setText("");
                textFObjetosc.setText("");
                if(kwadratRadioButton.isSelected() == true) kwadratRadioButton.setSelected(false);
                else if(prostokątRadioButton.isSelected() == true) prostokątRadioButton.setSelected(false);
                else if(trójkątRadioButton.isSelected() == true) trójkątRadioButton.setSelected(false);
                else if(trapezRadioButton.isSelected() == true) trapezRadioButton.setSelected(false);
                else if(sześcianRadioButton.isSelected() == true) sześcianRadioButton.setSelected(false);
                else if(prostopadłościanRadioButton.isSelected() == true) prostopadłościanRadioButton.setSelected(false);
                else if(walecRadioButton.isSelected() == true) walecRadioButton.setSelected(false);
                else if(kulaRadioButton.isSelected() == true) kulaRadioButton.setSelected(false);

            } else if (ob1 == kwadratRadioButton){
                if(kwadratRadioButton.isSelected() == true){
                    textFBokA.setEnabled(true);
                } else {
                    textFBokA.setEnabled(false);
                }
            } else if (ob1 == prostokątRadioButton){
                if(prostokątRadioButton.isSelected() == true){
                    textFBokA.setEnabled(true);
                    textFBokB.setEnabled(true);
                } else {
                    textFBokA.setEnabled(false);
                    textFBokB.setEnabled(false);
                }
            } else if (ob1 == trójkątRadioButton){
                if(trójkątRadioButton.isSelected() == true){
                    textFBokA.setEnabled(true);
                    textFWysokosc.setEnabled(true);
                } else {
                    textFBokA.setEnabled(false);
                    textFWysokosc.setEnabled(false);
                }
            } else if (ob1 == trapezRadioButton){
                if(trapezRadioButton.isSelected() == true){
                    textFBokA.setEnabled(true);
                    textFBokB.setEnabled(true);
                    textFWysokosc.setEnabled(true);
                } else {
                    textFBokA.setEnabled(false);
                    textFBokB.setEnabled(false);
                    textFWysokosc.setEnabled(false);
                }
            } else if (ob1 == sześcianRadioButton){
                if(sześcianRadioButton.isSelected() == true){
                    textFBokA.setEnabled(true);
                } else {
                    textFBokA.setEnabled(false);
                }
            } else if (ob1 == prostopadłościanRadioButton){
                if(prostopadłościanRadioButton.isSelected() == true){
                    textFBokA.setEnabled(true);
                    textFBokB.setEnabled(true);
                    textFWysokosc.setEnabled(true);
                } else {
                    textFBokA.setEnabled(false);
                    textFBokB.setEnabled(false);
                    textFWysokosc.setEnabled(false);
                }
            } else if (ob1 == walecRadioButton){
                if(walecRadioButton.isSelected() == true){
                    textFPromien.setEnabled(true);
                    textFWysokosc.setEnabled(true);
                } else {
                    textFPromien.setEnabled(false);
                    textFWysokosc.setEnabled(false);
                }
            } else if (ob1 == kulaRadioButton){
                if(kulaRadioButton.isSelected() == true){
                    textFPromien.setEnabled(true);
                } else {
                    textFPromien.setEnabled(false);
                }
            }
        }
    };
}
