package util;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public class UIUtils {
	private static final List<Image> QUIZ_BACKGROUND_IMAGES = new ArrayList<>();
    private static Random random = new Random();
    
    static {
        String[] imagePaths = {
            "/assets/images/alien_background.gif", 
            "/assets/images/astronaut.gif",
            "/assets/images/fish_background.gif",
            "/assets/images/girl_in_ship_background.gif",
            "/assets/images/rain_background.gif"
        };

        for (String path : imagePaths) {
            try {
                var url = UIUtils.class.getResource(path);
                if (url == null) {
                    System.err.println("Imagem não encontrada: " + path);
                    continue;
                }
                Image img = new ImageIcon(url).getImage();
                QUIZ_BACKGROUND_IMAGES.add(img);
            } catch (Exception e) {
                System.err.println("Erro ao carregar imagem: " + path);
                e.printStackTrace();
            }
        }
    }

    
	public static Image getRandomQuizBackgroundImage() {
        if (QUIZ_BACKGROUND_IMAGES.isEmpty()) {
            return null;
        }
        int randomIndex = random.nextInt(QUIZ_BACKGROUND_IMAGES.size());
        return QUIZ_BACKGROUND_IMAGES.get(randomIndex);
    }
	
	public static void registrarFonte(String caminhoDaFonte) throws FontFormatException, IOException {
        InputStream is = UIUtils.class.getResourceAsStream(caminhoDaFonte); 
        if (is == null) {
            throw new IOException("Recurso da fonte não encontrado: " + caminhoDaFonte);
        }
        Font fonte = Font.createFont(Font.TRUETYPE_FONT, is);
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(fonte);
    }

    public static Font obterFonte(String nomeDaFonte, float tamanho) {
        return new Font(nomeDaFonte, Font.PLAIN, (int)tamanho);
    }
    
    
}
