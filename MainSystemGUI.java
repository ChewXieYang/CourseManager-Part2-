import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainSystemGUI {
    private static MainGUI mainSystem = new MainGUI(1, "System");

    private static DefaultListModel<String> courseListModel = new DefaultListModel<>();
    private static DefaultListModel<String> studentListModel = new DefaultListModel<>();
    private static DefaultListModel<String> lecturerListModel = new DefaultListModel<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Certificate Program GUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 400);

            JPanel centerPanel = new JPanel();
            centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
            

            JLabel OptionLabel = new JLabel("Choose your profile", SwingConstants.CENTER);
            Font titleFont = new Font("Arial", Font.BOLD, 20);
            OptionLabel.setFont(titleFont); 

            JButton AdminButton = new JButton("Admin");
            AdminButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame adminFrame = new JFrame("Admin Interface");
                    adminFrame.setLayout(new BorderLayout());

                    JPanel adminPanel = new JPanel();
                    adminPanel.setLayout(new BorderLayout());

                    JList<String> courseList = new JList<>(courseListModel);
                    JList<String> studentList = new JList<>(studentListModel);
                    JList<String> lecturerList = new JList<>(lecturerListModel);

                    JScrollPane courseScrollPanel = new JScrollPane(courseList);
                    JScrollPane studentScrollPanel = new JScrollPane(studentList);
                    JScrollPane lecturerScrollPanel = new JScrollPane(lecturerList);

                    JPanel buttonPanel = new JPanel();
                    JButton addButton2 = new JButton("Add Course");
                    addButton2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            
                            Object[] existingCoursesArray = mainSystem.getAllCourses()
                                    .stream()
                                    .map(course -> course.getId() + ": " + course.getName())
                                    .toArray(Object[]::new);

                            // Object[] selectedCourses = (Object[]) JOptionPane.showInputDialog(
                            //         adminFrame,
                            //         "Select prerequisites:",
                            //         "Add Prerequisites",
                            //         JOptionPane.QUESTION_MESSAGE,
                            //         null,
                            //         existingCoursesArray,
                            //         null);

                            // if (selectedCourses != null) {
                            //     for (Object selectedCourse : selectedCourses) {
                            //         String courseId = selectedCourse.toString().split(":")[0].trim();
                            //         Course selectedPrerequisite = mainSystem.getCourseById(courseId);
                            //         prerequisites.add(selectedPrerequisite);
                            //     }
                            // }

                            String courseId = JOptionPane.showInputDialog(adminFrame, "Enter Course ID:");
                            String courseName = JOptionPane.showInputDialog(adminFrame, "Enter Course Name:");
                            int courseCredits = 0; // Default value in case of invalid input
                            try {
                                String creditsInput = JOptionPane.showInputDialog(adminFrame, "Enter Course Credits:");
                                if (creditsInput != null) { // Check if the user canceled the dialog
                                    courseCredits = Integer.parseInt(creditsInput);
                                } else {
                                    // User canceled the input dialog, handle accordingly
                                }
                            } catch (NumberFormatException except) {
                                // Handle invalid input (e.g., non-numeric input)
                                JOptionPane.showMessageDialog(adminFrame, "Invalid input! Please enter a valid integer value for course credits.");
                            }
                            String prerequisites = JOptionPane.showInputDialog(adminFrame, "Enter Course PreReq:");

                            mainSystem.addCourse(courseId, courseName, courseCredits ,prerequisites);
                            courseListModel.addElement(courseId + ": " + courseName);
                        }
                    });

                    JButton addButton3 = new JButton("Add Student");
                    addButton3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String studentId = JOptionPane.showInputDialog("Enter Student ID:");
                            String studentName = JOptionPane.showInputDialog("Enter Student Name:");

                            mainSystem.addStudent(studentId, studentName);
                            studentListModel.addElement(studentId + ": " + studentName);
                        }
                    });

                    JButton addButton4 = new JButton("Add Lecturer");
                    addButton4.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String lecturerId = JOptionPane.showInputDialog("Enter Lecturer ID:");
                            String lecturerName = JOptionPane.showInputDialog("Enter Lecturer Name:");

                            mainSystem.addLecturer(lecturerId, lecturerName);
                            lecturerListModel.addElement(lecturerId + ": " + lecturerName);
                        }
                    });

                    buttonPanel.add(addButton2);
                    buttonPanel.add(addButton3);
                    buttonPanel.add(addButton4);

                    adminPanel.add(courseScrollPanel, BorderLayout.WEST);
                    adminPanel.add(studentScrollPanel, BorderLayout.CENTER);
                    adminPanel.add(lecturerScrollPanel, BorderLayout.EAST);
                    adminPanel.add(buttonPanel, BorderLayout.SOUTH);

                    adminFrame.getContentPane().add(adminPanel);
                    adminFrame.setSize(800, 400);
                    adminFrame.setVisible(true);
                }
            });

            JButton StudentButton = new JButton("Student");

            JButton LecturerButton = new JButton("Lecturer");

            
            centerPanel.add(OptionLabel);
            centerPanel.add(Box.createVerticalGlue()); 
            centerPanel.add(AdminButton);
            centerPanel.add(Box.createVerticalStrut(10));
            centerPanel.add(StudentButton);
            centerPanel.add(Box.createVerticalStrut(10));
            centerPanel.add(LecturerButton);
            centerPanel.add(Box.createVerticalGlue()); 

           
            frame.setLayout(new GridBagLayout());
            frame.add(centerPanel, new GridBagConstraints());

            frame.setLocationRelativeTo(null);

            frame.setVisible(true);
        });
    }
}
