<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<style>
* { font-family:verdana,arial,sans-serif; }
a { font-size:12px; }
input { padding:3px; }
</style>
</head>
<body>

<div style="font-size:2em;">Web Application Benchmark</div>
<div style="font-color:#252525;font-weight:bold;font-size:14px;">Codeminium</div>
<div style="font-color:#252525;font-size:10px;">version 1.5</div>
<br>

<form action="plain/ackermann" method="get">
<input type="text" name="n"><input type="submit" value="Ackermann">
</form>

<form action="plain/fibo" method="get">
<input type="text" name="n"><input type="submit" value="Fibo">
</form>

<form action="plain/hash" method="get">
<input type="text" name="n"><input type="submit" value="Hash">
</form>

<form action="plain/hash2" method="get">
<input type="text" name="n"><input type="submit" value="Hash2">
</form>

<form action="plain/heapsort" method="get">
<input type="text" name="n"><input type="submit" value="HeapSort">
</form>

<form action="plain/matrix" method="get">
<input type="text" name="n"><input type="submit" value="Matrix">
</form>

<a href="tunnel.jsp">Check out the tunnel!</a>

</body>
</html>