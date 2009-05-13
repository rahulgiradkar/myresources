<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Google Maps JavaScript API Example</title>
<script
	src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAu99GtYhiacXNoX665Vy5cBQdveTzYo9aFBi8nsLjId7OuftObRTg_VyEZGtAV1hMYjaFXARCp_9BiA"
	type="text/javascript"></script>
<script type="text/javascript">

    //<![CDATA[
    function load() {
		var map = new GMap2(document.getElementById("map_canvas"));
		map.setCenter(new GLatLng(37.4419, -122.1419), 13);
		 
		// Add 10 markers to the map at random locations
		var bounds = map.getBounds();
		var southWest = bounds.getSouthWest();
		var northEast = bounds.getNorthEast();
		var lngSpan = northEast.lng() - southWest.lng();
		var latSpan = northEast.lat() - southWest.lat();
		
		// Marker events click, dragstart, drag and dragend
		for (var i = 0; i < 10; i++) {
		  var point = new GLatLng(southWest.lat() + latSpan * Math.random(),
		        southWest.lng() + lngSpan * Math.random());
			map.addOverlay(new GMarker(point));
		}		
    }

    //]]>
    </script>
</head>
<body onload="load()" onunload="GUnload()">
<div id="map_canvas" style="width: 500px; height: 300px"></div>
</body>
</html>