import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.ImageProducer;

public class UI extends JFrame {

    private Controller controller;
    private JPanel leftBar;
    private JPanel infoPanel;
    //TODO private JPanel imageBar;
    private JScrollPane leftBarScroll;
    private JList list;

    //shared generic shape JLabels
    private JLabel shapeHeader = new JLabel();
    private JLabel shapeColor = new JLabel();
    private JLabel shapePerimeter = new JLabel();
    private JLabel shapeArea = new JLabel();

    //rectangle specific JLabels
    private JLabel length = new JLabel();
    private JLabel width = new JLabel();

    //circle specific JLabels
    private JLabel radius = new JLabel();

    //square specific JLabels
    private JLabel side = new JLabel();

    //triangle specific JLabels
    private JLabel triangleSides = new JLabel();

    public UI(Controller newController)
    {
        super();
        controller = newController;

        this.setSize(new Dimension (700, 500));
        panelSetup();
        this.setVisible(true);
    }

    //creates panel layouts and heirarchy of panels/scroll panels/ lists/ jlabels
    public void panelSetup()
    {
        this.setLayout(new BorderLayout());

        //TODO imageBar = new JPanel();
        leftBar = new JPanel();
        infoPanel = new JPanel();
        list = new JList(controller.createBasisForList());
        leftBarScroll = new JScrollPane(list);

        //add main panels to frame
        this.add(leftBar, BorderLayout.WEST);
        this.add(infoPanel, BorderLayout.CENTER);
        //TODO this.add(imageBar, BorderLayout.EAST);

        //layout of panels
        BoxLayout infoGrid = new BoxLayout(infoPanel, BoxLayout.Y_AXIS);
        leftBar.setLayout(new BorderLayout());
        //TODO imageBar.setLayout(new BorderLayout());
        infoPanel.setLayout(infoGrid);

        //adding border lines
        leftBar.setBorder(BorderFactory.createLineBorder(Color.black));
        infoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        leftBarScroll.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        leftBarScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        infoPanel.setBorder(new EmptyBorder(new Insets(40,40,40,40)));

        leftBar.add(leftBarScroll, BorderLayout.CENTER);

        listListener jlistListener = new listListener(controller);
        list.addListSelectionListener(jlistListener);

        //add jlabels so shape header and color always first and perimeter and area always last
        infoPanel.add(shapeHeader);
        infoPanel.add(shapeColor);
        infoPanel.add(length);
        infoPanel.add(width);
        infoPanel.add(radius);
        infoPanel.add(side);
        infoPanel.add(triangleSides);
        infoPanel.add(shapePerimeter);
        infoPanel.add(shapeArea);

    }

//    TODO private void displayImage(String url) {
//        JLabel imageLabel=new JLabel();
//        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(url)));
//        imageBar.add(imageLabel, BorderLayout.CENTER); }

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

    //when the value of selected is no longer changing, update display info (avoids duplicate info)
    public void listSelectedChanged(ListSelectionEvent e)
    {
        int index = list.getSelectedIndex();

        if(!e.getValueIsAdjusting())
        {
            Shape shape = controller.getShape(index);
            displayInfo(shape);
        }
    }

    //displays basic shape info plus pertinent type-specific info for each shape
    public void displayInfo(Shape shape)
    {
        shapeHeader.setText(shape.getDisplayHeader());
        shapeColor.setText("Color: " + shape.getColor());
        if (shape instanceof Triangle)
        {
            Triangle triangle = (Triangle) shape;
            shapeArea.setText("Area: " + triangle.getArea());
            shapePerimeter.setText("Perimeter: " + triangle.getPerimeter());
            triangleSides.setText("Triangle dimensions: " + triangle.getSideOne() + ", " + triangle.getSideTwo() + ", " + triangle.getSideThree());

            triangleSides.setVisible(true);
            length.setVisible(false);
            width.setVisible(false);
            radius.setVisible(false);
            side.setVisible(false);

            //TODO myCreateImage("src/Images/triangle.png")
        }
        else if (shape instanceof Rectangle)
        {
            Rectangle rectangle = (Rectangle) shape;
            shapeArea.setText("Area: " + rectangle.getArea());
            shapePerimeter.setText("Perimeter: " + rectangle.getPerimeter());
            length.setText("Length: " + rectangle.getLength());
            width.setText("Width: " + rectangle.getWidth());

            triangleSides.setVisible(false);
            length.setVisible(true);
            width.setVisible(true);
            radius.setVisible(false);
            side.setVisible(false);
            //TODO myCreateImage("src/Images/rectangle.png")
        }
        else if(shape instanceof Circle)
        {
            Circle circle = (Circle) shape;
            shapeArea.setText("Area: " + circle.getArea());
            shapePerimeter.setText("Circumference: " + circle.getPerimeter());
            radius.setText("Radius: " + circle.getRadius());

            triangleSides.setVisible(false);
            length.setVisible(false);
            width.setVisible(false);
            radius.setVisible(true);
            side.setVisible(false);

             //TODO myCreateImage("src/Images/circle.png");
        }
        else if (shape instanceof Square)
        {
            Square square = (Square) shape;
            shapeArea.setText("Area: " + square.getArea());
            shapePerimeter.setText("Perimeter: " + square.getPerimeter());
            side.setText("Side: " + square.getSide());

            triangleSides.setVisible(false);
            length.setVisible(false);
            width.setVisible(false);
            radius.setVisible(false);
            side.setVisible(true);

            //TODO myCreateImage("src/Images/square.png")
            //
        }
        else {
            shapeArea.setText("Area: Unknown shape, area cannot be calculated");
            shapePerimeter.setText("Perimeter: Unknown shape, area cannot be calculated");

            triangleSides.setVisible(false);
            length.setVisible(false);
            width.setVisible(false);
            radius.setVisible(false);
            side.setVisible(false);
        }
    }

//    public void myCreateImage(String location)
//    {
//        Image image = Toolkit.getDefaultToolkit().getImage(Main.class.getResource(location));
//        this.add( image );
//
//    }

}
