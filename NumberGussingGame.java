/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oasis_project;

/**
 *
 * @author Deep Dutta
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGussingGame extends JFrame {

    private int numberToGuess;
    private int guessesRemaining;
    private JTextField textField;
    private JLabel resultLabel;
    private JButton guessButton;
    private JButton restartButton;
            
    public NumberGussingGame() {
//        initComponents();
        setTitle("Number Gussing Game");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        
        numberToGuess = (int)(Math.random()*100)+1;
        guessesRemaining = 5;
        
        JLabel titleLabel = new JLabel("Guess a Number between 1 to 100 : ");
        add(titleLabel);
        
        textField = new JTextField(10);
        add(textField);
        
        guessButton = new JButton("Guess");
        guessButton.addActionListener(new GuessButtonListener());
        add(guessButton);
        
        resultLabel = new JLabel("Restart");
        restartButton.addActionListener(new RestartButtonListener());
        restartButton.setEnabled(false);
        add(restartButton);
    }
    
    private class GuessButtonListener impplements ActionListener {
        public void actionPerformed(ActionEvent event){
            int guess = Integer.parseInt(textField.getText());
            
            if(guess == numberToGuess){
                resltLabel.setText("You Won The Match..");
                guessButton.setEnabled(false);
                restartButton.setEnabled(true);
            }
            else if(guessesRemaining==1){
                resultLabel.setText("Game Over. The number was " + numberToGuess);
                guessButton.setEnabled(false);
                restartButton.setEnabled(true);
            }
            else if (guess < numberToGuess){
                resultLabel.setText("Too low. Guesses remaining: " + (--guessesRemaining));
            } 
            else {
                resultLabel.setText("Too high. Guesses remaining: " + (--guessesRemaining));
            }
            textField.setText("");
        }
    }
    
    private class RestartButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            numberToGuess = (int) (Math.random() * 100) + 1;
            guessesRemaining = 5;
            resultLabel.setText("");
            guessButton.setEnabled(true);
            restartButton.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NumberGussingGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NumberGussingGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NumberGussingGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NumberGussingGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NumberGussingGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
