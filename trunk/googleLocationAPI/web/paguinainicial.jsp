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
    var map = null;
    var newGraphic;
   
    var lineWidth = 6;
	var lineColor = "#ff0000";
	var lineOpacity = 0.7;

    
    function distancePoint2Point(P, Q){  
	   dx = P.x - Q.x;
	   dy = P.y - Q.y;
	
	   var d = Math.sqrt(dx * dx + dy * dy);
	   ////_logger.info("distancePoint2Point=" + d )
  		return  d;
	}

    function getCircleCoords (centerX, centerY, r, numPoints) {

		var coords = new Array();
		var xCoords = new Array();
		var yCoords = new Array();
		var yDifs = new Array();
		
		var minX = centerX - r;
		var maxX = centerX + r;
		
		
		////_logger.info("getCircleCoords " + centerX + "," + centerY + "," + r + "," + numPoints + "," + minX + "," + maxX);
		
		
		var increment = (maxX - minX) / numPoints;
		
		////_logger.info("increment=" + increment)
		
		if(increment <= 0) return;
		
		var curX = minX;
		var curY = 0;
		

		var yDif = 0;
	    
	    	
	    var haveFirst = false;
		
		var i = 0;
		
		
		while ((curX <= maxX) || (i < 61)){
			
			curY = Math.sqrt(Math.pow(r,2) - Math.pow((curX - centerX),2))    + centerY;
			
			
			  if(isNaN(Math.sqrt(Math.pow(r,2) - Math.pow((curX - centerX),2)))) {
			     ////_logger.info("DIFFERENCE IS ZERO");
				 curY = centerY;
			  }

			
			yDif = 2*(curY - centerY);
	
			xCoords[i] = curX;
			yCoords[i] = curY;
			yDifs[i] = yDif;
			
			coords[i] = map.fromDivPixelToLatLng(new GPoint(curX,curY));
			
			curX += increment;

			
			i++;
			
			
			
		}
		
		
		//now add bottom half of circle
		var bottomY;
		for(k = xCoords.length-1; k > -1; k--){
		
			bottomY = yCoords[k] - yDifs[k];

			coords[i] = map.fromDivPixelToLatLng(new GPoint(xCoords[k],bottomY));
			
			i++;
		}
		
		
		return coords;
		
}
    
    
    function drawCircle(overlay, point) {
	   
		var clickPointPixel = map.fromLatLngToDivPixel(new GLatLng(-3.832997, -38.504215));
		var outerPoint = map.fromLatLngToDivPixel(point);
		var circleRadius = distancePoint2Point(clickPointPixel,outerPoint);
		//alert(circleRadius);
		newGraphicPoints = getCircleCoords(clickPointPixel.x,clickPointPixel.y,circleRadius,60);
		//alert(newGraphicPoints);
		isFirstPoint = false;
		//map.removeOverlay(newGraphic);	   
	    newGraphic = new GPolygon(newGraphicPoints, "#f33f00", 5, 1, "#ff0000", 0.2);
	    map.addOverlay(newGraphic);		
 	}


    
    function load() {
    	map = new GMap2(document.getElementById("map_canvas"));
		map.setCenter(new GLatLng(-3.832997, -38.504215), 13);
		map.setUIToDefault();

		GEvent.addListener(map, "click", drawCircle);

		// Add 10 markers to the map at random locations
		var bounds = map.getBounds();
		var southWest = bounds.getSouthWest();
		var northEast = bounds.getNorthEast();
		var lngSpan = northEast.lng() - southWest.lng();
		var latSpan = northEast.lat() - southWest.lat();
		
		/** Marker events click, dragstart, drag and dragend
		for (var i = 0; i < 10; i++) {
		  var point = new GLatLng(southWest.lat() + latSpan * Math.random(),
		        southWest.lng() + lngSpan * Math.random());
			map.addOverlay(new GMarker(point));
		}		*/
    }

    //]]>
    </script>
</head>
<body onload="load()" onunload="GUnload()">
<div id="map_canvas" style="width: 700px; height: 600px; border-width:1px; border-style: solid;border-color: #000000"></div>
<div>

</div>
</body>
</html>