<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="java.sql.*" %>
<%
    // Retrieve the category ID from the URL
    String categoryId = request.getParameter("id");

    if (categoryId != null) {
        // Establish a database connection and delete the category
        String url = "jdbc:mysql://localhost:3306/quizapp";
        String username = "root";
        String password = "your_password";  // Use your actual password

        try {
            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();

            // SQL query to delete the category
            //String deleteQuery = "DELETE FROM categories WHERE id = ?";
            
                        String deleteQuery = "DELETE FROM categories WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(deleteQuery);
            ps.setInt(1, Integer.parseInt(categoryId));

            // Execute the delete query
            int rowsAffected = ps.executeUpdate();

            // If rows are affected, category deleted successfully
            if (rowsAffected > 0) {
                out.println("<h2>Category deleted successfully!</h2>");
                response.sendRedirect("admin-dashboard.jsp");  // Redirect back to the admin dashboard
            } else {
                out.println("<h2>Failed to delete the category.</h2>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h2>Error while deleting the category: " + e.getMessage() + "</h2>");
        }
    } else {
        out.println("<h2>Invalid category ID.</h2>");
    }
%>

<!-- Provide a way for the user to go back -->
<a href="admin-dashboard.jsp" class="action-btn">Back to Dashboard</a>
