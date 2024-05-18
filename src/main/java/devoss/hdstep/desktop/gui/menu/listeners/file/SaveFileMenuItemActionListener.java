package devoss.hdstep.desktop.gui.menu.listeners.file;

import devoss.hdstep.desktop.windows.AbstractHDStepInternalFrame;
import devoss.hdstep.desktop.windows.HDSTEPDesktopPane;
import devoss.hdstep.desktop.windows.HDStepInternalFrame;
import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveFileMenuItemActionListener implements ActionListener {
    private HDSTEPDesktopPane desktopPane;

    public SaveFileMenuItemActionListener(HDSTEPDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List< devoss.hdstep.desktop.sheet.elements.Element> elementList = this.desktopPane.getSelectedFrame().getPanel().getElements();
        elementList.forEach(System.out::println);

        DOMImplementation domImplementation = SVGDOMImplementation.getDOMImplementation();
        String svgNamespace = SVGDOMImplementation.SVG_NAMESPACE_URI;
        Document document = domImplementation.createDocument(svgNamespace, "svg", null);
        // Get the root element (the 'svg' element).
        Element svgRoot = document.getDocumentElement();

        // Set the width and height attributes on the root 'svg' element.
        svgRoot.setAttributeNS(null, "width", "400");
        svgRoot.setAttributeNS(null, "height", "450");

        // Create the rectangle.
        Element rectangle = document.createElementNS(svgNamespace, "rect");
        rectangle.setAttributeNS(null, "x", "10");
        rectangle.setAttributeNS(null, "y", "20");
        rectangle.setAttributeNS(null, "width", "100");
        rectangle.setAttributeNS(null, "height", "50");
        rectangle.setAttributeNS(null, "fill", "red");

        // Attach the rectangle to the root 'svg' element.
        svgRoot.appendChild(rectangle);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException ex) {
            throw new RuntimeException(ex);
        }

        DOMSource domSource = new DOMSource(document);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(new File("test.svg"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        StreamResult streamResult = new StreamResult(fileWriter);
        try {
            transformer.transform(domSource, streamResult);
        } catch (TransformerException ex) {
            throw new RuntimeException(ex);
        }
    }

}
