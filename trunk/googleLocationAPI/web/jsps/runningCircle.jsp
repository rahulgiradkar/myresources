<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Google Maps JavaScript API Example</title>
<script
	src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAu99GtYhiacXNoX665Vy5cBQdveTzYo9aFBi8nsLjId7OuftObRTg_VyEZGtAV1hMYjaFXARCp_9BiA"
	type="text/javascript"></script>


<script type="text/javascript" src="../js/googleCode.js"/>
<script type="text/javascript" src="../js/showCop.js"/>

</head>
<body onload="load(), testMark()" onunload="GUnload()">
<div id="map_canvas" style="width: 700px; height: 600px; border-width:1px; border-style: solid;border-color: #000000"></div>
<div>
<!-- O valor da fulga é em M/s -->
<form action="" id="myForm">
	
	<input type="radio" name="modoFulga" value="5">bicicleta</input>
	
</form>

<br/>
<input type="text" id="horaFulga" value="22:35" size="20"/>

<br/>
<input type="button" value="Gerar Area" onclick="testMark()"/>

</div>


</body>
</html>