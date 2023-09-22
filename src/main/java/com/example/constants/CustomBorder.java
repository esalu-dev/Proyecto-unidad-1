package com.example.constants;

import java.awt.*;
import javax.swing.border.AbstractBorder;

public class CustomBorder extends AbstractBorder {
    private final Color colorSuperior;
    private final Color colorInferior;
    private final Color colorIzquierda;
    private final Color colorDerecha;
    private final int grosor;

    public CustomBorder(Color colorSuperior, Color colorInferior, Color colorIzquierda, Color colorDerecha, int grosor) {
        this.colorSuperior = colorSuperior;
        this.colorInferior = colorInferior;
        this.colorIzquierda = colorIzquierda;
        this.colorDerecha = colorDerecha;
        this.grosor = grosor;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;

        // Dibujar el borde superior
        g2d.setColor(colorSuperior);
        g2d.fillRect(x, y, width, grosor);

        // Dibujar el borde inferior
        g2d.setColor(colorInferior);
        g2d.fillRect(x, y + height - grosor, width, grosor);

        // Dibujar el borde izquierdo
        g2d.setColor(colorIzquierda);
        g2d.fillRect(x, y, grosor, height);

        // Dibujar el borde derecho
        g2d.setColor(colorDerecha);
        g2d.fillRect(x + width - grosor, y, grosor, height);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(grosor, grosor, grosor, grosor);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.top = grosor;
        insets.left = grosor;
        insets.bottom = grosor;
        insets.right = grosor;
        return insets;
    }
}
