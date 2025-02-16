<!-- /WEB-INF/jsp/new-category.jsp -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create New Category</title>
    <style>
        /* Basic Styles for Form */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Arial', sans-serif;
            background-color: #f9f9f9;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #ffffff;
            width: 100%;
            max-width: 500px;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        h3 {
            font-size: 1.8rem;
            margin-bottom: 20px;
            text-align: center;
            color: #333;
        }

        label {
            font-size: 1rem;
            margin-bottom: 8px;
            display: block;
        }

        input, textarea {
            width: 100%;
            padding: 12px;
            margin: 8px 0 16px;
            border-radius: 5px;
            border: 1px solid #ddd;
            font-size: 1rem;
        }

        input:focus, textarea:focus {
            border-color: #007bff;
            outline: none;
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            font-size: 1.2rem;
        }

        button:hover {
            background-color: #0056b3;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            font-size: 1.2rem;
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }

        /* Responsive design for smaller screens */
        @media (max-width: 600px) {
            .container {
                padding: 20px;
                width: 90%;
            }
            h3 {
                font-size: 1.6rem;
            }
            button {
                font-size: 1rem;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <h3>Create New Category</h3>

    <form action="/admin/save-category" method="POST">
        <div>
            <label for="name">Category Name:</label>
            <input type="text" id="name" name="name" required />
        </div>
        <div>
            <label for="description">Category Description:</label>
            <textarea id="description" name="description" required></textarea>
        </div>
        
        <div>
            <button type="submit">Save Category</button>
        </div>
    </form>

    <a href="/admin/dashboard">Back to Dashboard</a>
</div>

</body>
</html>
