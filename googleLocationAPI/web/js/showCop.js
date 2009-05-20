
// Cop Car conf
blueIcon = new GIcon(G_DEFAULT_ICON);
blueIcon.image = "http://gmaps-samples.googlecode.com/svn/trunk/markers/blue/blank.png";
var markerOptions = { icon:blueIcon };

//Carrega Cop Car Array
var copCars = new Array();
copCars[0] = new GMarker(new GLatLng(-3.832997, -38.504215), markerOptions);
copCars[1] = new GMarker(new GLatLng(-3.843889, -38.513215), markerOptions);
copCars[2] = new GMarker(new GLatLng(-3.854776, -38.525214), markerOptions);
copCars[3] = new GMarker(new GLatLng(-3.865665, -38.537213), markerOptions);

function testMark(){
	
	for (mark in copCars){		
		map.addOverlay(copCars[mark]);
	}		
}