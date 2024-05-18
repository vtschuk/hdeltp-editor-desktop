package devoss.hdstep.desktop.gui.menu.builder;

import devoss.hdstep.desktop.gui.menu.listeners.components.analog.*;
import devoss.hdstep.desktop.gui.menu.listeners.components.analog.devices.*;
import devoss.hdstep.desktop.gui.menu.listeners.components.digital.*;
import devoss.hdstep.desktop.gui.menu.listeners.components.digital.devices.BIOSComponentMenuItemActionListener;
import devoss.hdstep.desktop.gui.menu.listeners.components.digital.devices.MemoryComponentMenuItemActionListener;
import devoss.hdstep.desktop.windows.HDStepFrame;

import javax.swing.*;
import javax.swing.event.MenuDragMouseListener;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ComponentMenuBuilder extends MenuBuilder {
    private final HDStepFrame frame;
    private final List<ComponentMenuBuilder.MenuEntry> analogComponentsMenuEntries = new ArrayList<>();
    private final List<ComponentMenuBuilder.MenuEntry> analogDeviceMenuEntries = new ArrayList<>();

    private final List<ComponentMenuBuilder.MenuEntry> digitalComponentMenuEntiries = new ArrayList<>();
    private final List<ComponentMenuBuilder.MenuEntry> digitalDevicesMenuEnties = new ArrayList<>();

    private final List<ComponentMenuBuilder.MenuEntry> integratedComponentMenuEnties = new ArrayList<>();
    private final List<ComponentMenuBuilder.MenuEntry> integratedCirquitMenuEntries = new ArrayList<>();
    private final List<ComponentMenuBuilder.MenuEntry> integratedDeviceMenuEntries = new ArrayList<>();

    public ComponentMenuBuilder(HDStepFrame frame) {
        this.frame = frame;
        addAnalogComponents();
        addAnalogDevices();
        addDigitalComponents();
        addDigitalDevices();
    }

    @Override
    public JMenu createMenu() {
        JMenu componentMenu = new JMenu("Komponente");
        JMenu analogComponents = new JMenu("Analog");
        componentMenu.add(analogComponents);

        // add analog components
        analogComponentsMenuEntries.stream().map(menuEntry -> new HDStepMenuItem.Builder(menuEntry.title)
                .icon(menuEntry.icon)
                .actionListener(menuEntry.actionListener)
                .menuDragMouseListener(menuEntry.menuDragMouseListener)
                .toolTip(menuEntry.toolTip)
                .build()
        ).forEach(item -> analogComponents.add(item));

        JMenu analogDeviceComponents = new JMenu("Devices");
        analogComponents.add(analogDeviceComponents);

        // add analog devices
        analogDeviceMenuEntries.stream().map(menuEntry -> new HDStepMenuItem.Builder(menuEntry.title)
                .icon(menuEntry.icon)
                .actionListener(menuEntry.actionListener)
                .toolTip(menuEntry.toolTip)
                .build()
        ).forEach(item -> analogDeviceComponents.add(item));

        JMenu digitalComponents = new JMenu("Digital");
        componentMenu.add(digitalComponents);

        // add digital components
        digitalComponentMenuEntiries.stream().map(menuEntry -> new HDStepMenuItem.Builder(menuEntry.title)
                .icon(menuEntry.icon)
                .actionListener(menuEntry.actionListener)
                .toolTip(menuEntry.toolTip)
                .build()
        ).forEach(item -> digitalComponents.add(item));

        JMenu digitalDeviceComponents = new JMenu("Devices");
        digitalComponents.add(digitalDeviceComponents);

        // add digital devices
        digitalDevicesMenuEnties.stream().map(menuEntry -> new HDStepMenuItem.Builder(menuEntry.title)
                .icon(menuEntry.icon)
                .actionListener(menuEntry.actionListener)
                .toolTip(menuEntry.toolTip)
                .build()
        ).forEach(item -> digitalDeviceComponents.add(item));

        //integrated
        JMenu integratedComponents = new JMenu("Integrated");
        componentMenu.add(integratedComponents);
        JMenu chipsIntegratedComponents = new JMenu("Chips");
        integratedComponents.add(chipsIntegratedComponents);


        // add integrated chips
        integratedComponentMenuEnties.stream().map(menuEntry -> new HDStepMenuItem.Builder(menuEntry.title)
                .icon(menuEntry.icon)
                .actionListener(menuEntry.actionListener)
                .toolTip(menuEntry.toolTip)
                .build()
        ).forEach(item -> chipsIntegratedComponents.add(item));

        JMenu cirquitsIntegratedComponents = new JMenu("Schaltungen");
        integratedComponents.add(cirquitsIntegratedComponents);

        //add integrated cirquits
        integratedCirquitMenuEntries.stream().map(menuEntry -> new HDStepMenuItem.Builder(menuEntry.title)
                .icon(menuEntry.icon)
                .actionListener(menuEntry.actionListener)
                .toolTip(menuEntry.toolTip)
                .build()
        ).forEach(item -> cirquitsIntegratedComponents.add(item));

        JMenu devicesIntegratedComponents = new JMenu("Devices");
        integratedComponents.add(devicesIntegratedComponents);

        //add integated devices
        integratedDeviceMenuEntries.stream().map(menuEntry -> new HDStepMenuItem.Builder(menuEntry.title)
                .icon(menuEntry.icon)
                .actionListener(menuEntry.actionListener)
                .toolTip(menuEntry.toolTip)
                .build()
        ).forEach(item -> devicesIntegratedComponents.add(item));

        return componentMenu;
    }

    private void addAnalogComponents() {
        ComponentMenuBuilder.MenuEntry menuEntry;

        //Leitung
        menuEntry = new ComponentMenuBuilder.MenuEntry("Leitung",
                new WireComponentMenuItemActionListener(frame),
                new WireComponentMenuItemActionListener(frame),
                "icons/elements/image.16.png", "Leitung");
        this.analogComponentsMenuEntries.add(menuEntry);

        // Widerstand
        menuEntry = new ComponentMenuBuilder.MenuEntry("Widerstand",
                new ResistanceComponentMenuItemActionListener(frame),
                null,
                "icons/elements/image.16.png", "Widerstand");
        this.analogComponentsMenuEntries.add(menuEntry);

        //Capacitor
        menuEntry = new ComponentMenuBuilder.MenuEntry("Kondensator",
                new CapacitorComponentMenuItemActionListener(frame.getDesktopPane()),
                null,
                "icons/elements/image.16.png", "Kondensator");
        this.analogComponentsMenuEntries.add(menuEntry);

        //Coil
        menuEntry = new ComponentMenuBuilder.MenuEntry("Spule",
                new CoilComponentMenuItemActionListener(frame.getDesktopPane()),
                null,
                "icons/elements/image.16.png", "Spule");
        this.analogComponentsMenuEntries.add(menuEntry);

        //Diode
        menuEntry = new ComponentMenuBuilder.MenuEntry("Diode",
                new DiodeComponentMenuItemActionListener(frame.getDesktopPane()),
                null,
                "icons/elements/image.16.png", "Diode");
        this.analogComponentsMenuEntries.add(menuEntry);

        //NPN
        menuEntry = new ComponentMenuBuilder.MenuEntry("NPN",
                new NPNTransistorComponentMenuItemActionListener(frame.getDesktopPane()),
                null,
                "icons/elements/image.16.png", "NPN");
        this.analogComponentsMenuEntries.add(menuEntry);

        //PNP
        menuEntry = new ComponentMenuBuilder.MenuEntry("PNP",
                new PNPTransistorComponentMenuItemActionListener(frame.getDesktopPane()),
                null,
                "icons/elements/image.16.png", "PNP");
        this.analogComponentsMenuEntries.add(menuEntry);
    }

    private void addAnalogDevices() {
        MenuEntry menuEntry;

        // Amperemeter
        menuEntry = new MenuEntry("Amperemeter",
                new AmpereMeterComponentMenuItemActionListener(frame.getDesktopPane()),
                null,
                "icons/elements/image.16.png", "Amperemeter");
        this.analogDeviceMenuEntries.add(menuEntry);

        // Generator
        menuEntry = new MenuEntry("Generator",
                new GeneratorComponentMenuItemActionListener(frame.getDesktopPane()),
                null,
                "icons/elements/image.16.png", "Generator");
        this.analogDeviceMenuEntries.add(menuEntry);

        // Heissleiter
        menuEntry = new MenuEntry("Heissleiter",
                new HeissLeiterComponentMenuItemActionListener(frame.getDesktopPane()),
                null,
                "icons/elements/image.16.png", "Heissleiter");
        this.analogDeviceMenuEntries.add(menuEntry);

        // Kaltleiter
        menuEntry = new MenuEntry("Kaltleiter",
                new KaltleiterComponentMenuItemActionListener(frame.getDesktopPane()),
                null,
                "icons/elements/image.16.png", "Kaltleiter");
        this.analogDeviceMenuEntries.add(menuEntry);

        // Klingel
        menuEntry = new MenuEntry("Klingel",
                new KlingelComponentMenuItemActionListener(frame.getDesktopPane()),
                null,
                "icons/elements/image.16.png", "Klingel");
        this.analogDeviceMenuEntries.add(menuEntry);

        // Manometer
        menuEntry = new MenuEntry("Manometer",
                new ManometerComponentMenuItemActionListener(frame.getDesktopPane()),
                null,
                "icons/elements/image.16.png", "Manometer");
        this.analogDeviceMenuEntries.add(menuEntry);

        // Microfon
        menuEntry = new MenuEntry("Microfon",
                new MicrofonComponentMenuItemActionListener(frame.getDesktopPane()),
                null,
                "icons/elements/image.16.png", "Microfon");
        this.analogDeviceMenuEntries.add(menuEntry);

        // Motor
        menuEntry = new MenuEntry("Motor",
                new MotorComponentMenuItemActionListener(frame.getDesktopPane()),
                null,
                "icons/elements/image.16.png", "Motor");
        this.analogDeviceMenuEntries.add(menuEntry);

        // Oszioloskop
        menuEntry = new MenuEntry("Oszioloskop",
                new OszioloskopComponentMenuItemActionListener(frame.getDesktopPane()),
                null,
                "icons/elements/image.16.png", "Oszioloskop");
        this.analogDeviceMenuEntries.add(menuEntry);

        // Spreaker
        menuEntry = new MenuEntry("Speaker",
                new SpeakerComponentMenuItemActionListener(frame.getDesktopPane()),
                null,
                "icons/elements/image.16.png", "Speaker");
        this.analogDeviceMenuEntries.add(menuEntry);

        // Summer
        menuEntry = new MenuEntry("Summer",
                new SummerComponentMenuItemActionListener(frame.getDesktopPane()),
                null,
                "icons/elements/image.16.png", "Summer");
        this.analogDeviceMenuEntries.add(menuEntry);

        // Thermometer
        menuEntry = new MenuEntry("Summer",
                new ThermometerComponentMenuItemActionListener(frame.getDesktopPane()),
                 null, "icons/elements/image.16.png", "Summer");
        this.analogDeviceMenuEntries.add(menuEntry);

        // Transformator
        menuEntry = new MenuEntry("Transformator",
                new TransformatorComponentMenuItemActionListener(frame.getDesktopPane()),
                 null, "icons/elements/image.16.png", "Transformator");
        this.analogDeviceMenuEntries.add(menuEntry);

        // Varistor
        menuEntry = new MenuEntry("Varistor",
                new VaristorComponentMenuItemActionListener(frame.getDesktopPane()),
                 null, "icons/elements/image.16.png", "Varistor");
        this.analogDeviceMenuEntries.add(menuEntry);

        // Voltmeter
        menuEntry = new MenuEntry("Voltmeter",
                new VoltmeterComponentMenuItemActionListener(frame.getDesktopPane()),
                 null, "icons/elements/image.16.png", "Voltmeter");
        this.analogDeviceMenuEntries.add(menuEntry);
    }

    private void addDigitalComponents() {
        MenuEntry menuEntry;

        // AND Gatter
        menuEntry = new MenuEntry("AND",
                new ANDComponentMenuItemActionListener(frame.getDesktopPane()),
                null, "icons/elements/image.16.png", "AND");
        this.digitalComponentMenuEntiries.add(menuEntry);

        // NAND Gatter
        menuEntry = new MenuEntry("NAND",
                new NANDComponentMenuItemActionListener(frame.getDesktopPane()),
                null, "icons/elements/image.16.png", "NAND");
        this.digitalComponentMenuEntiries.add(menuEntry);

        // NOR Gatter
        menuEntry = new MenuEntry("NOR",
                new NORComponentMenuItemActionListener(frame.getDesktopPane()),
                null, "icons/elements/image.16.png", "NOR");
        this.digitalComponentMenuEntiries.add(menuEntry);

        // NOT Gatter
        menuEntry = new MenuEntry("NOT",
                new NOTComponentMenuItemActionListener(frame.getDesktopPane()),
                null, "icons/elements/image.16.png", "NOT");
        this.digitalComponentMenuEntiries.add(menuEntry);

        // XAND Gatter
        menuEntry = new MenuEntry("XAND",
                new XANDComponentMenuItemActionListener(frame.getDesktopPane()),
                null, "icons/elements/image.16.png", "XAND");
        this.digitalComponentMenuEntiries.add(menuEntry);

        // XOR Gatter
        menuEntry = new MenuEntry("XOR",
                new XORComponentMenuItemActionListener(frame.getDesktopPane()),
                null, "icons/elements/image.16.png", "XOR");
        this.digitalComponentMenuEntiries.add(menuEntry);
    }

    private void addDigitalDevices() {
        MenuEntry menuEntry;

        // BIOS
        menuEntry = new MenuEntry("BIOS",
                new BIOSComponentMenuItemActionListener(frame.getDesktopPane()),
                null, "icons/elements/image.16.png", "BIOS");
        this.digitalDevicesMenuEnties.add(menuEntry);

        // Memory
        menuEntry = new MenuEntry("Memory",
                new MemoryComponentMenuItemActionListener(frame.getDesktopPane()),
                null, "icons/elements/image.16.png", "Memory");
        this.digitalDevicesMenuEnties.add(menuEntry);
    }

    private class MenuEntry {
        private final String title;
        private final ActionListener actionListener;
        private final MenuDragMouseListener menuDragMouseListener;
        private final String icon;
        private final String toolTip;

        private MenuEntry(String title, ActionListener actionListener, MenuDragMouseListener menuDragMouseListener, String icon, String toolTip) {
            this.title = title;
            this.actionListener = actionListener;
            this.menuDragMouseListener = menuDragMouseListener;
            this.icon = icon;
            this.toolTip = toolTip;
        }
    }
}
