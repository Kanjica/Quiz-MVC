package view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class TransitionPanel extends JPanel{
	private JPanel currentPanel; // painel atual
	private JPanel nextPanel; // proximo painel
	
	private Timer timer; // p controlar animação
	private int animationProgress; // de 0 a ANIMATION_STEPS
	private int animationDirection; // -1 esquerda, 1 direita
	
	private final int ANIMATION_STEPS = 20; //num de frames
	private final int ANIMATION_DELAY_MS = 15; // delay
	
	public TransitionPanel() {
		setLayout(null);
		//setOpaque(false);
		timer = new Timer(ANIMATION_DELAY_MS, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateAnimation();
			}
		});
	}
	
	public void setPanel(JPanel panel) {
		if(currentPanel!=null) {
			remove(currentPanel);
		}
		this.currentPanel = panel;
		this.currentPanel.setBounds(0, 0, getWidth(), getHeight());
        add(currentPanel);
        revalidate(); 
        repaint();
	}
	
	public void transitionTo(JPanel newPanel, int direction) {
		this.nextPanel = newPanel;
		this.animationDirection = direction;
		this.animationProgress = 0;
		
		// Garante que o painel atual esteja adicionado e com o tamanho correto
        if (currentPanel != null && currentPanel.getParent() == null) {
             add(currentPanel);
             currentPanel.setBounds(0, 0, getWidth(), getHeight());
        }
        
        if (direction == 1) { // Nova tela vem da esquerda (slide para direita)
            nextPanel.setBounds(-getWidth(), 0, getWidth(), getHeight());
        } 
        else { // Nova tela vem da direita (slide para esquerda)
            nextPanel.setBounds(getWidth(), 0, getWidth(), getHeight());
        }
        add(nextPanel, 0); 
        timer.start();
	}
	
	private void updateAnimation() {
        animationProgress++;

        if (animationProgress <= ANIMATION_STEPS) {
            // Calcula o progresso percentual da animação (de 0.0 a 1.0)
            float progress = (float) animationProgress / ANIMATION_STEPS;
            // Calcula o deslocamento horizontal dos painéis
            int offset = (int) (getWidth() * progress);

            if (animationDirection == 1) { // Painel atual sai para a direita, novo entra pela esquerda
                if (currentPanel != null) {
                    currentPanel.setLocation(offset, 0); // Move o painel atual para a direita
                }
                nextPanel.setLocation(-getWidth() + offset, 0); // Move o próximo painel para a direita
            } 
            else { // Painel atual sai para a esquerda, novo entra pela direita
                if (currentPanel != null) {
                    currentPanel.setLocation(-offset, 0); // Move o painel atual para a esquerda
                }
                nextPanel.setLocation(getWidth() - offset, 0); // Move o próximo painel para a esquerda
            }
            repaint(); // Solicita a repintura para mostrar o movimento
        } 
        else {
            // A animação terminou
            timer.stop();

            // Remove o painel antigo
            if (currentPanel != null) {
                remove(currentPanel);
            }
            // Define o novo painel como o painel atual
            currentPanel = nextPanel;
            currentPanel.setLocation(0, 0); // Garante que o painel final esteja na posição correta
            remove(nextPanel); // Remove e adiciona de novo para garantir que esteja no topo da ordem Z
            add(currentPanel);

            revalidate(); // Revalida o layout
            repaint();    // Repinta a tela final
        }
    }
	
	
	@Override 
	public void doLayout() {
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
	}
}
