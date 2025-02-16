<!-- /WEB-INF/jsp/admin-dashboard.jsp -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
 
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <style>
        /* Basic reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        /* Header */
        header {
            background-color: #333;
            color: white;
            padding: 20px 0;
            text-align: center;
        }

        header h1 {
            margin: 0;
            font-size: 2rem;
        }

        /* Main content container */
        .container {
            padding: 20px;
            max-width: 1200px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        h3 {
            margin-bottom: 20px;
            font-size: 1.5rem;
            color: #333;
        }

        /* Table styles */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #333;
            color: white;
        }

        td {
            background-color: #fff;
        }

        tr:nth-child(even) td {
            background-color: #f9f9f9;
        }

        /* Action button */
        .action-btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
            margin-top: 20px;
        }

        .action-btn:hover {
            background-color: #0056b3;
        }

        /* Footer */
        footer {
            text-align: center;
            padding: 10px;
            background-color: #333;
            color: white;
            position: absolute;
            width: 100%;
           
            margin-top: auto;
        }
    </style>
</head>
<body>
    <header>
        <h1>Admin Dashboard</h1>
    </header>

    <div class="container">
    <c:if test="${not empty successMessage}">
            <p style="color: green; font-size: 20px;font-weight: bold; ">${successMessage}</p>
    </c:if>

    <c:if test="${not empty errorMessage}">
            <p style="color: red; font-size: 20px;font-weight: bold;">${errorMessage}</p>
    </c:if>
        <br/>
        <h3>All Categories</h3>
        
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Action</th>
                </tr>
            </thead>
           <tbody>
                <c:forEach var="category" items="${categories}">
                    <tr>
                        <td>${category.id}</td>
                        <td>${category.name}</td>
                        <td><!-- Action buttons -->
                         
                            <a href="/admin/delete-category/${category.id}" class="action-btn" onclick="return confirm('Are you sure you want to delete this category?');">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody> 
            
            
             <%-- <tbody>
                <c:forEach var="quiz" items="${quizes}">
                    <tr>
                        <td>${quiz.id}</td>
                        <td>${quiz.name}</td>
                        <td>${quiz.description}</td>
                    </tr>
                </c:forEach>
            </tbody> --%>
        </table>

        <!-- Link to create a new quiz -->
        <a href="/admin/create-quiz" class="action-btn">Create New Quiz</a> &ensp;
                <a href="/admin/new-category" class="action-btn">New Upload</a>
        
    </div>

    <footer>
        <p>&copy; 2025 Quiz App - Admin Panel</p>
    </footer>
</body>
</html>
