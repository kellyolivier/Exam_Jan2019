import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class UI extends JFrame {

    private Controller controller;
    private JPanel leftBar;
    private JPanel infoPanel;
    private JScrollPane leftBarScroll;
    private JList list;

    private JLabel id = new JLabel();
    private JLabel companyName = new JLabel();
    private JLabel customerName = new JLabel();
    private JLabel companyStanding = new JLabel();
    private JLabel companyPhone = new JLabel();
    private JLabel customerPhone = new JLabel();
    private JLabel customerAddress = new JLabel();

    public UI(Controller newController)
    {
        super();
        controller = newController;

        this.setPreferredSize(new Dimension (700, 500));

        //careful of order after this point in constructor
        panelSetup();

        this.setVisible(true);
    }

    public void panelSetup() //panel layouts etc
    {
        this.setLayout(new BorderLayout());

        leftBar = new JPanel();
        infoPanel = new JPanel();
        list = new JList(controller.createBasisForList());
        leftBarScroll = new JScrollPane(list);

        //add main panels to frame
        this.add(leftBar, BorderLayout.WEST);
        this.add(infoPanel, BorderLayout.CENTER);

        //layout of panels
        BoxLayout infoGrid = new BoxLayout(infoPanel, BoxLayout.Y_AXIS);
        leftBar.setLayout(new BorderLayout());
        infoPanel.setLayout(infoGrid);

        leftBar.setBorder(BorderFactory.createLineBorder(Color.black));
        infoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        leftBarScroll.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        leftBarScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        leftBar.add(leftBarScroll, BorderLayout.CENTER);

        infoPanel.setBorder(new EmptyBorder(new Insets(40,40,40,40)));

        listListener jlistListener = new listListener(controller);
        list.addListSelectionListener(jlistListener);

        infoPanel.add(id);
        infoPanel.add(companyName);
        infoPanel.add(customerName);
        infoPanel.add(companyStanding);
        infoPanel.add(companyPhone);
        infoPanel.add(customerPhone);
        infoPanel.add(customerAddress);

        id.setAlignmentX(Component.CENTER_ALIGNMENT);
        companyName.setAlignmentX(Component.CENTER_ALIGNMENT);
        customerName.setAlignmentX(Component.CENTER_ALIGNMENT);
        companyStanding.setAlignmentX(Component.CENTER_ALIGNMENT);
        companyPhone.setAlignmentX(Component.CENTER_ALIGNMENT);
        customerPhone.setAlignmentX(Component.CENTER_ALIGNMENT);
        customerAddress.setAlignmentX(Component.CENTER_ALIGNMENT);
    }


    //mouseclick listening here, call controller for info needed to update
    //list selection event for this
    private class listListener implements ListSelectionListener
    {
        Controller controller;

        /**
         * constructor for buildinglistlistener
         * @param newController cityview it will be working with
         */
        public listListener(Controller newController)
        {
            controller = newController;
        }

        /**
         * handles when different element in the list is selected
         * @param e list selection event
         */
        @Override
        public void valueChanged(ListSelectionEvent e) {
            listSelectedChanged(e);
        }
    }

    public void listSelectedChanged(ListSelectionEvent e) {
        int index = list.getSelectedIndex();

        if(!e.getValueIsAdjusting())
        {
            String[] currentRow = controller.getDisplayInfo(index);
            displayInfo(currentRow);
        }
    }

    public void displayInfo(String[] currentRow)
    {
        id.setText("Customer ID: "+ currentRow[0]);
        companyName.setText("Company name: " + currentRow[1]);
        customerName.setText("Customer name: " + currentRow[3] + " " + currentRow[4]);
        companyStanding.setText("Company phone: " + currentRow[5]);
        companyPhone.setText("Company Phone: " + currentRow[6]);
        customerPhone.setText("Customer phone: " + currentRow[7]);
        customerAddress.setText("Customer Address: " + currentRow[8] + ", " + currentRow[9] + ", " + currentRow[10] + ", " + currentRow[11] + " " + currentRow[10]);

//        //could use for if dont know length of file
//        for(int i = 0; i < currentRow.length; i++)
//        {
//
//        }
    }

}
