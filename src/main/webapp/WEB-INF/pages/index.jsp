<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<script>
    var websocket;

    function init()
    {
        output = document.getElementById("output");
    }

    function send()
    {
        var wsUri = "ws://localhost/stu/websocket/${user.getId()}";
        writeToScreen("Connecting to : "+ wsUri);
        websocket = new WebSocket(wsUri);
        websocket.onopen = function(evt)
        {
            writeToScreen("Connect Success!");
            doSend(document.getElementById("textID").value);
        };
        websocket.onmessage = function(evt)
        {
            writeToScreen("Received Message: "+ evt.data);
            websocket.close();
        };
        websocket.onerror = function (evt)
        {
            writeToScreen('<span style="color:red;">ERROR:</span>'+evt.data);
        };
    }
    function doSend(message)
    {
        websocket.send(message);
        writeToScreen("Send Message : "+message);
    }

    function writeToScreen(message)
    {
        var pre = document.createElement("p");
        pre.style.wordWrap = "break-word";
        pre.innerHTML = message;
        output.appendChild(pre)
    }

    window.addEventListener("load", init, false);
</script>
<body>
<h2>Hello World!</h2>
    <div style="text-align:left;">
        <form action="">
            <input onclick="send()" value="Send Message" type="button">
            <input id="textID" name="message" value="Hello Web Socket" type="text">
            <br>
        </form>

    </div>
    <div id="output"></div>
</div>
</body>
</html>
