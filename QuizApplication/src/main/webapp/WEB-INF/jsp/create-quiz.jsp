
<!-- /WEB-INF/jsp/create-quiz.jsp -->
<!DOCTYPE html>
<html>
<head>
    <title>Create Quiz</title>
</head>
<body>
    <h1>Create a New Quiz</h1>
    <form action="/admin/create-quiz" method="post">
        <label for="title">Quiz Title:</label>
        <input type="text" id="title" name="title" required><br><br>

        <label for="description">Quiz Description:</label>
        <textarea id="description" name="description" required></textarea><br><br>

        <input type="submit" value="Create Quiz">
    </form>
    <br>
    <a href="/admin/dashboard">Back to Dashboard</a>
</body>
</html>
