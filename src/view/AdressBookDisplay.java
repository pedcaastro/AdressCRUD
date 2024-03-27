package view;

import controller.PersonQueries;
import models.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class AdressBookDisplay extends JFrame {
    private Person currentEntry;
    private PersonQueries personQueries;
    private List<Person> results;
    private int numberOfEntries = 0;
    private int currentyEntryIndex;

    private JButton browseButton;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;
    private JLabel idLabel;
    private JTextField idTextField;
    private JTextField indexTextField;
    private JLabel lastNameLabel;
    private JTextField lastNameTextField;
    private JTextField maxTextField;
    private JButton nextButton;
    private JLabel ofLabel;
    private JLabel phoneLabel;
    private JTextField phoneTextField;
    private JButton previousButton;
    private JButton queryButton;
    private JLabel queryLabel;
    private JPanel queryPanel;
    private JPanel navigatePanel;
    private JPanel displayPanel;
    private JTextField queryTextField;
    private JButton insertButton;

    public AdressBookDisplay() {
        super("Adress Person");

        personQueries = new PersonQueries();

        navigatePanel = new JPanel();
        previousButton = new JButton();
        indexTextField = new JTextField(2);
        ofLabel = new JLabel();
        maxTextField = new JTextField(2);
        nextButton = new JButton();
        displayPanel = new JPanel();
        idLabel = new JLabel();
        idTextField = new JTextField(10);
        firstNameLabel = new JLabel();
        firstNameTextField = new JTextField(10);
        lastNameLabel = new JLabel();
        lastNameTextField = new JTextField(10);
        emailLabel = new JLabel();
        emailTextField = new JTextField(10);
        phoneLabel = new JLabel();
        phoneTextField = new JTextField(10);
        queryPanel = new JPanel();
        queryLabel = new JLabel();
        queryTextField = new JTextField(10);
        queryButton = new JButton();
        browseButton = new JButton();
        insertButton = new JButton();

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setSize(400, 300);
        setResizable(false);

        navigatePanel.setLayout(
                new BoxLayout(navigatePanel, BoxLayout.X_AXIS)
        );

        previousButton.setText("Voltar");
        previousButton.setEnabled(false);
        previousButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                            previousButtonActionPerfomed(e);
                    }
                }
        );
        navigatePanel.add(previousButton);
        navigatePanel.add(Box.createHorizontalStrut(10));

        indexTextField.setHorizontalAlignment(
                JTextField.CENTER
        );
        indexTextField.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        indexTextFieldActionPerfomed(e);
                    }
                }
        );

        navigatePanel.add(indexTextField);
        navigatePanel.add(Box.createHorizontalStrut(10));

        ofLabel.setText("Of");
        navigatePanel.add(ofLabel);
        navigatePanel.add(Box.createHorizontalStrut(10));

        maxTextField.setHorizontalAlignment(
                JTextField.CENTER
        );
        maxTextField.setEditable(false);
        navigatePanel.add(maxTextField);
        navigatePanel.add(Box.createHorizontalStrut(10));

        nextButton.setText("Próxima");
        nextButton.setEnabled(false);
        nextButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            nextButtonActionPerfomed(e);
                    }
                }
        );

        navigatePanel.add(nextButton);
        add(navigatePanel);

        displayPanel.setLayout(new GridLayout(5, 2, 4, 4));

        idLabel.setText("Endereço ID");
        displayPanel.add(idLabel);

        idTextField.setEditable(false);
        displayPanel.add(idTextField);

        firstNameLabel.setText("Primeiro Nome");
        displayPanel.add(firstNameLabel);
        displayPanel.add(firstNameTextField);

        lastNameLabel.setText("Último nome");
        displayPanel.add(lastNameLabel);
        displayPanel.add(lastNameTextField);

        emailLabel.setText("Email");
        displayPanel.add(emailLabel);
        displayPanel.add(emailTextField);

        phoneLabel.setText("Telefone");
        displayPanel.add(phoneLabel);
        displayPanel.add(phoneTextField);
        add(displayPanel);

        queryPanel.setLayout(
                new BoxLayout(
                        queryPanel, BoxLayout.X_AXIS
                )
        );

        queryPanel.setBorder(BorderFactory.createTitledBorder(
                "Procure pelo último nome"
        ));
        queryLabel.setText("Último nome:");
        queryPanel.add(Box.createHorizontalStrut(5));
        queryPanel.add(queryLabel);
        queryPanel.add(Box.createHorizontalStrut(10));
        queryPanel.add(queryTextField);
        queryPanel.add(Box.createHorizontalStrut(10));


        queryButton.setText("Procurar");
        queryButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        queryButtonPerfomedAction(e);
                    }
                }
        );

        queryPanel.add(queryButton);
        queryPanel.add(Box.createHorizontalStrut(5));
        add(queryPanel);

        browseButton.setText("Mostrar todos os dados");
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    browseButtonActionPerfomed(e);
            }
        });
        add(browseButton);

        insertButton.setText("Inserir novos dados:");
        insertButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        indexTextFieldActionPerfomed(e);
                    }
                }
        );
        add(insertButton);

        addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                    }
                }
        );
    }

    private void previousButtonActionPerfomed(ActionEvent evt) {
        currentyEntryIndex--;

        if (currentyEntryIndex < 0)
            currentyEntryIndex = numberOfEntries - 1;

        indexTextField.setText("" + (currentyEntryIndex + 1));
        indexTextFieldActionPerfomed(evt);
    }

    private void queryButtonPerfomedAction(ActionEvent evt) {
        results = personQueries.getPeopleByLastName(queryTextField.getText());
        numberOfEntries = results.size();

        if (numberOfEntries != 0) {
            currentyEntryIndex = 0;
            currentEntry = results.get(currentyEntryIndex);
            idTextField.setText("" + currentEntry.getAdressID());
            lastNameTextField.setText("" + currentEntry.getLastName());
            firstNameTextField.setText("" + currentEntry.getFirstName());
            emailTextField.setText("" + currentEntry.getEmai());
            phoneTextField.setText("" + currentEntry.getPhoneNumber());
            maxTextField.setText("" + numberOfEntries);
            indexTextField.setText("" + (currentyEntryIndex + 1));
            nextButton.setEnabled(true);
            previousButton.setEnabled(true);
        } else {
            browseButtonActionPerfomed(evt);
        }
    }

    private void nextButtonActionPerfomed(ActionEvent evt){
        currentyEntryIndex++;
        if (currentyEntryIndex>=numberOfEntries)
            currentyEntryIndex=0;


        indexTextField.setText("" + (currentyEntryIndex+1));
        indexTextFieldActionPerfomed(evt);
    }


    private void indexTextFieldActionPerfomed(ActionEvent evt){
        currentyEntryIndex = Integer.parseInt(indexTextField.getText()) - 1;

        if (numberOfEntries != 0 && currentyEntryIndex <numberOfEntries){

            currentEntry = results.get(currentyEntryIndex);
            idTextField.setText("" + currentEntry.getAdressID());
            lastNameTextField.setText("" + currentEntry.getLastName());
            firstNameTextField.setText("" + currentEntry.getFirstName());
            emailTextField.setText("" + currentEntry.getEmai());
            phoneTextField.setText("" + currentEntry.getPhoneNumber());
            maxTextField.setText("" + numberOfEntries);
            indexTextField.setText("" + (currentyEntryIndex + 1));
        }
    }

    private void browseButtonActionPerfomed(ActionEvent evt){
        try {
            results = personQueries.getAllPeople();
            numberOfEntries = results.size();

            if (numberOfEntries!=0){
                currentyEntryIndex = 0;
                currentEntry = results.get(currentyEntryIndex);
                idTextField.setText("" + currentEntry.getAdressID());
                lastNameTextField.setText("" + currentEntry.getLastName());
                firstNameTextField.setText("" + currentEntry.getFirstName());
                emailTextField.setText("" + currentEntry.getEmai());
                phoneTextField.setText("" + currentEntry.getPhoneNumber());
                maxTextField.setText("" + numberOfEntries);
                indexTextField.setText("" + (currentyEntryIndex + 1));
                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void insertButtonActionPerfomed(ActionEvent evt){
        int result = personQueries.addPerson(firstNameTextField.getText(),lastNameTextField.getText(),emailTextField.getText(),phoneTextField.getText());

        if (result ==1)
            JOptionPane.showMessageDialog(this,"Pessoa Adicionada!","Pessoa Adicionada",JOptionPane.PLAIN_MESSAGE);
        else
            JOptionPane.showMessageDialog(this,"Pessoa não adicionada","ERROR",JOptionPane.PLAIN_MESSAGE);

        browseButtonActionPerfomed(evt);
    }

    public static void main(String[] args) {
        new AdressBookDisplay();
    }
}
