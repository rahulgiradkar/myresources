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
    var stillPlace = null;
    var stillMarker = null;
    var newGraphic = null;
    var stillTime = null;
    
    
    function distancePoint2Point(P, Q){  
  	   dx = P.x - Q.x;
  	   dy = P.y - Q.y;  	
  	   var d = Math.sqrt(dx * dx + dy * dy);  	   
       return  d;
  	}

     function getCircleCoords (centerX, centerY, r, numPoints) {

 		var coords = new Array();
 		var xCoords = new Array();
 		var yCoords = new Array();
 		var yDifs = new Array();
 		
 		var minX = centerX - r;
 		var maxX = centerX + r; 		
 		
 		var increment = (maxX - minX) / numPoints;

 		if(increment <= 0) return;
 		
 		var curX = minX;
 		var curY = 0; 		

 		var yDif = 0;	    
 	    	
 	    var haveFirst = false;
 		
 		var i = 0; 		
 		
 		while ((curX <= maxX) || (i < 61))
 	 	{ 			
 			curY = Math.sqrt(Math.pow(r,2) - Math.pow((curX - centerX),2)) + centerY; 			
 			
		    if(isNaN(Math.sqrt(Math.pow(r,2) - Math.pow((curX - centerX),2)))) {		     
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


     function gerarArea(){
 		// Pega stillPoint e calcula a distancia possivel percorrida.
 		// Pega o modo de fulga * a diferença de tempo em seg
 		 // Gera area de fulga    	
 		if(newGraphic != null){        	
        	map.removeOverlay(newGraphic);
        } 
        
    	modoFulga = document.getElementById("myForm").modoFulga.value;

    	var curdate = new Date();    	
		difTempo = calcDifDate(); // em segundos
		
		distancia = modoFulga * difTempo;
				
		novaLat = stillMarker.getPoint().lat() + (distancia * 0.00001)/1.11;
		
		newPoint = new GLatLng(novaLat, stillMarker.getPoint().lng());
		
		// Draw circle
		var clickPointPixel = map.fromLatLngToDivPixel(stillMarker.getPoint());
		var outerPoint = map.fromLatLngToDivPixel(newPoint);
		var circleRadius = distancePoint2Point(clickPointPixel,outerPoint);
		
		newGraphicPoints = getCircleCoords(clickPointPixel.x,clickPointPixel.y,circleRadius,60);
			   
	    newGraphic = new GPolygon(newGraphicPoints, "#f33f00", 5, 1, "#ff0000", 0.2);
	    map.addOverlay(newGraphic);	     	 
     }

     function timeOutRender() 
     {
        gerarArea();
     	setTimeout("timeOutRender()",5000);
  	 }

    function calcDifDate(){
		fakeDate = new Date();
		stillTime = document.getElementById("horaFulga").value;
		splitedTime = stillTime.split(":");
		
		fakeDate.setHours(splitedTime[0]);
		fakeDate.setMinutes(splitedTime[1]);	
			
		atualDate = new Date();
		return (atualDate.getTime() - fakeDate.getTime())/1000;		   	
    }
     
    function markRunningPoint(overlay,point) {
 		fakeDate = new Date();
 		    	 
        if(stillMarker != null){
        	map.removeOverlay(stillMarker);
        	map.removeOverlay(newGraphic);
        } 	   
    	stillPlace = point;
    	stillMarker = new GMarker(point, {draggable: true} )
    	GEvent.addListener(stillMarker, "dragend", function() {           
            map.removeOverlay(newGraphic);
            gerarArea()            
          });
        
	    map.addOverlay(stillMarker);
	    timeOutRender(); 	    	
 	}
    
    function load() {
    	map = new GMap2(document.getElementById("map_canvas"));
		map.setCenter(new GLatLng(-3.832997, -38.504215), 13);
		map.setUIToDefault();

		GEvent.addListener(map, "click", markRunningPoint);			
    }

   
    //]]>
    </script>
</head>
<body onload="load()" onunload="GUnload()">
<div id="map_canvas" style="width: 700px; height: 600px; border-width:1px; border-style: solid;border-color: #000000"></div>
<div>
<!-- O valor da fulga é em M/s -->
<form action="" id="myForm">
	
	<input type="radio" name="modoFulga" value="5">bicicleta</input>
	
</form>

<br/>
<input type="text" id="horaFulga" value="22:35" size="20"/>

<br/>
<input type="button" value="Gerar Area" onclick="gerarArea()"/>

</div>
</body>
</html>