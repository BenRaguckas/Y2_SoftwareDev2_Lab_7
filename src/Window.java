import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener{
    //  Menu bar variables
    JMenuBar menuBar;
    JMenu menu_file, menu_new, menu_edit;
    JMenuItem menu_file_exit, menu_edit_remove;
    JMenuItem[] menu_new_items;

    JTabbedPane tabbedPane;

    public Window (int width, int height, String title) {
        //  Initialize Dimensions
        this.setTitle(title);
        this.setPreferredSize(new Dimension(width, height));
        this.setMinimumSize(new Dimension(width, height));

        //  Create menu Bar
        menuBar = new JMenuBar();
        //  Create File dropdown
        menu_file = new JMenu("File");
        menu_file_exit = new JMenuItem("Exit");
        menu_file_exit.addActionListener(this);
        menu_file.add(menu_file_exit);
        //  Create new drop down
        menu_new = new JMenu("New");
        String[] options = {"Building", "House", "Apartment Block", "Office Block"};
        menu_new_items = new JMenuItem[options.length];
        for (int i = 0; i < options.length; i++){
            menu_new_items[i] = new JMenuItem(options[i]);
            menu_new_items[i].addActionListener(this);
            menu_new.add(menu_new_items[i]);
        }
        //  Create edit dropdown
        menu_edit = new JMenu("Edit");
        menu_edit_remove = new JMenuItem("Remove");
        menu_edit_remove.addActionListener(this);
        menu_edit.add(menu_edit_remove);
        //  Push all menus to Menu Bar
        menuBar.add(menu_file);
        menuBar.add(menu_new);
        menuBar.add(menu_edit);
        this.setJMenuBar(menuBar);

        //  Tabbed pane
        tabbedPane = new JTabbedPane();
        this.add(tabbedPane);

        //  Closing, resizing, location
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //  Display window
        this.setVisible(true);
    }

    public void addTab(Tab tab){
        tabbedPane.addTab(tab.getName(), tab);
    }

    public void removeTab(){
        tabbedPane.remove(tabbedPane.getSelectedComponent());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //  Exit button clicked
        if (e.getSource() == menu_file_exit)
            this.dispose();
        //  Remove current Panel
        if (e.getSource() == menu_edit_remove)
            removeTab();
        //  Check for new items
        if (e.getSource() == menu_new_items[0]){
            addTab(new Tab(new Building()));
        }
        if (e.getSource() == menu_new_items[1]){
            addTab(new Tab(new House()));
        }
        if (e.getSource() == menu_new_items[2]){
            addTab(new Tab(new ApartmentBlock()));
        }
        if (e.getSource() == menu_new_items[3]){
            addTab(new Tab(new OfficeBlock()));
        }


//        System.out.println(e.getActionCommand());
    }
}

class Tab extends Panel implements ActionListener{
    private Building building;
    private String name;
    private JTextField walls, roof, spec;
    private JLabel lWall, lRoof, lSpec;
    private JButton btn_log, btn_update;

    public Tab(Building building) {
        //  Save building and default name
        this.building = building;
        this.name = building.getClass().getName();
        //  Set it to grid layout
        GridLayout layout = new GridLayout(0, 2);
        this.setLayout(layout);

        //  Create Wall display
        lWall = new JLabel("Walls : ");
        lWall.setFont(new Font(Font.SERIF, Font.BOLD, 26));
        this.add(lWall);
        walls = new JTextField("" + building.getWalls());
        walls.setFont(new Font(Font.SERIF, Font.BOLD, 26));
        this.add(walls);

        //  Create Roof display
        lRoof = new JLabel("Roof : ");
        lRoof.setFont(new Font(Font.SERIF, Font.BOLD, 26));
        this.add(lRoof);
        roof = new JTextField(building.getRoof());
        roof.setFont(new Font(Font.SERIF, Font.BOLD, 26));
        this.add(roof);

        //  Ensure the object is NOT building
        if (building.getClass() != Building.class) {
            //  Create specific object by checking what class object inherently is
            if (building.getClass() == House.class) {
                lSpec = new JLabel("Rooms : ");
                this.add(lSpec);
                spec = new JTextField("" + ((House) building).getRooms());
                this.add(spec);
            } else if (building.getClass() == ApartmentBlock.class) {
                lSpec = new JLabel("Units : ");
                this.add(lSpec);
                spec = new JTextField("" + ((ApartmentBlock) building).getUnits());
                this.add(spec);
            } else if (building.getClass() == OfficeBlock.class) {
                lSpec = new JLabel("Cubicles : ");
                this.add(lSpec);
                spec = new JTextField("" + ((OfficeBlock) building).getCubicles());
                this.add(spec);
            }
            //  Set fonts for spec and lSpec
            spec.setFont(new Font(Font.SERIF, Font.BOLD, 26));
            lSpec.setFont(new Font(Font.SERIF, Font.BOLD, 26));
        }

        //  Add interaction buttons
        btn_log = new JButton("Log");
        btn_log.addActionListener(this);
        this.add(btn_log);

        btn_update = new JButton("Update");
        btn_update.addActionListener(this);
        this.add(btn_update);

        this.setBackground(Color.lightGray);
    }

    //  not particularly used
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //  Log button
        if (e.getSource() == btn_log)
            System.out.println(building.toString());
        //  Update button
        if (e.getSource() == btn_update){
            building.setWalls(Integer.parseInt(walls.getText()));
            building.setRoof(roof.getText());
            //  Specific object updates
            if (building.getClass() == House.class) {
                ((House) building).setRooms(Integer.parseInt(spec.getText()));
            }
            else if (building.getClass() == ApartmentBlock.class) {
                ((ApartmentBlock) building).setUnits(Integer.parseInt(spec.getText()));
            }
            else if (building.getClass() == OfficeBlock.class) {
                ((OfficeBlock) building).setCubicles(Integer.parseInt(spec.getText()));
            }
        }
    }
}