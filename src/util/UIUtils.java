package util;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

public class UIUtils {
	public static void registrarFonte(String caminhoDaFonte) throws FontFormatException, IOException {
        InputStream is = UIUtils.class.getResourceAsStream(caminhoDaFonte); //
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
