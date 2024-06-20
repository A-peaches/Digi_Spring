<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Message</title>
    <script type="text/javascript">
        function showMessageAndRedirect(message, url) {
            alert(message);
            window.location.href = url;
        }
    </script>
</head>
<body>
    <script type="text/javascript">
        showMessageAndRedirect('${message}', '${url}');
    </script>
</body>
</html>
